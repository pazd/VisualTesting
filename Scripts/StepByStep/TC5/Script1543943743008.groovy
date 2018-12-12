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
import java.nio.file.Path as Path
import com.kazurayam.materials.MaterialRepository as MaterialRepository
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

/**
 * StepByStep/TC_step5
 *
 * The screenshot files have fixed name 'search_form.png' and 'search_result.png'
 * rather than URL-dependent file names.
 *
 * Fixed file name is required to do image file comparison. Why?
 *
 * The following 2 PNG files make a MaterialPair:
 * - .\Materials\StepByStep.TS_step5\20181023_141006\StepByStep.TC_step5\search_form.png
 * - .\Materials\StepByStep.TS_step5\20181023_141008\StepByStep.TC_step5\search_form.png
 *
 * But the following 2 PNG files does not make a MaterialPair:
 * -
 * -
 */
MaterialRepository mr = ((GlobalVariable.MATERIAL_REPOSITORY) as MaterialRepository)

WebUI.openBrowser('')

WebUI.setViewPortSize(1279, 720)

assert GlobalVariable.URL != null

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.waitForPageLoad(5)

//WebUI.verifyElementPresent(findTestObject('Page_Latest News Videos  Guest Inte/iframe_TODAY_google_ads_iframe'), 2, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(1)

//DONT Path fileFnamedByURL = mr.resolveScreenshotPath(GlobalVariable.CURRENT_TESTCASE_ID, urlF)
Path fileF = mr.resolveMaterialPath(GlobalVariable.CURRENT_TESTCASE_ID, 'News_full.png')

CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.saveEntirePageImage'(fileF.toFile())

WebUI.closeBrowser()
//
//
//
//WebUI.openBrowser('https://www.nbcnews.com/mach?adtest=NewsCuratorTool')
//
//WebUI.setViewPortSize(1279, 720)
//
//
//WebUI.waitForPageLoad(5)
//
//Path fileF = mr.resolveMaterialPath(GlobalVariable.CURRENT_TESTCASE_ID, 'mach.png')
//
//CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.saveEntirePageImage'(fileF.toFile())
//
//
//WebUI.closeBrowser()