package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.Dao;
import Bean.insertylfyBean;
import Bean.updateylfyBean;

import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class updatejzfpylfyservlet
 */
@WebServlet("/updatejzfpylfyservlet")
public class updatejzfpylfyservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatejzfpylfyservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");//服务器编码
		response.setHeader("content-type", "text/html;charset=UTF-8");//浏览器编码
		String json= new String(request.getParameter("json").getBytes("ISO-8859-1"),"UTF-8");
		boolean ok;
		String yy="";
		ok=doupdatejson(json);
		if(ok){
			yy="true";
		}
		else{
			yy="false";
		}
		response.getOutputStream().write(yy.getBytes("UTF-8"));
	}

	private boolean doupdatejson(String json) {
		boolean ok=false;
		List<updateylfyBean> lBeans=JSON.parseArray(json,updateylfyBean.class);
		String sql="";
		for(int k=0;k<lBeans.size();k++){
			String sqlString="update jzfp_jk_ylfy set zflxbm='"+lBeans.get(k).getZflxbm()+"',ylfybm='"+lBeans.get(k).getYlfybm()+"' where id='"+lBeans.get(k).getId()+"'";
			sql=sql+sqlString+"\t";
		}
		Dao dao =Dao.getInstance();
		// TODO Auto-generated method stub
		ok=dao.update(sql);
		return ok;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
	
		// TODO Auto-generated method stub
	}

}
