package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object APPLITOOLS_API_KEY
     
    /**
     * <p></p>
     */
    public static Object APPLITOOLS_SETUP
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            APPLITOOLS_API_KEY = selectedVariables['APPLITOOLS_API_KEY']
            APPLITOOLS_SETUP = selectedVariables['APPLITOOLS_SETUP']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
