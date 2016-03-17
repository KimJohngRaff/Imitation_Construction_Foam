package com.KJR.ICF.registry;

import com.KJR.ICF.items.Item_ICF_Ingot;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipes {
	
	public static void init() {
		
		//smelting ores
		for (int i = 0; i < 6; i++) {
			GameRegistry.addSmelting(new ItemStack(ICF_Blocks.icfOre, 1, i), new ItemStack(ICF_Items.icfIngot, 1, i), 1.0F);
		}
		
		//smelting dust
		for (int i = 0; i < Item_ICF_Ingot.names.length; i++) {
			GameRegistry.addSmelting(new ItemStack(ICF_Items.icfDust_Metal, 1, i), new ItemStack(ICF_Items.icfIngot, 1, i), 1.0F);
		}
		
		//other smelting
		//GameRegistry.addSmelting(new ItemStack(Items.egg), new ItemStack(FoodDecICF.foodFriedEgg), 1.0F);
		GameRegistry.addSmelting(new ItemStack(ICF_Items.icfMisc_1, 1, 1), new ItemStack(ICF_Blocks.icfBlock, 1, 7), 1.0F);
		GameRegistry.addSmelting(new ItemStack(ICF_Items.icfMisc_1, 1, 3), new ItemStack(ICF_Blocks.icfMetalBlock, 1, 8), 1.0F);
		GameRegistry.addSmelting(new ItemStack(ICF_Items.icfMisc_1, 1, 4), new ItemStack(ICF_Items.icfMisc_1, 1, 5), 1.0F);
		
		//ICF coloring
		int x = OreDictionary.WILDCARD_VALUE;
		String[] colors = new String[] {"dyeBlack", "dyeRed", "dyeGreen", "dyeBrown", "dyeBlue", "dyePurple","dyeCyan", "dyeLightGray", "dyeGray", "dyePink", "dyeLime", "dyeYellow", "dyeLightBlue", "dyeMagenta", "dyeOrange", "dyeWhite"};
		for (int j = 0; j < ICF_Blocks.icfBlock_names.length; j++) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ICF_Blocks.icfBlock, 8, j), "iii", "idi", "iii", 'i', new ItemStack(ICF_Blocks.icfBlock, 1, x), 'd', colors[j]));
		}
		
		//ingots to block
		for (int i = 0; i < Item_ICF_Ingot.names.length; i++) {
			GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ICF_Blocks.icfMetalBlock, 1, i), "iii", "iii", "iii", 'i', "ingot" + Item_ICF_Ingot.names[i].substring(0, 1).toUpperCase() + Item_ICF_Ingot.names[i].substring(1)));
		}
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ICF_Blocks.icfMetalBlock, 1, 9), Blocks.quartz_block , new ItemStack(ICF_Items.icfMisc_1, 1, 4), new ItemStack(Items.water_bucket)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ICF_Blocks.icfMetalBlock, 1, 9), Items.quartz, Items.quartz, Items.quartz, Items.quartz, new ItemStack(ICF_Items.icfMisc_1, 1, 4), Items.water_bucket));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ICF_Blocks.icfMetalBlock, 1, 10), "iii", "iii", "iii", 'i', new ItemStack(ICF_Items.icfMisc_1, 1, 7)));
		
		//block to ingots
		for (int i = 0; i < Item_ICF_Ingot.names.length; i++) {
			GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ICF_Items.icfIngot, 9, i), new ItemStack(ICF_Blocks.icfMetalBlock, 1, i)));
		}
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ICF_Items.icfMisc_1, 1, 7), new ItemStack(ICF_Blocks.icfMetalBlock, 1, 10)));
		
		//other crafting
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ICF_Items.icfMisc_1, 1, 0), "s s", "s s", "sss", 's', "slabWood"));
		GameRegistry.addShapedRecipe(new ItemStack(ICF_Items.icfMisc_1, 1, 1), "scs", "gwg", "gig", 's', new ItemStack(Blocks.sand), 'c', new ItemStack(Blocks.clay), 'g', new ItemStack(Blocks.gravel), 'w', new ItemStack(Items.water_bucket), 'i', new ItemStack(ICF_Items.icfMisc_1, 1, 0));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ICF_Items.icfDust_Metal, 1, 6), "dustCopper", "dustCopper", "dustCopper", "dustTin"));
		
		//swine hammers
//		GameRegistry.addRecipe(new ShapedOreRecipe(ItemDecICF.toolAluminiumSwineHammer, " ii", "ssi", " ii", 'i', "ingotAluminum", 's', "stickWood"));
//		GameRegistry.addRecipe(new ShapedOreRecipe(ItemDecICF.toolBronzeSwineHammer, " ii", "ssi", " ii", 'i', "ingotBronze", 's', "stickWood"));
//		GameRegistry.addRecipe(new ShapedOreRecipe(ItemDecICF.toolEndimandiumSwineHammer, " ii", "ssi", " ii", 'i', "ingotEndimandium", 's', "stickWood"));
		
		//acid stuff
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ICF_Items.icfMisc_1, 1, 4), "iii", "nsn", "iii", 'i', "dustSulfur", 'n', "dustSaltpeter", 's', Items.water_bucket));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ICF_Items.icfMisc_1, 1, 3), "isi", "isi", "igi", 'i', "dustDiamond", 's', "blockEnderiumpaste", 'g', new ItemStack(ICF_Items.icfMisc_1, 1, 0)));
		GameRegistry.addSmelting(new ItemStack(ICF_Blocks.icfMetalBlock, 1, 10), new ItemStack(ICF_Blocks.icfMetalBlock, 1, 7), 1.0F);
		GameRegistry.addSmelting(new ItemStack(ICF_Items.icfMisc_1, 1, 6), new ItemStack(ICF_Items.icfIngot, 1, 7), 1.0F);
		
		ItemStack e = new ItemStack(Items.ender_pearl);
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ICF_Items.icfMisc_1, 1, 7), e, e, e, e, "dustPlatinum", "dustSilver", "dustTin", "dustTin", new ItemStack(ICF_Items.icfMisc_1, 1, 4)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ICF_Items.icfMisc_1, 4, 6), Items.redstone, Items.blaze_powder, "dustCoal", "dustSulfur", new ItemStack(ICF_Items.icfMisc_1, 1, 7)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ICF_Items.icfMisc_1, 4, 6), "ingotEnderium", new ItemStack(ICF_Items.icfMisc_1, 1, 4)));
		GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ICF_Blocks.icfMetalBlock, 1, 10), new ItemStack(ICF_Items.icfMisc_1, 1, 4), "blockEnderium"));
		
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.netherrack, 8, 0), "iii", "isi", "iii", 'i', Items.netherbrick, 's', new ItemStack(ICF_Items.icfMisc_1, 1, 4)));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.clay_ball, 8, 0), "iii", "isi", "iii", 'i', Items.brick, 's', new ItemStack(ICF_Items.icfMisc_1, 1, 4)));
	}
}
