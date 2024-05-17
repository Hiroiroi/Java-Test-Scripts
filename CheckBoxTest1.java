import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBoxTest1 {

    public static void main (String[] args) {

        System.setProperty("Webdriver.chrome.driver","/Users/hiro/Desktop/chromedriver-mac-arm64/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        WebElement checkBoxesLink = driver.findElement(By.linkText("Checkboxes"));
        checkBoxesLink.click();

        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        System.out.println(checkBox1.isSelected());

        if (!checkBox1.isSelected()) {
            System.out.println("Checkbox 1 has been selected");
            checkBox1.click();
        } else {
            System.out.println("Checkbox 1 already selected");
        }

        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        System.out.println(checkBox2.isSelected());

        if (!checkBox2.isSelected()) {
            System.out.println("Checkbox 2 has been selected");
            checkBox2.click();
        } else {
            System.out.println("Checkbox 2 already selected");
        }

        if (checkBox1.isSelected()) {
        System.out.println("Checkbox 1 unselected");
        checkBox1.click();
        } else {
        System.out.println();
        }

        if (checkBox2.isSelected()) {
        System.out.println("Checkbox 2 unselected");
        checkBox2.click();
        } else {
            System.out.println();
        }

        driver.quit();

    }

}