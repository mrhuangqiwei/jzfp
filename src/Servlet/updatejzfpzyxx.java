package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.Dao;

/**
 * Servlet implementation class updatejzfpzyxx
 * 更新精准扶贫住院病人信息
 */
@WebServlet("/updatejzfpzyxx")
public class updatejzfpzyxx extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatejzfpzyxx() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setHeader("Access-Control-Allow-Origin", "*"); 
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");//服务器编码
		response.setHeader("content-type", "text/html;charset=UTF-8");//浏览器编码
		String zyh= new String(request.getParameter("zyh").getBytes("ISO-8859-1"),"UTF-8");
		String sql="update zyb_rydj set jzfpbz ='1' , pkhbz ='1' where  zyh ='"+zyh+"' ";
		boolean ok=false;
		Dao dao =Dao.getInstance();
		ok=dao.update(sql);
		String yy="";
	
		if(ok){
			yy="true";
		}
		else{
			yy="false";
		}
		response.getOutputStream().write(yy.getBytes("UTF-8"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
