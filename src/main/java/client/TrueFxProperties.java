package client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Manages properties for both prod and dev contexts.
 */
public class TrueFxProperties {

  public static String getUsername() {
    return TrueFxProperties.getProperty("username");
  }

  public static String getPassword() {
    return TrueFxProperties.getProperty("password");
  }

  public static String getDevUsername() {
    return TrueFxProperties.getTestProperty("username");
  }

  public static String getDevPassword() {
    return TrueFxProperties.getTestProperty("password");
  }

  private static String getProperty(String property, String env) {
    Properties prop = new Properties();
    InputStream input = null;

    try {

      String filename = "application-" + env + ".properties";
      input = TrueFxProperties
          .class
          .getClassLoader()
          .getResourceAsStream(filename);
      if(input==null){
        throw new FileNotFoundException(filename);
      }

      //load a properties file from class path, inside static method
      prop.load(input);

      //get the property value and print it out
      return prop.getProperty(property);

    } catch (IOException ex) {
      ex.printStackTrace();
    } finally{
      if(input!=null){
        try {
          input.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }

  private static String getProperty(String property) {
    return TrueFxProperties.getProperty(property, "prod");
  }

  private static String getTestProperty(String property) {
    return TrueFxProperties.getProperty(property, "dev");
  }
}
