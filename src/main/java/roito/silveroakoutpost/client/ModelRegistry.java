package roito.silveroakoutpost.client;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import roito.silveroakoutpost.helper.ModelHelper;

import static java.util.Objects.requireNonNull;
import static roito.silveroakoutpost.common.register.RegisterManager.MODEL_ITEMS;

public final class ModelRegistry
{

	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{
		for (Item item : MODEL_ITEMS)
		{
			requireNonNull(item.getRegistryName());

			ModelHelper.registerItemVariants(item.getRegistryName().getNamespace(), item);
			ModelHelper.registerRender(item.getRegistryName().getNamespace(), item);
		}
	}
}
