package roito.silveroakoutpost;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import roito.silveroakoutpost.common.CommonProxy;
import roito.silveroakoutpost.common.SOOCreativeTabs;

@Mod(modid = SilveroakOutpost.MODID,
		name = SilveroakOutpost.NAME,
		version = SilveroakOutpost.VERSION,
		acceptedMinecraftVersions = "[1.12.2,1.13)",
		dependencies = "required-after:forge@[14.23.5.2768,);")

public class SilveroakOutpost
{
	public static final String MODID = "silveroakoutpost";
	public static final String NAME = "Silveroak Outpost";
	public static final String VERSION = "@version@";

	private static final SilveroakOutpost INSTANCE = new SilveroakOutpost();

	@Mod.InstanceFactory
	public static SilveroakOutpost getInstance()
	{
		return INSTANCE;
	}

	@SidedProxy(clientSide = "roito.silveroakoutpost.client.ClientProxy",
			serverSide = "roito.silveroakoutpost.common.CommonProxy")
	public static CommonProxy proxy;

	public static Logger logger;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) throws IllegalAccessException, InstantiationException, ClassNotFoundException
	{
		logger = event.getModLog();
		proxy.preInit(event);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init(event);
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event);
	}

	public static final CreativeTabs TAB_CRAFT = new SOOCreativeTabs();
}
