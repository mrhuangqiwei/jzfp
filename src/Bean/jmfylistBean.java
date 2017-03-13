package Bean;

import java.util.List;
/**
 * 获取减免费用项目的对码。
 * @author Administrator
 *
 */
public class jmfylistBean {
List<jmfycxBean>jmfycxBeans;
List<jmfyxmbmBean>jmfyxmbmBeans;
List<mxfybmBean>mxfybmBeans;
public jmfylistBean(List<jmfycxBean> jmfycxBeans,
		List<jmfyxmbmBean> jmfyxmbmBeans, List<mxfybmBean> mxfybmBeans) {
	super();
	this.jmfycxBeans = jmfycxBeans;
	this.jmfyxmbmBeans = jmfyxmbmBeans;
	this.mxfybmBeans = mxfybmBeans;
}
public List<jmfycxBean> getJmfycxBeans() {
	return jmfycxBeans;
}
public void setJmfycxBeans(List<jmfycxBean> jmfycxBeans) {
	this.jmfycxBeans = jmfycxBeans;
}
public List<jmfyxmbmBean> getJmfyxmbmBeans() {
	return jmfyxmbmBeans;
}
public void setJmfyxmbmBeans(List<jmfyxmbmBean> jmfyxmbmBeans) {
	this.jmfyxmbmBeans = jmfyxmbmBeans;
}
public List<mxfybmBean> getMxfybmBeans() {
	return mxfybmBeans;
}
public void setMxfybmBeans(List<mxfybmBean> mxfybmBeans) {
	this.mxfybmBeans = mxfybmBeans;
}

}
