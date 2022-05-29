package ntdi.world.releamclient;

import ntdi.world.releamclient.DiscordBot.BotThread;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class ReleamClient extends JavaPlugin {
    public static HashMap<String, Integer> warns = new HashMap<>();

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("");
        Bukkit.getLogger().info("█▀█ █▀▀    Releam Client Enabled");
        Bukkit.getLogger().info("█▀▄ █▄▄    By Ntdi");
        Bukkit.getLogger().info("");
        BotThread thread = new BotThread();
        thread.start();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
