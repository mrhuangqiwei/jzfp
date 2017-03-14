package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sql.Dao;
import Bean.inserjzfpJmfyBean;
import Bean.insertbzfyBean;
import Bean.updatebzfyBean;
import Bean.updatejzfpjmfyBean;

import com.alibaba.fastjson.JSON;

/**
 * 补助费用对码更新
 * Servlet implementation class bzfyupdateservlet
 */
@WebServlet("/bzfyupdateservlet")
public class bzfyupdateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bzfyupdateservlet() {
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
		String cs= new String(request.getParameter("cs").getBytes("ISO-8859-1"),"UTF-8");
		String json= new String(request.getParameter("json").getBytes("ISO-8859-1"),"UTF-8");
		boolean ok=false;;
		String yy="";
		if(cs.trim().equals("0")){
			ok=doinsertjson(json);
		}
		else {
			ok=doupdatejson(json);
		}
		
		
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
		List<updatebzfyBean> lBeans=JSON.parseArray(json,updatebzfyBean.class);
		String sql="";
		for(int k=0;k<lBeans.size();k++){
			String sqlString="update jzfp_jk_bzfy set zflxbm='"+lBeans.get(k).getZflxbm()+"',bzfybm='"+lBeans.get(k).getBzfybm()+"' where id='"+lBeans.get(k).getId()+"'";
			sql=sql+sqlString+"\t";
		}
		Dao dao =Dao.getInstance();
		// TODO Auto-generated method stub
		ok=dao.update(sql);
		return ok;
	}

	private boolean doinsertjson(String json) {
		boolean ok=false;
		List<insertbzfyBean> lBeans=JSON.parseArray(json,insertbzfyBean.class);
		String sql="";
		for(int k=0;k<lBeans.size();k++){
			String sqlString="insert into jzfp_jk_bzfy (zflxbm,bzfybm) values('"+lBeans.get(k).getZflxbm()+"','"+lBeans.get(k).getBzfybm()+"')";
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
