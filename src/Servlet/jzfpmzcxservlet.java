package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.stringtree.json.JSONValidatingWriter;

import sql.JDBC;
import sql.jzyfzyxxcx;

/** 精准扶贫门诊信息查询servlet
 * Servlet implementation class jzfpmzcxservlet
 */
@WebServlet("/jzfpmzcxservlet")
public class jzfpmzcxservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public jzfpmzcxservlet() {
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
		String kssj= new String(request.getParameter("kssj").getBytes("ISO-8859-1"),"UTF-8");
		String jssj= new String(request.getParameter("jssj").getBytes("ISO-8859-1"),"UTF-8");
		String json=getjzfpmzxx(kssj, jssj);
		response.getOutputStream().write(json.getBytes("UTF-8"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
private  String getjzfpmzxx(String kssj,String jssj){
		Connection conn = JDBC.getConnection();	
		String sql=" SELECT   Rtrim(ghb_jsjl.jsjlid)jsjlid,   Rtrim(ghb_jsjl.ghxh)ghxh,   Rtrim(ghb_jsjl.jscs)jscs, Rtrim( isnull(ghb_jsjl.jkpzh,''))jkpzh,  rtrim(ghb_jsjl.czybm)czybm, Rtrim(gyb_czy.czyxm)czyxm,rtrim(ghb_jsjl.ywckbm)ywckbm,   rtrim(ghb_jsjl.brid)brid,   ghb_jsjl.fyhj,    ghb_jsjl.ylkzf,  ghb_jsjl.xjzf,ghb_jsjl.ybkzf, ghb_jsjl.tbje,   ghb_jsjl.jsqf,  ghb_jsjl.qfbj, Rtrim(isnull(ghb_jsjl.fphm,''))fphm,  ghb_jsjl.jszt,  CONVERT(varchar(100),ghb_jsjl.jsrq, 25)ryrq, ghb_jsjl.czyks,    ghb_jsjl.bzms, rtrim(isnull(ghb_jsjl.bxlbbm,''))bxlbbm,   rtrim(isnull(ghb_jsjl.bxjsbh,''))bxjsbh,rtrim(ghb_zcxx.brxm)brxm,ghb_zcxx.brxb,ghb_brgh.brnl,Rtrim(isnull(ghb_zcxx.sfzh,''))sfzh,isnull(ghb_brgh.jzfpbz,'')jzfpbz,Rtrim(isnull(ghb_zcxx.pydm,''))pydm FROM v_ghb_jsjl ghb_jsjl with(nolock) INNER JOIN ghb_brgh on ghb_jsjl.ghxh = ghb_brgh.ghxh INNER JOIN ghb_zcxx on ghb_brgh.brid = ghb_zcxx.brid left join gyb_czy on  ghb_jsjl.czybm=gyb_czy.czybm WHERE ( ghb_jsjl.jszt = '0' ) AND"
				+ " ( ghb_jsjl.jsrq >= '"+kssj+"' ) AND ( ghb_jsjl.jsrq < '"+jssj+"' )   ";
		String json="";
		try {
			json=new JSONValidatingWriter().write(
				        new QueryRunner().query(conn, sql, new MapListHandler()));
			//conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	
	
}
