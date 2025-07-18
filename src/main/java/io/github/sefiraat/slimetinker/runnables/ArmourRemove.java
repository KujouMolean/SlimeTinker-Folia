package io.github.sefiraat.slimetinker.runnables;

import com.molean.folia.adapter.Folia;
import com.molean.folia.adapter.FoliaRunnable;
import io.github.sefiraat.slimetinker.SlimeTinker;
import io.github.sefiraat.slimetinker.utils.ItemUtils;
import io.github.sefiraat.slimetinker.utils.ThemeUtils;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class ArmourRemove extends FoliaRunnable {

    @Override
    public void run() {
        for (Player player : SlimeTinker.getInstance().getServer().getOnlinePlayers()) {

            Folia.runSync(() -> {
                ItemStack helmet = player.getInventory().getHelmet();
                ItemStack chestplate = player.getInventory().getChestplate();
                ItemStack leggings = player.getInventory().getLeggings();
                ItemStack boots = player.getInventory().getBoots();

                if (ItemUtils.isArmour(helmet) && ItemUtils.isTinkersBroken(helmet) && ItemUtils.doesUnequipWhenBroken(helmet)) {
                    unequip(player, helmet);
                }
                if (ItemUtils.isArmour(chestplate) && ItemUtils.isTinkersBroken(chestplate) && ItemUtils.doesUnequipWhenBroken(chestplate)) {
                    unequip(player, chestplate);
                }
                if (ItemUtils.isArmour(leggings) && ItemUtils.isTinkersBroken(leggings) && ItemUtils.doesUnequipWhenBroken(leggings)) {
                    unequip(player, leggings);
                }
                if (ItemUtils.isArmour(boots) && ItemUtils.isTinkersBroken(boots) && ItemUtils.doesUnequipWhenBroken(boots)) {
                    unequip(player, boots);
                }

            }, player);
        }
    }

    private void unequip(@Nonnull Player player, @Nonnull ItemStack itemStack) {
        Inventory i = player.getInventory();
        ItemStack newItem = itemStack.clone();
        itemStack.setAmount(0);
        if (i.firstEmpty() > -1) {
            i.addItem(newItem);
            player.sendMessage(ThemeUtils.WARNING + "你的某件防具已损坏! 它已自动卸到你的物品栏中.");
        } else {
            player.getWorld().dropItemNaturally(player.getLocation(), newItem);
            player.sendMessage(ThemeUtils.WARNING + "你的某件防具已损坏! 你的物品栏已满,它掉在地上了.");
        }
    }
}
