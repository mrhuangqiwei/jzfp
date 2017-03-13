package Bean;

import java.util.List;

public class ylfyListBean {
private List<ylfydmBean>ylfydmBeans;	
private List<ylfyxmBean> ylfyxmBeans;
private List<zflxBean>zflxBeans;
public ylfyListBean(List<ylfydmBean> ylfydmBeans, List<ylfyxmBean> ylfyxmBeans,
		List<zflxBean> zflxBeans) {
	super();
	this.ylfydmBeans = ylfydmBeans;
	this.ylfyxmBeans = ylfyxmBeans;
	this.zflxBeans = zflxBeans;
}
public List<ylfydmBean> getYlfydmBeans() {
	return ylfydmBeans;
}
public void setYlfydmBeans(List<ylfydmBean> ylfydmBeans) {
	this.ylfydmBeans = ylfydmBeans;
}
public List<ylfyxmBean> getYlfyxmBeans() {
	return ylfyxmBeans;
}
public void setYlfyxmBeans(List<ylfyxmBean> ylfyxmBeans) {
	this.ylfyxmBeans = ylfyxmBeans;
}
public List<zflxBean> getZflxBeans() {
	return zflxBeans;
}
public void setZflxBeans(List<zflxBean> zflxBeans) {
	this.zflxBeans = zflxBeans;
}

}
