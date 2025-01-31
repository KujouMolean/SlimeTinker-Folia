package io.github.sefiraat.slimetinker.runnables.event;

import com.molean.folia.adapter.FoliaRunnable;
import org.bukkit.entity.Wolf;

public class RemoveWolf extends FoliaRunnable {

    private final Wolf wolf;

    public RemoveWolf(Wolf wolf) {
        this.wolf = wolf;
    }

    @Override
    public void run() {
        wolf.remove();
        this.cancel();
    }
}
