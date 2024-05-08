package com.cfl.util;

import com.cfl.pojo.Job;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JobThread implements Runnable {

    StringBuffer url ;

    int flag ;

    StringBuffer keyWords ;

    StringBuffer cp ;

    int p = 2;

    List<Job> list = new ArrayList<Job>();

    public List<Job> getList() {
        return list;
    }

    public void setList(List<Job> list) {
        this.list = list;
    }

    public StringBuffer getCp() {
        return cp;
    }

    public void setCp(StringBuffer cp) {
        this.cp = cp;
    }

    public StringBuffer getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(StringBuffer keyWords) {
        this.keyWords = keyWords;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public StringBuffer getUrl() {
        return url;
    }

    public void setUrl(StringBuffer url) {
        this.url = url;
    }

    public void run() {
        if(Resouce._51JOB.getIndex()==flag){
//            _51job();
        }else if(Resouce.ZHILIAN.getIndex()==flag){
            //_zhilian();
        }else if(Resouce.DAJIE.getIndex()==flag){
            //_dajiewang();
        }else if(Resouce.HIATOU.getIndex()==flag){
            haitou();
        }else if(Resouce.LAGOU.getIndex()==flag){
           /// lagou();
        }else  if(Resouce.SHIXIZENG.getIndex()==flag){
//shixiseng();
        }
    }

    public void _51job(){

        for(int j = 1 ; j <= p; j++) {

            url = new StringBuffer("https://search.51job.com/list/000000,000000,0107,00,9,99,").append(keyWords).append(new StringBuffer(",2,")).append(new StringBuffer(j+"")).append(".html");

            System.out.println();
            System.out.println(Resouce._51JOB.getName()+"  " + j);
            System.out.println(url);

            Document doc = null;
            try {
                doc = Jsoup.connect(String.valueOf(url))
                        .timeout(5000).ignoreContentType(true)
                        .get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //JAVA 工程师   |   https://jobs.51job.com/wuxi/92793797.html?s=01&t=0   |   无锡漫途科技有限公司   |   无锡   |   8-10万/年   |   07-09   |   ------来源于前程无忧
            Elements t1s = doc.getElementsByClass("jname"); //职位名
            Elements t2s = doc.getElementsByClass("t2"); //公司名
            Elements t3s = doc.getElementsByClass("t3"); //工作地点
            Elements t4s = doc.getElementsByClass("t4"); //薪资
            Elements t5s = doc.getElementsByClass("t5"); //发布时间
            for (int i = 1; i < t1s.size(); i++) {
                String jobName = t1s.get(i).text();
                String jobHref = t1s.get(i).select("a").attr("href");
                String companyName = t2s.get(i).text();
                String pubCity = t3s.get(i).text();
                String salary = t4s.get(i).text();
                String date = t5s.get(i).text();
                String resource = "前程无忧";
                Job job = new Job(jobName,jobHref,salary,companyName,pubCity,"2018-"+date,resource);
                list.add(job);

            }
        }
    }

    public void getToken(){

        /*
         *       注意cookies过期
         * */

        for (int j = 1 ; j< p; j++){


            url = new StringBuffer("https://oauth.51job.com/ajax/get_token.php?fromdomain=51job_web");
            Document doc = null;

            try {
                doc = Jsoup.connect(String.valueOf(url))
                        .header("Property","%7B%22partner%22%3A%22%22%2C%22webId%22%3A2%2C%22fromdomain%22%3A%2251job_web%22%2C%22frompageUrl%22%3A%22https%3A%2F%2Fwe.51job.com%2F%22%2C%22pageUrl%22%3A%22https%3A%2F%2Fwe.51job.com%2Fpc%2Fsearch%3Ffunction%3D0107%26keyword%3Djava%26searchType%3D2%26sortType%3D0%26metro%3D%22%2C%22identityType%22%3A%22%22%2C%22userType%22%3A%22%22%2C%22isLogin%22%3A%22%E5%90%A6%22%2C%22accountid%22%3A%22%22%2C%22keywordType%22%3A%22%22%7D")
                        .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36")
                        .header("Cookie","guid=d238c8475cc65ee642b89d41a447cd30; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22d238c8475cc65ee642b89d41a447cd30%22%2C%22first_id%22%3A%2218ed93e37c14d0-044563f11c4dd18-26001a51-1327104-18ed93e37c21197%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThlZDkzZTM3YzE0ZDAtMDQ0NTYzZjExYzRkZDE4LTI2MDAxYTUxLTEzMjcxMDQtMThlZDkzZTM3YzIxMTk3IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiZDIzOGM4NDc1Y2M2NWVlNjQyYjg5ZDQxYTQ0N2NkMzAifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22d238c8475cc65ee642b89d41a447cd30%22%7D%2C%22%24device_id%22%3A%2218ed93e37c14d0-044563f11c4dd18-26001a51-1327104-18ed93e37c21197%22%7D; nsearch=jobarea%3D%26%7C%26ord_field%3D%26%7C%26recentSearch0%3D%26%7C%26recentSearch1%3D%26%7C%26recentSearch2%3D%26%7C%26recentSearch3%3D%26%7C%26recentSearch4%3D%26%7C%26collapse_expansion%3D; acw_tc=ac11000117130768948306691e7c507636fb63628fa7508a2e117efd7a3a2f; acw_sc__v2=661b7a9f7bf00ff9b76c97dda20ad30b82f51347; search=jobarea%7E%60%7C%21recentSearch0%7E%60000000%A1%FB%A1%FA000000%A1%FB%A1%FA0107%A1%FB%A1%FA00%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA9%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA0%A1%FB%A1%FAjava%A1%FB%A1%FA2%A1%FB%A1%FA1%7C%21recentSearch1%7E%60000000%A1%FB%A1%FA000000%A1%FB%A1%FA0000%A1%FB%A1%FA00%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA9%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA0%A1%FB%A1%FAjava%A1%FB%A1%FA2%A1%FB%A1%FA1%7C%21; ssxmod_itna2=YqIxcQG=EpeCq0dD=G7+cHpDGgE=jR+QQBD8MCShDGNGCRDF2hTz0BwDDv93OkNSxApoXIYkAx4YLB7D2ioolwBmeT6rlibPRS6MaRI=z025=OT8=iIxONiTDtkcsLw6HM5nrRVad7oFNu2vz01yzRW2O9QHNtzv=Veymy=nN9DApon4ID1OkVjg+RDBi6o8Pz+nCK0fQua2Dz+PbL=m6nZOkv99wz/TXxsupVCCwp+L0Iblzt5822h88eac1R4jjYcqOdUKsqBAN9Q02LRBynn4saCUN5y98EvHdMlP1EkYgU15sCMozlP2lGHiGtEejQeICEoCNW1NLQ5WZKo9PG6imGEYK09G36BEx05Qa2if03WbWE23nmuG3NRRP63Q1Rsl3QEr2Gi2QmZcumQYNZitILmWXPtKwpmyCfsi6EgnrrQm4EUi5ki=br6f/oDgrO1IotvtZKmRAFQ2ynEoFNNfFnUWOFv+jY8g97xy+9wR+ptE0ZEixc4=37=RvBA2bRFjPy1C4DQ9OD08DiQtYD==; tfstk=fA9qOEqdUxHVI5OGza6NTYFOOLWA693I_d_1jhxGcZb0hmdzEGTflcKikFJNrhvfoZiAQ1YMoF5tDN_G7FtMG0MIdnKABOYZRvMBhjzvKK7g5OXqHkDqR2MIF3AzKPuB1rz6paSOrijcjZmrEGSVIiVcm07lbMFgoFXi43bRfPVgiSDlZGj3SbIvmh2PAs0jWHI1wu0dHwxcontXEbfzMnby6BpP037HmW2gILSVgdT_ZkrGGCxd9KtZQ8BXYQXlbdn3_N5esK6kn4Dhw1vkrgYjf5Iy_hvdHsETBeW276vcal2OnOAAUgvnfWQWUZTM3_mQL16kd6XDNb3f1tSeSKL4bRYHVH9AwduUrNdfvTjwBDVN71jrFPIulUJ9gPVNigIPR0ouMZEgmV42O3FT6_")
                        .header("Uuid","d238c8475cc65ee642b89d41a447cd30")
                        .header("Accept","application/json, text/plain, */*")
                        .timeout(5000).ignoreContentType(true)
                        .get();
            } catch (IOException e) {
                e.printStackTrace();
            }



            String s = String.valueOf (doc.body().text());

            JSONObject  jsonObject = JSONObject.fromObject(s);

            JSONObject data = JSONObject.fromObject(jsonObject.getString("data"));

            JSONArray list1 = JSONArray.fromObject(data.getString("list"));

            //Java   |   https://job.dajie.com/fe277788-3b7f-450e-83d7-caa94b957582.html?jobsearch=0&pagereferer=blank&keyword=java&clicktype=job   |   15K-30K/月   |   上海傲梦网络科技有限公司   |   上海   |   --------来源于大街网
            for(int i = 0 ; i <list1.size(); i++){
                JSONObject object = list1.getJSONObject(i);
                String jobName = object.getString("jobName") ;
                String jobHref = object.getString("jobHref") ;
                String salary = object.getString("salary") ;
                String compName = object.getString("compName") ;
                String pubCity = object.getString("pubCity");
                String resource = "大街网";
                Job job = new Job(jobName,jobHref,salary,compName,pubCity,DateFormatUtil.DateToString(new Date()),resource);
                list.add(job);
            }
        }
    }

    public void _51job2(){
        getToken();
        for(int j = 1 ; j <= p; j++) {

            url = new StringBuffer("\n" +
                    "https://we.51job.com/api/job/search-pc?api_key=51job&timestamp=1713077453&keyword=java&searchType=2&function=0107&industry=&jobArea=000000&jobArea2=&landmark=&metro=&salary=&workYear=&degree=&companyType=&companySize=&jobType=&issueDate=&sortType=0&pageNum=1&requestId=&pageSize=20&source=1&accountId=&pageCode=sou%7Csou%7Csoulb");

            System.out.println();
            System.out.println(Resouce._51JOB.getName()+"  " + j);
            System.out.println(url);

            Document doc = null;
            try {
                doc = Jsoup.connect(String.valueOf(url))
                        .header("Property","%7B%22partner%22%3A%22%22%2C%22webId%22%3A2%2C%22fromdomain%22%3A%2251job_web%22%2C%22frompageUrl%22%3A%22https%3A%2F%2Fwe.51job.com%2F%22%2C%22pageUrl%22%3A%22https%3A%2F%2Fwe.51job.com%2Fpc%2Fsearch%3Ffunction%3D0107%26keyword%3Djava%26searchType%3D2%26sortType%3D0%26metro%3D%22%2C%22identityType%22%3A%22%22%2C%22userType%22%3A%22%22%2C%22isLogin%22%3A%22%E5%90%A6%22%2C%22accountid%22%3A%22%22%2C%22keywordType%22%3A%22%22%7D")
                        .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36")
                        .header("Cookie","guid=d238c8475cc65ee642b89d41a447cd30; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22d238c8475cc65ee642b89d41a447cd30%22%2C%22first_id%22%3A%2218ed93e37c14d0-044563f11c4dd18-26001a51-1327104-18ed93e37c21197%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThlZDkzZTM3YzE0ZDAtMDQ0NTYzZjExYzRkZDE4LTI2MDAxYTUxLTEzMjcxMDQtMThlZDkzZTM3YzIxMTk3IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiZDIzOGM4NDc1Y2M2NWVlNjQyYjg5ZDQxYTQ0N2NkMzAifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22d238c8475cc65ee642b89d41a447cd30%22%7D%2C%22%24device_id%22%3A%2218ed93e37c14d0-044563f11c4dd18-26001a51-1327104-18ed93e37c21197%22%7D; nsearch=jobarea%3D%26%7C%26ord_field%3D%26%7C%26recentSearch0%3D%26%7C%26recentSearch1%3D%26%7C%26recentSearch2%3D%26%7C%26recentSearch3%3D%26%7C%26recentSearch4%3D%26%7C%26collapse_expansion%3D; acw_tc=ac11000117130768935926083e7c50088c85dcd16513cc255e41fe2c431f67; acw_sc__v2=661b7a9f7bf00ff9b76c97dda20ad30b82f51347; search=jobarea%7E%60%7C%21recentSearch0%7E%60000000%A1%FB%A1%FA000000%A1%FB%A1%FA0107%A1%FB%A1%FA00%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA9%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA0%A1%FB%A1%FAjava%A1%FB%A1%FA2%A1%FB%A1%FA1%7C%21recentSearch1%7E%60000000%A1%FB%A1%FA000000%A1%FB%A1%FA0000%A1%FB%A1%FA00%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA9%A1%FB%A1%FA99%A1%FB%A1%FA%A1%FB%A1%FA0%A1%FB%A1%FAjava%A1%FB%A1%FA2%A1%FB%A1%FA1%7C%21; JSESSIONID=73E760E29C673D94CD2F8536C556AC91; ssxmod_itna=eu0=Y5DKiIZKDtDXDnQmIx7IWEixfrkox0KQ=QD/KDpDnqD=GFDK40oEO3AeoRPGbDEG3hEKCGeLhoWrEWoa5eEREXPbDCPGnDB9YoTDen=D5xGoDPxDeDADYoXDAqiOD7qDdjpkVUkDm4GW7qGfDDoDY+=uDitD4qDB+hdDKqGg7LetzdxD0dhiTiqctDDhYQrU8jU3vTweoG=DjMbD/4ekTG6YX=ye9dr7oiiaQqGytKGuULt/lfbDCg6/0T0sAipPAi4jIDeFnY+qA7nbBI+P3DmPnAef3A4qnBh=xgDQStVeDDfxRR5qiDD=; ssxmod_itna2=eu0=Y5DKiIZKDtDXDnQmIx7IWEixfrkox0KQ=G9bE35DBkOAe7pq=SFBPlhqSPXKjGKh+MbWe5YhWtFQhiCiG3eWr+5e/kTU7e5BWM4vqUFYKy49z2xBD8GKm407rxjKD2bYD===; tfstk=faoZOE68YhKamZg0TWZ4zHK9lxETYudWumNbnxD0C5VGfd3Fx-G_1KHD6jo4txm_s59T0rcmsjzvBSN0gjMm5ptWVAHTDoc2N3t7IfRcKcPcGoqwXTxwNQtWAv0FqsRSl15j2WyYtR2gn5vU--eumR40opP338QcsjqDLvVLH-jGmGxhxRe7njA")
                        .header("User-Token:","")
                        .header("Uuid","d238c8475cc65ee642b89d41a447cd30")
                        .header("Accept","application/json, text/plain, */*")
                        .timeout(5000).ignoreContentType(true)
                        .get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //JAVA 工程师   |   https://jobs.51job.com/wuxi/92793797.html?s=01&t=0   |   无锡漫途科技有限公司   |   无锡   |   8-10万/年   |   07-09   |   ------来源于前程无忧
            Elements t1s = doc.getElementsByClass("jname"); //职位名
            Elements t2s = doc.getElementsByClass("t2"); //公司名
            Elements t3s = doc.getElementsByClass("t3"); //工作地点
            Elements t4s = doc.getElementsByClass("t4"); //薪资
            Elements t5s = doc.getElementsByClass("t5"); //发布时间
            for (int i = 1; i < t1s.size(); i++) {
                String jobName = t1s.get(i).text();
                String jobHref = t1s.get(i).select("a").attr("href");
                String companyName = t2s.get(i).text();
                String pubCity = t3s.get(i).text();
                String salary = t4s.get(i).text();
                String date = t5s.get(i).text();
                String resource = "前程无忧";
                Job job = new Job(jobName,jobHref,salary,companyName,pubCity,"2018-"+date,resource);
                list.add(job);

            }
        }
    }

    public void _zhilian(){
        //System.out.println("\n第"+cp+"页 :\n");

        for(int j = 1 ; j <= p; j++) {

            url = new StringBuffer("https://sou.zhaopin.com/jobs/searchresult.ashx?kw=").append(keyWords).append(new StringBuffer("&p=")).append(new StringBuffer(j+""));

            System.out.println();
            System.out.println(Resouce.ZHILIAN.getName()+"  " + j);
            System.out.println(url);

            Document doc = null;

            try {
                doc = Jsoup.connect(String.valueOf(url))
                        .timeout(5000).ignoreContentType(true)
                        .get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //  System.out.println(doc);




            //
            //高级JAVA工程师（OA方向）   |   http://jobs.zhaopin.com/479050586250037.htm   |   武汉瑞英腾创科技有限公司   |   7000-13000   |   武汉   |   最新   |   ------来源于智联招聘
            Elements gsmc = doc.getElementsByClass("gsmc"); //公司名称
            Elements zwyx = doc.getElementsByClass("zwyx"); //职位月薪
            Elements gzdd = doc.getElementsByClass("gzdd"); //工作地点
            Elements gzsj = doc.getElementsByClass("gxsj"); //时间

            Elements _zwmc = doc.getElementsByClass("zwmc");

            Elements zwmc = new Elements(); //职位名称

            for (int i = 1; i < _zwmc.size(); i++) {
                Elements _div = _zwmc.get(i).getElementsByTag("div");
                zwmc.add(_div.get(0));
            }


            for (int i = 1; i < zwmc.size(); i++) {
                if ((zwmc.get(i).text().indexOf("java") != -1) || (zwmc.get(i).text().indexOf("Java") != -1) || (zwmc.get(i).text().indexOf("JAVA") != -1)) {
                    String jobName = zwmc.get(i).text();
                    String jobHref = zwmc.get(i).select("a").attr("href");
                    String companyName = gsmc.get(i).text() ;
                    String pubCity = gzdd.get(i).text();
                    String salary = zwyx.get(i).text();
                    String date = gzsj.get(i).text();
                    String resource = "智联招聘";
                    Job job = new Job(jobName,jobHref,salary,companyName,pubCity,DateFormatUtil.DateToString(new Date()),resource);
                    list.add(job);
                    //list.add(zwmc.get(i).text() + "   |   " + zwmc.get(i).select("a").attr("href") + "   |   " + gsmc.get(i).text() + "   |   " + zwyx.get(i).text() + "   |   " + gzdd.get(i).text() + "   |   " + gzsj.get(i).text() + "   |   " + "------来源于智联招聘");
                //     System.out.println(zwmc.get(i).text()+"  "+zwmc.get(i).select("a").attr("href")+"   "+gsmc.get(i).text()+"  "+zwyx.get(i).text()+"  "+gzdd.get(i).text()+"  "+gzsj.get(i).text()+"  "+"------来源于智联招聘");
                } else {
                    continue;
                }
            }
        }
    }

    public void _dajiewang(){

           /*
            *       注意cookies过期
            * */

            for (int j = 1 ; j< p; j++){


            url = new StringBuffer("https://so.dajie.com/job/ajax/search/filter?keyword=").append(keyWords).append(new StringBuffer("&page=")).append(new StringBuffer(j+""));

             System.out.println();
             System.out.println(Resouce.DAJIE.getName()+"  " + j);
             System.out.println(url);



            Document doc = null;

            try {
                doc = Jsoup.connect(String.valueOf(url))
                        .header("Accept","application/json, text/javascript, */*; q=0.01")//去掉中文乱码
                        .header("Accept-Encoding","gzip, deflate, br")
                        .header("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                       .header("Connection","keep-alive")
                        .header("Cookie","DJ_UVID=MTUyOTgzMDY3MDkxNTE1NTMw; Hm_lvt_6822a51ffa95d58bbe562e877f743b4f=1529830668,1529834183,1529935427,1531105298; _ga=GA1.2.786760888.1529830986; DJ_RF=empty; DJ_EU=http%3A%2F%2Fso.dajie.com%2Fjob%2Fsearch%3Fkeyword%3Djava; SO_COOKIE_V2=2bfaeJWKZDk2jJdrguYsYNpSfVenq4CM80pJvCdrCpFpf2uQWu3BQyI8VUd0bGTEoZfKOdNWPTd2zs14IxFkKrURED7d0B590uoR; dj_cap=559397ce221b7554dc4e983b511cc7f4; Hm_lpvt_6822a51ffa95d58bbe562e877f743b4f=1531105298; _close_autoreg=1531105299731")//去掉发生403错误HTTP error fetching URL
                        .header("Host","so.dajie.com")
                        .header("Referer","https://so.dajie.com/job/search?keyword=java")//去掉发生403错误HTTP error fetching URL
                        .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
                        .timeout(5000).ignoreContentType(true)
                        .get();
            } catch (IOException e) {
                e.printStackTrace();
            }



            String s = String.valueOf (doc.body().text());

            JSONObject  jsonObject = JSONObject.fromObject(s);

            JSONObject data = JSONObject.fromObject(jsonObject.getString("data"));

            JSONArray list1 = JSONArray.fromObject(data.getString("list"));

            //Java   |   https://job.dajie.com/fe277788-3b7f-450e-83d7-caa94b957582.html?jobsearch=0&pagereferer=blank&keyword=java&clicktype=job   |   15K-30K/月   |   上海傲梦网络科技有限公司   |   上海   |   --------来源于大街网
            for(int i = 0 ; i <list1.size(); i++){
                JSONObject object = list1.getJSONObject(i);
                String jobName = object.getString("jobName") ;
                String jobHref = object.getString("jobHref") ;
                String salary = object.getString("salary") ;
                String compName = object.getString("compName") ;
                String pubCity = object.getString("pubCity");
                String resource = "大街网";
                Job job = new Job(jobName,jobHref,salary,compName,pubCity,DateFormatUtil.DateToString(new Date()),resource);
                list.add(job);
             }
            }
    }

    public  void haitou(){
        //System.out.println("\n第"+cp+"页 :\n");

        for(int j = 1 ; j <= p; j++) {

            url = new StringBuffer("https://xyzp.haitou.cc/search-").append(keyWords).append(new StringBuffer("/page-")).append(new StringBuffer(j+""));

            System.out.println();
            System.out.println(Resouce.HIATOU.getName()+"  " + j);
            System.out.println(url);

            Document doc = null;

            try {
                doc = Jsoup.connect(String.valueOf(url))
                        .header("Cookie","mediav=%7B%22eid%22%3A%221089574%22%2C%22ep%22%3A%22%22%2C%22vid%22%3A%226PMO%3DdiEeP%3DiRjBhZkD8%22%2C%22ctn%22%3A%22%22%2C%22vvid%22%3A%226PMO%3DdiEeP%3DiRjBhZkD8%22%2C%22_mvnf%22%3A1%2C%22_mvctn%22%3A0%2C%22_mvck%22%3A1%2C%22_refnf%22%3A0%7D; ONL_Udid=b174d53dbc287b37e2f5a9d5b480f916; ONL_C=5e705226acd7a97aa6ee95ab188632d61713079691e97eb89ebce39557651df28cb7e40973; ONL_F=91f1eb329c3ce9d5857ee0da3e618cfe; haitou_session=tpipbi7oj06p3prpd2rak6e2im; Haitou-Unique=pc9ef6caad71d3aecd3e4015975e0fda78; showSelectZone=gz; haitou_zone=gz; _csrf=DVFrdrYFlSqxcsWLaTb0zXs2HMQJh3rR; Hm_lvt_2010a27ca18ae12b96df00b3e73dd033=1713079697; Hm_lpvt_2010a27ca18ae12b96df00b3e73dd033=1713079697; _bl_uid=belseu3zzFX7dCf3O6Fn9n8qkseq; Qs_lvt_393344=1713079697; Qs_pv_393344=369371885978219650")
                        .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36")
                        .timeout(5000).ignoreContentType(true)
                        .get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Java开发工程师  C++开发工程师(图形方向)  C++开发工程师(算法方向)  C++开发工程师  开发工程师(大数据方向)  开发工程师(前端方向)  自动化测试工程师  测试工程师  测试工程师(建筑类专业)  交互设计师  人力资源    |   https://xyzp.haitou.cc//article/1272851.html   |   广联达     |   北京  上海  深圳  西安  香港    |   2018-04-10   |   ------来源于海投网
            Elements _cxxt_title = doc.getElementsByClass("cxxt-title");//包裹着公司名称，和连接的td

            Elements companyName = new Elements();

            for (int i = 0; i < _cxxt_title.size(); i++) {
                Elements _a = _cxxt_title.get(i).getElementsByTag("a");
                Elements _div = _a.get(0).getElementsByTag("div");
                companyName.add(_div.get(0));
            }


            Element table = doc.getElementsByClass("cxxt-table").get(0);

            Elements _city = table.getElementsByClass("text-ellipsis");//工作城市

            Elements city = new Elements();//工作城市

            for (int i = 0 ; i<_city.size();i++){
                if(i%2!=0){
                    city.add(_city.get(i));
                }
            }

            Elements position = doc.getElementsByClass("cxxt-position");//工作城市

            Elements time = doc.getElementsByClass("cxxt-time");

            for (int i = 0; i < companyName.size(); i++) {
                if ((position.get(i).text().indexOf("java") != -1) || (position.get(i).text().indexOf("Java") != -1) || (position.get(i).text().indexOf("JAVA") != -1)) {
                    String jobName = position.get(i).text() ;
                    String jobHref = "https://xyzp.haitou.cc"+_cxxt_title.get(i).select("a").attr("href") ;
                    String salary =  "未知";
                    String compName = companyName.get(i).text();
                    String pubCity = city.get(i).text();
                    String date = time.get(i).text();
                    String resource = "大街网";
                    Job job = new Job(jobName,jobHref,salary,compName,pubCity,date,resource);
                    list.add(job);
                    //list.add(position.get(i).text()+"   |   "+"https://xyzp.haitou.cc/"+_cxxt_title.get(i).select("a").attr("href")+"   |   "+ companyName.get(i).text()+"  "+"   |   "+city.get(i).text()+"   |   "+time.get(i).text()+"   |   "+"------来源于海投网");
                    // System.out.println((i+1)+"   |   "+ companyName.get(i).text()+"  "+"https://xyzp.haitou.cc/"+_cxxt_title.get(i).select("a").attr("href")+"   |   "+position.get(i).text()+"   |   "+city.get(i).text()+"   |   "+time.get(i).text()+"   |   "+"------来源于海投网");
                } else {
                    continue;
                }
            }
        }
    }

    public  void lagou(){

        /*
         *       注意cookies过期
         * */

        for (int j = 1 ; j< p; j++){


            url = new StringBuffer("https://www.lagou.com/jobs/positionAjax.json?needAddtionalResult=false");

            System.out.println();
            System.out.println(Resouce.LAGOU.getName()+"  " + j);
            System.out.println(url);

            Document doc = null;

            try {
                doc = Jsoup.connect(String.valueOf(url))
                        .data("first","false")
                        .data("kd",String.valueOf(keyWords))
                        .data("pn",String.valueOf(p))
                        .header("Accept","application/json, text/javascript, */*; q=0.01")//去掉中文乱码
                        .header("Accept-Encoding","gzip, deflate, br")
                        .header("Accept-Language","zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2")
                        .header("Connection","keep-alive")
                        .header("Cookie","user_trace_token=20180524223448-2769d25c-7569-4bb3-86cd-f3360392677c; Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1529937256,1530701008; _ga=GA1.2.120881748.1527172487; LGUID=20180524223451-9dee45d5-5f5f-11e8-8ace-5254005c3644; LG_LOGIN_USER_ID=2c395cf9becd6e85f6c5a14001f334e07fcb4fa98c47986ba7e8562d891a7e11; JSESSIONID=ABAAABAAAIAACBIF099F4FCEDC609218CB068834E0A4744; _gat=1; Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1530701333; LGSID=20180704184355-262c2b52-7f77-11e8-98e3-5254005c3644; PRE_UTM=; PRE_HOST=; PRE_SITE=; PRE_LAND=https%3A%2F%2Fwww.lagou.com%2F; LGRID=20180704184921-e860e509-7f77-11e8-be30-525400f775ce; _gid=GA1.2.2047585565.1530701010; index_location_city=%E5%85%A8%E5%9B%BD; TG-TRACK-CODE=search_code; SEARCH_ID=3cf5dbc48a37407ea2314048c6ffdb7d")//去掉发生403错误HTTP error fetching URL
                        .header("Host","www.lagou.com")
                        .header("Referer","https://www.lagou.com/jobs/list_")//去掉发生403错误HTTP error fetching URL
                        .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64; rv:60.0) Gecko/20100101 Firefox/60.0")
                        .timeout(5000).ignoreContentType(true)
                        .get();
            } catch (IOException e) {
                e.printStackTrace();
            }

           // System.out.println(doc.body());

            //java   |   https:https://www.lagou.com/jobs/4496828.html   |   20k-35k   |   有鱼金融科技   |   上海   |   2018-07-09 10:10:39   |   --------来源于拉钩网
            String s = String.valueOf (doc.body().text());

            JSONObject  jsonObject = JSONObject.fromObject(s);

            JSONObject content = JSONObject.fromObject(jsonObject.getString("content"));

            JSONObject positionResult = JSONObject.fromObject(content.getString("positionResult"));

            JSONArray result = JSONArray.fromObject(positionResult.getString("result"));


            for(int i = 0 ; i <result.size(); i++){
                JSONObject object = result.getJSONObject(i);
                String jobName = object.getString("positionName") ;
                String jobId = object.getString("positionId");
                String jobHref = "https://www.lagou.com/jobs/"+jobId+".html" ;
                String salary = object.getString("salary") ;
                String compName = object.getString("companyShortName") ;
                String pubCity = object.getString("city");
                String time = object.getString("createTime");

                String resource = "大街网";
                Job job = new Job(jobName,jobHref,salary,compName,pubCity,time.substring(0,10),resource);
                list.add(job);

               // this.list.add(jobName +"   |   "+ "https:"+jobHref +"   |   "+salary  +"   |   "+compName  +"   |   "+pubCity +"   |   "+time +"   |   "+"--------来源于拉钩网");

            }


        }
    }

    public  void shixiseng(){/*
        //System.out.println("\n第"+cp+"页 :\n");

        for(int j = 1 ; j <= p; j++) {

            url = new StringBuffer("https://www.shixiseng.com/interns/st-intern_?k=").append(keyWords).append(new StringBuffer("&p=")).append(new StringBuffer(j+""));

            System.out.println();
            System.out.println(Resouce.LAGOUgetName()+"  " + j);
            System.out.println(url);

            Document doc = null;

            try {
                doc = Jsoup.connect(String.valueOf(url))
                        .timeout(5000).ignoreContentType(true)
                        .get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //System.out.println(doc.body());

            Elements name = doc.getElementsByClass("name");//职位名称

            Elements company = doc.getElementsByClass("company");//职位名称

            Elements time = doc.getElementsByClass("release-time");//发布时间

            Elements area = doc.getElementsByClass("area");//工作地点

            Elements more = doc.getElementsByClass("area");//0 薪酬  1 每周工作时间  2 实习时间

            Elements salary = new Elements();

            for (Element m : more) {
                salary.add(m);
            }


            for (int i = 0; i < company.size(); i++) {
                if ((name.get(i).text().indexOf("java") != -1) || (name.get(i).text().indexOf("Java") != -1) || (name.get(i).text().indexOf("JAVA") != -1)) {
                    list.add(name.get(i).text()+"   |   "+"https://xyzp.haitou.cc/"+name.get(i).select("a").attr("href")+"   |   "+ company.get(i).text()+"  "+"   |   "+area.get(i).text()+"   |   "+time.get(i).text()+"   |   "+"------来源于海投网");
                    // System.out.println((i+1)+"   |   "+ companyName.get(i).text()+"  "+"https://xyzp.haitou.cc/"+_cxxt_title.get(i).select("a").attr("href")+"   |   "+position.get(i).text()+"   |   "+city.get(i).text()+"   |   "+time.get(i).text()+"   |   "+"------来源于海投网");
                } else {
                    continue;
                }
            }
        }*/
    }
}
