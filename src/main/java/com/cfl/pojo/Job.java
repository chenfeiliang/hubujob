package com.cfl.pojo;

import java.util.Date;

public class Job {

    private String jobName ;

    private String jobHref;

    private String salary;

    private String companyName;

    private String pubCity;

    private String date;

    private String resouse ;

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

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobHref() {
        return jobHref;
    }

    public void setJobHref(String jobHref) {
        this.jobHref = jobHref;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPubCity() {
        return pubCity;
    }

    public void setPubCity(String pubCity) {
        this.pubCity = pubCity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResouse() {
        return resouse;
    }

    public void setResouse(String resouse) {
        this.resouse = resouse;
    }
}
