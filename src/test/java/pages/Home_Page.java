package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Home_Page extends BasePage{

	public WebDriver driver;

	public Home_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	PageObjectManager pageObjectManager;

	@FindBy(id = "logout_sidebar_link")
	private WebElement logout_Button;
	
	@FindBy(id = "react-burger-menu-btn")
	private WebElement menu_Button;
	
	@FindBy(xpath = "//div[text()='Swag Labs']")
	private WebElement logo_Text;
	
	
	public void verifyHomePageTitle(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	public void verifyHomePageLogo() {
		Assert.assertEquals(logo_Text.getText(), "Swag Labs");
	}
	
	public void logout() {
		waitforVisibilityOfElement(menu_Button);
		waitforElementToBeClickable(menu_Button);
		click(menu_Button);
		waitforPageLoad(10);
		waitforVisibilityOfElement(logout_Button);
		waitforElementToBeClickable(logout_Button);
		click(logout_Button);
	}
}
