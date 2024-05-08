package com.cfl.pojo;

public class Job {
    private String id;

    private String jobName;

    private String jobHref;

    private String salary;

    private String companyName;

    private String pubCity;

    private String date;

    private String resouse;

    public Job() {
    }

    public Job(String jobName, String jobHref, String salary, String companyName, String pubCity, String date, String resouse) {
        this.jobName = jobName;
        this.jobHref = jobHref;
        this.salary = salary;
        this.companyName = companyName;
        this.pubCity = pubCity;
        this.date = date;
        this.resouse = resouse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    public String getJobHref() {
        return jobHref;
    }

    public void setJobHref(String jobHref) {
        this.jobHref = jobHref == null ? null : jobHref.trim();
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary == null ? null : salary.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getPubCity() {
        return pubCity;
    }

    public void setPubCity(String pubCity) {
        this.pubCity = pubCity == null ? null : pubCity.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getResouse() {
        return resouse;
    }

    public void setResouse(String resouse) {
        this.resouse = resouse == null ? null : resouse.trim();
    }
}