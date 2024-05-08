function a(){
    $.ajax({
        url: "http://192.168.1.6:8080/hubujob/findFullTextByKey?key=java",
        type:"get",
        dataType:"json",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",//防止乱码
        success:function(data){


            //遍历数据数据
            $.each(data.extend.list,function(index,item){
                var tr1 = $("<tr></tr>").attr("align","center");

                var jobAndCompanyTd = $("<td></td>");
                var rowDiv1= $("<div></div>").attr("class","row");
                var jobNameDiv = $("<div></div>").attr("class","col-md-6 jobName").append($("<a></a>").attr("href",item.jobHref.toString()).append(item.jobName.toString()));
                var companyNameDiv = $("<div></div>").attr("class","col-md-6 company").append(item.companyName.toString());

                rowDiv1.append(jobNameDiv).append(companyNameDiv);
                jobAndCompanyTd.append(rowDiv1);

                var salaryAndpubCityAndTimeTd = $("<td></td>");
                var rowDiv2= $("<div></div>").attr("class","row");
                var salaryDiv = $("<div></div>").attr("class","col-md-4 salary").append(item.salary.toString());
                var pubCityDiv = $("<div></div>").attr("class","col-md-4 pubCity").append(item.pubCity.toString());
                var timeDiv = $("<div></div>").attr("class","col-md-4 time").append(item.date.toString());
                rowDiv2.append(salaryDiv).append(pubCityDiv).append(timeDiv);
                salaryAndpubCityAndTimeTd.append(rowDiv2);

                var collectTd = $("<td></td>");
                var rowDiv3= $("<div></div>").attr("class","row");
                var zhanweiDiv = $("<div></div>").attr("class","col-md-6").append("&nbsp;");
                var collectImgDiv = $("<div></div>").attr("class","col-md-6 collect");

                var collectImg = $("<img src='img/collect.png'/>").attr("class","collectImg");
                collectImgDiv.append(collectImg);
                rowDiv3.append(collectImgDiv);/*.append(zhanweiDiv)*/
                collectTd.append(rowDiv3);

                var resourceTd = $("<td></td>");
                var rowDiv4= $("<div></div>").attr("class","row");
                var zhanweiDiv2 = $("<div></div>").attr("class","col-md-6").append("&nbsp;");
                var resourceImgDiv = $("<div></div>").attr("class","col-md-6 collect");
                var resourceImg = $("<img src='img/qianchengwuyou.png'/>").attr("class","resourceImg");
                resourceImgDiv.append(resourceImg);
                rowDiv4.append(resourceImgDiv);/*.append(zhanweiDiv2)*/
                resourceTd.append(rowDiv4);

                tr1.append(jobAndCompanyTd).append(salaryAndpubCityAndTimeTd).append(collectTd)
                    .append(resourceTd);

                $("#tableBody").append(tr1);

            });
        },
        error:function(XHR,status){
            alert("fail");
        },
    });
}