package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.stringtree.json.JSONValidatingWriter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import Bean.jzfpzyhzjbxxBean;
import Bean.zyhzzflxBean;
/**
 * 获取住院贫困户信息
 * @author Administrator
 *
 */
public class getpkhzzyxx {
	public  String getpkhzyxx(String kssj,String jssj){
		List<String> list=new ArrayList<String>();
		list=getzyhzjbxx(kssj, jssj);
		System.out.print(list);
	  List<jzfpzyhzjbxxBean>iBeans=new ArrayList<jzfpzyhzjbxxBean>();
	  for(int i=0;i<list.size();i=i+17){
		  String fyhj=getzyhzfyhj(list.get(i));
		  List<zyhzzflxBean> zyhzzflxBeans=new ArrayList<zyhzzflxBean>();
		  List<String> zflxlist=new ArrayList<String>();
		  zflxlist=getzyhzzflx(list.get(i));
		  for(int j=0;j<zflxlist.size();j=j+6){
			  zyhzzflxBean zBean=new zyhzzflxBean(zflxlist.get(j), zflxlist.get(j+1), zflxlist.get(j+2),
					  zflxlist.get(j+3), zflxlist.get(j+4), zflxlist.get(j+5));
			  zyhzzflxBeans.add(zBean);
		  }
	jzfpzyhzjbxxBean jBean=new   jzfpzyhzjbxxBean(list.get(i), list.get(i+1), list.get(i+2),list.get(i+3),list.get(i+4), list.get(i+5),
      list.get(i+6), list.get(i+7), list.get(i+8),list.get(i+9), list.get(i+10), list.get(i+11), list.get(i+12), list.get(i+13), list.get(i+14), list.get(i+15),list.get(i+16), fyhj, zyhzzflxBeans);
		  iBeans.add(jBean);
	  }
	  String json=JSON.toJSONString(iBeans,SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);
		 return json;
		
	}
	
	
	/**
	 * 获取精准扶贫住院患者基本信息
	 * @param kssj
	 * @param jssj
	 * @return
	 */
	public  List<String> getzyhzjbxx(String kssj,String jssj){	
		List<String> list=new ArrayList<String>();
		Connection conn = JDBC.getConnection();	
		Statement stmt;
		String sql=" SELECT  rtrim(zyb_rydj.zyh)zyh,  rtrim(zyb_zcxx.brxm)brxm,   rtrim(zyb_zcxx.brxb)brxb,   rtrim(zyb_rydj.brnl)brnl,rtrim(zyb_rydj.brnldw)brnldw, rtrim(zyb_rydj.ryks)ryks,  RTRIM( ksmc)ksmc,  rtrim(zyb_rydj.ybkh)ybkh, rtrim(zyb_rydj.zyzt)zyzt,rtrim(zyb_zcxx.pydm)pydm,CONVERT(varchar(100),zyb_rydj.ryrq, 25)ryrq,CONVERT(varchar(100),zyb_rydj.cyrq, 25)ryrq,rtrim(zyb_zcxx.sfzh)sfzh,rtrim(zyb_rydj.jzfpbz)jzfpbz,rtrim(bagl_basy_zdxx.ryzdbm)ryzdbm  ,rtrim(bagl_basy_zdxx.ryzdmc)ryzdmc  ,rtrim(bagl_basy_zdxx.cyzyzdbm)cyzyzdbm,rtrim(bagl_basy_zdxx.cyzyzdmc)cyzyzdmc FROM zyb_rydj,     zyb_zcxx,	bagl_basy_zdxx ,gyb_ks WHERE ( zyb_rydj.brid = zyb_zcxx.brid ) and  (bagl_basy_zdxx.zyh = zyb_rydj.zyh) and (zyb_rydj.ryks=gyb_ks.ksbm)and( zyb_rydj.zyzt = '1' )"
				+ " AND( zyb_rydj.cyrq >= '"+kssj+"' ) AND ( zyb_rydj.cyrq < '"+jssj+"' ) and zyb_rydj.ifzf = '0' and zyb_rydj.jzfpbz = '1'  ";
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			//ѭ�����ÿһ����¼
			while(rs.next())
			{list.add(rs.getString("zyh"));
			list.add(rs.getString("brxm"));
			list.add(rs.getString("brxb"));
			list.add(rs.getString("brnl"));
			list.add(rs.getString("brnldw"));
			list.add(rs.getString("ryks"));
			list.add(rs.getString("ksmc"));
			list.add(rs.getString("ybkh"));
			list.add(rs.getString("zyzt"));
			list.add(rs.getString("pydm"));
			list.add(rs.getString("ryrq"));
			list.add(rs.getString("sfzh"));
			list.add(rs.getString("jzfpbz"));
			list.add(rs.getString("ryzdbm"));
			list.add(rs.getString("ryzdmc"));
			list.add(rs.getString("cyzyzdbm"));
			list.add(rs.getString("cyzyzdmc"));
		}
			stmt.close();								// �ر�����״̬����
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
			
		}
	/**
	 * 获取贫困患者费用信息
	 * @param zyh
	 * @return
	 */
	public String getzyhzfyhj(String zyh){	
		List<String> list=new ArrayList<String>();
		Connection conn = JDBC.getConnection();	
		Statement stmt;
		String sql="select sum ( fyje )as fyhj  from zyb_brfy where yxbz ='1' and zyh ='"+zyh+"' ";
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			//ѭ�����ÿһ����¼
			while(rs.next())
			{list.add(rs.getString("fyhj"));
			
		}
			stmt.close();								// �ر�����״̬����
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list.get(0);
			
		}
	
	/**
	 * 获取患者支付类型及费用
	 * @param zyh
	 * @return
	 */
	public  List<String> getzyhzzflx(String zyh){	
		List<String> list=new ArrayList<String>();
		Connection conn = JDBC.getConnection();	
		Statement stmt;
		String sql=" select rtrim(zyh)zyh,RTRIM(jzfp_jk_ylfy.ylfybm)ylfybm,rtrim(jzfp_ylfy.ylfymc)ylfymc,rtrim(jzfp_jk_ylfy.zflxbm)zflxbm,rtrim(zflxmc)zflxmc,zfje from jzfp_jk_ylfy inner join  zyb_jsjl_qtzf on jzfp_jk_ylfy.zflxbm = zyb_jsjl_qtzf.zflx left join jzfp_ylfy on jzfp_jk_ylfy.ylfybm=jzfp_ylfy.ylfybm left join gyb_zflx on jzfp_jk_ylfy.zflxbm=gyb_zflx.zflxbm where "
				+ "zyh = '"+zyh+"' ";
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			//ѭ�����ÿһ����¼
			while(rs.next())
			{list.add(rs.getString("zyh"));
			list.add(rs.getString("ylfybm"));
			list.add(rs.getString("ylfymc"));
			list.add(rs.getString("zflxbm"));
			list.add(rs.getString("zflxmc"));
			list.add(rs.getString("zfje"));
		}
			stmt.close();								// �ر�����״̬����
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
			
		}	
	
	
}
