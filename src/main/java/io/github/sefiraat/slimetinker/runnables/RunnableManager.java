package io.github.sefiraat.slimetinker.runnables;

import com.molean.folia.adapter.Folia;
import io.github.sefiraat.slimetinker.SlimeTinker;

public class RunnableManager {

    private final EffectTick effectTick;
    private final TrailTick trailTick;
    private final ArmourRemove armourRemove;
    private final FirstTick firstTick;

    public RunnableManager() {
        final SlimeTinker plugin = SlimeTinker.getInstance();

        this.effectTick = new EffectTick();
        effectTick.runTaskTimerAsynchronously(plugin, 0, SlimeTinker.RUNNABLE_TICK_RATE);

        this.trailTick = new TrailTick();
        trailTick.runTaskTimerAsynchronously(plugin, 0, 5);

        this.armourRemove = new ArmourRemove();
        armourRemove.runTaskTimerAsynchronously(plugin, 0, SlimeTinker.RUNNABLE_TICK_RATE);

        this.firstTick = new FirstTick();

        Folia.runAtFirstTick(plugin, firstTick::run);
    }
}
