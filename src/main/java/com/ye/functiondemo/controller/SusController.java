package com.ye.functiondemo.controller;


import com.ye.functiondemo.model.EasyUIPage;
import com.ye.functiondemo.model.TbXwKyxsRy;
import com.ye.functiondemo.service.SusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SusController {

 @Autowired
 private SusService susService;
/*
 @RequestMapping("/suspicious")
public  String suspicious(){
 // getTbXwKyxsRyList("","",0,0);
 return  "suspicious";
}
*/

@RequestMapping("/suspicious")
 public ModelAndView suspicious(HttpServletRequest request){
  ModelAndView modelAndView = new ModelAndView(request.getContextPath()+"/suspicious");
  return modelAndView;
 }
 @RequestMapping("/queryList")
 @ResponseBody
 public Map<String,Object>  getTbXwKyxsRyList(@RequestParam(value = "kyxsry_Zjhm",defaultValue = "")
        String kyxsry_Zjhm,@RequestParam(value = "kyxsry_Kyyj",defaultValue = "") String kyxsry_Kyyj,
         @RequestParam(value = "page",defaultValue = "0") int page,@RequestParam(value = "rows",
        defaultValue = "0")int rows ){
        Map<String, Object> map = new HashMap<String,Object>();
        Map<String, Object> map1 = new HashMap<String,Object>();
      EasyUIPage easyUIPage = new EasyUIPage();
       easyUIPage.setPage(page);
       easyUIPage.setPagePara(rows);
      int begin = easyUIPage.getBegin();
      int end = easyUIPage.getEnd();
        map1.put("kyxsry_Zjhm",kyxsry_Zjhm);
        map1.put("kyxsry_Kyyj",kyxsry_Kyyj);
        map1.put("begin",begin);
        map1.put("end",end);
      List<TbXwKyxsRy> list1 = susService.getSelMapTbXwList(map1);
        List<TbXwKyxsRy> list= susService.getSelTbXwKyxsRyList();
  for (TbXwKyxsRy tbXwKyxsRy : list) {
   System.out.println(tbXwKyxsRy);
  }
  System.out.println("=================");
  System.out.println("=================");
      for (TbXwKyxsRy tbXwKyxsRy : list1) {
        System.out.println(tbXwKyxsRy);
      }
  int count = susService.qrySusCount(map1);
    //  int count =10;
      map.put("rows",list1);
  map.put("total",count);
    //  map=null;
      return  map;
 }

}
