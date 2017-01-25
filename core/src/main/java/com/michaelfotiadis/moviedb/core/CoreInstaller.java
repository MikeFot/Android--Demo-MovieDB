package com.michaelfotiadis.moviedb.core;

import android.content.Context;

import com.michaelfotiadis.moviedb.core.utils.CoreConstants;
import com.michaelfotiadis.moviedb.core.utils.stream.StreamUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;

/*package*/ final class CoreInstaller {
    // File descriptor
    private static final String INSTALLATION = "INSTALLATION";
    // Field for holding the installation generateInstallationId
    private static String sID = null;

    private CoreInstaller() {
        // DO NOT INSTANTIATE
    }

    /*package*/
    static synchronized String generateInstallationId(final Context context) {
        if (sID == null) {
            final File installationFile = new File(context.getFilesDir(), INSTALLATION);
            try {
                if (!installationFile.exists()) {
                    writeInstallationFile(installationFile);
                }
                sID = readInstallationFile(installationFile);
            } catch (final Exception e) {
                throw new RuntimeException(e);
            }
        }
        return sID;
    }

    /*package*/
    static String readInstallationFile(final File installation) throws IOException {
        final RandomAccessFile file = new RandomAccessFile(installation, "r");
        final byte[] bytes = new byte[(int) file.length()];
        file.readFully(bytes);
        StreamUtils.close(file);
        return new String(bytes);
    }

    /*package*/
    static void writeInstallationFile(final File installation) throws IOException {
        final FileOutputStream out = new FileOutputStream(installation);
        final String id = UUID.randomUUID().toString();
        out.write(id.getBytes(CoreConstants.ENCODING_UTF8));
        StreamUtils.close(out);
    }
}