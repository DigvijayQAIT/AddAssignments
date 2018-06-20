package gmailAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail {
	
public static WebDriver driver;
	
	public void sendKeys(String type, String typeValue, String key) {
		if (type.equals("id")) {
			driver.findElement(By.id(typeValue)).sendKeys(key);
		} else if (type.equals("css")) {
			driver.findElement(By.cssSelector(typeValue)).sendKeys(key);
		}
	}
	
	public void openLink(String url) {
		driver.get(url);
	}
	
	public void waitTime(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	
	public void getNumberOfUnreadEmails(WebDriver driver) {
		String attrValue = driver.findElement(
				By.cssSelector("#\\3a gt > div > div.aio.UKr6le > span > a")).getAttribute("aria-label");
		String unreadMessageValue = attrValue.substring(6, 8);
		System.out.println(unreadMessageValue);
	}

	public static void main(String[] args) {
		
		// Initializing Objects
		Gmail gmail = new Gmail();
		driver = new ChromeDriver();
		
		// Open Gmail
		gmail.openLink("https://mail.google.com/");
		
		// Entering email address in required field and clicking next
		gmail.sendKeys("id", "identifierId", "vj.vns1707");
		driver.findElement(By.id("identifierNext")).click();
		gmail.waitTime(5);
		
		// Entering password in required field and clicking next
		gmail.sendKeys("css", "#password > div.aCsJod.oJeWuf > div > div.Xb9hP > input", "**********");
		driver.findElement(By.id("passwordNext")).click();
		gmail.waitTime(5);
		
		// Reading initial count of unread email's
		gmail.getNumberOfUnreadEmails(driver);
		
		
		// Opening an unread email
		WebElement table = driver.findElement(By.cssSelector("#\\3a 2d"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		
		for (WebElement row : rows) {
			String classType = row.getAttribute("class");
			if (classType.equals("zA zE")) {
				row.click();
				gmail.waitTime(5);
				driver.findElement(By.xpath(".//*[@id=\":5\"]/div[2]/div[1]/div/div[1]/div")).click();
				break;
			} else if (classType.equals("zA yO")) {
				continue;
			}
		}
		
		// Again reading count of unread email's
		gmail.getNumberOfUnreadEmails(driver);
	}
}
