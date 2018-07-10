package com.cfl.service;

import com.cfl.pojo.Company;
import com.cfl.pojo.Job;

import java.util.List;

public interface JobService {

    public List<Job> findFullTextByKey(String key) throws InterruptedException;

    public List<Job> findCampusByKey(String key);

    public List<Job> findApplyOnLineByKey(String key);

    public List<Job> findImportantApplyOnLineByKey(String key);

    public int followCompany(String key);

    public int  unfollowCompany(int userId, Company company);

    public int  collectJob(Job job , int id);

    public int  uncollectJob(int jobId);

}
