package com.KJR.ICF.api.registry;

import com.KJR.ICF.ICF_Global;
import com.KJR.ICF.blocks.Block_ICF_Metal;
import com.KJR.ICF.blocks.Block_ICF_Ore;
import com.KJR.ICF.blocks.Block_of_ICF;
import com.KJR.ICF.itemBlocks.ICF_ItemBlock_String;
import com.google.common.collect.Lists;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ICF_Blocks {
	
	//declare blocks
	public static Block icfBlock;
	public static Block icfOre;
	public static Block icfMetalBlock;
	
	//string array declarations
	public static final String[] icfBlock_names = new String[] {"black", "red", "green", "brown", "blue", "purple", "cyan", "lgray", "gray", "pink", "lime", "yellow", "lblue", "magenta", "orange", "white"};
	public static final String[] icfOre_names = new String[] {"platinum", "tin", "silver", "aluminum", "copper", "nickel", "sulfur", "potassium_nitrate"};
	public static final String[] icfMetalBlock_names = new String[] {"blockendimandium", "blockplatinum", "blocktin", "blocksilver", "blockaluminum", "blockcopper", "blockbronze", "blocknickel", "blockweakenedquartz", "blockenderpaste", "blockenderium",};
	
	//initialize blocks
	public static void initBlocks() {
		//icf
		GameRegistry.registerBlock(icfBlock = new Block_of_ICF("icfBlock", Material.rock, icfBlock_names, 3, 15), ICF_ItemBlock_String.class, "icfBlock");
		GameRegistry.registerBlock(icfOre = new Block_ICF_Ore("icfOre", Material.rock, icfOre_names, 3, 15), ICF_ItemBlock_String.class, "icfOre");
		GameRegistry.registerBlock(icfMetalBlock = new Block_ICF_Metal("icfMetalBlock", Material.iron, icfMetalBlock_names, 3, 15), ICF_ItemBlock_String.class, "icfMetalBlock");
	}
	
	//render blocks
	public static void renderBlocks() {
		
		for (int i = 0; i < 16; i++) {
			registerRenders(icfBlock, i, "foam" + icfBlock_names[i]);
		}
		for (int i = 0; i < 8; i++) {
			registerRenders(icfOre, i, icfOre_names[i] + "Ore");
		}
		for (int i = 0; i < 11; i++) {
			registerRenders(icfMetalBlock, i, icfMetalBlock_names[i]);
		}
		
	}
	
	//register item variants
	public static void registerBlockItemVariants() {
	
		for (int i = 0; i < 16; i++) {
			ModelBakery.registerItemVariants(Item.getItemFromBlock(icfBlock), new ModelResourceLocation(ICF_Global.modID + ":foam" + icfBlock_names[i], "inventory"));
		}
		for (int i = 0; i < 8; i++) {
			ModelBakery.registerItemVariants(Item.getItemFromBlock(icfOre), new ModelResourceLocation(ICF_Global.modID + ":" + icfOre_names[i] + "Ore", "inventory"));
		}
		for (int i = 0; i < 11; i++) {
			ModelBakery.registerItemVariants(Item.getItemFromBlock(icfMetalBlock), new ModelResourceLocation(ICF_Global.modID + ":" + icfMetalBlock_names[i], "inventory"));
		}
		
	}
    
	//create methods to be used in this class
	public static void registerRenders(Block block, int meta, String texure_name) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(ICF_Global.modID + ":" + texure_name, "inventory"));
	}

}
