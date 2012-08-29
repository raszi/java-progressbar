package hu.ssh.test.progressbar.console;

import hu.ssh.progressbar.ProgressBar;
import hu.ssh.progressbar.console.ConsoleProgressBar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

public class TestConsoleProgressBar {
	private List<Object[]> getTestCases() {
		return ImmutableList.of(
				new Object[] { 0, "  0.00" },
				new Object[] { 25, " 25.00" },
				new Object[] { 30, " 55.00" },
				new Object[] { 44, " 99.00" },
				new Object[] { 1, "100.00" }
				);
	}

	@Test
	public final void testConsoleProgressBarOutput() throws IOException {
		final ByteArrayOutputStream outputstream = new ByteArrayOutputStream();

		try {
			final ProgressBar progressBar = ConsoleProgressBar.on(new PrintStream(outputstream))
					.withFormat(":percent");

			for (final Object[] params : getTestCases()) {
				final int nextTick = (Integer) params[0];
				final String expectedOutput = (String) params[1];

				progressBar.tick(nextTick);
				Assert.assertEquals(getLastOutput(outputstream.toString()), expectedOutput);
			}

		} finally {
			outputstream.close();
		}
	}

	private String getLastOutput(final String string) {
		if (Strings.isNullOrEmpty(string)) {
			return string;
		}

		final Iterable<String> outputs = Splitter.on(ConsoleProgressBar.CARRIAGE_RETURN)
				.omitEmptyStrings()
				.split(string);

		return Iterables.getLast(outputs);
	}
}
