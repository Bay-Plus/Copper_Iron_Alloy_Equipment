package com.young.alloycraft.tools;

import com.young.alloycraft.Alloycraft;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class AlloyPickaxeMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 750;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 7;
    }

    @Override
    public float getAttackDamage() {
        return -1;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(Alloycraft.ALLOY_INGOT);
    }
}
