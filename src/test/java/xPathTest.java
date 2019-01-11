import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class xPathTest
{

    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program files\\Tools\\chromedriver.exe");
        driver = new ChromeDriver();
        String baseURL = "http://www.google.com";
        driver.manage().window().maximize();
        driver.get(baseURL);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void xPathTest()
    {
        driver.get("https://www.tinkoff.ru/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Выбираем массив всех элементов второго меню

        driver.findElement(By.xpath("//div[@class=\"header__9V1so header__3rtwn\"]"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Тут обращаемся к последнему

        driver.findElement(By.xpath("//div[@class=\"header__9V1so header__3rtwn\"]/div[last()]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div[@class=\"Icon__icon_3c1E8\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Тут ко второму

        driver.findElement(By.xpath("//div[@class=\"header__9V1so header__3rtwn\"]/div[2]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Ищем родительский элемент. Смог его вывести только при помощи getTagName(). Ни id ни text не работают

        WebElement Parent= driver.findElement(By.xpath("//div[@class=\"header__9V1so header__3rtwn\"]/div[2]/parent::div"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(Parent.getTagName());

        // Тут находится число ссылок. Все эти ссылки это пункты во втором меню - Кредитные карты, Дебетовые карты, Кредит наличными и тд

        List<WebElement> links= Parent.findElements(By.xpath(".//a"));
        System.out.println("Ссылок найдено: " + links.size());

        driver.close();
    }
}
