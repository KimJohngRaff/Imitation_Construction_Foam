package com.KJR.ICF.proxy;

import com.KJR.ICF.api.handler.ICF_Armor_Effect_Handler;
import com.KJR.ICF.api.handler.ICF_Drops_Handler;
import com.KJR.ICF.registry.ICF_Blocks;
import com.KJR.ICF.registry.ICF_Items;
import com.KJR.ICF.registry.OreRegistry;
import com.KJR.ICF.registry.Recipes;
import com.KJR.ICF.registry.SwineRegistry;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public void preInit(FMLPreInitializationEvent preEvent){
		
		ICF_Blocks.initBlocks();
		ICF_Items.initItems();
		
		Recipes.init();
		
	}
	
	public void init(FMLInitializationEvent event){
		
		MinecraftForge.EVENT_BUS.register(new ICF_Armor_Effect_Handler());
		MinecraftForge.EVENT_BUS.register(new ICF_Drops_Handler());
		
	}
	
	public void postInit(FMLPostInitializationEvent postEvent){
		
	}
	
}
