package com.github.fscheffer.arras.test;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

public class DefaultTestContext implements TestContext {

    private final WebDriver    driver;

    private final String       baseUrl;

    private final Capabilities capabilities;

    public DefaultTestContext(WebDriver driver, String baseUrl, Capabilities capabilities) {
        this.driver = driver;
        this.baseUrl = baseUrl;
        this.capabilities = capabilities;
    }

    public DefaultTestContext(String baseUrl, Capabilities capabilities) {
        this(ArrasTestUtils.createWebDrive(capabilities), baseUrl, capabilities);
    }

    public DefaultTestContext(Capabilities capabilities) {
        this(System.getProperty(TestingConstants.BASE_URL, "localhost:8080"), capabilities);
    }

    @Override
    public WebDriver getDriver() {
        return this.driver;
    }

    @Override
    public String getBaseUrl() {
        return this.baseUrl;
    }

    @Override
    public Capabilities getCapabilities() {
        return this.capabilities;
    }
}
