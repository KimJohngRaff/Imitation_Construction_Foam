package com.KJR.ICF.items;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import com.KJR.ICF.Main;
import com.KJR.ICF.api.helpers.Swineable;
import com.KJR.ICF.registry.ICF_Items;
import com.KJR.ICF.registry.SwineRegistry;
import com.google.common.collect.Sets;

public class Item_ICF_SwineHammer extends ItemTool {

	@SuppressWarnings("rawtypes")
	public static Set blocksEffectiveAgainst = Sets.newHashSet(new Block[]{});

	public Item_ICF_SwineHammer(ToolMaterial material) 
	{
		super(3.0F, material, blocksEffectiveAgainst);
		this.setCreativeTab(Main.tabImitationConstructionFoam);
	}
	
    @Override
	public boolean canHarvestBlock(Block block)
	{
    	Item[] items = SwineRegistry.getBlockItems();
		for (int i = 0; i < items.length; ++i){
			if (items[i] == Item.getItemFromBlock(block)){
				return true;
			}
		}
		return false;
	}

	@Override
	public float getStrVsBlock(ItemStack stack, Block block)
	{
		Item hammer = stack.getItem();
		Item[] items = SwineRegistry.getBlockItems();

		for (int i = 0; i < items.length; ++i)
		{
			if (items[i] == Item.getItemFromBlock(block) && block == Blocks.obsidian){
				return efficiencyOnProperMaterial * 10.75F;
			}
			else if (items[i] == Item.getItemFromBlock(block) && hammer == ICF_Items.toolEndimandiumSwineHammer){
				return 30.0F;					
			}
			else if (items[i] == Item.getItemFromBlock(block) && hammer == ICF_Items.toolBronzeSwineHammer){
				return 15.0F;					
			}
			else if (items[i] == Item.getItemFromBlock(block) && hammer == ICF_Items.toolAluminumSwineHammer){
				return 7.5F;					
			}
		}
		return 0.8F;
	}
	
	@Override		
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn)
	{
		IBlockState state = worldIn.getBlockState(pos);
		Item itemFromBlock = Item.getItemFromBlock(state.getBlock());
		int blockMeta = blockIn.getMetaFromState(state);
		boolean valid = false;

		ArrayList<Swineable> rewards = SwineRegistry.getRewards(itemFromBlock, blockMeta);
		
		if(rewards.size() > 0)
		{
			Iterator<Swineable> it = rewards.iterator();
			while(it.hasNext())
			{
				Swineable reward = it.next();

				if (!worldIn.isRemote)
				{
					EntityItem entityitem = new EntityItem(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, new ItemStack(reward.item, reward.rewardAmount, reward.meta));

					double f3 = 0.05F;
					entityitem.motionX = worldIn.rand.nextGaussian() * f3;
					entityitem.motionY = (0.2d);
					entityitem.motionZ = worldIn.rand.nextGaussian() * f3;

					worldIn.spawnEntityInWorld(entityitem);
				}
				
				valid = true;
			}
		}
		else
		{
			if (blockIn.getMaterial().isToolNotRequired() || blockIn.getHarvestTool(state) == null)
			{
				return false;
			}
		}
		
		stack.damageItem(1, playerIn);

		
// 		------------ depreciated ------------
//		if (stack.stackSize == 0)
//		{
//			playerIn.destroyCurrentEquippedItem();
//		}

		
// 		------------ depreciated ------------
//		if (!worldIn.isRemote)
//		{
//			worldIn.destroyBlock(pos, false);
//		}
		
		return valid;
	}
}
