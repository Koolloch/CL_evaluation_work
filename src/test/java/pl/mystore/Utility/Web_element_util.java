package pl.mystore.Utility;

import org.openqa.selenium.WebElement;

public class Web_element_util {
        public static void setText(String text, WebElement targetElement) {
            targetElement.clear();
            targetElement.sendKeys(text);
        }
}
