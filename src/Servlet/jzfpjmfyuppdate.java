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
import Bean.insertylfyBean;
import Bean.updatejzfpjmfyBean;
import Bean.updateylfyBean;

import com.alibaba.fastjson.JSON;

/**精准扶贫减免费用更新
 * Servlet implementation class jzfpjmfyuppdate
 */
@WebServlet("/jzfpjmfyuppdate")
public class jzfpjmfyuppdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jzfpjmfyuppdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*"); 
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
		List<updatejzfpjmfyBean> lBeans=JSON.parseArray(json,updatejzfpjmfyBean.class);
		String sql="";
		for(int k=0;k<lBeans.size();k++){
			String sqlString="update jzfp_jk_jmfy set fyxlbm='"+lBeans.get(k).getFyxlbm()+"',jmfybm='"+lBeans.get(k).getJmfybm()+"' where id='"+lBeans.get(k).getId()+"'";
			sql=sql+sqlString+"\t";
		}
		Dao dao =Dao.getInstance();
		// TODO Auto-generated method stub
		ok=dao.update(sql);
		return ok;
		
	}

	private boolean doinsertjson(String json) {
		boolean ok=false;
		List<inserjzfpJmfyBean> lBeans=JSON.parseArray(json,inserjzfpJmfyBean.class);
		String sql="";
		for(int k=0;k<lBeans.size();k++){
			String sqlString="insert into jzfp_jk_jmfy (fyxlbm,jmfybm)values('"+lBeans.get(k).getFyxlbm()+"','"+lBeans.get(k).getJmfybm()+"')";
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
