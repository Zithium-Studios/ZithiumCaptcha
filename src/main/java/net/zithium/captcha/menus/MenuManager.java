package net.zithium.captcha.menus;

import net.zithium.captcha.ZithiumCaptcha;
import org.bukkit.entity.Player;

public class MenuManager {

    private final ZithiumCaptcha plugin;
    private CaptchaMenu captchaMenu;

    public MenuManager(ZithiumCaptcha plugin){
        this.plugin = plugin;
    }

    public void onEnable(){
        captchaMenu = new CaptchaMenu(plugin);
    }

    public void openCaptchaMenu(Player player){
        captchaMenu.open(player);
    }

}
