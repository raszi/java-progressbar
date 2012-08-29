package hu.ssh.test.progressbar.helpers;

import hu.ssh.progressbar.helpers.HumanTimeFormatter;

import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

public class TestHumanTimeFormatter {
	@DataProvider
	public final Iterator<Object[]> getExampleConversions() {
		return ImmutableList.of(
				new Object[] { 0L, "0ms" },
				new Object[] { 150L, "150ms" },
				new Object[] { 6005L, "6s5ms" },
				new Object[] { 600001L, "10m1ms" },
				new Object[] { 5061616105L, "58d14h16s105ms" }
				).iterator();
	}

	@Test(dataProvider = "getExampleConversions")
	public final void testConversion(final long elapsedTime, final String expectedOutput) {
		Assert.assertEquals(HumanTimeFormatter.formatTime(elapsedTime), expectedOutput);
	}
}
