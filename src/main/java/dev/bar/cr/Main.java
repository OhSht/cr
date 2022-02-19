package dev.bar.cr;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.nio.channels.FileChannel;

public final class Main extends JavaPlugin {


    @Override
    public void onEnable() {
        saveConfig();
        this.getCommand("punish").setExecutor(new Cmds());
        final FileConfiguration config = this.getConfig();
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents((Listener) new ListenerM(this), this);

    }

    @Override
    public void onDisable() {
        saveConfig();
    }
}
