package me.fallenbreath.mixinauditor.hooks;

import me.fallenbreath.mixinauditor.impl.MixinAuditor;
import me.fallenbreath.mixinauditor.impl.When;

public class ModInitHook
{
	public static void onModInit()
	{
		if (MixinAuditor.isEnabled() && When.get() == When.MOD_INIT)
		{
			MixinAuditor.run();
		}
	}
}
