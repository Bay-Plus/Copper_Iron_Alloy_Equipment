package com.young.alloycraft.armor.material;

import com.young.alloycraft.Alloycraft;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class AlloyArmorMaterial implements ArmorMaterial {

    // 数值顺序：头盔、胸甲、护腿、靴子
    public static final int[] DURABILITY = {264, 384, 360, 312};
    public static final int[] PROTECTION = {2, 7, 6, 2};


    @Override
    public int getDurability(EquipmentSlot slot) {
        return DURABILITY[slot.getEntitySlotId()];
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return PROTECTION[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Alloycraft.ALLOY_INGOT);
    }

    @Override
    public String getName() {
        return "alloyarmor";  // 这里的名字必须有，且必须和“alloyarmor_layer_1”里第一个_前的一模一样！
    }

    @Override
    public float getToughness() {
        return 1.0f;
    }

    @Override
    public float getKnockbackResistance() {
        return 0;
    }
}
