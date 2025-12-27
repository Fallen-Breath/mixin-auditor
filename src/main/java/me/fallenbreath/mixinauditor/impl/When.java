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

package me.fallenbreath.mixinauditor.impl;

public enum When
{
	MOD_INIT,
	GAME_INIT,
	;

	public static final When DEFAULT = When.MOD_INIT;

	public static When get()
	{
		String property = System.getProperty(Properties.WHEN, "");
		try
		{
			return When.valueOf(property.toUpperCase());
		}
		catch (IllegalArgumentException e)
		{
			return DEFAULT;
		}
	}
}
