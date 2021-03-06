package com.imooc.oa.controller;

import com.imooc.oa.entity.LeaveForm;
import com.imooc.oa.service.LeaveFormService;
import com.imooc.oa.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-09-28 21:32]
 */
@WebServlet("/api/leave/*")
public class LeaveFormServlet extends HttpServlet {
    private LeaveFormService leaveFormService= new LeaveFormService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        String methodName = uri.substring(uri.lastIndexOf("/") + 1);
        //http://localhost/api/leave/create
        if (methodName.equals("create")){
            this.create(request,response);
        }else if (methodName.equals("list")){
            this.list(request,response);
        }else if (methodName.equals("audit")) {
            this.audit(request,response);

        }
    }



    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        String employeeId = request.getParameter("eid");
        ResponseUtils respUtils = null;
        try{
            List<Map> formList = leaveFormService.getLeveFormList("process", Long.parseLong(employeeId));
            respUtils = new ResponseUtils().put("list",formList);
        }catch (Exception e) {
            e.printStackTrace();
            respUtils = new ResponseUtils(e.getClass().getSimpleName(),e.getMessage());
        }

        response.getWriter().println(respUtils.toJsonString());


    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        String eid = request.getParameter("eid");
        String formType = request.getParameter("formType");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String reason = request.getParameter("reason");

        LeaveForm leaveForm = new LeaveForm();
        leaveForm.setEmployeeId(Long.parseLong(eid));
        leaveForm.setStartTime(new Date(Long.parseLong(startTime)));
        leaveForm.setEndTime(new Date(Long.parseLong(endTime)));
        leaveForm.setCreateTime(new Date(Long.parseLong(endTime)));
        leaveForm.setReason(reason);
        leaveForm.setFormType(Integer.parseInt(formType));
        ResponseUtils resp = null;
        try{
            leaveFormService.createLeaveForm(leaveForm);
            resp = new ResponseUtils();
        }catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(),e.getMessage());
        }

        response.getWriter().println(resp.toJsonString());
    }

    private void audit(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        String formId = request.getParameter("formId");
        String result = request.getParameter("result");
        String reason = request.getParameter("reason");
        String eid = request.getParameter("eid");
        ResponseUtils resp = null;
        try{
            leaveFormService.audit(Long.parseLong(formId),Long.parseLong(eid),result,reason);
            resp = new ResponseUtils();
        }catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(),e.getMessage());
        }

        response.getWriter().println(resp.toJsonString());
    }
}
