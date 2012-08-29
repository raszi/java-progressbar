package hu.ssh.test.progressbar.console.replacers;

import hu.ssh.progressbar.Progress;
import hu.ssh.progressbar.console.replacers.ElapsedTimeReplacer;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

public class TestElapsedTimeReplacer {
	@DataProvider
	protected final Iterator<Object[]> getExampleTotalTimeContents() {
		return ImmutableList.of(
				new Object[] { new Progress(5, 0, 0), "0ms" },
				new Object[] { new Progress(5, 2, 200), "200ms" },
				new Object[] { new Progress(5, 3, 3000), "3s" },
				new Object[] { new Progress(5, 5, 200), "200ms" }
				).iterator();
	}

	@Test(dataProvider = "getExampleTotalTimeContents")
	public final void testElapsedTimeReplacer(final Progress progress, final String expectedContent) {
		final ElapsedTimeReplacer replacer = new ElapsedTimeReplacer();
		Assert.assertEquals(replacer.getReplacementForProgress(progress), expectedContent);
	}
}

