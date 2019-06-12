package roito.silveroakoutpost.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import roito.silveroakoutpost.SilveroakOutpost;

public class SOOCreativeTabs extends CreativeTabs
{
	public SOOCreativeTabs()
	{
		super(SilveroakOutpost.MODID + "_craft");
	}

	@Override
	public ItemStack createIcon()
	{
		return ItemStack.EMPTY;
	}
}
