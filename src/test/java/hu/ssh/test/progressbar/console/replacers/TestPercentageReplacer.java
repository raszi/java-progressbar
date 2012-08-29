package hu.ssh.test.progressbar.console.replacers;

import hu.ssh.progressbar.Progress;
import hu.ssh.progressbar.console.replacers.PercentageReplacer;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

public class TestPercentageReplacer {
	@DataProvider
	protected final Iterator<Object[]> getExamplePercentageContents() {
		return ImmutableList.of(
				new Object[] { new Progress(5, 0, 0), "  0.00" },
				new Object[] { new Progress(5, 2, 200), " 40.00" },
				new Object[] { new Progress(5, 3, 3000), " 60.00" },
				new Object[] { new Progress(5, 5, 200), "100.00" }
				).iterator();
	}

	@Test(dataProvider = "getExamplePercentageContents")
	public final void testPercentageReplacer(final Progress progress, final String expectedContent) {
		final PercentageReplacer replacer = new PercentageReplacer();
		Assert.assertEquals(replacer.getReplacementForProgress(progress), expectedContent);
	}
}
