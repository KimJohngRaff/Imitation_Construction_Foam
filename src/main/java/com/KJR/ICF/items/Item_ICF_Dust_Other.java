package com.KJR.ICF.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.KJR.ICF.ICF_Global;
import com.KJR.ICF.Main;

public class Item_ICF_Dust_Other extends Item {
	
    public static String[] names = {"diamond", "emerald", "lapis", "coal", "obsidian", "saltpeter", "sulfur", "netherQuartz", "granite", "dorite", "andesite"};

    public Item_ICF_Dust_Other() {
        super();

        setCreativeTab(Main.tabImitationConstructionFoam);
        setUnlocalizedName(ICF_Global.modID + ".Dust");
        setHasSubtypes(true);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item id, CreativeTabs creativeTab, List<ItemStack> list)
    {
        for (int i = 0; i < names.length; i++)
            list.add(new ItemStack(id, 1, i));
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return super.getUnlocalizedName(stack) + names[stack.getItemDamage()];
    }
}