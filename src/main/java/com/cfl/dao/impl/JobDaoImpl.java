package com.cfl.dao.impl;

import com.cfl.dao.JobDao;
import com.cfl.pojo.Company;
import com.cfl.pojo.Job;
import com.cfl.util.JobThread;
import com.cfl.util.Resouce;
import com.cfl.util.ResourceMapUtil;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JobDaoImpl implements JobDao {
    @Override
    public List<Job> findFullTextByKey(String key) throws InterruptedException {


        System.out.println("jobdao");

        List<Job> list = new ArrayList<>();

        final int  SIZE = 6 ;

        JobThread [] jobThreads = new JobThread[SIZE];

        for (int i = 0 ; i<jobThreads.length;i++){
            jobThreads[i] = new JobThread();
            jobThreads[i].setFlag((i+1));
            jobThreads[i].setKeyWords(new StringBuffer(key));
        }

        Thread [] threads = new Thread[SIZE];

        for (int i = 0 ; i<threads.length;i++){
            threads[i] = new Thread(jobThreads[i]);
            threads[i].start();
        }

        for (int i = 0 ; i<threads.length;i++){
            threads[i].join();
        }



        for (int i = 0 ; i<threads.length;i++){
            list.addAll(jobThreads[i].getList());
        }

        return list;
    }

    @Override
    public List<Job> findCampusByKey(String key) throws InterruptedException {

        List<Job> list = new ArrayList<>();

        final int  SIZE = 6 ;

        JobThread [] jobThreads = new JobThread[SIZE];

        for (int i = 0 ; i<jobThreads.length;i++){
            jobThreads[i].setFlag(i);
            jobThreads[i].setKeyWords(new StringBuffer(key));
        }

        Thread [] threads = new Thread[SIZE];

        for (int i = 0 ; i<threads.length;i++){
             threads[i] = new Thread(jobThreads[i]);
             threads[i].start();
             threads[i].join();
        }


        for (int i = 0 ; i<threads.length;i++){
            list.addAll(jobThreads[i].getList());
        }

        return list;
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
