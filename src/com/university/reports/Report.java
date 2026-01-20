package com.university.reports;

/**
 * Abstract base class for all report types.
 * Demonstrates ABSTRACTION and INHERITANCE.
 * 
 * TODO: Create concrete implementations (Transcript, CourseRoster, TeachingLoad, DepartmentSummary).
 */
public abstract class Report {
    protected String reportId;
    protected String reportName;
    protected String generatedDate;

    public Report(String reportId, String reportName, String generatedDate) {
        this.reportId = reportId;
        this.reportName = reportName;
        this.generatedDate = generatedDate;
    }

    /**
     * Generate the report content.
     * Each report type implements this differently (POLYMORPHISM).
     * 
     * @return The generated report as a string
     */
    public abstract String generateReport();

    /**
     * Get the report type (e.g., "TRANSCRIPT", "ROSTER").
     * 
     * @return The report type as a string
     */
    public abstract String getReportType();

    /**
     * Validate if the report can be generated with current data.
     * 
     * @return true if valid, false otherwise
     */
    public abstract boolean validate();

    /**
     * Format the report header.
     * 
     * @return Formatted header string
     */
    protected String formatHeader() {
        return "==========================================\n" +
               reportName + "\n" +
               "Generated: " + generatedDate + "\n" +
               "==========================================\n";
    }

    // Getters
    public String getReportId() {
        return reportId;
    }

    public String getReportName() {
        return reportName;
    }

    public String getGeneratedDate() {
        return generatedDate;
    }
}
