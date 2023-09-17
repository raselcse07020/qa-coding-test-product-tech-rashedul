package au.foxsports.com.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportManager {
    private static String path;
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();

        return extent;
    }

    private static ExtentReports createInstance() {
        if (extent == null) {
            String projectDirectory = System.getProperty("user.dir");
            String reportGeneratedPath = "\\build\\extendReport\\ExtendReport.html";
            ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(projectDirectory + reportGeneratedPath);
            extentSparkReporter.config().setDocumentTitle("Fox Sport Project's Automation Report");
            extentSparkReporter.config().setReportName("Fox Sport Project's - Automation Report");
            extentSparkReporter.config().setTheme(Theme.DARK);
            extentSparkReporter.config().setEncoding("utf-8");

            extent = new ExtentReports();
            extent.attachReporter(extentSparkReporter);
        }
        return extent;
    }
}