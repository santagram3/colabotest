package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class HeaderTest {
   
   @GetMapping("/header")
   public String openHeader() {
      System.out.println("header test");
      return "/header/header";
   }
   
   @GetMapping("/header2")
   public String openHeader2() {
      System.out.println("header test");
      return "/header/h1";
   }

}