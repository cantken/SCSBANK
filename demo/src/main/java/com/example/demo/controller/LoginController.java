package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.FunctionDto;
import com.example.demo.service.LoginService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String account, HttpSession session, Model model) {
        if (loginService.hasLoginPermission(account)) {
            // 將帳號資訊存入 session
            session.setAttribute("account", account);
            return "redirect:/index";
        }
        model.addAttribute("error", "無權限登入");
        return "login";
    }

    @GetMapping("/index")
    public String showIndex(HttpSession session, Model model) {
        // 從 session 取得 empNo
        String empNo = (String) session.getAttribute("account");

        if (empNo == null) {
            return "redirect:/login"; // 尚未登入，導回登入頁
        }

        // 取得員工功能選單
        Map<String, List<FunctionDto>> functions = loginService.getFunctionsByEmployee(empNo);
		System.out.println("function = " + functions);
		List<FunctionDto> allFunctions = functions.values().stream().flatMap(List::stream).collect(Collectors.toList());
//		System.out.println("allFunctions = " + allFunctions);
		Map<String, List<FunctionDto>> functionMap = allFunctions.stream()
		        .collect(Collectors.groupingBy(FunctionDto::getCodeDesc));

		model.addAttribute("functionMap", functionMap);
//        // 將功能群組資料傳遞給前端
//        model.addAttribute("functionMap", allFunctions); // 傳遞群組的 List
//        System.out.println("function = " + functions.values());
        return "index"; // Thymeleaf 模板名稱
    }

}
