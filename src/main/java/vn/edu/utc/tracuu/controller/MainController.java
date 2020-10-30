package vn.edu.utc.tracuu.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.utc.tracuu.cachevariable.StaticData;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class MainController {

    @GetMapping(path = {"/","/index"})
    public String getIndex(Model model){
        LocalDate today = LocalDate.now();
        model.addAttribute("title","Tra cứu kết quả phân loại tiếng anh sinh viên hệ đại học chính quy khóa 61 năm "+today.getYear());
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("title","Đăng nhập");
        return "login";
    }

    @PostMapping("/login")
    public String loginProcess(@RequestParam("username") String username, @RequestParam("password") String password
    , HttpServletRequest request, Model model){
        String encodedPass = DigestUtils
                .md5Hex(password);
        System.out.println(encodedPass);
        if(username.equals(StaticData.USERNAME)&&encodedPass.equals(StaticData.ENCRYPTED_PASSWORD)){
            request.getSession().setAttribute("name","Nguyễn Việt Hưng");
            return "redirect:/admin/index";
        }else{
            model.addAttribute("error","Sai tên đăng nhập hoặc mật khẩu!");
            return "login";
        }
    }
}
