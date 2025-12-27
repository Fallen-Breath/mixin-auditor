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

package me.fallenbreath.mixinauditor.utils;

import java.util.concurrent.atomic.AtomicBoolean;

public class Once implements Runnable
{
	private final AtomicBoolean done = new AtomicBoolean(false);
	private final Runnable delegate;

	public Once(Runnable delegate)
	{
		this.delegate = delegate;
	}

	@Override
	public void run()
	{
		if (this.done.compareAndSet(false, true))
		{
			this.delegate.run();
		}
	}
}
