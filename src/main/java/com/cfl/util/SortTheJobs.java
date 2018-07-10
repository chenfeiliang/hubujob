package com.cfl.util;

import com.cfl.pojo.Job;

import java.util.List;

public class SortTheJobs {
    public static List<Job> sortTheJob( List<Job>  jobs){

        String temp = jobs.get(0).getDate();
        for (int i = 1 ; i<jobs.size();i++) {

            int result = jobs.get(i).getDate().compareTo(temp);

            if(result>0){
                for (int j = i ; j < jobs.size();i++){

                }
            }
        }

        return jobs;
    }
}
