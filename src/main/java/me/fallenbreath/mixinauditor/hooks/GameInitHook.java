package me.fallenbreath.mixinauditor.hooks;

import me.fallenbreath.mixinauditor.impl.MixinAuditor;
import me.fallenbreath.mixinauditor.impl.When;

public class GameInitHook
{
	public static void onGameInit()
	{
		if (MixinAuditor.isEnabled() && When.get() == When.GAME_INIT)
		{
			MixinAuditor.run();
		}
	}
}
