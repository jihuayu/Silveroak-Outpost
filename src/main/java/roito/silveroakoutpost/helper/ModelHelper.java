package roito.silveroakoutpost.helper;

import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class ModelHelper
{
	public static void registerItemVariants(String modid, Item item)
	{
		if (item.getHasSubtypes())
		{
			NonNullList<ItemStack> subItems = NonNullList.create();
			item.getSubItems(item.getCreativeTab(), subItems);
			NonNullList<ResourceLocation> rl = NonNullList.create();
			for (ItemStack subItem : subItems)
			{
				String subItemName = item.getTranslationKey(subItem);
				subItemName = subItemName.substring(subItemName.indexOf(".") + 1);
				subItemName = subItemName.substring(subItemName.indexOf(".") + 1);

				rl.add(new ResourceLocation(modid, subItemName));
			}
			ResourceLocation[] rL = new ResourceLocation[rl.size()];
			ModelBakery.registerItemVariants(item, rl.toArray(rL));
		}
	}

	public static void registerRender(String modid, Item item)
	{
		if (item.getHasSubtypes())
		{
			NonNullList<ItemStack> subItems = NonNullList.create();
			item.getSubItems(item.getCreativeTab(), subItems);
			for (ItemStack subItem : subItems)
			{
				String subItemName = item.getTranslationKey(subItem);
				subItemName = subItemName.substring(subItemName.indexOf(".") + 1);
				subItemName = subItemName.substring(subItemName.indexOf(".") + 1);

				ModelLoader.setCustomModelResourceLocation(item, subItem.getMetadata(), new ModelResourceLocation(modid + ":" + subItemName, "inventory"));
			}
		}
		else
		{
			String itemName = item.getTranslationKey();
			itemName = itemName.substring(itemName.indexOf(".") + 1);
			itemName = itemName.substring(itemName.indexOf(".") + 1);
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(modid + ":" + itemName, "inventory"));
		}
	}
}
