package com.houseyoung.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by houseyoung on 15/9/27 14:37.
 */
@Controller
@RequestMapping(value = "")
public class IndexController {
    @RequestMapping(value = {"", "/", "index"}, method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request, Model model) throws Exception{
        try {
            if (request.getSession().getAttribute("admin") != null) {
                //��ʾ���ϽǸ�����Ϣ
                String username = (String) request.getSession().getAttribute("admin");
                model.addAttribute("username", username);

                return "admin/index";
            } else if (request.getSession().getAttribute("instructor") != null) {
                //��ʾ���ϽǸ�����Ϣ
                String username = (String) request.getSession().getAttribute("instructor");
                model.addAttribute("username", username);

                return "admin/index1";
            } else if (request.getSession().getAttribute("studentDto") != null) {
                //��ʾ���ϽǸ�����Ϣ
                String username = (String) request.getSession().getAttribute("studentDto");
                model.addAttribute("username", username);

                return "user/index";
            } else {
                return "index";
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "index";
        }
    }

    //���ʱ��ܾ�ҳ
    @RequestMapping(value = "forbidden")
    public String toForbidden(){
        return "forbidden";
    }
}