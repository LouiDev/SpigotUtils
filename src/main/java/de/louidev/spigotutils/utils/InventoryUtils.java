package de.louidev.spigotutils.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Objects;

/**
 * A utils class for Inventory convenience
 */
public class InventoryUtils {
    /**
     * Fills the empty slots of the provided inventory with the provided ItemStack
     *
     * @param inventory The Inventory
     * @param itemStack The ItemStack
     */
    public static void fillEmptySlots(Inventory inventory, ItemStack itemStack) {
        Arrays.stream(inventory.getContents())
                .filter(Objects::isNull)
                .forEach(item -> inventory.addItem(itemStack));
    }

    /**
     * Returns the index of the provided ItemStack in the provided Inventory or -1 if not found
     *
     * @param inventory The Inventory
     * @param itemStack The ItemStack
     * @return int
     */
    public static int indexOfItemStack(Inventory inventory, ItemStack itemStack) {
        return Arrays.asList(inventory.getContents()).indexOf(itemStack);
    }

    /**
     * Returns a copy of the provided Inventory with the new provided name
     *
     * @param inventory The Inventory
     * @param name      The new name
     * @return org.bukkit.inventory.Inventory
     */
    public static Inventory renameInventory(Inventory inventory, String name) {
        Inventory newInventory = Bukkit.createInventory(inventory.getHolder(), inventory.getSize(), name);
        inventory.forEach(newInventory::addItem);
        return newInventory;
    }
}
