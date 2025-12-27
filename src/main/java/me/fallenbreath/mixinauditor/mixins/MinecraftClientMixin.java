/*
 * This file is part of the Mixin Auditor project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2025  Fallen_Breath and contributors
 *
 * Mixin Auditor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Mixin Auditor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Mixin Auditor.  If not, see <https://www.gnu.org/licenses/>.
 */

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
