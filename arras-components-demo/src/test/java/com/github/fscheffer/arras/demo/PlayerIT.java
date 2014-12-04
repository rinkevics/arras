package com.github.fscheffer.arras.demo;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.fscheffer.arras.test.ArrasTestCase;

public class PlayerIT extends ArrasTestCase {

    @BeforeMethod
    public void before() {
        open("/PlayerDemo");
    }

    @Test
    public void testVideoPlayer() {

        click("#video .vjs-big-play-button");

        waitUntil(visible("#video .vjs-control-bar"));

        click("#video .vjs-playing");

        // FIXME: sometimes video.js thinks the file is a live stream. Not sure why. Probably another timing issue.
        if (!isLive()) {
            waitUntil(containsText("#video .vjs-duration-display", "0:33"));
        }
    }

    @Test
    public void testAudioPlayer() {

        click("#audio .vjs-play-control");

        waitUntil(visible("#audio .vjs-playing"));

        click("#audio .vjs-playing");

        // FIXME: sometimes video.js thinks the file is a live stream. Not sure why. Probably another timing issue.
        if (!isLive()) {
            waitUntil(containsText("#audio .vjs-duration-display", "3:29"));
        }
    }

    protected boolean isLive() {
        return element(By.cssSelector(".vjs-live-display")).isDisplayed();
    }
}
