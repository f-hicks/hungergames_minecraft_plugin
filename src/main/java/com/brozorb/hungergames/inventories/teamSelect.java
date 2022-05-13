package com.brozorb.hungergames.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.List;

public class teamSelect implements InventoryHolder {

    private Inventory inv;

    public teamSelect() {
        inv = Bukkit.createInventory(this, 9, "Select Your Team!");
        init();
    }

    private void init() {
        ItemStack item = createItem(Material.RED_STAINED_GLASS_PANE, "§4Red", Collections.singletonList("§4Click to join the Red Team!"));
        inv.setItem(0, item);
        item = createItem(Material.ORANGE_STAINED_GLASS_PANE, "§6Orange",  Collections.singletonList("§6Click to join the Orange Team!"));
        inv.setItem(1, item);
        item = createItem(Material.YELLOW_STAINED_GLASS_PANE, "§eYellow",  Collections.singletonList("§eClick to join the Yellow Team!"));
        inv.setItem(2, item);
        item = createItem(Material.LIME_STAINED_GLASS_PANE, "§aLight Green",  Collections.singletonList("§aClick to join the Light Green Team!"));
        inv.setItem(3, item);
        item = createItem(Material.GREEN_STAINED_GLASS_PANE, "§2Dark Green",  Collections.singletonList("§2Click to join the Dark Green Team!"));
        inv.setItem(4, item);
        item = createItem(Material.BLUE_STAINED_GLASS_PANE, "§1Blue",  Collections.singletonList("§1Click to join the Blue Team!"));
        inv.setItem(5, item);
        item = createItem(Material.LIGHT_BLUE_STAINED_GLASS_PANE, "§9Light Blue",  Collections.singletonList("§9Click to join the Light Blue Team!"));
        inv.setItem(6, item);
        item = createItem(Material.PURPLE_STAINED_GLASS_PANE, "§5Purple",  Collections.singletonList("§5Click to join the Purple Team!"));
        inv.setItem(7, item);
        item = createItem(Material.BARRIER, "§cCancel",  Collections.singletonList("§cClick to cancel!"));
        inv.setItem(8, item);

    }

    private ItemStack createItem(Material material, String name, List<String> lore) {
        ItemStack item = new ItemStack(material, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    @Override
    public Inventory getInventory() {
        return inv;
    }

}
