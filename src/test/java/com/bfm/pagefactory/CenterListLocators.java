package com.bfm.pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.util.Baseclass;

public class CenterListLocators extends Baseclass{
public CenterListLocators()
{
	PageFactory.initElements(driver, this);
}

@FindBy(id="")
private WebElement usrn;

public WebElement getUsrn() {
	return usrn;
}


}
