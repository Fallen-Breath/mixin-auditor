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

public class Properties
{
	public static final String SWITCH = "mixinAuditor.audit";
	public static final String ENSURE_AUDIT = "mixinAuditor.ensureAudit";
	public static final String WHEN = "mixinAuditor.when";
	public static final String EXIT = "mixinAuditor.exit";
	public static final String FAIL_CODE = "mixinAuditor.failCode";

	private static final int DEFAULT_FAIL_CODE = 19;

	public static boolean isAuditEnabled()
	{
		return "true".equalsIgnoreCase(System.getProperty(SWITCH));
	}

	public static boolean shouldEnsureAudit()
	{
		return !"false".equalsIgnoreCase(System.getProperty(ENSURE_AUDIT));
	}

	public static int getFailCode()
	{
		String codeStr = System.getProperty(FAIL_CODE, "");
		try
		{
			return Integer.parseInt(codeStr);
		}
		catch (NumberFormatException e)
		{
			return DEFAULT_FAIL_CODE;
		}
	}

	public static int getShutdownFailCode()
	{
		int failCode = getFailCode();
		return failCode >= 1 && failCode <= 255 ? failCode : DEFAULT_FAIL_CODE;
	}
}
