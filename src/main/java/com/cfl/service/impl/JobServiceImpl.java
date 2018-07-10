package com.cfl.service.impl;

import com.cfl.dao.JobDao;
import com.cfl.pojo.Company;
import com.cfl.pojo.Job;
import com.cfl.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    JobDao jobDao;

    @Override
    public List<Job> findFullTextByKey(String key) throws InterruptedException {

        List<Job> list = jobDao.findFullTextByKey(key);

        return list;
    }

    @Override
    public List<Job> findCampusByKey(String key) {
        return null;
    }

    @Override
    public List<Job> findApplyOnLineByKey(String key) {
        return null;
    }

    @Override
    public List<Job> findImportantApplyOnLineByKey(String key) {
        return null;
    }

    @Override
    public int followCompany(String key) {
        return 0;
    }

    @Override
    public int unfollowCompany(int userId, Company company) {
        return 0;
    }

    @Override
    public int collectJob(Job job, int id) {
        return 0;
    }

    @Override
    public int uncollectJob(int jobId) {
        return 0;
    }
}
