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
import java.nio.file.Path as Path
import com.kazurayam.materials.MaterialRepository as MaterialRepository

/**
 * StepByStep/TC_step2 - Materials applied
 *
 */
MaterialRepository mr = ((GlobalVariable.MATERIAL_REPOSITORY) as MaterialRepository)

WebUI.openBrowser('')

WebUI.setViewPortSize(1279, 720)

WebUI.navigateToUrl('https://www.google.com/')

//WebUI.verifyElementPresent(findTestObject('StepByStep/Page_Google_search/input_q'), 10, FailureHandling.CONTINUE_ON_FAILURE)

//WebUI.setText(findTestObject('StepByStep/Page_Google_search/input_q'), 'katalon')

Path fileF = mr.resolveMaterialPath(GlobalVariable.CURRENT_TESTCASE_ID, "search_form.png")
WebUI.takeScreenshot(fileF.toString())
URL urlF = new URL(WebUI.getUrl())

Path fileFnamedByURL = mr.resolveScreenshotPath(GlobalVariable.CURRENT_TESTCASE_ID, urlF)

WebUI.takeScreenshot(fileFnamedByURL.toString())

//WebUI.submit(findTestObject('StepByStep/Page_Google_search/input_q'))

//WebUI.verifyElementPresent(findTestObject('StepByStep/Page_Google_result/div_g_1'), 10, FailureHandling.CONTINUE_ON_FAILURE)

Path fileR = mr.resolveMaterialPath(GlobalVariable.CURRENT_TESTCASE_ID, "search_result.png")
WebUI.takeScreenshot(fileR.toString())
URL urlR = new URL(WebUI.getUrl())

Path fileRnamedByURL = mr.resolveScreenshotPath(GlobalVariable.CURRENT_TESTCASE_ID, urlR)

WebUI.takeScreenshot(fileRnamedByURL.toString())

WebUI.closeBrowser()

