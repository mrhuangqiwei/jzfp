package sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class staticsql {
   /**
    * 获取支付类型
    * @return
    */
public static List<String> getzflx(){	
List<String> list=new ArrayList<String>();
Connection conn = JDBC.getConnection();	
Statement stmt;
String sql="select Rtrim(zflxbm)zflxbm,Rtrim(zflxmc)zflxmc from gyb_zflx";
try {
	stmt = conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	//ѭ�����ÿһ����¼
	while(rs.next())
	{list.add(rs.getString("zflxbm"));
	list.add(rs.getString("zflxmc"));
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
 * 获取明细费用项目编码 
 * @return
 */
public static List<String> getfymxbm(){	
List<String> list=new ArrayList<String>();
Connection conn = JDBC.getConnection();	
Statement stmt;
String sql="select  Rtrim(mxfyxmbm) as bm ,Rtrim(mxfyxmmc) as mc from gyb_mxfyxm  union all   select  Rtrim(ypbm) as bm ,Rtrim(ypmc) as mc from ykb_ypzd ";
try {
	stmt = conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	//ѭ�����ÿһ����¼
	while(rs.next())
	{list.add(rs.getString("bm"));
	list.add(rs.getString("mc"));
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
 * 获取精准扶贫信息
 * @return
 */
public static List<String> getjzfpylfy(){	
List<String> list=new ArrayList<String>();
Connection conn = JDBC.getConnection();	
Statement stmt;
String sql=" SELECT    Rtrim(jzfp_jk_ylfy.id)id , Rtrim(jzfp_jk_ylfy.zflxbm)zflxbm,Rtrim(zflxmc)zflxmc  ,          Rtrim(isnull(jzfp_jk_ylfy.ylfybm ,''))ylfybm,Rtrim(isnull(jzfp_ylfy.ylfymc,''))ylfyxmmc FROM jzfp_jk_ylfy  left join gyb_zflx on   jzfp_jk_ylfy.zflxbm=gyb_zflx.zflxbm left join jzfp_ylfy on jzfp_jk_ylfy.ylfybm=jzfp_ylfy.ylfybm ";
try {
	stmt = conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	//ѭ�����ÿһ����¼
	while(rs.next())
	{list.add(rs.getString("id"));
	list.add(rs.getString("zflxbm"));
	list.add(rs.getString("zflxmc"));
	list.add(rs.getString("ylfybm"));
	list.add(rs.getString("ylfyxmmc"));
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
 * 获取医疗费用项目编码
 * @return
 */
public static List<String> getylfybm(){	
List<String> list=new ArrayList<String>();
Connection conn = JDBC.getConnection();	
Statement stmt;
String sql="select Rtrim(ylfybm)ylfyxmbm,Rtrim(ylfymc)ylfymc from jzfp_ylfy";
try {
	stmt = conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	//ѭ�����ÿһ����¼
	while(rs.next())
	{list.add(rs.getString("ylfyxmbm"));
	list.add(rs.getString("ylfymc"));
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
 * 获取减免费用
 * @return
 */
public static List<String> getjzfpjmfy(){	
List<String> list=new ArrayList<String>();
Connection conn = JDBC.getConnection();	
Statement stmt;
String sql="select Rtrim(id)id,Rtrim(fyxlbm)fyxlbm,Rtrim(b.mc)mc,Rtrim(isnull(a.jmfybm,''))jmfybm ,Rtrim(isnull(c.jmfymc,''))jmfymc from jzfp_jk_jmfy  a left join view_jzfp_mxfyxm  b on a.fyxlbm=b.bm left join jzfp_jmfy c on a.jmfybm=c.jmfybm ";
try {
	stmt = conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	//ѭ�����ÿһ����¼
	while(rs.next())
	{list.add(rs.getString("id"));
	list.add(rs.getString("fyxlbm"));
	list.add(rs.getString("mc"));
	list.add(rs.getString("jmfybm"));
	list.add(rs.getString("jmfymc"));
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
 * 获取减免费用项目编码和名称
 * @return
 */
public static List<String> getjzfpjmfybm(){	
List<String> list=new ArrayList<String>();
Connection conn = JDBC.getConnection();	
Statement stmt;
String sql="select Rtrim(jmfybm)jmfybm ,RTRIM(jmfymc)jmfymc from jzfp_jmfy";
try {
	stmt = conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	//ѭ�����ÿһ����¼
	while(rs.next())
	{list.add(rs.getString("jmfybm"));
	list.add(rs.getString("jmfymc"));
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
 * 获取精准扶贫补助费用
 * @return
 */
public static List<String> getjzfpbzfy(){	
List<String> list=new ArrayList<String>();
Connection conn = JDBC.getConnection();	
Statement stmt;
String sql=" select Rtrim(id)id,Rtrim(a.zflxbm)zflxbm,Rtrim(b.zflxmc)zflxmc,Rtrim(isnull(a.bzfybm,''))bzfybm,Rtrim(isnull(c.bzfymc,''))bzfymc from jzfp_jk_bzfy a left join gyb_zflx b on a.zflxbm=b.zflxbm left join jzfp_bzfyxm c on a.bzfybm=c.bzfybm";
try {
	stmt = conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	//ѭ�����ÿһ����¼
	while(rs.next())
	{list.add(rs.getString("id"));
	list.add(rs.getString("zflxbm"));
	list.add(rs.getString("zflxmc"));
	list.add(rs.getString("bzfybm"));
	list.add(rs.getString("bzfymc"));
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
 * 获取补助费用编码的编码和名称
 * @return
 */
public static List<String> getjzfpbzfybm(){	
List<String> list=new ArrayList<String>();
Connection conn = JDBC.getConnection();	
Statement stmt;
String sql="select Rtrim(bzfybm)bzfybm,Rtrim(bzfymc)bzfymc from jzfp_bzfyxm";
try {
	stmt = conn.createStatement();
	ResultSet rs=stmt.executeQuery(sql);
	//ѭ�����ÿһ����¼
	while(rs.next())
	{list.add(rs.getString("bzfybm"));
	list.add(rs.getString("bzfymc"));
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
