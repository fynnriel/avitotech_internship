package ru.avito.tech.qa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FavoriteTest {

    @Test
    public void addingFavoriteItem(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.avito.ru/2639542363");
        WebElement likeButton = driver.findElement(By.className("desktop-p6xjn6"));
        likeButton.click();
        driver.get("https://www.avito.ru/favorites");
        WebElement itemNameBlock = driver.findElement(By.className("item-snippet-column-2-md2mY"));
        WebElement itemLink = itemNameBlock.findElement(By.tagName("a"));
        assertEquals(itemLink.getAttribute("href"),
                "https://www.avito.ru/nikel/knigi_i_zhurnaly/domain-driven_design_distilled_vaughn_vernon_2639542363");
        WebElement itemName = itemLink.findElement(By.tagName("p")).findElement(By.tagName("strong"));
        assertEquals(itemName.getText(), "Domain-Driven Design Distilled Vaughn Vernon");
        driver.quit();
    }
}
