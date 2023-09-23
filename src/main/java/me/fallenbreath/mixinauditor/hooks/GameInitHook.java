package me.fallenbreath.mixinauditor.hooks;

import me.fallenbreath.mixinauditor.impl.MixinAuditor;
import me.fallenbreath.mixinauditor.impl.When;
import me.fallenbreath.mixinauditor.utils.Once;

public class GameInitHook
{
	private static final Once callback = new Once(() ->
	{
		if (MixinAuditor.isEnabled() && When.get() == When.GAME_INIT)
		{
			MixinAuditor.run();
		}
	});

	public static void onGameInit()
	{
		callback.run();
	}
}
