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
		if (!this.done.get())
		{
			if (this.done.compareAndSet(false, true))
			{
				this.delegate.run();
			}
		}
	}
}
