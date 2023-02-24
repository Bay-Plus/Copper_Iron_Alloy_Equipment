package com.young.alloycraft;

import com.young.alloycraft.armor.AlloyArmorItem;
import com.young.alloycraft.armor.material.AlloyArmorMaterial;
import com.young.alloycraft.items.AlloyIngot;
import com.young.alloycraft.tools.*;
import com.young.alloycraft.tools.weapon.AlloySword;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Alloycraft implements ModInitializer {

    public Alloycraft() {
    }

    public static void main(String[] args) {
    }

    public static final AlloyIngot ALLOY_INGOT = new AlloyIngot(new Item.Settings());  // 铜铁合金锭
    public static final Block ALLOY_BLOCK = new Block(AbstractBlock.Settings.of(Material.STONE).requiresTool().hardness(5.0f));
    public static final ArmorMaterial ALLOY_MATERIAL = new AlloyArmorMaterial();
    public static final AlloyArmorItem ALLOY_HELMET = new AlloyArmorItem(ALLOY_MATERIAL, EquipmentSlot.HEAD, new Item.Settings());
    public static final AlloyArmorItem ALLOY_CHEST = new AlloyArmorItem(ALLOY_MATERIAL, EquipmentSlot.CHEST, new Item.Settings());
    public static final AlloyArmorItem ALLOY_LEGGINGS = new AlloyArmorItem(ALLOY_MATERIAL, EquipmentSlot.LEGS, new Item.Settings());
    public static final AlloyArmorItem ALLOY_BOOTS = new AlloyArmorItem(ALLOY_MATERIAL, EquipmentSlot.FEET, new Item.Settings());
    public static final AlloySword ALLOY_SWORD = new AlloySword(new AlloySwordMaterial(),
            6, -2.4f, new Item.Settings());
    public static final AlloyAxe ALLOY_AXE = new AlloyAxe(new AlloyAxeMaterial(),
            9, -3.05f, new Item.Settings());
    public static final AlloyPickaxe ALLOY_PICKAXE = new AlloyPickaxe(new AlloyPickaxeMaterial(),
            4, -2.8f, new Item.Settings());
    public static final AlloyShovel ALLOY_SHOVEL = new AlloyShovel(new AlloyShovelMaterial(),
            5, -3f, new Item.Settings());
    public static final AlloyHoe ALLOY_HOE = new AlloyHoe(new AlloyHoeMaterial(),
            1, -0.5f, new Item.Settings());

    @Override
    public void onInitialize() {

        // 注册物品
        Registry.register(Registries.ITEM, new Identifier("alloycraft", "alloy_ingot"), ALLOY_INGOT);
        Registry.register(Registries.BLOCK, new Identifier("alloycraft", "alloy_block"), ALLOY_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("alloycraft", "alloy_block"),
                new BlockItem(ALLOY_BLOCK, new Item.Settings()));
        Registry.register(Registries.ITEM, new Identifier("alloycraft", "alloy_helmet"), ALLOY_HELMET);
        Registry.register(Registries.ITEM, new Identifier("alloycraft", "alloy_chestplate"), ALLOY_CHEST);
        Registry.register(Registries.ITEM, new Identifier("alloycraft", "alloy_leggings"), ALLOY_LEGGINGS);
        Registry.register(Registries.ITEM, new Identifier("alloycraft", "alloy_boots"), ALLOY_BOOTS);
        Registry.register(Registries.ITEM, new Identifier("alloycraft", "alloy_sword"), ALLOY_SWORD);
        Registry.register(Registries.ITEM, new Identifier("alloycraft", "alloy_axe"), ALLOY_AXE);
        Registry.register(Registries.ITEM, new Identifier("alloycraft", "alloy_pickaxe"), ALLOY_PICKAXE);
        Registry.register(Registries.ITEM, new Identifier("alloycraft", "alloy_shovel"), ALLOY_SHOVEL);
        Registry.register(Registries.ITEM, new Identifier("alloycraft", "alloy_hoe"), ALLOY_HOE);

        // 设置分组
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {
            content.addAfter(Items.COPPER_INGOT, ALLOY_INGOT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {
            content.addAfter(Items.IRON_BLOCK, ALLOY_BLOCK);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
            content.addAfter(Items.IRON_BOOTS, ALLOY_BOOTS);
            content.addAfter(Items.IRON_BOOTS, ALLOY_LEGGINGS);
            content.addAfter(Items.IRON_BOOTS, ALLOY_CHEST);
            content.addAfter(Items.IRON_BOOTS, ALLOY_HELMET);
            content.addAfter(Items.IRON_SWORD, ALLOY_SWORD);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.STONE_HOE, ALLOY_HOE);
            content.addAfter(Items.STONE_HOE, ALLOY_AXE);
            content.addAfter(Items.STONE_HOE, ALLOY_PICKAXE);
            content.addAfter(Items.STONE_HOE, ALLOY_SHOVEL);
        });
    }
}
