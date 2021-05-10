package com.zs.hiki.settings.domain;

public class WorkReoprt {
    private String id;

    private String fromWork;

    private String report;

    private String reporter;

    private String reporterTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFromWork() {
        return fromWork;
    }

    public void setFromWork(String fromWork) {
        this.fromWork = fromWork;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getReporterTime() {
        return reporterTime;
    }

    public void setReporterTime(String reporterTime) {
        this.reporterTime = reporterTime;
    }

    public WorkReoprt() {
    }

    public WorkReoprt(String id, String fromWork, String report, String reporter, String reporterTime) {
        this.id = id;
        this.fromWork = fromWork;
        this.report = report;
        this.reporter = reporter;
        this.reporterTime = reporterTime;
    }

    @Override
    public String toString() {
        return "WorkReoprt{" +
                "id='" + id + '\'' +
                ", fromWork='" + fromWork + '\'' +
                ", report='" + report + '\'' +
                ", reporter='" + reporter + '\'' +
                ", reporterTime='" + reporterTime + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WorkReoprt)) return false;

        WorkReoprt that = (WorkReoprt) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (fromWork != null ? !fromWork.equals(that.fromWork) : that.fromWork != null) return false;
        if (report != null ? !report.equals(that.report) : that.report != null) return false;
        if (reporter != null ? !reporter.equals(that.reporter) : that.reporter != null) return false;
        return reporterTime != null ? reporterTime.equals(that.reporterTime) : that.reporterTime == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fromWork != null ? fromWork.hashCode() : 0);
        result = 31 * result + (report != null ? report.hashCode() : 0);
        result = 31 * result + (reporter != null ? reporter.hashCode() : 0);
        result = 31 * result + (reporterTime != null ? reporterTime.hashCode() : 0);
        return result;
    }
}
