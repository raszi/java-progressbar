package hu.ssh.test.progressbar.console.replacers;

import hu.ssh.progressbar.Progress;
import hu.ssh.progressbar.console.replacers.BarReplacer;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

public class TestBarReplacer {
	@DataProvider
	protected final Iterator<Object[]> getExampleBarContents() {
		return ImmutableList.of(
				new Object[] { new Progress(5, 0, 0), "-----" },
				new Object[] { new Progress(5, 2, 0), "==---" },
				new Object[] { new Progress(5, 3, 0), "===--" },
				new Object[] { new Progress(5, 5, 0), "=====" }
				).iterator();
	}

	@Test(dataProvider = "getExampleBarContents")
	public final void testBarReplacer(final Progress progress, final String expectedContent) {
		final BarReplacer replacer = new BarReplacer(5);
		Assert.assertEquals(replacer.getReplacementForProgress(progress), expectedContent);
	}
}
