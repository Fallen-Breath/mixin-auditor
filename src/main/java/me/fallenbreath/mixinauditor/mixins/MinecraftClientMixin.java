package me.fallenbreath.mixinauditor.mixins;

import me.fallenbreath.mixinauditor.hooks.GameInitHook;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftClientMixin
{
	@Inject(
			method = "run",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/Minecraft;runTick(Z)V"
			)
	)
	private void onServerInitHook(CallbackInfo ci)
	{
		GameInitHook.onGameInit();
	}
}
