package pl.mystore.Utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Driver;
import java.time.LocalDateTime;

public class Web_element_util {
        public static void setText(String text, WebElement targetElement) {
            targetElement.clear();
            targetElement.sendKeys(text);
        }
    public static void takeScreen(Driver driver) throws IOException {
        File tmpScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        Files.copy(tmpScreenshot.toPath(), Paths.get("zaliczenie/screen", "test-evidence", "zadanie2-"+currentDateTime+".png"));
    }

}
