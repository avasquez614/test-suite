package org.craftercms.studio.test.pages;

import org.craftercms.studio.test.utils.UIElementsPropertiesManager;
import org.craftercms.studio.test.utils.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

	private SiteConfigPage siteConfigPage;

	/**
	 * 
	 */
	public PreviewPage(WebDriverManager driverManager, UIElementsPropertiesManager UIElementsPropertiesManager) {
		this.driverManager = driverManager;
		this.driverManager.getDriver();
		this.siteConfigPage = new SiteConfigPage(driverManager, UIElementsPropertiesManager);
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

	}

	public PreviewPage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	}

	// Click on admin console link

	public void clickAdminConsoleOption() {
		this.driverManager.driverWait();
		WebElement adminConsoleOption = driverManager.getDriver().findElement(By.cssSelector(adminConsole));
		adminConsoleOption.click();

	}

	public void goToAdminConsolePage() {

		// Click on admin console link

		this.clickAdminConsoleOption();

	}

	// Open combo all sites

	public void ComboAllSites() {
		this.driverManager.driverWait();
		WebElement openCombo = driverManager.getDriver().findElement(By.id(openComboSites));
		openCombo.click();

	}

	public void OpenComboAllSites() {

		// Open combo all sites

		this.ComboAllSites();

	}

	// Click on preview tools icon

	public void previewTools() {
		this.driverManager.driverWait();
		WebElement toolsIcon = driverManager.getDriver().findElement(By.id(clickPreviewTools));
		toolsIcon.click();

	}

	public void clickOnPreviewTools() {

		// Click on preview tools icon

		this.previewTools();

	}

	// Expand the In Context Menu

	public void expandInContextEditing() {
		this.driverManager.driverWait();
		WebElement expandInContextMenu = driverManager.getDriver().findElement(By.xpath(expandInContextEditing));
		expandInContextMenu.click();

	}

	public void clickToExpandInContextEditing() {

		// Expand the In Context Menu

		this.expandInContextEditing();

	}

	// Enable/Diseble In-Context Editing

	public void inContextEditing() {
		this.driverManager.driverWait();
		WebElement inContextEditingOption = driverManager.getDriver().findElement(By.xpath(clickInContextEdit));
		inContextEditingOption.click();

	}

	public void clickToEnableDisableInContextEditing() {

		// Enable/Diseble In-Context Editing

		this.inContextEditing();

	}

	// Click on Approve&Publish option

	public void approvePublish() {
		this.driverManager.driverWait();
		WebElement toolsIcon = driverManager.getDriver().findElement(By.xpath(approvePublish));
		
		toolsIcon.click();
		this.driverManager.driverWait();
	}

	public void clickOnApprovePublish() {

		// Click on Approve&Publish option

		this.approvePublish();

	}

	// Click on submit button of Approve&Publish

	public void submitApprovePublish() {
		this.driverManager.driverWait();
		WebElement toolsIcon = driverManager.getDriver().findElement(By.xpath(submitButtonApprovePublish));
		toolsIcon.click();

	}

	public void clickOnSubmitButtonOfApprovePublish() {

		// Click on submit button of Approve&Publish

		this.submitApprovePublish();

	}

	// Click on duplicate button of the menu

	public void duplicateButton() {
		this.driverManager.driverWait();
		WebElement duplicateOption = driverManager.getDriver().findElement(By.xpath(previewDuplicate));
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
		this.driverManager.driverWait();
		WebElement deleteOption = driverManager.getDriver().findElement(By.xpath(previewDelete));
		deleteOption.click();

	}

	public void clickOnDeleteOption() {

		// Click on delete button of the menu

		this.deleteButton();

	}

	// Click on delete dependencies

	public void deleteDependencies() {
		this.driverManager.driverWait();
		WebElement deleteDepen = driverManager.getDriver().findElement(By.id(deleteDependencies));
		deleteDepen.click();

	}

	public void clickOnDeleteDependencies() {

		// Click on delete dependencies

		this.deleteDependencies();

	}

	// Click on OK to delete dependencies

	public void okDeleteDependencies() {
		this.driverManager.driverWait();
		WebElement OKdeleteDepen = driverManager.getDriver().findElement(By.cssSelector(OKdeleteDependencies));
		OKdeleteDepen.click();

	}

	public void clickOnOKDeleteDependencies() {

		// Click on OK to delete dependencies

		this.okDeleteDependencies();

	}

	// Click on edit button of the menu

	public void EditButton() {
		this.driverManager.driverWait();
		WebElement editOption = driverManager.getDriver().findElement(By.xpath(previewEdit));
		editOption.click();

	}

	public void clickOnEditOption() {

		// Click on edit button of the menu

		this.EditButton();

	}

	// Click on history button of the menu

	public void historyButton() {
		this.driverManager.driverWait();
		WebElement historyOption = driverManager.getDriver().findElement(By.cssSelector(previewHistory));
		historyOption.click();

	}

	public void clickOnHistoryOption() {

		// Click on history button of the menu

		this.historyButton();

	}

	// Click on dependencies button of the menu

	public void dependenciesButton() {
		this.driverManager.driverWait();
		WebElement historyOption = driverManager.getDriver().findElement(By.cssSelector(previewDependecies));
		historyOption.click();

	}

	public void clickOnDependenciesOption() {

		// Click on dependencies button of the menu

		this.dependenciesButton();

	}

	// Set the new name duplicated

	public void duplicateName(String strDuplicateName) {
		this.driverManager.driverWait();
		WebElement internalName = driverManager.getDriver().findElement(By.xpath(duplicateName));
		internalName.sendKeys(strDuplicateName);

	}

	public void setDuplicateName(String strDuplicateName) {

		// Set the new name duplicated

		this.duplicateName(strDuplicateName);

	}

	// Click on save and close

	public void SaveAndClose() {
		this.driverManager.driverWait();
		WebElement saveClose = driverManager.getDriver().findElement(By.cssSelector(saveAndClose));
		saveClose.click();

	}

	// Expand pages tree

	public void clickPagesTree() {
		this.driverManager.driverWait();
		WebElement expandPagesTree = driverManager.getDriver().findElement(By.cssSelector(pagesTree));
		expandPagesTree.click();

	}

	public void expandPagesTree() {

		// Expand pages tree

		this.clickPagesTree();

	}

	// Expand global entry content

	public void clickHomeContent() {
		this.driverManager.driverWait();
		WebElement homeContent = driverManager.getDriver().findElement(By.cssSelector(expandGlobalEntryContent));
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
		this.driverManager.driverWait();
		WebElement URLName = driverManager.getDriver().findElement(By.xpath(internalName));
		URLName.sendKeys(strNewInternalName);

	}

	public void setNewInternalName(String strNewInternalName) {

		// Set the new name of the URL

		this.changeInternalName(strNewInternalName);

	}

	// Click save and close

	public void saveAndCloseButton() {
		this.driverManager.driverWait();
		WebElement saveClose = driverManager.getDriver().findElement(By.cssSelector(saveAndCloseiFrame));
		saveClose.click();

	}

	public void clickOnSaveAndCloseButton() {

		// Click save and close

		this.saveAndCloseButton();

	}

	public void changeBodyOfEntryContentPageToNotRequired() {
		this.getDriverManager().driverWait();
		this.getDriverManager().driverWait();
		// Show site content panel
		driverManager.getDriver().findElement(By.xpath(".//a[@id='acn-dropdown-toggler']")).click();

		// wait for element is clickeable

		this.getDriverManager().driverWait();
		this.getDriverManager().driverWait();

		// go to admin console page

		this.getDriverManager().getDriver().findElement(By.cssSelector("#admin-console")).click();

		// wait for element is clickeable

		this.getDriverManager().driverWait();

		// select content types
		siteConfigPage.selectContentTypeOption();

		// open content types

		siteConfigPage.clickExistingTypeOption();

		// wait for element is clickeable

		this.getDriverManager().driverWait();
		this.getDriverManager().driverWait();

		siteConfigPage.selectEntryContentType();

		// Confirm the content type selected

		siteConfigPage.confirmContentTypeSelected();

		// wait for element is clickeable
		driverManager.getDriver().switchTo().defaultContent();

		this.getDriverManager().driverWait();

		// select main content

		driverManager.getDriver().findElement(By.cssSelector("#yui-gen8")).click();

		// wait for element is clickeable

		this.getDriverManager().driverWait();

		// Body not required

		driverManager.getDriver()
				.findElement(By.cssSelector("div.property-wrapper:nth-child(21) > div:nth-child(2) > input")).click();

		// wait for element is clickeable

		this.getDriverManager().driverWait();

		// save

		siteConfigPage.saveDragAndDropProcess();

		// wait for element is clickeable

		this.getDriverManager().driverWait();

		// go to dashboard

		driverManager.getDriver().findElement(By.cssSelector("#cstudio-logo")).click();

	}

}