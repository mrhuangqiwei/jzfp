package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.jmfysql;
import sql.jzyfzyxxcx;

/**
 * Servlet implementation class jzfpzyxxcxservlet
 */
@WebServlet("/jzfpzyxxcxservlet")
public class jzfpzyxxcxservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jzfpzyxxcxservlet() {
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
		String kssj= new String(request.getParameter("kssj").getBytes("ISO-8859-1"),"UTF-8");
		String jssj= new String(request.getParameter("jssj").getBytes("ISO-8859-1"),"UTF-8");
		jzyfzyxxcx jz=new jzyfzyxxcx();
		System.out.print(kssj+"\t"+jssj);
		String json=jz.getjzfpzyxx(kssj, jssj);
		response.getOutputStream().write(json.getBytes("UTF-8"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
