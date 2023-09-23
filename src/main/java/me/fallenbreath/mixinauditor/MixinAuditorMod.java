package me.fallenbreath.mixinauditor;

import me.fallenbreath.mixinauditor.hooks.ModInitHook;
import net.fabricmc.api.ModInitializer;

public class MixinAuditorMod implements ModInitializer
{
	@Override
	public void onInitialize()
	{
		ModInitHook.onModInit();
	}
}
