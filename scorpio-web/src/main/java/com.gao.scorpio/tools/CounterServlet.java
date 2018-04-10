package com.gao.scorpio.tools;

/**
 * Created by 高保红 on 2017/5/2.
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CounterServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //一个web应用程序只有一个上下文对象,该上下文对象可访问所有servlet
//        ServletContext context = getServletContext();
//        synchronized (context) {
//            List<Map<String,String>> list = new ArrayList<>();
        String logId = req.getParameter("logId") == null ? null : req.getParameter("logId");
//            list = (List<Map<String,String>>) context.getAttribute("list");
//            if (list==null){
//                list = new ArrayList<>();
//            }
//            if (list!=null && list.size()>0){
//                for (Map<String, String> map1 : list){
//                    Integer count = 1;
//                    if (logId.equals(map1.get("logId"))){
//                        count = Integer.valueOf(map1.get("count"));
//                        if (null == count) {
//                            count = new Integer(1);
//                        } else {
//                            count = new Integer(count.intValue() + 1);
//                        }
//                        map1.put("count",String.valueOf(count));
//                    }
//                }
//            }
//            Set<String> set = new HashSet<>();
//            for (int i=0;list!=null && i<list.size();i++){
//                set.add(list.get(i).get("logId"));
//            }
//            //若是没有logId就添加 或者不包含此次传进来的id就添加
//            if (!set.contains(logId)){
//                    Map<String,String> map = new HashedMap();
//                    map.put("logId",logId);
//                    map.put("count","1");
//                    list.add(map);
//            }
//            context.setAttribute("list", list);
        resp.sendRedirect("/crainnogao/detail?logId=" + logId);
//        }
    }
}
