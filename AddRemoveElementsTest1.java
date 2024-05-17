import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddRemoveElementsTest1 {

    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver","/Users/hiro/Desktop/chromedriver-mac-arm64/chromedriver");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        WebElement addRemoveElementsPage = driver.findElement(By.linkText("Add/Remove Elements"));
        addRemoveElementsPage.click();

        WebElement addElementButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElementButton.click();
        System.out.println("Element added");

        WebElement deleteElementButton = driver.findElement(By.xpath("//button[text()='Delete'][1]"));
        deleteElementButton.click();
        System.out.println("Element deleted");

        driver.quit();

    }

}
