package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {
    public void onStart(ITestContext execution) {
        System.out.println("----------------- Starting Execution ---------------");
    }

    public void onFinish(ITestContext execution) {
        System.out.println("----------------- Ending Execution ---------------");
    }

    public void onTestSkipped(ITestResult test) {
        System.out.println("----------- Skipping Test:" + test.getName() + " -------------");
    }

    public void onTestStart(ITestResult test) {
        System.out.println("----------- Starting Test:" + test.getName() + " -------------");
    }

    public void onTestSuccess(ITestResult test) {
        System.out.println("----------- Test:" + test.getName() + " Passed -------------");

            try { 
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }

            
            File file = new File("./test-recordings/" + test.getName() + ".avi");
            if(file.delete())
                System.out.println("Test recording Deleted Successfully");
            else
                System.out.println("Failed to Delete File");
    
    }


    public void onTestFailure(ITestResult test) {
        System.out.println("----------- Test:" + test.getName() + " Failed -------------");

            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            saveScreenshot("Failed", "png");
        
    }

}
