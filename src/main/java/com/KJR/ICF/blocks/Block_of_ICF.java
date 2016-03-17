package com.KJR.ICF.blocks;

import java.util.Arrays;
import java.util.List;

import com.KJR.ICF.ICF_Global;
import com.KJR.ICF.Main;
import com.KJR.ICF.api.iface.IMetaBlockName;
import com.KJR.ICF.registry.ICF_Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Block_of_ICF extends Block implements IMetaBlockName {
	
	private final int maxMeta;
	private static String[] values;
	
	public Block_of_ICF(String unlocalizedName, Material material, String[] names, float hardness, float resistance){
		super(material);
		
		this.maxMeta = names.length;
		this.values = names;
		this.setCreativeTab(Main.tabImitationConstructionFoam);
		this.setUnlocalizedName(ICF_Global.modID + "." + unlocalizedName + ".");
		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumType.VAL_0));
	}

	private static final PropertyEnum TYPE = PropertyEnum.create("type", Block_of_ICF.EnumType.class);
	
	private enum EnumType implements IStringSerializable {
		VAL_0(0),
		VAL_1(1),
		VAL_2(2),
		VAL_3(3),
		VAL_4(4),
		VAL_5(5),
		VAL_6(6),
		VAL_7(7),
		VAL_8(8),
		VAL_9(9),
		VAL_10(10),
		VAL_11(11),
		VAL_12(12),
		VAL_13(13),
		VAL_14(14),
		VAL_15(15);
		
	    private int ID;
	    private String name;
	    
	    private EnumType(int ID) {
	        this.ID = ID;
	        this.name = ICF_Blocks.icfBlock_names[ID];
	    }
	    
	    @Override
	    public String getName() {
	        return name;
	    }

	    public int getID() {
	        return ID;
	    }
	    
	    @Override
	    public String toString() {
	        return getName();
	    }
	}

	@Override
	protected BlockState createBlockState() {
	    return new BlockState(this, new IProperty[] { TYPE });
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		if (meta == 1) {
			return getDefaultState().withProperty(TYPE, EnumType.VAL_1);
		}
		else if (meta == 2) {
			return getDefaultState().withProperty(TYPE, EnumType.VAL_2);
		}
		else if (meta == 3) {
			return getDefaultState().withProperty(TYPE, EnumType.VAL_3);
		}
		else if (meta == 4) {
			return getDefaultState().withProperty(TYPE, EnumType.VAL_4);
		}
		else if (meta == 5) {
			return getDefaultState().withProperty(TYPE, EnumType.VAL_5);
		}
		else if (meta == 6) {
			return getDefaultState().withProperty(TYPE, EnumType.VAL_6);
		}
		else if (meta == 7) {
			return getDefaultState().withProperty(TYPE, EnumType.VAL_7);
		}
		else if (meta == 8) {
			return getDefaultState().withProperty(TYPE, EnumType.VAL_8);
		}
		else if (meta == 9) {
			return getDefaultState().withProperty(TYPE, EnumType.VAL_9);
		}
		else if (meta == 10) {
			return getDefaultState().withProperty(TYPE, EnumType.VAL_10);
		}
		else if (meta == 11) {
			return getDefaultState().withProperty(TYPE, EnumType.VAL_11);
		}
		else if (meta == 12) {
			return getDefaultState().withProperty(TYPE, EnumType.VAL_12);
		}
		else if (meta == 13) {
			return getDefaultState().withProperty(TYPE, EnumType.VAL_13);
		}
		else if (meta == 14) {
			return getDefaultState().withProperty(TYPE, EnumType.VAL_14);
		}
		else if (meta == 15) {
			return getDefaultState().withProperty(TYPE, EnumType.VAL_15);
		}
		else {
			return getDefaultState().withProperty(TYPE, EnumType.VAL_0);
		}
		
	}

	@Override
	public int getMetaFromState(IBlockState state) {
	    EnumType type = (EnumType) state.getValue(TYPE);
	    return type.getID();
	}
	
	@Override
	public int damageDropped(IBlockState state) {
	    return getMetaFromState(state);
	}

    @SideOnly(Side.CLIENT)
	public void getSubBlocks(Item block, CreativeTabs creativeTabs, List list) {
		for (int i = 0; i < maxMeta; i++) {
			list.add(new ItemStack(block, 1, i));
		}
	}
    
    @Override
    public String getSpecialName(ItemStack stack) {
        return values[stack.getItemDamage()];
    }
    
    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos) {
        return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
    }

}
