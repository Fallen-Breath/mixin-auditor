package me.fallenbreath.mixinauditor.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.MixinEnvironment;

public class MixinAuditor
{
	private static final Logger LOGGER = LogManager.getLogger(MixinAuditor.class);
	private static final int DEFAULT_FAIL_CODE = 19;

	public static boolean isEnabled()
	{
		return "true".equalsIgnoreCase(System.getProperty(Properties.SWITCH));
	}

	public static int getFailCode()
	{
		String codeStr = System.getProperty(Properties.FAIL_CODE, "");
		try
		{
			return Integer.parseInt(codeStr);
		}
		catch (NumberFormatException e)
		{
			return DEFAULT_FAIL_CODE;
		}
	}

	public static void run()
	{
		LOGGER.info("Triggered auto mixin audit");
		boolean ok = doAudit();

		boolean exit;
		switch (ExitMode.get())
		{
			case TRUE:
				exit = true;
				break;
			case FALSE:
				exit = false;
				break;
			case ON_FAIL:
				exit = !ok;
				break;
			default:
				throw new RuntimeException();
		}

		if (exit)
		{
			System.exit(ok ? 0 : getFailCode());
		}
	}

	private static boolean doAudit()
	{
		try
		{
			MixinEnvironment.getCurrentEnvironment().audit();
		}
		catch (Throwable t)
		{
			LOGGER.error("Error when auditing mixin", t);
			return false;
		}

		LOGGER.info("Mixin environment audited successfully");
		return true;
	}
}
