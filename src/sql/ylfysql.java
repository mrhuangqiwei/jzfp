package sql;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import Bean.ylfyListBean;
import Bean.ylfydmBean;
import Bean.ylfyxmBean;
import Bean.zflxBean;

public class ylfysql {
/**
 * 获取医疗费用信息
 * @return
 */
public String getylfyxx(){
	List<String> mzflxlist=new ArrayList<String>();
	List<String> mylfylist=new ArrayList<String>();
	List<String> mylfydmlist=new ArrayList<String>();
	mzflxlist=staticsql.getzflx();
	mylfylist=staticsql.getylfybm();
	mylfydmlist=staticsql.getjzfpylfy();
	List<zflxBean>zflxBeans=new ArrayList<zflxBean>();
	for(int k=0;k<mzflxlist.size();k=k+2){
		zflxBean zBean=new zflxBean(mzflxlist.get(k), mzflxlist.get(k+1));
		zflxBeans.add(zBean);
	}
	List<ylfyxmBean> ylfyxmBeans=new ArrayList<ylfyxmBean>();
	for(int i=0;i<mylfylist.size();i=i+2){
		ylfyxmBean yBean=new ylfyxmBean(mylfylist.get(i), mylfylist.get(i+1));
		ylfyxmBeans.add(yBean);
	}
	List<ylfydmBean>ylfydmBeans=new ArrayList<ylfydmBean>();
	for(int j=0;j<mylfydmlist.size();j=j+5){
		ylfydmBean ylfydmBean=new ylfydmBean(mylfydmlist.get(j),mylfydmlist.get(j+1),mylfydmlist.get(j+2), mylfydmlist.get(j+3), mylfydmlist.get(j+4));
	    ylfydmBeans.add(ylfydmBean);
	}
	ylfyListBean yListBean=new ylfyListBean(ylfydmBeans, ylfyxmBeans, zflxBeans);
	 String json=JSON.toJSONString(yListBean,SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);
	 return json;
	
	}
	
	
}
