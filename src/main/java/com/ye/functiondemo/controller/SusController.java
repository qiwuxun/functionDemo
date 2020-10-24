package com.ye.functiondemo.controller;


import com.ye.functiondemo.model.EasyUIPage;
import com.ye.functiondemo.model.TbXwKyxsRy;
import com.ye.functiondemo.service.SusService;
import com.ye.functiondemo.until.UUID_Rdom;
/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
 Logger logger = LoggerFactory.getLogger(SusController.class);
 logger.error("error");
  return modelAndView;
 }
 //查询
 @RequestMapping("/queryList")
 @ResponseBody
 public Map<String,Object>  getTbXwKyxsRyList(@RequestParam(value = "kyxsry_Zjhm",defaultValue = "")
        String kyxsry_Zjhm,@RequestParam(value = "kyxsry_Kyyj",defaultValue = "") String kyxsry_Kyyj,
         @RequestParam(value = "page",defaultValue = "0") int page,@RequestParam(value = "rows",
        defaultValue = "0")int rows ){
  Logger logger = LoggerFactory.getLogger(SusController.class);
  logger.error("error");
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

@RequestMapping("/add_Sus")
 public String add_Sus(){
 return  "add_Sus";
 }
/*
*
*
*
* */
public TbXwKyxsRy craateXxzjbh(TbXwKyxsRy tbXwKyxsRy){
 String xxzjbh= "";
 while(true){
  xxzjbh= UUID_Rdom.getUUID_30();
  TbXwKyxsRy tbXwKyxsRy1=  susService.qrySusById(xxzjbh);
  if (tbXwKyxsRy1==null){
   break;
  }

 }
 tbXwKyxsRy.setXxzjbh(xxzjbh);
 return tbXwKyxsRy;
}
//添加
 @RequestMapping("/addSus")
@ResponseBody
 public  Map<String,Object> addTbXwKyxsRy(TbXwKyxsRy tbXwKyxsRy,
         @RequestParam(value = "kyxsry_Kyyj") String kyxsry_Kyyj){
  Map<String, Object> map =new HashMap<>();
  tbXwKyxsRy.setKyxsry_kyyj(kyxsry_Kyyj);

  //Logger logger=new Lo
  Logger logger = LoggerFactory.getLogger(SusController.class);
  logger.error("error");
  System.out.println("++++++++++kyxsry_Kyyj:"+tbXwKyxsRy.getKyxsry_kyyj());
  System.out.println("kyxsry_Kyyj:    "+kyxsry_Kyyj);
/*debug：调试，对应的方法 debug()
info：信息（正常运行），对应的方法 info()
warn：警告，对应的方法warn()
error：错误，对应的方法error()*/

 tbXwKyxsRy.setXxsc_Pdbz("0");
  if (tbXwKyxsRy.getXxzjbh()==null||tbXwKyxsRy.getXxzjbh().equals("")){
    tbXwKyxsRy = craateXxzjbh(tbXwKyxsRy);
  }
  System.out.println("++++++++++++++++++++++++++++");
  System.out.println(tbXwKyxsRy);
      int  b= susService.insertSus(tbXwKyxsRy);
         if (b>0){
          System.out.println(b);
          map.put("Msg","添加成功");
         }else{
          map.put("Msg","");
         }
   //  map=null;
     return map;
 }

@RequestMapping("/quy_xxzjbh")
@ResponseBody
 public Map<String,Object>   qryByTbXwKyxsRy(@RequestParam(value = "xxzjbh") String xxzjbh){
 Map<String, Object> map = new HashMap<>();
 TbXwKyxsRy tbXwKyxsRy = susService.qrySusById(xxzjbh);
 map.put("tbXwKyxsRy",tbXwKyxsRy);

 return map;
}

@RequestMapping("/update_Sus")
 public String update_Sus(@RequestParam(value = "xxzjbh") String xxzjbh, Model model){
 Map<String, Object> map = new HashMap<>();
 TbXwKyxsRy tbXwKyxsRy = susService.qrySusById(xxzjbh);
 map.put("tbXwKyxsRy",tbXwKyxsRy);
  model.addAttribute("xxzjbh",xxzjbh);
  model.addAttribute("tbXw",tbXwKyxsRy);
 return  "update_Sus";
 }
 //修改
@RequestMapping("/up_Sus")
@ResponseBody
public Map<String,Object> updateTbXwKyxsRy(TbXwKyxsRy tbXwKyxsRy,
                @RequestParam(value = "kyxsry_Kyyj") String kyxsry_Kyyj){
 Map<String, Object> map = new HashMap<>();
 System.out.println("gggggggggggggggggggggg");
 System.out.println(tbXwKyxsRy);
 System.out.println(tbXwKyxsRy.getKyxsry_kyyj()+"   =====+++++====");
 //tbXwKyxsRy.setXxzjbh(xxzjbh);
 tbXwKyxsRy.setKyxsry_kyyj(kyxsry_Kyyj);

 int num= susService.updateTbXwKyxsRy(tbXwKyxsRy);
 if (num>0){
  map.put("Msg","修改成功");
 }else{
  map.put("Msg","修改失败");
 }
 return map;
}
//删除
@RequestMapping("/del_Sus")
@ResponseBody
public Map<String,Object> delTbXwKyxsRy(@RequestParam(value = "xxzjbh") String xxzjbh){
 Map<String, Object> map = new HashMap<>();
 int num= susService.delTbXwKyxs(xxzjbh);
if (num>0){
 map.put("Msg","删除成功！");
}else {
 map.put("Msg","删除失败！");
}


 return map;
}
}
