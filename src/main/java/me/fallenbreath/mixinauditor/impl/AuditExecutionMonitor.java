/*
 * This file is part of the Mixin Auditor project, licensed under the
 * GNU Lesser General Public License v3.0
 *
 * Copyright (C) 2026  Fallen_Breath and contributors
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

public class AuditExecutionMonitor
{
	private static volatile boolean auditExecuted = false;

	public static void start()
	{
		if (!Properties.isAuditEnabled() || !Properties.shouldEnsureAudit())
		{
			return;
		}

		final int exitCode = Properties.getShutdownFailCode();
		Runtime runtime = Runtime.getRuntime();
		runtime.addShutdownHook(new Thread(() ->
		{
			if (!auditExecuted)
			{
				try
				{
					System.err.println("[Mixin Auditor] Audit was enabled but was not executed before shutdown, halting with code " + exitCode);
				}
				finally
				{
					runtime.halt(exitCode);
				}
			}
		}, "Mixin Auditor Shutdown Check"));
	}

	public static void onAuditExecuted()
	{
		auditExecuted = true;
	}
}
