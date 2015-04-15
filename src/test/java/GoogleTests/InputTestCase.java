package GoogleTests;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

@Test
public class InputTestCase extends TestConfig {

	@Parameters({ "baseUrl", "sonyWord", "googleWord", "delay" })
	public void shouldBeSonyPages(String baseUrl, String sonyWord,
			String googleWord, int delay) {
		webDriver.get(baseUrl);

		assertTrue(isElementPresent(By.id("lst-ib")));
		assertTrue(isElementPresent(By.name("btnG")));

		webDriver.findElement(By.id("lst-ib")).clear();
		webDriver.findElement(By.id("lst-ib")).sendKeys(sonyWord);
		webDriver.findElement(By.name("btnG")).click();

		webDriver.manage().timeouts().pageLoadTimeout(delay, TimeUnit.SECONDS);

		assertTrue(webDriver.getTitle().contains(sonyWord)
				&& webDriver.getTitle().contains(googleWord));
	}

	/**
	 * Checks on element present.
	 * 
	 * @param by
	 *            Element with id or name attributes.
	 * @return True if element present, false another.
	 */
	private boolean isElementPresent(By by) {
		try {
			webDriver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
