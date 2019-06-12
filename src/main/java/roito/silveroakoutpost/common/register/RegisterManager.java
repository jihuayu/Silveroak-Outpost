package roito.silveroakoutpost.common.register;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.discovery.ASMDataTable;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import roito.silveroakoutpost.helper.LogHelper;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static roito.silveroakoutpost.SilveroakOutpost.logger;

public final class RegisterManager
{
	public static List<Item> ITEMS = new ArrayList<>();
	public static List<Block> BLOCKS = new ArrayList<>();

	public static List<Item> MODEL_ITEMS = new ArrayList<>();

	public RegisterManager()
	{
		MinecraftForge.EVENT_BUS.register(this);
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ITEMS.toArray(new Item[ITEMS.size()]));
	}

	public static void loadRegistry(FMLPreInitializationEvent event) throws ClassNotFoundException, IllegalAccessException, InstantiationException
	{
		ASMDataTable table = event.getAsmData();
		Set<ASMDataTable.ASMData> allRegistry = table.getAll(SilveroakRegistry.class.getName());
		for (ASMDataTable.ASMData data : allRegistry)
		{
			String modid = (String) data.getAnnotationInfo().get("modid");
			String registryName = (String) data.getAnnotationInfo().get("name");

			Class<?> asmClass = Class.forName(data.getClassName());
			Object registry = asmClass.newInstance();

			if (registryName == null)
			{
				registryName = asmClass.getSimpleName();
			}

			int registeredCount = 0;

			Class<?> clazz = registry.getClass();
			RegisterType registerType = clazz.getAnnotation(SilveroakRegistry.class).registerType();

			for (Field field : clazz.getFields())
			{
				int modifiers = field.getModifiers();
				if (Modifier.isStatic(modifiers))
				{
					Object object = field.get(null);
					String objectName;

					try
					{
						objectName = field.getAnnotation(RegisterInfo.class).value();
					} catch (Exception e)
					{
						continue;
					}

					switch (registerType)
					{
						case ITEM:
						{
							if (object instanceof Item)
							{
								((Item) object).setRegistryName(new ResourceLocation(modid, objectName));
								((Item) object).setTranslationKey(modid + "." + objectName);
								ITEMS.add((Item) object);
								registeredCount++;

								boolean need;
								try
								{
									need = field.getAnnotation(RegisterModel.class).value();
								} catch (Exception e)
								{
									continue;
								}
								if (need && event.getSide().isClient())
								{
									MODEL_ITEMS.add((Item) object);
								}
							}
							break;
						}
						case BLOCK:
						{
							break;
						}
						case POTION:
						{

						}
					}
				}
			}
			LogHelper.info(logger, "Loaded %d %s(s) from %s in %s.", registeredCount, registerType, registryName, modid);
		}
	}
}
