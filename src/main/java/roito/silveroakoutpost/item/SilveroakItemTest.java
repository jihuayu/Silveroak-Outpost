package roito.silveroakoutpost.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class SilveroakItemTest extends SilveroakItemNormal
{
	public SilveroakItemTest()
	{
		super();
		this.setHasSubtypes(true);
	}

	@Override
	public String getTranslationKey(ItemStack stack)
	{
		switch (stack.getItemDamage())
		{
			case 1:
				return super.getTranslationKey() + "_" + "black";
			case 2:
				return super.getTranslationKey() + "_" + "yellow";
			case 3:
				return super.getTranslationKey() + "_" + "white";
			case 4:
				return super.getTranslationKey() + "_" + "oolong";
			case 5:
				return super.getTranslationKey() + "_" + "puer";
			default:
				return super.getTranslationKey() + "_" + "green";
		}
	}

	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
	{
		if (this.isInCreativeTab(tab))
		{
			items.add(new ItemStack(this, 1, 0));
			items.add(new ItemStack(this, 1, 1));
			items.add(new ItemStack(this, 1, 2));
			items.add(new ItemStack(this, 1, 3));
			items.add(new ItemStack(this, 1, 4));
			items.add(new ItemStack(this, 1, 5));
		}
	}
}
