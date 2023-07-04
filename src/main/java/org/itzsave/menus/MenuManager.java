package org.itzsave.menus;

import org.bukkit.entity.Player;
import org.itzsave.SaveCaptcha;

public class MenuManager {

    private final SaveCaptcha plugin;
    private CaptchaMenu captchaMenu;

    public MenuManager(SaveCaptcha plugin){
        this.plugin = plugin;
    }

    public void onEnable(){
        captchaMenu = new CaptchaMenu(plugin);
    }

    public void openCaptchaMenu(Player player){
        captchaMenu.open(player);
    }

}
