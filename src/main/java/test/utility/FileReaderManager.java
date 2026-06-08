package test.utility;

import org.junit.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileReaderManager {

    private static FileInputStream fileInputStream;
    private static Properties properties;
    public static void setupProperties() {
        File file = new File("C:\\Users\\nasri\\IdeaProjects\\MavenProject\\src\\main\\resources\\TestData.properties");
        try {
            fileInputStream = new FileInputStream(file);
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            Assert.fail("ERROR: OCCUR DURING FILE LOADING");
        } catch (IOException e) {
             Assert.fail("ERROR: OCCUR DURING FILE READING");
        }
    }
        public static String getDataProperty(String value)
        {
            setupProperties();
            String data = properties.getProperty(value);
            return data;

        }
    }


