package alert;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Genz_Technologies {

	public static void main(String[] args) throws InterruptedException {

		EdgeOptions options = new EdgeOptions();
		//		options.addArguments("--headless");
		options.addArguments("--start-maximized");

		WebDriver driver = new EdgeDriver(options);
		driver.get("https://www.genztechnologies.net/#");

		List<WebElement> courseLinks = driver.findElements(By.xpath("//div[@class='course-info course-info-2']//child::a"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		if (!courseLinks.isEmpty()) {
			Random random = new Random();
			int randomIndex = random.nextInt(courseLinks.size());
			wait.until(ExpectedConditions.elementToBeClickable(courseLinks.get(randomIndex)));
			actions.moveToElement(courseLinks.get(randomIndex)).click().build().perform();
		} else {
			System.out.println("No course links found.");
		}

		js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath("//h2[text()='Course Details']")));

	}
}
