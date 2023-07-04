package org.itzsave;

import dev.triumphteam.gui.guis.GuiItem;
import me.mattstudios.mf.base.CommandManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.itzsave.commands.CaptchaCommand;
import org.itzsave.menus.MenuManager;
import org.itzsave.utils.TextUtils;

import java.util.Random;


public final class SaveCaptcha extends JavaPlugin {

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
