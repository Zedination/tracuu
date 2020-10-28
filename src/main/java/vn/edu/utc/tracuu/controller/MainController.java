package vn.edu.utc.tracuu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class MainController {

    @GetMapping(path = {"/","/index"})
    public String getIndex(Model model){
        LocalDate today = LocalDate.now();
        model.addAttribute("title","ra cứu kết quả phân loại tiếng anh sinh viên hệ đại học chính quy khóa 61 năm "+today.getYear());
        return "index";
    }
}
