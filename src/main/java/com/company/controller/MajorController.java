package com.company.controller;

import com.company.entity.College;
import com.company.entity.Major;
import com.company.entity.QueryMajor;
import com.company.service.MajorService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.print.attribute.standard.PresentationDirection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("major")
public class MajorController {

    @Autowired
    private MajorService majorService;

    @RequestMapping("list")
    public String findAllMajor(String page, HttpServletRequest request, HttpServletResponse response, QueryMajor queryMajor) {
        //调用
        PageInfo<Major> pageInfo = majorService.findAllMajor(page, queryMajor);
        List<College> allCollege = majorService.findAllCollege();
        //传值
        request.setAttribute("pageInfo", pageInfo);//页面
        request.setAttribute("queryMajor", queryMajor);//封装查询信息的对象
        request.getSession().setAttribute("allCollege", allCollege);//专业所属学院
        //跳转
        return "list";
    }

    @RequestMapping("addMajor")
    public void addMajor(Major major, HttpServletResponse response) throws IOException {
        majorService.addMajor(major);
        response.sendRedirect("/major/list");
    }

    @RequestMapping("deleteMajor")
    public void deleteMajor(Integer id, HttpServletRequest request, HttpServletResponse response, String page) throws IOException, ServletException {
        majorService.deleteMajor(id);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/major/list").forward(request, response);
    }

    @RequestMapping("toUpdate")
    public void toUpdate(Integer id, String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Major updateMajor = majorService.findUpdateMajor(id);
        request.setAttribute("updateMajor", updateMajor);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/updateMajor.jsp?page="+page).forward(request, response);
//        response.sendRedirect("/updateMajor.jsp");
    }

    @RequestMapping("doUpdate")
    public void doUpdate(Major major, String page, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        majorService.updateMajor(major);
//        request.getRequestDispatcher("/major/list").forward(request,response);
        response.sendRedirect("/major/list?page=" + page);
    }
}
