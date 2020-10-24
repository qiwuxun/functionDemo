package com.ye.functiondemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

 @RequestMapping("/hello")
 public String hello(){
  return "hello";
 }
 @RequestMapping("/test")
 public String test(){
  return "test";
 }




}




