package org.itzsave.menus;


import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.itzsave.SaveCaptcha;
import org.itzsave.utils.TextUtils;

import java.util.concurrent.ThreadLocalRandom;

public class CaptchaMenu {

    private final SaveCaptcha plugin;

    public CaptchaMenu(SaveCaptcha plugin) {
        this.plugin = plugin;
    }

    public void open(Player player) {
        // Randomizing the slot of the item.
        final int value = ThreadLocalRandom.current().nextInt(1, 34);

        // Creating the gui
        Gui gui = Gui.gui()
                .title(TextUtils.color("Click green glass pane!"))
                .rows(4)
                .create();

        gui.setDefaultClickAction(event -> event.setCancelled(true));

        // If the user clicks the green glass the gui closes.
        GuiItem guiItem = ItemBuilder.from(Material.GREEN_STAINED_GLASS_PANE).asGuiItem(event -> {
            player.sendMessage(TextUtils.color("<green>Thank you for completing the captcha!"));
            gui.close(player);
        });


        gui.setItem(value, guiItem);

        GuiItem filler = ItemBuilder.from(Material.BLACK_STAINED_GLASS_PANE).asGuiItem();
        gui.getFiller().fill(filler);


        // Preventing user's from closing the gui without clicking the correct item.
        gui.setCloseGuiAction(event -> {
            if (event.getReason().equals(InventoryCloseEvent.Reason.PLAYER)) {
                player.sendMessage(TextUtils.color("<red>Please complete the captcha!"));
                Bukkit.getScheduler().runTaskLater(plugin, () -> gui.open(player), 5L);
            }

        });


        gui.open(player);


    }


}
