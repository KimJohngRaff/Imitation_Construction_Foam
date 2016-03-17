package com.KJR.ICF.registry;

import com.KJR.ICF.ICF_Global;
import com.KJR.ICF.MaterialsICF;
import com.KJR.ICF.items.Item_ICF_Dust_Metal;
import com.KJR.ICF.items.Item_ICF_Dust_Other;
import com.KJR.ICF.items.Item_ICF_Ingot;
import com.KJR.ICF.items.Item_ICF_Misc_1;
import com.KJR.ICF.items.Item_ICF_SwineHammer;
import com.KJR.ICF.items.armor.Item_ICF_EndimandiumArmor;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ICF_Items {

	//declare items
	public static Item icfIngot;
	public static Item icfDust_Metal;
	public static Item icfDust_Other;
	public static Item icfMisc_1;
	
	//tools
	public static Item toolEndimandiumSwineHammer;
	public static Item toolAluminumSwineHammer;
	public static Item toolBronzeSwineHammer;
	
	//armor
	public static ArmorMaterial ENDIMANDIUMARMOR = EnumHelper.addArmorMaterial("ENDIMANDIUMARMOR", ICF_Global.modID + ":" + "endimandium", 80, new int[]{5, 10, 8, 5}, 40);

	public static Item endimandiumHelmet;
	public static Item endimandiumChestplate;
	public static Item endimandiumLeggings;
	public static Item endimandiumBoots;
	
	//initialize items
	public static void initItems() {
		GameRegistry.registerItem(icfIngot = new Item_ICF_Ingot(), "icfIngot");
		GameRegistry.registerItem(icfDust_Metal = new Item_ICF_Dust_Metal(), "icfDust_Metal");
		GameRegistry.registerItem(icfDust_Other = new Item_ICF_Dust_Other(), "icfDust_Other");
		GameRegistry.registerItem(icfMisc_1 = new Item_ICF_Misc_1(), "icfMisc_1");
		GameRegistry.registerItem(toolEndimandiumSwineHammer = new Item_ICF_SwineHammer(MaterialsICF.EndimandiumToolMaterial).setUnlocalizedName("SwineHammerEndimandium"), "SwineHammerEndimandium");
		GameRegistry.registerItem(toolAluminumSwineHammer = new Item_ICF_SwineHammer(MaterialsICF.AluminiumToolMaterial).setUnlocalizedName("SwineHammerAluminium"), "SwineHammerAluminum");
		GameRegistry.registerItem(toolBronzeSwineHammer = new Item_ICF_SwineHammer(MaterialsICF.BronzeToolMaterial).setUnlocalizedName("SwineHammerBronze"), "SwineHammerBronze");
		GameRegistry.registerItem(endimandiumHelmet = new Item_ICF_EndimandiumArmor("endimandiumHelmet", ENDIMANDIUMARMOR, 1, 0), "endimandiumHelmet");
		GameRegistry.registerItem(endimandiumChestplate = new Item_ICF_EndimandiumArmor("endimandiumChestplate", ENDIMANDIUMARMOR, 1, 1), "endimandiumChestplate");
		GameRegistry.registerItem(endimandiumLeggings = new Item_ICF_EndimandiumArmor("endimandiumLeggings", ENDIMANDIUMARMOR, 2, 2), "endimandiumLeggings");
		GameRegistry.registerItem(endimandiumBoots = new Item_ICF_EndimandiumArmor("endimandiumBoots", ENDIMANDIUMARMOR, 1, 3), "endimandiumBoots");
	}
	
	//register item variants
	public static void registerItemVariants() {
		for (int i = 0; i < Item_ICF_Ingot.names.length; i++) {
			ModelBakery.registerItemVariants(icfIngot, new ModelResourceLocation(ICF_Global.modID + ":ingot" + Item_ICF_Ingot.names[i], "inventory"));
		}
		for (int i = 0; i < Item_ICF_Dust_Metal.names.length; i++) {
			ModelBakery.registerItemVariants(icfDust_Metal, new ModelResourceLocation(ICF_Global.modID + ":dust" + Item_ICF_Dust_Metal.names[i], "inventory"));
		}
		for (int i = 0; i < Item_ICF_Dust_Other.names.length; i++) {
			ModelBakery.registerItemVariants(icfDust_Other, new ModelResourceLocation(ICF_Global.modID + ":dust" + Item_ICF_Dust_Other.names[i], "inventory"));
		}
		for (int i = 0; i < Item_ICF_Misc_1.names.length; i++) {
			ModelBakery.registerItemVariants(icfMisc_1, new ModelResourceLocation(ICF_Global.modID + ":item" + Item_ICF_Misc_1.names[i], "inventory"));
		}
		ModelBakery.registerItemVariants(toolEndimandiumSwineHammer, new ModelResourceLocation(ICF_Global.modID + ":SwineHammerEndimandium", "inventory"));
		ModelBakery.registerItemVariants(toolAluminumSwineHammer, new ModelResourceLocation(ICF_Global.modID + ":SwineHammerAluminum", "inventory"));
		ModelBakery.registerItemVariants(toolBronzeSwineHammer, new ModelResourceLocation(ICF_Global.modID + ":SwineHammerBronze", "inventory"));
		ModelBakery.registerItemVariants(endimandiumHelmet, new ModelResourceLocation(ICF_Global.modID + ":endimandiumHelmet", "inventory"));
		ModelBakery.registerItemVariants(endimandiumChestplate, new ModelResourceLocation(ICF_Global.modID + ":endimandiumChestplate", "inventory"));
		ModelBakery.registerItemVariants(endimandiumLeggings, new ModelResourceLocation(ICF_Global.modID + ":endimandiumLeggings", "inventory"));
		ModelBakery.registerItemVariants(endimandiumBoots, new ModelResourceLocation(ICF_Global.modID + ":endimandiumBoots", "inventory"));
	}
	
	//render Items
	public static void renderItems() {
		for (int i = 0; i < Item_ICF_Ingot.names.length; i++) {
			registerRenders(icfIngot, i, "ingot" + Item_ICF_Ingot.names[i]);
		}
		for (int i = 0; i < Item_ICF_Dust_Metal.names.length; i++) {
			registerRenders(icfDust_Metal, i, "dust" + Item_ICF_Dust_Metal.names[i]);
		}
		for (int i = 0; i < Item_ICF_Dust_Other.names.length; i++) {
			registerRenders(icfDust_Other, i, "dust" + Item_ICF_Dust_Other.names[i]);
		}
		for (int i = 0; i < Item_ICF_Misc_1.names.length; i++) {
			registerRenders(icfMisc_1, i, "item" + Item_ICF_Misc_1.names[i]);
		}
		registerRenders(toolEndimandiumSwineHammer, 0, "SwineHammerEndimandium");
		registerRenders(toolAluminumSwineHammer, 0, "SwineHammerAluminum");
		registerRenders(toolBronzeSwineHammer, 0, "SwineHammerBronze");
		registerRenders(endimandiumHelmet, 0, "endimandiumHelmet");
		registerRenders(endimandiumChestplate, 0, "endimandiumChestplate");
		registerRenders(endimandiumLeggings, 0, "endimandiumLeggings");
		registerRenders(endimandiumBoots, 0, "endimandiumBoots");
	}
	
	//create methods to be used in this class
	public static void registerRenders(Item item, int meta, String name) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(ICF_Global.modID + ":" + name, "inventory"));
	}
	
}
