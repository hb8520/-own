package cn.bdqn.servlect;

import cn.bdqn.entity.Rainquality;
import cn.bdqn.service.RainqualityService;
import cn.bdqn.service.impl.RainqualityServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/rainqs")
public class RainqualityServlet extends HttpServlet {
    private RainqualityService rainqualityService=new RainqualityServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String opr=request.getParameter("opr");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out =  response.getWriter();//输出流对象
        if ("getPageList".equals(opr)){//查询所有数据
            List<Rainquality> list = rainqualityService.findRainquality();
            String JSONstring=JSON.toJSONString(list);
            out.print(JSONstring);
        }else if ("add".equals(opr)){//新增数据
            //获取表单中的数据
            String districtName=request.getParameter("districtName");
            String monitorTime=request.getParameter("monitorTime");
            String rain=request.getParameter("rain");
            String monitoringStation=request.getParameter("monitoringStation");
            String monitoringAddress=request.getParameter("monitoringAddress");
            Rainquality rql=new Rainquality(districtName,monitorTime,Integer.parseInt(rain),monitoringStation,monitoringAddress);
            boolean result = rainqualityService.add(rql);
            String JSONstring=JSON.toJSONString(result);
            out.print(JSONstring);
        }else if ("del".equals(opr)){//删除数据
            String id=request.getParameter("del_id");
            boolean result = rainqualityService.removen(Integer.parseInt(id));
            String JSONstring=JSON.toJSONString(result);
            out.print(JSONstring);
        }else if ("updateById".equals(opr)){//根据id获取数据信息
            String id=request.getParameter("update_id");
            Rainquality rain = rainqualityService.getById(Integer.parseInt(id));
            String JSONstring=JSON.toJSONString(rain);
            out.print(JSONstring);
        }else if ("update".equals(opr)){//修改数据
            //获取表单中的数据
            String id=request.getParameter("id");
            String districtName=request.getParameter("districtName");
            String monitorTime=request.getParameter("monitorTime");
            String rain=request.getParameter("rain");
            String monitoringStation=request.getParameter("monitoringStation");
            String monitoringAddress=request.getParameter("monitoringAddress");
            Rainquality rql=new Rainquality(Integer.parseInt(id),districtName,monitorTime,Integer.parseInt(rain),monitoringStation,monitoringAddress);
            boolean result = rainqualityService.getUpdate(rql);
            String JSONstring=JSON.toJSONString(result);
            out.print(JSONstring);
        }
    }
}
