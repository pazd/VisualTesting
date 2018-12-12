import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.nio.file.Files as Files
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

/**
 * StepByStep/TC_step1 - start up
 *
 * We are starting up an ordinary Test Case.
 * This test case opens Google and make search query, take screenshots, saves images into ./tmp directory.
 * No "Visual Testing" feature is implemented yet.
 */
// resolve output dir
Path projectDir = Paths.get(RunConfiguration.getProjectDir())

Path outdir = projectDir.resolve('tmp')

Files.createDirectories(outdir)

// open browser
WebUI.openBrowser('')

WebUI.setViewPortSize(1279, 720)

// navigate to the Google form page
WebUI.navigateToUrl('https://www.google.com')

//WebUI.verifyElementPresent(findTestObject('StepByStep/Page_Google_search/input_q'), 10)
//WebUI.setText(findTestObject('StepByStep/Page_Google_search/input_q'), 'katalon')
// take screen shot and save it into search_form.png file
Path fileF = outdir.resolve('search_form.png')

WebUI.waitForPageLoad(1)

WebUI.takeScreenshot(fileF.toString())

//// submit query, page is transfered to the Google result page
//WebUI.submit(findTestObject('StepByStep/Page_Google_search/input_q'))
//WebUI.verifyElementPresent(findTestObject('StepByStep/Page_Google_result/div_g_1'), 10)
// take scree shot and save it into search_result.png file
Path fileR = outdir.resolve('search_result.png')

WebUI.takeScreenshot(fileR.toString())

// close browser
WebUI.closeBrowser()

