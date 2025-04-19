package com.hcl.uimpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class ProductsPage {
	
	String products=null;
	WebDriver driver;
	
	private WebElement productsTag;
	
	public void productsTab(String products) {
		
		productsTag= driver.findElement(By.xpath("//*[normalize-space(text())='"+products+"']"));
		productsTag.click();
		
	}
	
	public ProductsPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public HashMap<String, String> getProductsRates() {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,100);");
		
		List<WebElement> list=driver.findElements(By.xpath("//*[contains(text(),'View Product')]/../../../preceding-sibling::div/div/p"));
		HashMap<String, String> map=new HashMap<>();
			if(list.size()>0) {
				for (int i=1;i<list.size();i++) {
					WebElement el1=driver.findElement(By.xpath("(//*[contains(text(),'View Product')]/../../../preceding-sibling::div)["+i+"]/div/p[1]"));
					js.executeScript("arguments[0].scrollIntoView(true);", el1);
					String productName= el1.getText().trim();
					String ProductCost= driver.findElement(By.xpath("(//*[contains(text(),'View Product')]/../../../preceding-sibling::div)["+i+"]/div/h2[1]")).getText().trim();
					map.put(productName, ProductCost);
				}
			}else {
				System.out.println("No Products found");
			}
		return map;
	}
	
	

}
