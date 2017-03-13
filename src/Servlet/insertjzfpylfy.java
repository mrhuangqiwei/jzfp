package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import Bean.insertylfyBean;
import sql.Dao;
import sql.ylfysql;

/**
 * Servlet implementation class insertjzfpylfy
 */
@WebServlet("/insertjzfpylfy")
public class insertjzfpylfy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertjzfpylfy() {
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
		ok=doinsertjson(json);
		if(ok){
			yy="true";
		}
		else{
			yy="false";
		}
		response.getOutputStream().write(yy.getBytes("UTF-8"));
	}

	private boolean doinsertjson(String json) {
		boolean ok=false;
		List<insertylfyBean> lBeans=JSON.parseArray(json,insertylfyBean.class);
		String sql="";
		for(int k=0;k<lBeans.size();k++){
			String sqlString="insert into jzfp_jk_ylfy (zflxbm,ylfybm)values('"+lBeans.get(k).getZflxbm()+"','"+lBeans.get(k).getYlfybm()+"')";
			sql=sql+sqlString+"\t";
		}
	 Dao dao =Dao.getInstance();
	 ok=dao.insert(sql);
	 return ok;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	  
}
