package io.github.sefiraat.slimetinker.runnables.event;

import com.molean.folia.adapter.FoliaRunnable;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class RemoveMagmaBlock extends FoliaRunnable {

    private final Block block;

    public RemoveMagmaBlock(Block block) {
        this.block = block;
    }

    @Override
    public void run() {
        block.setType(Material.LAVA);
    }
}
