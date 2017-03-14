package Bean;

import java.util.List;





/**
 * 补助费用list
 * @author Administrator
 *
 */
public class bzfylistBean {
private List<bzfycxBean> bzfycxBeans;
private List<bzfybmBean>bzfybmBeans;
private List<zflxBean>zflxBeans;
public bzfylistBean(List<bzfycxBean> bzfycxBeans, List<bzfybmBean> bzfybmBeans,
		List<zflxBean> zflxBeans) {
	super();
	this.bzfycxBeans = bzfycxBeans;
	this.bzfybmBeans = bzfybmBeans;
	this.zflxBeans = zflxBeans;
}
public List<bzfycxBean> getBzfycxBeans() {
	return bzfycxBeans;
}
public void setBzfycxBeans(List<bzfycxBean> bzfycxBeans) {
	this.bzfycxBeans = bzfycxBeans;
}
public List<bzfybmBean> getBzfybmBeans() {
	return bzfybmBeans;
}
public void setBzfybmBeans(List<bzfybmBean> bzfybmBeans) {
	this.bzfybmBeans = bzfybmBeans;
}
public List<zflxBean> getZflxBeans() {
	return zflxBeans;
}
public void setZflxBeans(List<zflxBean> zflxBeans) {
	this.zflxBeans = zflxBeans;
}

}
