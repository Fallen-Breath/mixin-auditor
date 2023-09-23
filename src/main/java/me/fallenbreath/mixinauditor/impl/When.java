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
