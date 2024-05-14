package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page extends BasePage{

	public WebDriver driver;

	public Login_Page(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	PageObjectManager pageObjectManager;

	@FindBy(id = "user-name")
	private WebElement userName_Textbox;
	
	@FindBy(id = "password")
	private WebElement password_Textbox;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	
	public void loginToApp(String username, String Pwd) {
		sendkeys(userName_Textbox,username);
		sendkeys(password_Textbox,Pwd);
		click(loginButton);
	}
}
