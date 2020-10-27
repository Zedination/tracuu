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
        model.addAttribute("title","TRA CỨU KẾT QUẢ NHẬP HỌC HỆ ĐẠI HỌC CHÍNH QUY NĂM "+today.getYear());
        return "index";
    }
}
