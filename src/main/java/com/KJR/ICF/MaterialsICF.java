package com.KJR.ICF;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MaterialsICF {

	public static ArmorMaterial EndimandiumArmorMaterial = EnumHelper.addArmorMaterial("EndimandiumArmorMaterial", "EndimandiumArmorMaterial", 45, new int[] {3, 8, 6, 3}, 20);
	
	public static ToolMaterial EndimandiumToolMaterial = EnumHelper.addToolMaterial("EndimandiumToolMaterial", 4, 3500, 27.0F, 7.0F, 22);
	public static ToolMaterial AluminiumToolMaterial = EnumHelper.addToolMaterial("AluminiumToolMaterial", 4, 200, 7.0F, 3.0F, 12);
	public static ToolMaterial BronzeToolMaterial = EnumHelper.addToolMaterial("BronzeToolMaterial", 4, 650, 13.0F, 3.0F, 10);
	
}

