package roito.silveroakoutpost.client;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import roito.silveroakoutpost.common.CommonProxy;
import roito.silveroakoutpost.helper.ModelHelper;

import static roito.silveroakoutpost.common.register.RegisterManager.MODEL_ITEMS;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{
		for (Item item : MODEL_ITEMS)
		{
			ModelHelper.registerItemVariants(item.getRegistryName().getNamespace(), item);
			ModelHelper.registerRender(item.getRegistryName().getNamespace(), item);
		}
		ModelHelper.clear();
	}
}