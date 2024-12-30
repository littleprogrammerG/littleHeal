package dev.littleprogrammer.littleHeal;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("heal").setExecutor(new HealCommand());

        Bukkit.getServer().getLogger().info("[littleHeal] Enabled!");
    }
}
