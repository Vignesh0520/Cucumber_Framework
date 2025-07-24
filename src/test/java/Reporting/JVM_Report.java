package Reporting;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JVM_Report {

	public static void generateJVMReport(String jsonFilePath, String reportOutputPath) {
		
		System.out.println("Generating JVM report...");
		
		// Ensure the output directory exists
		File jvmReportFile = new File(reportOutputPath);

		// Create configuration for the JVM report
		Configuration configuration = new Configuration(jvmReportFile, "Cucumber Framework Report");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Browser Version", "138.0.7204.158 (Official Build) (64-bit)");
		configuration.addClassifications("Platform", "Windows");
		configuration.addClassifications("Java Version", "java 21.0.6 2025-01-21 LTS");
		configuration.addClassifications("Build Number", "1.0.0");
		configuration.setBuildNumber("1.0.0");
		configuration.addClassifications("Environment", "QA");
		configuration.addClassifications("Sprint", "Sprint 1");
		configuration.addClassifications("Team", "Automation Team");
		configuration.addClassifications("Project", "Cucumber Framework");
		configuration.addClassifications("Report Date", "2025-07-24");
		
		// Create a list of JSON files to include in the report
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFilePath);
		
		// Generate the report using the ReportBuilder
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();

		System.out.println("JVM report generated successfully.");

	}

}
