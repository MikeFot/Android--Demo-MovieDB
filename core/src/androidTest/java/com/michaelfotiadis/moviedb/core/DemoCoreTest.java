package com.michaelfotiadis.moviedb.core;


import android.test.AndroidTestCase;

/**
 *
 */
public class DemoCoreTest extends AndroidTestCase {

    public void setUp() throws Exception {
        super.setUp();
        // initialise the sdk first
        DemoCore.init(getContext().getApplicationContext(), "key", "url", true, true);
    }

    public void testGetInstallationId() throws Exception {
        assertNotNull("Null installation id", DemoCore.getInstallationId());
    }

    public void testIsDebugEnabled() throws Exception {
        assertNotNull("Null debug flag", DemoCore.isDebugEnabled());
    }

    public void testIsStrictMode() throws Exception {
        assertNotNull(DemoCore.getInstance().isStrictModeEnabled());
    }

    public void testSetIsDebugEnabled() throws Exception {
        DemoCore.setDebugEnabled(false);
        assertFalse("Wrong debug flag", DemoCore.isDebugEnabled());
        DemoCore.setDebugEnabled(true);
        assertTrue("Wrong debug flag", DemoCore.isDebugEnabled());
    }

    public void testSetIsStrictMode() throws Exception {
        DemoCore.setStrictModeEnabled(true);
        assertTrue(DemoCore.getInstance().isStrictModeEnabled());
        DemoCore.setStrictModeEnabled(false);
        assertFalse(DemoCore.getInstance().isStrictModeEnabled());
    }

}