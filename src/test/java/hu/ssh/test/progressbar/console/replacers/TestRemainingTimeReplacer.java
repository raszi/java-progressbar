package hu.ssh.test.progressbar.console.replacers;

import hu.ssh.progressbar.Progress;
import hu.ssh.progressbar.console.replacers.RemainingTimeReplacer;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

public class TestRemainingTimeReplacer {
	@DataProvider
	protected final Iterator<Object[]> getExampleRemainingTimeContents() {
		return ImmutableList.of(
				new Object[] { new Progress(5, 0, 0), "?" },
				new Object[] { new Progress(5, 2, 200), "300ms" },
				new Object[] { new Progress(5, 3, 3000), "2s" },
				new Object[] { new Progress(5, 5, 200), "0ms" }
				).iterator();
	}

	@Test(dataProvider = "getExampleRemainingTimeContents")
	public final void testRemaingingTimeReplacer(final Progress progress, final String expectedContent) {
		final RemainingTimeReplacer replacer = new RemainingTimeReplacer();
		Assert.assertEquals(replacer.getReplacementForProgress(progress), expectedContent);
	}
}
