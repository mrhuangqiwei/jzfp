package sql;

import java.util.ArrayList;
import java.util.List;

import Bean.bzfybmBean;
import Bean.bzfycxBean;
import Bean.bzfylistBean;
import Bean.jmfycxBean;
import Bean.jmfylistBean;
import Bean.bzfybmBean;
import Bean.mxfybmBean;
import Bean.zflxBean;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 补助费用查询
 * @author Administrator
 *
 */
public class bzfycxsql {
/**
 * 获取补助费用信息
 * @return
 */
	public String getbzfyxx(){
		List<String> mbzfycxlist=new ArrayList<String>();
		List<String> mybzylist=new ArrayList<String>();
		List<String> mzflxlist=new ArrayList<String>();
		mbzfycxlist=staticsql.getjzfpbzfy();
		mybzylist=staticsql.getjzfpbzfybm();
		mzflxlist=staticsql.getzflx();
		List<bzfycxBean> bzfycxBeans=new ArrayList<bzfycxBean>();
		for(int k=0;k<mbzfycxlist.size();k=k+5){
			bzfycxBean bzfycxBean=new bzfycxBean(mbzfycxlist.get(k),mbzfycxlist.get(k+1), mbzfycxlist.get(k+2),mbzfycxlist.get(k+3),mbzfycxlist.get(k+4));
		bzfycxBeans.add(bzfycxBean);	}
		List<bzfybmBean> bzfybmBeans=new ArrayList<bzfybmBean>();
		for(int i=0;i< mybzylist.size();i=i+2){
			bzfybmBean bzfybmBean=new bzfybmBean(mybzylist.get(i),mybzylist.get(i+1));
			bzfybmBeans.add(bzfybmBean);
		}
		
		List<zflxBean> zflxBeans=new ArrayList<zflxBean>();
		for (int j=0;j<mzflxlist.size();j=j+2){
			zflxBean mxfybmBean=new zflxBean(mzflxlist.get(j), mzflxlist.get(j+1));
			zflxBeans.add(mxfybmBean);
		}
		bzfylistBean bBean=new bzfylistBean(bzfycxBeans, bzfybmBeans, zflxBeans);
		 String json=JSON.toJSONString(bBean,SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);
		 return json;
	}
	
}
