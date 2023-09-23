package me.fallenbreath.mixinauditor.mixins;

import me.fallenbreath.mixinauditor.hooks.GameInitHook;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin
{
	@Unique
	private static boolean clientInitHookTriggered = false;

	@Inject(
			method = "run",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/MinecraftClient;render(Z)V"
			)
	)
	private void onServerInitHook(CallbackInfo ci)
	{
		if (!clientInitHookTriggered)
		{
			clientInitHookTriggered = true;
			GameInitHook.onGameInit();
		}
	}
}
