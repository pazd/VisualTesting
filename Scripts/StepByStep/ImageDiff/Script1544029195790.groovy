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

import java.util.stream.Collectors

import com.kazurayam.ksbackyard.Assert
import com.kazurayam.ksbackyard.ImageCollectionDiffer
import com.kazurayam.materials.ExecutionProfile
import com.kazurayam.materials.FileType
import com.kazurayam.materials.MaterialPair
import com.kazurayam.materials.MaterialRepository
import com.kazurayam.materials.TCaseName
import com.kazurayam.materials.TSuiteName
import com.kms.katalon.core.model.FailureHandling

import internal.GlobalVariable

/**
 * StepByStep/ImageDiff
 *
 * This test case reads 2 sets of PNG files and creates a set of PNG files.
 *
 * This test case compares 2 img files, calculate how much different these are, and
 * generates 1 ImageDiff file.
 *
 * This test case makes no interaction with web.
 */
MaterialRepository mr = (MaterialRepository)GlobalVariable.MATERIAL_REPOSITORY
assert mr != null

// scan the ./Materials directory to make a list of MateriaPair object.
// The 1st and 2nd latest TSuiteResult 'Test Suites/StepByStep/TS_step5' are looked up.
// The list will be filtered to include PNG files only.
List<MaterialPair> materialPairs = mr.createMaterialPairs(
		new TSuiteName('Test Suites/StepByStep/TS_step5')
		).stream().filter { mp ->
			mp.getLeft().getFileType() == FileType.PNG
		}.collect(Collectors.toList())

// make sure the list of MateriaPairs is not empty
Assert.assertTrue(">>> materialPairs.size() is 0. there must be something wrong.",
	materialPairs.size() > 0,
	FailureHandling.STOP_ON_FAILURE)

// make ImageDiff files in the ./Materials/ImageDiff directory
new ImageCollectionDiffer(mr).makeImageCollectionDifferences(
		materialPairs,
		new TCaseName(GlobalVariable.CURRENT_TESTCASE_ID),  // 'Test Cases/StepByStep/ImageDiff'
		0.50)
