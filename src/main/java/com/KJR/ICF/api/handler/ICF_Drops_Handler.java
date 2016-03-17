package com.KJR.ICF.api.handler;

import java.util.Random;

import com.KJR.ICF.items.Item_ICF_SwineHammer;
import com.KJR.ICF.registry.SwineRegistry;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ICF_Drops_Handler {

	@SubscribeEvent
	public void addBlockDrop (HarvestDropsEvent event) {
		if (SwineRegistry.swineableItems.contains(Item.getItemFromBlock(event.state.getBlock()))){
			ItemStack holding = event.harvester.inventory.getStackInSlot(event.harvester.inventory.currentItem);
			if (holding != null  && holding.getItem() instanceof Item_ICF_SwineHammer) {
				event.drops.clear();
			}
		}
	}
}
