package roito.silveroakoutpost.helper;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

public final class LogHelper
{
	private LogHelper(){};
	public static void error(Logger logger, String format, Object... data)
	{
		logger.log(Level.ERROR, String.format(format, data));
	}

	public static void warn(Logger logger, String format, Object... data)
	{
		logger.log(Level.WARN, String.format(format, data));
	}

	public static void info(Logger logger, String format, Object... data)
	{
		logger.log(Level.INFO, String.format(format, data));
	}
}
