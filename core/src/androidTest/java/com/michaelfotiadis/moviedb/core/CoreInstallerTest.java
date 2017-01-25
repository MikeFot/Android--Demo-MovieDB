package com.michaelfotiadis.moviedb.core;

import android.test.AndroidTestCase;
import android.text.TextUtils;

import java.io.File;

/**
 * Tests for the installer class
 */
public class CoreInstallerTest extends AndroidTestCase {

    public void testId() throws Exception {

        final String installationId = CoreInstaller.generateInstallationId(getContext().getApplicationContext());

        assertFalse("Empty installation id", TextUtils.isEmpty(installationId));

    }

    public void testReadWriteInstallationFile() throws Exception {

        final File installationFile = new File(getContext().getFilesDir(), "test_installation");

        CoreInstaller.writeInstallationFile(installationFile);

        final String contents = CoreInstaller.readInstallationFile(installationFile);

        assertFalse("Empty contents", TextUtils.isEmpty(contents));

    }

}