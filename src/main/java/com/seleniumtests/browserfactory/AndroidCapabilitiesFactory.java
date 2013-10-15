package com.seleniumtests.browserfactory;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.seleniumtests.driver.web.WebDriverConfig;

public class AndroidCapabilitiesFactory implements ICapabilitiesFactory{

	public DesiredCapabilities createCapabilities(WebDriverConfig cfg) {
		DesiredCapabilities capability = null;
		capability = DesiredCapabilities.android();
		
		if(cfg.isEnableJavascript())
			capability.setJavascriptEnabled(true);
		else
			capability.setJavascriptEnabled(false);
		capability.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		if (cfg.getBrowserVersion()!= null) {
			capability.setVersion(cfg.getBrowserVersion());
		}

		if (cfg.getPlatform() != null) {
			capability.setPlatform(cfg.getPlatform());
		}
		
		
		if (cfg.getProxyHost() != null) {
			Proxy proxy = cfg.getProxy();
			capability.setCapability(CapabilityType.PROXY, proxy);
		}
		
		
		return capability;
	}
	
	

}
