
package Bean;
/**
 * 获取明细费用项目编码和明细费用项目名称
 * @author Administrator
 *
 */
public class mxfybmBean {
private String bm;
private String mc;
public mxfybmBean(String bm, String mc) {
	super();
	this.bm = bm;
	this.mc = mc;
}
public String getBm() {
	return bm;
}
public void setBm(String bm) {
	this.bm = bm;
}
public String getMc() {
	return mc;
}
public void setMc(String mc) {
	this.mc = mc;
}
	
	
}
