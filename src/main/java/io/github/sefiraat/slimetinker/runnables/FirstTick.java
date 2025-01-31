package io.github.sefiraat.slimetinker.runnables;

import com.molean.folia.adapter.FoliaRunnable;
import io.github.sefiraat.slimetinker.SlimeTinker;

public class FirstTick extends FoliaRunnable {

    @Override
    public void run() {
        SlimeTinker.getInstance().getWorkbench().setupRecipes();
    }
}
