package de.louidev.spigotutils.utils;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

/**
 * A utils class for ItemStack convenience
 */
public class ItemStackUtils {
    /**
     * Sets the lore of the provided ItemStack
     *
     * @param itemStack The ItemStack
     * @param lore      The lore
     */
    public static void setLore(ItemStack itemStack, String... lore) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        assert itemMeta != null;
        itemMeta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(itemMeta);
    }
}
