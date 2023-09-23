package me.fallenbreath.mixinauditor.impl;

public enum ExitMode
{
	TRUE,
	FALSE,
	ON_FAIL,
	;

	public static final ExitMode DEFAULT = ExitMode.TRUE;

	public static ExitMode get()
	{
		String property = System.getProperty(Properties.EXIT, "");
		try
		{
			return ExitMode.valueOf(property.toUpperCase());
		}
		catch (IllegalArgumentException e)
		{
			return DEFAULT;
		}
	}
}
