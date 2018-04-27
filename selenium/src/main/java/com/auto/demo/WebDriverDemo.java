package com.auto.demo;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverDemo {
	public static void main(String[] args) {
		ChromeDriverService service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File("drivers/chromedriver.exe")).usingAnyFreePort().build();
		try {
			service.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		URL url = service.getUrl();

		WebDriverDemo w = new WebDriverDemo();
		w.openbaidu(url);
		w.openbaidu(url);
		service.stop();
	}

	public static void openbaidu(URL url) {
		WebDriver driver = new RemoteWebDriver(url, DesiredCapabilities.chrome());
		driver.get("https://www.baidu.com/");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 driver.close();
	}

	/*
	 * public static void main(String[] args) {
	 * System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	 * WebDriver driver = new ChromeDriver(); driver.get("https://www.baidu.com/");
	 * 
	 * try { Thread.sleep(3000); } catch (InterruptedException e) {
	 * e.printStackTrace(); }
	 *  driver.close(); }
	 */
}
