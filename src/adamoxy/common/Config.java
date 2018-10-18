
package adamoxy.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

/**
 *
 * @author adam
 */
public class Config {

    public static String getConfigurationParameter(String parameterName, String defaultValue) {

        return getConfigurationParameter(parameterName, defaultValue, "wamy.ini");

    }

    public static String getConfigurationParameter(String parameterName, String defaultValue, String aFile) {

        Properties prop = new Properties();
        try {
            if (!aFile.contains(File.separator)) {
                String path = System.getProperty("user.home") + File.separator + "Adamoxy@wamy" + File.separator + "Configuration" + File.separator;

                aFile = path + aFile;

            }

            String text;
            try (FileInputStream stream = new FileInputStream(aFile)) {
                prop.load(stream);
                text = prop.getProperty(parameterName, defaultValue);
            }

            return (text);

        } catch (IOException ex) {
            log.writeEvent(ex.toString());
            return (defaultValue);
        }

    }

    public static String getMD5(String pass) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            byte[] data = pass.getBytes();
            m.update(data, 0, data.length);

            BigInteger i = new BigInteger(1, m.digest());
            return (String.format("%1$032X", i).toLowerCase());
        } catch (NoSuchAlgorithmException ex) {
            log.writeEvent("Error in GetMD5: " + ex.toString());
            return (null);
        }
    }
}
