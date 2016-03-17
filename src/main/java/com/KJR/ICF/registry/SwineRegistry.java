package com.KJR.ICF.registry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;

import com.KJR.ICF.api.helpers.Swineable;
import com.KJR.ICF.items.Item_ICF_Dust_Metal;
import com.KJR.ICF.items.Item_ICF_Dust_Other;

public class SwineRegistry {
public static ArrayList<Swineable> rewards = new ArrayList<Swineable>();
public static ArrayList<Item> swineableItems = new ArrayList<Item>();
	
	public static void register(Block source, int sourceMeta, Item output, int outputMeta, int rewardAmount)
	{
		Item itemSource = Item.getItemFromBlock(source);
		ItemStack stackSource = new ItemStack(itemSource, 1, sourceMeta);
		Swineable entry = new Swineable(stackSource, itemSource, sourceMeta, output, outputMeta, rewardAmount);
		rewards.add(entry);
		swineableItems.add(itemSource);
	}
	
	public static void registerWithOreDic(String string, Item output, int outputMeta, int rewardAmount)
	{
		// potential issue involving List<> and ArrayList<>
		List<ItemStack> ores;
		ores = OreDictionary.getOres(string);
		for (int i = 0; i < ores.size(); i++){
		ItemStack itemStack = ores.get(i);
		int sourceMeta = itemStack.getItemDamage();
		Item itemSource = itemStack.getItem();
		ItemStack stackSource = new ItemStack(itemSource, 1, sourceMeta);
		Swineable entry = new Swineable(stackSource, itemSource, sourceMeta, output, outputMeta, rewardAmount);
		rewards.add(entry);
		swineableItems.add(itemSource);
		}		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ArrayList<Swineable> getRewards(Item item, int meta)
	{
		ArrayList<Swineable> rewardList = new ArrayList();

		Iterator<Swineable> it = rewards.iterator();
		while(it.hasNext())
		{
			Swineable reward = it.next();

			if (reward.itemSource == item && reward.sourceMeta == meta && reward.item != null)
			{
				rewardList.add(reward);
			}
		}
		
		return rewardList;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Item[] getBlockItems()
	{
		ArrayList<Item> items = new ArrayList();

		Iterator<Swineable> it = rewards.iterator();
		while(it.hasNext())
		{
			Swineable reward = it.next();

			if (!items.contains(reward.itemSource))
			{
				items.add(reward.itemSource);
			}
		}
		
		return items.toArray(new Item[items.size()]);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static ItemStack[] getItemStacks()
	{
		ArrayList<ItemStack> itemStacks = new ArrayList();

		Iterator<Swineable> it = rewards.iterator();
		while(it.hasNext())
		{
			Swineable reward = it.next();

			if (!itemStacks.contains(reward.stackSource))
			{
				itemStacks.add(reward.stackSource);
			}
		}
		
		return itemStacks.toArray(new ItemStack[itemStacks.size()]);
	}
	
	public static void load(Configuration config)
	{
		// Load all the vanilla swineables
	}
	
	public static void registerSwineables()
	{		
		
		register(Blocks.cobblestone, 0, Item.getItemFromBlock(Blocks.gravel), 0, 1);
		register(Blocks.gravel, 0, Item.getItemFromBlock(Blocks.sand), 0, 1);
		register(Blocks.sand, 0, ICF_Items.icfMisc_1, 2, 1);
		
		for (int i = 0; i < Item_ICF_Dust_Metal.names.length; i++) {
			registerWithOreDic("ore" + Item_ICF_Dust_Metal.names[i].substring(0, 1).toUpperCase() + Item_ICF_Dust_Metal.names[i].substring(1), ICF_Items.icfDust_Metal, i, 2);
		}
		for (int i = 0; i < Item_ICF_Dust_Metal.names.length; i++) {
			registerWithOreDic("block" + Item_ICF_Dust_Metal.names[i].substring(0, 1).toUpperCase() + Item_ICF_Dust_Metal.names[i].substring(1), ICF_Items.icfDust_Metal, i, 9);
		}
		for (int i = 0; i < 2; i++) {
			registerWithOreDic("block" + Item_ICF_Dust_Other.names[i].substring(0, 1).toUpperCase() + Item_ICF_Dust_Other.names[i].substring(1), ICF_Items.icfDust_Other, i, 9);
		}
		
		register(Blocks.coal_block, 0, ICF_Items.icfDust_Other, 3, 9);
		register(Blocks.obsidian, 0, ICF_Items.icfDust_Other, 4, 8);
		registerWithOreDic("oreSaltpeter", ICF_Items.icfDust_Other, 5, 4);
		registerWithOreDic("oreSulfur", ICF_Items.icfDust_Other, 6, 6);
		register(Blocks.netherrack, 0, ICF_Items.icfDust_Other, 6, 1);
		registerWithOreDic("blockWeakenedQuartz", ICF_Items.icfDust_Other, 7, 4);
		register(Blocks.stone, 1, ICF_Items.icfDust_Other, 8, 1);
		register(Blocks.stone, 2, ICF_Items.icfDust_Other, 8, 1);
		register(Blocks.stone, 3, ICF_Items.icfDust_Other, 9, 1);
		register(Blocks.stone, 4, ICF_Items.icfDust_Other, 9, 1);
		register(Blocks.stone, 5, ICF_Items.icfDust_Other, 10, 1);
		register(Blocks.stone, 6, ICF_Items.icfDust_Other, 10, 1);

		register(Blocks.nether_brick, 0, Items.netherbrick, 0, 4);
		register(Blocks.brick_block, 0, Items.brick, 0, 4);
		register(Blocks.quartz_block, 0, Items.quartz, 0, 4);
		
		register(Blocks.sandstone, 0, Item.getItemFromBlock(Blocks.sand), 0, 1);
		register(Blocks.sandstone, 1, Item.getItemFromBlock(Blocks.sand), 0, 1);
		register(Blocks.sandstone, 2, Item.getItemFromBlock(Blocks.sand), 0, 1);
	
		
	}
	public static boolean registered(Block block, int meta)
	{
		Iterator<Swineable> it = rewards.iterator();
		while(it.hasNext())
		{
			Swineable reward = it.next();

			if (reward.itemSource.getUnlocalizedName().equals(Item.getItemFromBlock(block).getUnlocalizedName()) && reward.meta == meta)
			{
				return true;
			}
		}
		
		return false;
	}
}
