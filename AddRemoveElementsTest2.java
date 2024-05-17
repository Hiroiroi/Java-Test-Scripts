import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class AddRemoveElementsTest2 {
    ChromeDriver driver = null;

    @Before
    public void testSetup() {
        System.setProperty("Webdriver.chromedriver", "/Users/hiro/Desktop/chromedriver-mac-arm64/chromedriver");
        driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
    }
    @Test
    public void testAddRemove() {

        WebElement addRemoveElementsTab = driver.findElement(By.linkText("Add/Remove Elements"));
        addRemoveElementsTab.click();

        WebElement addElementButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElementButton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));
        Assert.assertTrue(deleteButton.isDisplayed());
        deleteButton.click();

    }

    @Test
    public void checkBoxTest() {
        driver.findElement(By.linkText("Checkboxes")).click();
        WebElement checkBox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        Assert.assertFalse(checkBox1.isSelected());
        if (!checkBox1.isSelected()) {
            checkBox1.click();
            Assert.assertTrue(checkBox1.isSelected());
        }

        WebElement checkBox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
        if(!checkBox2.isSelected()) {
            checkBox2.click();
        }
        if(checkBox1.isSelected()) {
            checkBox1.click();
        }
        if(checkBox2.isSelected()) {
            checkBox2.click();
        }
    }

    @After
    public void cleanUp() {
        driver.quit();
    }
}
