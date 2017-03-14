package sql;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.stringtree.json.JSONValidatingWriter;

/**
 * 精准扶贫住院信息查询
 * @author Administrator
 *
 */
public class jzyfzyxxcx {
	public String getjzfpzyxx(String kssj,String jssj){
		Connection conn = JDBC.getConnection();	
		String sql="  SELECT rtrim(zyb_rydj.zyh)zyh,Rtrim(zyb_zcxx.brxm)brxm, Rtrim(zyb_zcxx.brxb)brxb,Rtrim(zyb_rydj.brnl)brnl,  rtrim(zyb_rydj.brnldw)brnldw,  rtrim(zyb_rydj.ryks)ryks,  rtrim(gyb_ks.ksmc)yksmc,rtrim(isnull(zyb_rydj.ybkh,''))ybkh, rtrim(zyb_rydj.zyzt)zyzt, rtrim(isnull(zyb_zcxx.pydm,''))pydm,CONVERT(varchar(100),zyb_rydj.ryrq, 25)ryrq,CONVERT(varchar(100),zyb_rydj.cyrq, 25)cyrq,rtrim(isnull(zyb_zcxx.sfzh,''))sfzh,isnull(zyb_rydj.jzfpbz,'') jzfpbz FROM zyb_rydj,    zyb_zcxx,gyb_ks WHERE ( zyb_rydj.brid = zyb_zcxx.brid ) and (zyb_rydj.ryks=gyb_ks.ksbm)and ( zyb_rydj.zyzt = '1' ) AND"
				+ "( zyb_rydj.cyrq >= '"+kssj+"' ) AND ( zyb_rydj.cyrq < '"+jssj+"' ) and zyb_rydj.ifzf = '"+0+"' ";
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
