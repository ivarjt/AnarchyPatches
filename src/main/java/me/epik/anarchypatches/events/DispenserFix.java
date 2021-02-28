package me.epik.anarchypatches.events;

import me.epik.anarchypatches.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.type.Dispenser;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class DispenserFix implements Listener {
    private final Main plugin;

    public DispenserFix(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onBlockPlace(BlockPlaceEvent event) {
        Block block = event.getBlockPlaced();
        Dispenser dispenser =  (Dispenser) block.getBlockData();
        if (block.getType() == Material.DISPENSER && block.getY() == 255 && dispenser.getFacing() == BlockFace.UP || block.getY() == 0 && dispenser.getFacing() == BlockFace.DOWN) {
            block.breakNaturally();
        }
    }
}
