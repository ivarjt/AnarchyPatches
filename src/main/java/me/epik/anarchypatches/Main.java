package me.epik.anarchypatches;

import me.epik.anarchypatches.events.DispenserFix;
import me.epik.anarchypatches.events.FallingEntityFix;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static final String NAME = "AnarchyPatches";

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + NAME + "Is enabled!");
        pm.registerEvents(new DispenserFix(this),this);
        pm.registerEvents(new FallingEntityFix(this), this);
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + NAME + "Is disabled!");
    }
}
