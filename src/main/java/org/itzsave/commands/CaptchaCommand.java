package org.itzsave.commands;


import me.mattstudios.mf.annotations.*;
import me.mattstudios.mf.base.CommandBase;
import org.bukkit.entity.Player;
import org.itzsave.SaveCaptcha;
import org.itzsave.utils.TextUtils;


@Command("captcha")
@SuppressWarnings("unused") // Since IntelliJ likes to throw notices about unused methods.
public class CaptchaCommand extends CommandBase {
    private final SaveCaptcha plugin;

    public CaptchaCommand(SaveCaptcha plugin) {
        this.plugin = plugin;
    }

    @Permission("captcha.admin")
    @Default
    public void execute(Player player) {
        player.sendMessage(TextUtils.color("<green>/captcha show <username>"));
    }

    @SubCommand("show")
    @Permission({"captcha.admin", "captcha.command.show"})
    @Completion("#players")
    public void showCommand(Player player, String[] args) {
        if (args.length == 1) {
            player.sendMessage(TextUtils.color("<yellow>Usage: /tag remove <player>"));
            return;
        }

        if (plugin.getServer().getPlayerExact(args[1]) == null) {
            player.sendMessage(TextUtils.color("<red>That player is not online!"));
            return;
        }

        Player target = plugin.getServer().getPlayerExact(args[1]);
        if (args.length == 2 && target != null) {
            plugin.getMenuManager().openCaptchaMenu(target);
        }

    }
}
