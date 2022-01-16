package com.magang.jcb;


import org.junit.Test;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features")
public class TestRunner {
	@Test
	public void runTest() {
		
	}
	
}
