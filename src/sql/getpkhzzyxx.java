package sql;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.stringtree.json.JSONValidatingWriter;
/**
 * 获取住院贫困户信息
 * @author Administrator
 *
 */
public class getpkhzzyxx {
	public  String getpkhzyxx(String kssj,String jssj){
		Connection conn = JDBC.getConnection();	
		String sql=" SELECT  rtrim(zyb_rydj.zyh)zyh,  rtrim(zyb_zcxx.brxm)brxm,   rtrim(zyb_zcxx.brxb)brxb,   rtrim(zyb_rydj.brnl)brnl,rtrim(zyb_rydj.brnldw)brnldw, rtrim(zyb_rydj.ryks)ryks,  RTRIM( ksmc)ksmc,  rtrim(zyb_rydj.ybkh)ybkh, rtrim(zyb_rydj.zyzt)zyzt,rtrim(zyb_zcxx.pydm)pydm,CONVERT(varchar(100),zyb_rydj.ryrq, 25)ryrq,CONVERT(varchar(100),zyb_rydj.cyrq, 25)ryrq,rtrim(zyb_zcxx.sfzh)sfzh,rtrim(zyb_rydj.jzfpbz)jzfpbz,rtrim(bagl_basy_zdxx.ryzdbm)ryzdbm  ,rtrim(bagl_basy_zdxx.ryzdmc)ryzdmc  ,rtrim(bagl_basy_zdxx.cyzyzdbm)cyzyzdbm,rtrim(bagl_basy_zdxx.cyzyzdmc)cyzyzdmc FROM zyb_rydj,     zyb_zcxx,	bagl_basy_zdxx ,gyb_ks WHERE ( zyb_rydj.brid = zyb_zcxx.brid ) and  (bagl_basy_zdxx.zyh = zyb_rydj.zyh) and (zyb_rydj.ryks=gyb_ks.ksbm)and( zyb_rydj.zyzt = '1' )"
				+ " AND( zyb_rydj.cyrq >= '"+kssj+"' ) AND ( zyb_rydj.cyrq < '"+jssj+"' ) and zyb_rydj.ifzf = '0' and zyb_rydj.jzfpbz = '1'  ";
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
