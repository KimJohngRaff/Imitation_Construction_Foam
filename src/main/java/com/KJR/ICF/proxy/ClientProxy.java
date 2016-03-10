package com.KJR.ICF.proxy;

import com.KJR.ICF.api.registry.ICF_Blocks;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	
	public void preInit(FMLPreInitializationEvent preEvent){
		
		super.preInit(preEvent);
		
		ICF_Blocks.registerBlockItemVariants();
		
	}
	
	
	public void init(FMLInitializationEvent event){
		
		super.init(event);
		
		ICF_Blocks.renderBlocks();
		
	}
	
	
	public void postInit(FMLPostInitializationEvent postEvent){
		
		super.postInit(postEvent);
		
	}
	
}
