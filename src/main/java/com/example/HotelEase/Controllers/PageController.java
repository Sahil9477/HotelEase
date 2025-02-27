package com.example.HotelEase.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
    
    @GetMapping("")
    public String homePage(Model model) {
        return "index";
    }
    
    @GetMapping("/staffManage")
    public String staffManagePage(Model model) {
        return "staffManage";
    }

    @GetMapping("/roomInquiry")
    public String roomInquiryPage(Model model) {
        return "roomInquiry";
    }
    
    @GetMapping("/bookCancel")
    public String bookCancelPage(Model model) {
        return "bookCancel";
    }

    @GetMapping("/aboutUs")
    public String aboutUsPage(Model model) {
        return "aboutUs";
    }
}
