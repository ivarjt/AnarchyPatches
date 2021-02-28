package me.epik.anarchypatches.events;

import me.epik.anarchypatches.Main;
import org.bukkit.Chunk;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class FallingEntityFix implements Listener {
    private final Main plugin;

    public FallingEntityFix(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    private void onFallingChange(EntityChangeBlockEvent event) {
        Chunk chunk = event.getBlock().getChunk();
        int limit = 0;
        for (Entity entity : chunk.getEntities()) {
            if (entity instanceof FallingBlock) {
                if (limit < 40) {
                    limit++;
                    continue;
                } else {
                    entity.remove();
                    break;
                }
            }
        }
    }
}
