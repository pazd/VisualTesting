import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

import java.nio.file.Path

import com.kazurayam.materials.MaterialRepository
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

/**
 * StepByStep/TC_step3 - Entire page screenshot
 *
 */
MaterialRepository mr = (MaterialRepository)GlobalVariable.MATERIAL_REPOSITORY

WebUI.openBrowser('')
WebUI.setViewPortSize(1279, 720)

WebUI.navigateToUrl('https://www.google.com/')

//WebUI.verifyElementPresent(findTestObject('StepByStep/Page_Google_search/name=q'), 10)
//WebUI.setText(findTestObject('StepByStep/Page_Google_search/name=q'), 'katalon')

URL urlF = new URL(WebUI.getUrl())
Path fileFnamedByURL = mr.resolveScreenshotPath(GlobalVariable.CURRENT_TESTCASE_ID, urlF)
CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.saveEntirePageImage'(
	fileFnamedByURL.toFile())

//WebUI.submit(findTestObject('StepByStep/Page_Google_search/name=q'))
//WebUI.verifyElementPresent(findTestObject('StepByStep/Page_Google_result/div_g_1'), 10)

URL urlR = new URL(WebUI.getUrl())
Path fileRnamedByURL = mr.resolveScreenshotPath(GlobalVariable.CURRENT_TESTCASE_ID, urlR)
CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.saveEntirePageImage'(
	fileRnamedByURL.toFile())

WebUI.closeBrowser()