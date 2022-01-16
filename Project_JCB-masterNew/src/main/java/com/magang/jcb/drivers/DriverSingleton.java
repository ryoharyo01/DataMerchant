package com.magang.jcb.drivers;

import org.openqa.selenium.WebDriver;

import com.magang.jcb.drivers.strategies.DriverStrategy;
import com.magang.jcb.drivers.strategies.DriverStrategyImplementer;

public class DriverSingleton {
	private static DriverSingleton instance = null;
	private static WebDriver driver;

	private DriverSingleton(String driver) {
		instantiate(driver);
	}

	private WebDriver instantiate(String strategy) {
		DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(strategy);
		driver = driverStrategy.setStrategy();
		driver.manage().window().maximize();
		return driver;

	}

	public static DriverSingleton getInstance(String driver) {
		if (instance == null) {
			instance = new DriverSingleton(driver);
		}
		return instance;
	}

	public static void closeObjectInstance() {
		instance = null;
		driver.quit();
	}

	public static WebDriver getDriver() {
		return driver;
	}

}
