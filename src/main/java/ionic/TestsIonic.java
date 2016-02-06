package ionic;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class TestsIonic {
    FirefoxDriver wd;
    
    @Before
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void tests() {
        wd.get("http://192.168.1.28:8100/");
        wd.findElement(By.linkText("Déchets")).click();
        wd.findElement(By.linkText("Plastique Brique")).click();
        wd.findElement(By.linkText("Barquette polystyrène")).click();
        wd.findElement(By.xpath("//ion-nav-view/ion-tabs/ion-nav-view[2]/ion-view[3]/ion-content/div[1]/div/div[2]")).click();
        wd.findElement(By.linkText("Fiches")).click();
        wd.findElement(By.linkText("Bacs jaunes et bleus")).click();
        wd.findElement(By.xpath("//ion-nav-bar/div[1]/ion-header-bar/button")).click();
        wd.findElement(By.linkText("Lieux")).click();
        wd.findElement(By.xpath("//ion-nav-view/ion-tabs/ion-nav-view[4]/ion-view/ion-content/div[1]/label[2]/input")).click();
        wd.findElement(By.xpath("//ion-nav-view/ion-tabs/ion-nav-view[4]/ion-view/ion-content/div[1]/label[2]")).click();
        wd.findElement(By.xpath("//ion-nav-view/ion-tabs/ion-nav-view[4]/ion-view/ion-content/div[1]/label[2]/input")).click();
        wd.findElement(By.xpath("//ion-nav-view/ion-tabs/ion-nav-view[4]/ion-view/ion-content/div[1]/label[2]/input")).clear();
        wd.findElement(By.xpath("//ion-nav-view/ion-tabs/ion-nav-view[4]/ion-view/ion-content/div[1]/label[2]/input")).sendKeys("test_structure");
        wd.findElement(By.xpath("//ion-nav-view/ion-tabs/ion-nav-view[4]/ion-view/ion-content/div[1]/label[2]/input")).click();
        wd.findElement(By.xpath("//ion-nav-view/ion-tabs/ion-nav-view[4]/ion-view/ion-content/div[1]/label[2]/input")).sendKeys("\n");
        wd.findElement(By.linkText("Déchets")).click();
        new Actions(wd).doubleClick(wd.findElement(By.linkText("Déchets"))).build().perform();
        wd.findElement(By.linkText("Carte")).click();
        wd.findElement(By.xpath("//div[@class='leaflet-marker-pane']/img[36]")).click();
    }
    
    @After
    public void tearDown() {
        wd.quit();
    }
    
    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
