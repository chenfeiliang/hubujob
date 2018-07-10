package com.cfl.controller;

import com.cfl.controller.dto.UserDTO;
import com.cfl.pojo.Company;
import com.cfl.pojo.Job;
import com.cfl.pojo.Msg;
import com.cfl.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    JobService jobService;



    public Msg login(String userName ,String passWord){
        return new Msg();
    }

    public Msg register(UserDTO userDTO){
        return new Msg();
    }

    @ResponseBody
    @RequestMapping("/findFullTextByKey")
    public Msg findFullTextByKey(String key) throws InterruptedException {

        List<Job> list = new ArrayList<>();

        list = jobService.findFullTextByKey(key);

        //System.out.println(list.size());

        return new Msg().success().add("list",list);
    }

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    public Msg findCampusByKey(String key) throws InterruptedException {

        List<Job> list = new ArrayList<>();

        list = jobService.findFullTextByKey(key);

        return new Msg().success().add("list",list);


    }

    public Msg  findApplyOnLineByKey(String key){
        return new Msg();
    }

    public Msg findImportantApplyOnLineByKey(String key){
        return new Msg();
    }

    public Msg followCompany(String key){
        return new Msg();
    }

    public Msg unfollowCompany(int userId, Company company){
        return new Msg();
    }

    public Msg collectJob(Job job , int id){
        return new Msg();
    }

    public Msg  uncollectJob(int jobId){
        return new Msg();
    }
}
