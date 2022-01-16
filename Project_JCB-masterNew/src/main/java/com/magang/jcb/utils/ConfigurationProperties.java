package com.magang.jcb.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("framework.properties")
public class ConfigurationProperties {
	@Value("${browser}")
	private String browser;
	
	@Value("${myusername}")
	private String username;
	
	@Value("${password}")
	private String password;
	
	@Value("${messageLogin}")
	private String messageLogin;
	
	@Value("${m1}")
	private String m1;
	
	@Value("${m2}")
	private String m2;
	
	@Value("${m3}")
	private String m3;
	
	@Value("${m4}")
	private String m4;
	
	@Value("${m5}")
	private String m5;
	
	@Value("${nik}")
	private String nik;
	
	@Value("${name}")
	private String name;
	
	@Value("${usernameU}")
	private String usernameU;
	
	@Value("${passwordU}")
	private String passwordU;
	
	@Value("${privilege}")
	private String privilege;
	
	@Value("${kota1}")
	private String kota1;
	
	@Value("${kota2}")
	private String kota2;
	
	@Value("${area1}")
	private String area1;
	
	@Value("${area2}")
	private String area2;
	
	@Value("${startDate}")
	private String startDate;
	
	@Value("${endDate}")
	private String endDate;
	
	@Value("${surveyor}")
	private String surveyor;
	
	@Value("${searchKeyCompleted}")
	private String searchKeyCompleted;
	
	public String getSearchKeyCompleted() {
		return searchKeyCompleted;
	}

	public String getSurveyor() {
		return surveyor;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getBrowser() {
		return browser;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getMessageLogin() {
		return messageLogin;
	}
	
	public String getM1() {
		return m1;
	}
	
	public String getM2() {
		return m2;
	}
	
	public String getM3() {
		return m3;
	}
	
	public String getM4() {
		return m4;
	}
	
	public String getM5() {
		return m5;
	}
	
	public String getNik() {
		return nik;
	}
	
	public String getName() {
		return name;
	}
	
	public String getUsernameU() {
		return usernameU;
	}
	
	public String getPasswordU() {
		return passwordU;
	}
	
	public String getPrivilege() {
		return privilege;
	}
	
	public String getKota1() {
		return kota1;
	}
	
	public String getKota2() {
		return kota2;
	}
	
	public String getArea1() {
		return area1;
	}
	
	public String getArea2() {
		return area2;
	}
}
