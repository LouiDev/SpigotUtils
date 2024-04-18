package de.louidev.spigotutils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class EventWrapper {
    private final PluginManager pluginManager;
    private final Plugin plugin;

    /**
     * A simple wrapper for event handling removing unnecessary Listener classes
     * 
     * @param manager The PluginManager
     * @param plugin The Plugin
     */
    public EventWrapper(PluginManager manager, Plugin plugin) {
        this.pluginManager = manager;
        this.plugin = plugin;
    }

    /**
     * <p>Registers a new Listener with the only purpose to set the provided message as the join message.</p>
     * <p>NOTICE: Use the placeholder "playerName" to insert the joining player's name at this position of the String.</p>
     *
     * @param message The message
     */
    public void setJoinMessage(String message) {
        pluginManager.registerEvents(new JoinListener(message), plugin);
    }

    /**
     * <p>Registers a new Listener with the only purpose to set the provided message as the quit message.</p>
     * <p>NOTICE: Use the placeholder "playerName" to insert the quitting player's name at this position of the String.</p>
     *
     * @param message The message
     */
    public void setQuitMessage(String message) {
        pluginManager.registerEvents(new QuitListener(message), plugin);
    }

    private record JoinListener(String joinMessage) implements Listener {
        @EventHandler
        public void onPlayerJoin(PlayerJoinEvent e) {
            e.setJoinMessage(joinMessage.replaceAll("playerName", e.getPlayer().getName()));
        }
    }

    private record QuitListener(String quitMessage) implements Listener {
        @EventHandler
        public void onPlayerQuit(PlayerQuitEvent e) {
            e.setQuitMessage(quitMessage.replaceAll("playerName", e.getPlayer().getName()));
        }
    }
}
