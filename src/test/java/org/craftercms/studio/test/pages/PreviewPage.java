package org.craftercms.studio.test.pages;

import static org.testng.Assert.assertTrue;

import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 *
 * 
 * @author Gustavo Andrei Ortiz Alfaro
 *
 */

public class PreviewPage {

	private WebDriverManager driverManager;
	private String adminConsole;
	private String openComboSites;
	private String clickPreviewTools;
	private String expandInContextEditing;
	private String clickInContextEdit;
	private String approvePublish;
	private String submitButtonApprovePublish;
	private String previewDuplicate;
	private String duplicateName;
	private String saveAndClose;
	private String pagesTree;
	private String expandGlobalEntryContent;
	private String previewDelete;
	private String deleteDependencies;
	private String OKdeleteDependencies;
	private String previewEdit;
	private String internalName;
	private String saveAndCloseiFrame;
	private String previewHistory;
	private String previewDependecies;
	
	private String dependenciesSelector;
	private String dependenciesCloseButton;
	private String siteconfigBulkOperationsoption;
	private String bulkOperationsPathToPublishInput;
	private String bulkoperationsPublishButton;
	private String bulkoperationsAcceptWarning;
	private String bulkoperationsMessage;

	private SiteConfigPage siteConfigPage;
	private DashboardPage dashboardPage;

	private String studioLogo;
	private String siteDropdownElementXPath;
	private String adminConsoleXpath;
	private String entryContentTypeBodyXpath;
	private String entryContentTypeBodyCheckCss;


	/**
	 * 
	 */
	public PreviewPage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
		this.driverManager = driverManager;
		this.driverManager.getDriver();

		this.siteConfigPage = new SiteConfigPage(driverManager, UIElementsPropertiesManager);
		this.dashboardPage = new DashboardPage(driverManager, UIElementsPropertiesManager);
		

		adminConsole = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.admin_console_link");
		openComboSites = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.open_combo_sites");
		clickPreviewTools = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.preview_tools");
		expandInContextEditing = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.expand_in_context_editing");
		clickInContextEdit = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.enable_disable_in_context_edit");
		approvePublish = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.approve&publish");
		submitButtonApprovePublish = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.approve&publish_submit");
		previewDuplicate = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("preview.duplicate");
		duplicateName = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("preview.duplicate_name");
		saveAndClose = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("preview.save_close");
		pagesTree = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("preview.expand_pages");
		expandGlobalEntryContent = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.expand_GlobalEntry_Tree");
		previewDelete = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("preview.delete");
		deleteDependencies = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.delete_dependencies");
		OKdeleteDependencies = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.ok_delete_dependencies");
		previewEdit = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("preview.edit");
		internalName = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("frame1.internal_Name");
		saveAndCloseiFrame = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("frame1.save_close");
		previewHistory = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("preview.history");
		previewDependecies = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("preview.dependencies");
		dependenciesSelector = UIElementsPropertiesManager.getSharedUIElementsLocators()
					.getProperty("dependencies.content_selector");
		dependenciesCloseButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
					.getProperty("dependencies.close_button");
		siteconfigBulkOperationsoption = UIElementsPropertiesManager.getSharedUIElementsLocators()
					.getProperty("siteconfig.bulk_operations_option");
		bulkOperationsPathToPublishInput = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("bulkoperations.path_to_publish_input");
		bulkoperationsPublishButton = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("bulkoperations.publish_button");
		bulkoperationsAcceptWarning = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("bulkoperations.accept_warning");
		bulkoperationsMessage = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("bulkoperations.message");
		studioLogo = UIElementsPropertiesManager.getSharedUIElementsLocators().getProperty("general.studiologo");
		siteDropdownElementXPath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("complexscenarios.general.sitedropdown");
		adminConsoleXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.adminconsole");
		entryContentTypeBodyXpath = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.entrycontenttype.body");
		entryContentTypeBodyCheckCss = UIElementsPropertiesManager.getSharedUIElementsLocators()
				.getProperty("general.entrycontenttype.bodyrequiredcheck");


	}

	// Click on admin console link

	public void clickAdminConsoleOption() {
		WebElement adminConsoleOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
				adminConsole);

		adminConsoleOption.click();

	}

	public void goToAdminConsolePage() {

		// Click on admin console link

		this.clickAdminConsoleOption();

	}

	// Open combo all sites

	public void ComboAllSites() {

		WebElement openCombo = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", openComboSites);

		openCombo.click();

	}

	public void OpenComboAllSites() {

		// Open combo all sites

		this.ComboAllSites();

	}

	// Click on preview tools icon

	public void previewTools() {
		WebElement toolsIcon = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id", clickPreviewTools);

		toolsIcon.click();

	}

	public void clickOnPreviewTools() {

		// Click on preview tools icon

		this.previewTools();

	}

	// Expand the In Context Menu

	public void expandInContextEditing() {
		WebElement expandInContextMenu = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				expandInContextEditing);

		expandInContextMenu.click();

	}

	public void clickToExpandInContextEditing() {

		// Expand the In Context Menu

		this.expandInContextEditing();

	}

	// Enable/Diseble In-Context Editing

	public void inContextEditing() {
		WebElement inContextEditingOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				clickInContextEdit);

		inContextEditingOption.click();

	}

	public void clickToEnableDisableInContextEditing() {

		// Enable/Diseble In-Context Editing

		this.inContextEditing();

	}

	// Click on Approve&Publish option
	public void approvePublish() {
		WebElement publishIcon = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				approvePublish);

		publishIcon.click();

	}

	public void clickOnApprovePublish() {

		// Click on Approve&Publish option

		this.approvePublish();

	}

	// Click on submit button of Approve&Publish

	public void submitApprovePublish() {
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", submitButtonApprovePublish);
		WebElement toolsIcon = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				submitButtonApprovePublish);
		toolsIcon.click();

	}

	public void clickOnSubmitButtonOfApprovePublish() {

		// Click on submit button of Approve&Publish

		this.submitApprovePublish();

	}

	// Click on duplicate button of the menu

	public void duplicateButton() {

		WebElement duplicateOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				previewDuplicate);
		duplicateOption.click();

	}

	public void clickOnDuplicateOption() {

		// Click on duplicate button of the menu

		this.duplicateButton();

	}

	public WebDriverManager getDriverManager() {
		return driverManager;
	}

	// Click on delete button of the menu

	public void deleteButton() {

		WebElement deleteOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				previewDelete);

		deleteOption.click();

	}

	public void clickOnDeleteOption() {

		// Click on delete button of the menu

		this.deleteButton();

	}

	// Click on delete dependencies

	public void deleteDependencies() {

		WebElement deleteDepen = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id",
				deleteDependencies);

		deleteDepen.click();

	}

	public void clickOnDeleteDependencies() {

		// Click on delete dependencies

		this.deleteDependencies();

	}

	// Click on OK to delete dependencies

	public void okDeleteDependencies() {

		WebElement OKdeleteDepen = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
				OKdeleteDependencies);

		OKdeleteDepen.click();

	}

	public void clickOnOKDeleteDependencies() {

		// Click on OK to delete dependencies

		this.okDeleteDependencies();

	}

	// Click on edit button of the menu

	public void EditButton() {

		WebElement editOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", previewEdit);

		editOption.click();

	}

	public void clickOnEditOption() {

		// Click on edit button of the menu

		this.EditButton();

	}

	// Click on history button of the menu

	public void historyButton() {

		WebElement historyOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
				previewHistory);

		historyOption.click();

	}

	public void clickOnHistoryOption() {

		// Click on history button of the menu
		this.historyButton();

	}

	// Click on dependencies button of the menu

	public void dependenciesButton() {

		WebElement historyOption = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
				previewDependecies);

		historyOption.click();

	}

	public void clickOnDependenciesOption() {

		// Click on dependencies button of the menu
		this.dependenciesButton();

	}

	// Set the new name duplicated

	public void duplicateName(String strDuplicateName) {

		WebElement internalName = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath",
				duplicateName);

		internalName.sendKeys(strDuplicateName);

	}

	public void setDuplicateName(String strDuplicateName) {

		// Set the new name duplicated

		this.duplicateName(strDuplicateName);

	}

	// Click on save and close

	public void SaveAndClose() {

		WebElement saveClose = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
				saveAndClose);

		saveClose.click();

	}

	// Expand pages tree

	public void clickPagesTree() {

		WebElement expandPagesTree = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", pagesTree);

		expandPagesTree.click();

	}

	public void expandPagesTree() {

		// Expand pages tree
		this.clickPagesTree();

	}

	// Expand global entry content

	public void clickHomeContent() {
		this.driverManager.isElementPresentAndClickableByXpath(expandGlobalEntryContent);
		WebElement homeContent = this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
				expandGlobalEntryContent);
		homeContent.click();

	}

	public void expandHomeTree() {

		// Expand global entry content

		this.clickHomeContent();

	}

	public void clickOnSaveAndClose() {

		// Click on save and close

		this.SaveAndClose();

	}

	// Set the new name of the URL

	public void changeInternalName(String strNewInternalName) {

		WebElement URLName = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", internalName);

		URLName.sendKeys(strNewInternalName);

	}

	public void setNewInternalName(String strNewInternalName) {

		// Set the new name of the URL

		this.changeInternalName(strNewInternalName);

	}

	// Click save and close

	public void saveAndCloseButton() {

		WebElement saveClose = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector",
				saveAndCloseiFrame);

		saveClose.click();

	}

	public void clickOnSaveAndCloseButton() {

		// Click save and close

		this.saveAndCloseButton();

	}

	public void changeBodyOfEntryContentPageToNotRequired() {

		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", siteDropdownElementXPath).click();

		// go to admin console page
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", adminConsoleXpath).click();

		// select content types
		siteConfigPage.selectContentTypeOption();

		// open content types
		siteConfigPage.clickExistingTypeOption();

		// Confirm the content type selected

		siteConfigPage.confirmContentTypeSelected();

		// wait for element is clickeable
		driverManager.getDriver().switchTo().defaultContent();

		// select main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", entryContentTypeBodyXpath).click();

		// Mark Body not required
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("cssSelector", entryContentTypeBodyCheckCss)
				.click();
		// save
		siteConfigPage.saveDragAndDropProcess();

		driverManager.getDriver().switchTo().defaultContent();

		// go to dashboard
		this.driverManager.getDriver().navigate().refresh();
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("id", studioLogo).click();

	}
	
	public void changeBodyOfArticlePageToNotRequired() {
		
		// Show site content panel
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "xpath", ".//a[@id='acn-dropdown-toggler']")
				.click();
		
		// go to admin console page
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#admin-console").click();

		//Click on Content Types Option
		siteConfigPage.clickContentTypeOption();
		
		// open content types

		siteConfigPage.clickExistingTypeOption();
		
		// select content types
		siteConfigPage.selectPageArticleContentType();


		// Confirm the content type selected
		siteConfigPage.confirmContentTypeSelected();

		// wait for element is clickeable
		driverManager.getDriver().switchTo().defaultContent();
		
		//Scroll Down to select the item
		this.driverManager.scrollDown();

		// select main content
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( 
				"xpath", "//*[@id='yui-gen19']/span[1]").click();
		
		// Mark Body not required
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector",
				"div.property-wrapper:nth-child(21) > div:nth-child(2) > input").click();
	
		// save
		siteConfigPage.saveDragAndDropProcess();

		 driverManager.getDriver().switchTo().defaultContent();
		 
		// go to dashboard
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#cstudio-logo").click();	

	}
	
	
	public void createPageArticleContent(
			String url,String name, String title,String folderLocation, String selectedSegments, String selectedCategories,
			String subject, String author, String summary) {
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", folderLocation);
		
		// right click to see the the menu
		dashboardPage.rightClickToSeeMenuOfSpecificFolder(folderLocation);
		
		// Select Entry Content Type
		dashboardPage.clickEntryCT();

		// Confirm the Content Type selected
		dashboardPage.clickOKButton();

		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", ".studio-ice-dialog > .bd iframe"));
		this.driverManager.isElementPresentAndClickableBycssSelector( ".studio-ice-dialog > .bd iframe");

		//Fill the New Article page Fields
		dashboardPage.setPageURL1(url);
		dashboardPage.setInternalName1(name);
		dashboardPage.setArticlesTitle(title);
		
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", selectedCategories);
		
		//Fill the New Article Content Section
		dashboardPage.setNewArticleContentSection(subject, author, summary);
		
		//Select the catergory of the Article Page
		dashboardPage.selectCategoriesOfNewPageArticle(selectedCategories);
		
		//Select the segment of the Article Page
		dashboardPage.selectSegmentsOfNewPageArticle(selectedSegments);
		
		this.driverManager.scrollDown();
		
		//Add an Image
		dashboardPage.addAnImageToAnArticle();
		
		// Switch to the iframe
		driverManager.getDriver().switchTo().defaultContent();
		driverManager.getDriver().switchTo().frame(this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
				"cssSelector", ".studio-ice-dialog > .bd iframe"));
		this.driverManager.isElementPresentAndClickableBycssSelector( ".studio-ice-dialog > .bd iframe");
		
		// save and close
		this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "id", "cstudioSaveAndClose").click();
			
	}
	
		public void checkDependencies() {
			
			// Switch to the frame
			driverManager.getDriver().switchTo().defaultContent();
			driverManager.getDriver().switchTo().activeElement();
			
			driverManager.waitUntilPageLoad();
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath", dependenciesSelector);
			
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable(
					"xpath", dependenciesCloseButton);
			
			Select categoriesDropDown = new Select(
					this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("xpath", dependenciesSelector));
			categoriesDropDown.selectByValue("depends-on-me");
			
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed(
					"xpath","(//TD[text()='1-gear.png'])[1]");
			
			assertTrue(this.getDriverManager().isElementPresentByXpath(
					"(//TD[text()='1-gear.png'])[1]"));
			
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable(
					"xpath", dependenciesCloseButton).click();
			
		}

		public void bulkPublish() {
			
			WebElement siteConfigButton = this.driverManager.driverWaitUntilElementIsPresentAndDisplayed("id",
					"admin-console");
			siteConfigButton.click();
			
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable(
					"xpath", siteconfigBulkOperationsoption);
			
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable(
					"xpath", siteconfigBulkOperationsoption).click();
			
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable(
					"xpath", bulkOperationsPathToPublishInput).click();
			
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable(
					"xpath", bulkOperationsPathToPublishInput).clear();
			
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable(
					"xpath", bulkOperationsPathToPublishInput).sendKeys("/");
			
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable(
					"xpath", bulkoperationsPublishButton).click();
			
			this.driverManager.getDriver().switchTo().activeElement();
			
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable(
					"xpath", bulkoperationsAcceptWarning);
			
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable(
					"xpath", bulkoperationsAcceptWarning).click();
			
			assertTrue(this.driverManager.isElementPresentByXpath(bulkoperationsMessage));
			
			// Switch back to the dashboard page	
			driverManager.getDriver().switchTo().defaultContent();
			this.driverManager.getDriver().switchTo().activeElement();
			
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable(
			"id", "navbar-site-name");

			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable(
			"id", "navbar-site-name").click();	
			
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayed( "cssSelector", "#admin-console");
			
			
		}

		public void verifyPageArticleIsPublished() {
				
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable(
					"xpath", ".//span[contains(text(),'Testing1')]");
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable(
					"xpath", ".//span[contains(text(),'Testing1')]").click();
			
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable("xpath",
					"//A[@class='cursor'][text()='Delete']");
			
			this.driverManager.driverWaitUntilElementIsPresentAndDisplayedAndClickable( "xpath",
					"//A[@class='cursor'][text()='Edit']");
					
			String isLifeContent="";
			
			while(!(isLifeContent.contains("undefined live")))
			{
				isLifeContent= this.driverManager.getDriver()
				.findElement(By
				.xpath(
						"//ul[@id='activeContentActions']/li/span/div/span/span[2]")).getAttribute("class").toString();
				driverManager.getDriver().navigate().refresh();
				this.dashboardPage.expandHomeTree();	
			}
					
			Assert.assertTrue(this.driverManager.getDriver()
					.findElement(By
					.xpath(
					 ".//ul[@id='activeContentActions']/li/span/div/span/span[2]")).getAttribute("class").contains("undefined live"));
			
		}
		
		
		
	}
	
	
	