package net.boypika.sword;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;

public class WitherWhacker extends SwordItem {
    public WitherWhacker(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target instanceof WitherEntity){
            target.damage(target.getRecentDamageSource(), 100000000000f);
        }
        else {
            attacker.sendMessage(Text.translatable("text.item.bosswhackers.event_fail_message.wither_whacker"));
            target.heal(1f);
        }
        return true;
    }
}
