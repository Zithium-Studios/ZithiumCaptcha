package net.zithium.captcha;

import me.mattstudios.mf.base.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;
import net.zithium.captcha.commands.CaptchaCommand;
import net.zithium.captcha.menus.MenuManager;
import net.zithium.captcha.utils.TextUtils;


public final class ZithiumCaptcha extends JavaPlugin {

    private MenuManager menuManager;

    @Override
    public void onEnable() {
        // Plugin startup logic

        CommandManager commandManager = new CommandManager(this);
        commandManager.register(new CaptchaCommand(this));

        (menuManager = new MenuManager(this)).onEnable();

        getComponentLogger().info(TextUtils.color("<green>Enabled successfully"));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public MenuManager getMenuManager() {
        return menuManager;
    }
}
