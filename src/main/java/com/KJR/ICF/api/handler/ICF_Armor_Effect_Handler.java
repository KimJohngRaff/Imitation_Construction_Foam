package com.KJR.ICF.api.handler;

import com.KJR.ICF.registry.ICF_Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ICF_Armor_Effect_Handler {
	
	public int heal_counter = 0;
	
	@SubscribeEvent
    public void LivingUpdate(LivingUpdateEvent event) {
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)event.entity;
			
			if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == ICF_Items.endimandiumHelmet){
				this.waterbreathing(player);
				this.saturate(player);
			}
			else if(player.inventory.armorItemInSlot(3) == null || player.inventory.armorItemInSlot(3).getItem() != ICF_Items.endimandiumHelmet){
			
			}
			if (player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == ICF_Items.endimandiumChestplate){
			
			}
			else if(player.inventory.armorItemInSlot(2) == null || player.inventory.armorItemInSlot(2).getItem() != ICF_Items.endimandiumChestplate){
			
			}
			if (player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == ICF_Items.endimandiumLeggings){
				this.setSpeedFast(player);
			}
			else if(player.inventory.armorItemInSlot(1) == null || player.inventory.armorItemInSlot(1).getItem() != ICF_Items.endimandiumLeggings){
				this.setSpeedDefault(player);
			}
			if (player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == ICF_Items.endimandiumBoots){
				this.setStepHigh(player);
			}
			else if(player.inventory.armorItemInSlot(0) == null || player.inventory.armorItemInSlot(0).getItem() != ICF_Items.endimandiumBoots){
				this.setStepDefault(player);
			}
			if (this.isWearingFullSet(player, ICF_Items.endimandiumHelmet, ICF_Items.endimandiumChestplate, ICF_Items.endimandiumLeggings, ICF_Items.endimandiumBoots)){
				this.regenerate(player);
			}
			else{
			
			}
		}
    }
	
	@SubscribeEvent
	public void onLivingJump(LivingJumpEvent event){
		if(event.entity instanceof EntityPlayer){
			if (((EntityPlayer)event.entity).inventory.armorItemInSlot(0) != null && ((EntityPlayer)event.entity).inventory.armorItemInSlot(0).getItem() == ICF_Items.endimandiumBoots){
				event.entityLiving.motionY += 0.3;
			}
		}
	}
	
	@SubscribeEvent
	public void onLivingFall(LivingFallEvent event){
		if(event.entity instanceof EntityPlayer){
			if (((EntityPlayer)event.entity).inventory.armorItemInSlot(0) != null && ((EntityPlayer)event.entity).inventory.armorItemInSlot(0).getItem() == ICF_Items.endimandiumBoots){
				if(event.distance < 8){
					event.distance = 1;
				}
				else{
					event.damageMultiplier *= 0.25;
				}
			}
		}
	}
	
	private boolean isWearingFullSet(EntityPlayer player, Item helmet, Item chestplate, Item leggings, Item boots) {
		return player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == helmet
				&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == chestplate
				&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == leggings
				&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == boots;
	}
	
	private void regenerate(EntityPlayer player) {
		this.heal_counter = this.heal_counter + 1;
		if (player.getHealth() < player.getMaxHealth() && this.heal_counter >= 5){
            player.heal(0.25F);
            this.heal_counter = 0;
        }
	}

	private void saturate(EntityPlayer player){
		if (player.getFoodStats().getFoodLevel() < 20){
            player.getFoodStats().addStats(1, 0.0F);
		}
	}
	
	private void waterbreathing(EntityPlayer player){
		if (player.getAir() < 285){
			player.setAir(player.getAir()+10);
		}
	}
	
	@SideOnly(Side.CLIENT)
	private void setSpeedFast(EntityPlayer player){
			player.capabilities.setPlayerWalkSpeed(0.17F);
	}
	
	@SideOnly(Side.CLIENT)
	private void setSpeedDefault(EntityPlayer player){
			player.capabilities.setPlayerWalkSpeed(0.1F);
	}
	
	@SideOnly(Side.CLIENT)
	private void setStepHigh(EntityPlayer player){
		if (player.isSneaking()){
			player.stepHeight = 0.50001F;
		}
		else player.stepHeight = 1F;
	}
	
	@SideOnly(Side.CLIENT)
	private void setStepDefault(EntityPlayer player){
		player.stepHeight = 0.5F;
	}
}
