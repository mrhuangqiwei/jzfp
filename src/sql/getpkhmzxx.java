package sql;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.stringtree.json.JSONValidatingWriter;

/**
 * 获取门诊贫苦户信息
 * @author Administrator
 *
 */
public class getpkhmzxx {
	public  String getpkhmzxx(String kssj,String jssj){
		Connection conn = JDBC.getConnection();	
		String sql="SELECT   rtrim(ghb_jsjl.jsjlid)jsjlid,rtrim(ghb_jsjl.ghxh)ghxh, ghb_jsjl.jscs,rtrim(isnull(ghb_jsjl.jkpzh,''))jkpzh,rtrim(ghb_jsjl.czybm)czybm,  rtrim(ghb_jsjl.ywckbm)ywckbm,rtrim(ghb_jsjl.brid)brid,ghb_jsjl.fyhj,ghb_jsjl.ylkzf,ghb_jsjl.xjzf,ghb_jsjl.ybkzf, ghb_jsjl.tbje,ghb_jsjl.jsqf,  ghb_jsjl.qfbj,  rtrim(isnull(ghb_jsjl.fphm,''))fphm,  ghb_jsjl.jszt,CONVERT(varchar(100),ghb_jsjl.jsrq, 25)jsrq, rtrim(ghb_jsjl.czyks)czyks, rtrim(ghb_jsjl.bzms)bzms, rtrim(ghb_jsjl.bxlbbm)bxlbbm,  rtrim(ghb_jsjl.bxjsbh)bxjsbh,rtrim(ghb_zcxx.brxm)brxm,ghb_zcxx.brxb,ghb_brgh.brnl,rtrim(ghb_zcxx.sfzh)sfzh,ghb_brgh.jzfpbz,rtrim(ghb_zcxx.pydm)pydm,rtrim(mzys_mzzd.zdmc)zdmc FROM v_ghb_jsjl ghb_jsjl with(nolock) INNER JOIN ghb_brgh on ghb_jsjl.ghxh = ghb_brgh.ghxh INNER JOIN ghb_zcxx on ghb_brgh.brid = ghb_zcxx.brid LEFT OUTER JOIN mzys_mzzd on ghb_jsjl.ghxh = mzys_mzzd.zdghxh  WHERE ( ghb_jsjl.jszt = '0' ) AND"
				+ " ( ghb_jsjl.jsrq >= '"+kssj+"' ) AND( ghb_jsjl.jsrq < '"+jssj+"' )  AND (ghb_brgh.jzfpbz='1') ";
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
