package me.fallenbreath.mixinauditor.mixins;

import me.fallenbreath.mixinauditor.hooks.GameInitHook;
import net.minecraft.server.dedicated.DedicatedServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DedicatedServer.class)
public abstract class MinecraftDedicatedServerMixin
{
	@Inject(method = "initServer()Z", at = @At("RETURN"))
	private void onServerInitHook(CallbackInfoReturnable<Boolean> cir)
	{
		Boolean initOk = cir.getReturnValue();
		if (initOk)
		{
			GameInitHook.onGameInit();
		}
	}
}
