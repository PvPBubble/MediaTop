package gg.steve.mc.dazzer.mt.cmd.implementation;

import gg.steve.mc.dazzer.mt.cmd.AbstractCommand;
import gg.steve.mc.dazzer.mt.cmd.AbstractSubCommand;
import gg.steve.mc.dazzer.mt.cmd.implementation.subs.*;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class MediaTopCommand extends AbstractCommand {

    public MediaTopCommand() {
        super("MediaTop", "admin");
    }

    @Override
    public void registerAllSubCommands() {
        this.registerSubCommand(new MediaHelpSubCommand(this));
        this.registerSubCommand(new MediaReloadSubCommand(this));
        this.registerSubCommand(new MediaVoteSubCommand(this));
        this.registerSubCommand(new MediaGuiSubCommand(this));
        this.registerSubCommand(new MediaTokenSubCommand(this));
    }

    @Override
    public void runOnNoArgsGiven(CommandSender sender) {
        if (this.getSubCommands() != null && this.getSubCommands().containsKey("help"))
            this.getSubCommands().get("help").execute(sender, new String[0]);
    }

    @Override
    public void registerAliases() {
        this.registerAlias("mt");
    }

    @Override
    public List<String> onTabComplete(CommandSender executor, String[] arguments) {
        List<String> options = new ArrayList<>();
        if (arguments.length == 1 || arguments.length == 2) {
            for (AbstractSubCommand subCommand : this.getSubCommands().values()) {
                options.add(subCommand.getCommand());
            }
        }
        return options;
    }
}
