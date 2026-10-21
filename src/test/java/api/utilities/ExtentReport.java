
package api.utilities;

import java.io.File;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport implements ITestListener {

    ExtentReports extent;
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {

        String path = System.getProperty("user.dir")
                + "/reports/ExtentReport.html";

        new File(System.getProperty("user.dir") + "/reports")
                .mkdirs();

        ExtentSparkReporter reporter =
                new ExtentSparkReporter(path);

        reporter.config().setDocumentTitle("API Automation Report");
        reporter.config().setReportName("Rest Assured Test Results");
       

        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                extent.createTest(result.getMethod().getMethodName());

        test.set(extentTest);
        test.get().info("API test execution started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("API test passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail("API test failed");
        test.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip("API test skipped");

        if (result.getThrowable() != null) {
            test.get().skip(result.getThrowable());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
