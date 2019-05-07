import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration


//get the list of timezone Id here: https://garygregory.wordpress.com/2013/06/18/what-are-the-java-timezone-ids/
//refer to this link to find more datetime format: https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html

//get current date
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getCurrentDateTime'(null,null))
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getCurrentDateTime'(null,"MM_dd_yy-HH_mm_ss"))
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getCurrentDateTime'(null,"hh:mm:ss"))
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getCurrentDateTime'(null,"dd-MM-yyyy hh:mm:ss a"))
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getCurrentDateTime'("US/Samoa","dd-MM-yyyy"))

//get previous date time
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getPreviousDateTime'(1,null,null))
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getPreviousDateTime'(1,"US/Samoa","dd-MM-yyyy"))
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getPreviousDateTime'(1,"US/Samoa","dd-MM-yyyy hh:mm:ss a z"))

//get future date time
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getFutureDateTime'(5, null, null))
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getFutureDateTime'(5, "US/Samoa", "dd-MM-yyyy"))
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getFutureDateTime'(5, null, null))
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getFutureDateTime'(5, "US/Samoa", "d/M/yy h:m:s"))

//set/get timeZone default
TimeZone oldTimeZone = CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getDefaultTimeZone'()
CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.setDefaultTimeZone'("US/Samoa")
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getCurrentDateTime'(null,"dd-MM-yyyy hh:mm:ss a"))
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getPastTime'(5, 1))

//set the default timeZone to local timeZone
CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.setDefaultTimeZone'(null)
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getCurrentDateTime'(null,"dd-MM-yyyy hh:mm:ss a"))
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getPastTime'(5, 1))

//format string date to another format
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.formatStringDate'("30/05/2019", "dd/mm/yyyy", "dd/m/yyyy"))

//convert string to date
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.convertString2Date'("30/05/2019", "dd/MM/yyyy").toString())

//add days to string date
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.addDays'("30/05/2019", "dd/MM/yyyy", 5))

//get day of week
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getDayOfWeek'("05-07-2019", "MM-dd-yyyy"))

//get current date
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getCurrentDate'().toString())

//get current month
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getCurrentMonth'().toString())

//get current year
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getCurrentYear'().toString())

//get duration
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getDuration'("09:00 AM","11:00 AM").toString())

//get current time
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getCurrentDateTime'(null,"hh:mm a"))

//get past time
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getPastTime'(3, 3))

//get future time
KeywordUtil.logInfo(CustomKeywords.'com.kms.katalon.keyword.datetime.DateTimeUtility.getFutureTime'(2, 2))