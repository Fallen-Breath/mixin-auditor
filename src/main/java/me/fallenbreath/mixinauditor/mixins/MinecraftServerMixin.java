package me.fallenbreath.mixinauditor.mixins;

import me.fallenbreath.mixinauditor.hooks.GameInitHook;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public abstract class MinecraftServerMixin
{
	@Inject(method = "loadWorld", at = @At("HEAD"))
	private void onServerInitHook(CallbackInfo ci)
	{
		MinecraftServer self = (MinecraftServer)(Object)this;
		if (self.isDedicated())
		{
			GameInitHook.onGameInit();
		}
	}
}