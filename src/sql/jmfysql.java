package sql;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import Bean.jmfycxBean;
import Bean.jmfylistBean;
import Bean.jmfyxmbmBean;
import Bean.mxfybmBean;
import Bean.ylfyListBean;

public class jmfysql {
	/**
	 * 获取减免费用项目信息
	 * @return
	 */
public  String getjmfyxm(){
	List<String> mjmfycxlist=new ArrayList<String>();
	List<String> myjmfylist=new ArrayList<String>();
	List<String> mfyxlbmlist=new ArrayList<String>();
	mjmfycxlist=staticsql.getjzfpjmfy();
	 myjmfylist=staticsql.getjzfpjmfybm();
	mfyxlbmlist=staticsql.getfymxbm();
	List<jmfycxBean> jmfycxBeans=new ArrayList<jmfycxBean>();
	for(int k=0;k<mjmfycxlist.size();k=k+5){
		jmfycxBean jmfycxBean=new jmfycxBean(mjmfycxlist.get(k),mjmfycxlist.get(k+1), mjmfycxlist.get(k+2),mjmfycxlist.get(k+3),mjmfycxlist.get(k+4));
	jmfycxBeans.add(jmfycxBean)
;	}
	
	List<jmfyxmbmBean> jmfyxmbmBeans=new ArrayList<jmfyxmbmBean>();
	for(int i=0;i< myjmfylist.size();i=i+2){
		jmfyxmbmBean jmfyxmbmBean=new jmfyxmbmBean( myjmfylist.get(i), myjmfylist.get(i+1));
		jmfyxmbmBeans.add(jmfyxmbmBean);
	}
	
	List<mxfybmBean> mxfybmBeans=new ArrayList<mxfybmBean>();
	for (int j=0;j<mfyxlbmlist.size();j=j+2){
		mxfybmBean mxfybmBean=new mxfybmBean(mfyxlbmlist.get(j), mfyxlbmlist.get(j+1));
		mxfybmBeans.add(mxfybmBean);
	}
	jmfylistBean jBean=new jmfylistBean(jmfycxBeans, jmfyxmbmBeans, mxfybmBeans);
	 String json=JSON.toJSONString(jBean,SerializerFeature.WriteMapNullValue,SerializerFeature.WriteNullStringAsEmpty);
	 return json;
}
}
