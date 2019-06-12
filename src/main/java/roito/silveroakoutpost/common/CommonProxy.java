package roito.silveroakoutpost.common;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import roito.silveroakoutpost.client.ModelRegistry;
import roito.silveroakoutpost.common.register.RegisterManager;

public class CommonProxy
{
	public void preInit(FMLPreInitializationEvent event) throws ClassNotFoundException, IllegalAccessException, InstantiationException
	{
		MinecraftForge.EVENT_BUS.register(RegisterManager.class);
		MinecraftForge.EVENT_BUS.register(ModelRegistry.class);
		RegisterManager.loadRegistry(event);

	}

	public void init(FMLInitializationEvent event)
	{

	}

	public void postInit(FMLPostInitializationEvent event)
	{

	}
}