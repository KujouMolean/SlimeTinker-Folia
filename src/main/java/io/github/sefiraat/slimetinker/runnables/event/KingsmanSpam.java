package io.github.sefiraat.slimetinker.runnables.event;

import com.molean.folia.adapter.FoliaRunnable;
import io.github.sefiraat.slimetinker.utils.EntityUtils;
import io.github.sefiraat.slimetinker.utils.GeneralUtils;
import io.github.sefiraat.slimetinker.utils.WorldUtils;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class KingsmanSpam extends FoliaRunnable {

    private final Player p;
    private final Location l;
    private int runs;

    public KingsmanSpam(Player p, int runs) {
        this.p = p;
        this.l = p.getLocation();
        this.runs = runs;
    }

    @Override
    public void run() {
        if (runs <= 0) {
            this.cancel();
        } else {
            int rnd1 = GeneralUtils.roll(255);
            int rnd2 = GeneralUtils.roll(255);
            int rnd3 = GeneralUtils.roll(255);
            int rnd4 = GeneralUtils.roll(255);
            int rnd5 = GeneralUtils.roll(255);

            Particle.DustOptions d1 = new Particle.DustOptions(Color.fromRGB(rnd1, rnd2, rnd3), 5);
            Particle.DustOptions d2 = new Particle.DustOptions(Color.fromRGB(rnd5, rnd1, rnd2), 5);
            Particle.DustOptions d3 = new Particle.DustOptions(Color.fromRGB(rnd4, rnd5, rnd1), 5);
            Particle.DustOptions d4 = new Particle.DustOptions(Color.fromRGB(rnd3, rnd4, rnd5), 5);
            Particle.DustOptions d5 = new Particle.DustOptions(Color.fromRGB(rnd2, rnd3, rnd4), 5);

            Location l1 = WorldUtils.getRandomLocationInRange(p, 5, 2, 5);
            Location l2 = WorldUtils.getRandomLocationInRange(p, 5, 2, 5);
            Location l3 = WorldUtils.getRandomLocationInRange(p, 5, 2, 5);
            Location l4 = WorldUtils.getRandomLocationInRange(p, 5, 2, 5);
            Location l5 = WorldUtils.getRandomLocationInRange(p, 5, 2, 5);

            l.getWorld().spawnParticle(Particle.DUST, l1, 30, 3, 3, 3, 1, d1);
            l.getWorld().spawnParticle(Particle.DUST, l2, 30, 3, 3, 3, 1, d2);
            l.getWorld().spawnParticle(Particle.DUST, l3, 30, 3, 3, 3, 1, d3);
            l.getWorld().spawnParticle(Particle.DUST, l4, 30, 3, 3, 3, 1, d4);
            l.getWorld().spawnParticle(Particle.DUST, l5, 30, 3, 3, 3, 1, d5);

            List<LivingEntity> damaged = new ArrayList<>();

            damaged.addAll(EntityUtils.getNearbyEntitiesByType(LivingEntity.class, l1, 2, 2, 2));
            damaged.addAll(EntityUtils.getNearbyEntitiesByType(LivingEntity.class, l2, 2, 2, 2));
            damaged.addAll(EntityUtils.getNearbyEntitiesByType(LivingEntity.class, l3, 2, 2, 2));
            damaged.addAll(EntityUtils.getNearbyEntitiesByType(LivingEntity.class, l4, 2, 2, 2));
            damaged.addAll(EntityUtils.getNearbyEntitiesByType(LivingEntity.class, l5, 2, 2, 2));

            for (LivingEntity e : damaged) {
                if (e.getUniqueId() != p.getUniqueId()) {
                    e.damage(2, p);
                }
            }
            runs--;
        }
    }
}
