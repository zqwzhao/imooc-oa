package com.imooc.oa.controller;

import com.imooc.oa.entity.Notice;
import com.imooc.oa.service.NoticeService;
import com.imooc.oa.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author : [zqwzh]
 * @version : [v1.0]
 * @createTime : [2021-10-10 10:18]
 */
@WebServlet("/api/notice/list")
public class NoticeServlet extends HttpServlet {
    private NoticeService noticeService = new NoticeService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eid = request.getParameter("eid");
        ResponseUtils resp = null;
        try {
            List<Notice> noticeList = noticeService.getNoticeList(Long.parseLong(eid));
            resp = new ResponseUtils().put("list",noticeList);
        }catch (Exception e) {
            e.printStackTrace();
            resp = new ResponseUtils(e.getClass().getSimpleName(),e.getMessage());

        }

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().println(resp.toJsonString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
