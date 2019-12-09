package be.intecbrussel.centralblogproject.model.Utilities;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

//credit to https://binarycoders.dev/2015/04/21/image-url-to-byte-array/


public class ImageRecovery {

    public static byte[] recoverImageFromUrl(String urlText) throws Exception {
        URL url = new URL(urlText);
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try (InputStream inputStream = url.openStream()) {
            int n = 0;
            byte [] buffer = new byte[ 1024 ];
            while (-1 != (n = inputStream.read(buffer))) {
                output.write(buffer, 0, n);
            }
        }

        return output.toByteArray();
    }
}