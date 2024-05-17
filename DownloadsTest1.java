import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DownloadsTest1 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","/Users/hiro/Desktop/chromedriver-mac-arm64/chromedriver");

        String downloadDirectory = "/Users/hiro/Downloads";

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadDirectory);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://the-internet.herokuapp.com/");
        WebElement fileDownloadLink = driver.findElement(By.linkText("File Download"));
        fileDownloadLink.click();

        driver.findElement(By.xpath("//a[text()='selenium-snapshot.png']")).click();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String downloadedFilePath = downloadDirectory + File.separator + "selenium-snapshot.png";
        File downloadedFile = new File(downloadedFilePath);

        if (downloadedFile.exists()) {
            System.out.println("File downloaded successfully");
        } else {
            System.out.println("File not downloaded");
        }

        if(downloadedFile.delete()) {
            System.out.println("File has been deleted");
        } else {
            System.out.println("File could not be deleted");
        }

        driver.quit();

    }
}