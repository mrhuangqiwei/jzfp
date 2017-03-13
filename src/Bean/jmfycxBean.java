package Bean;
/**
 * 减免费用查询bean
 * @author Administrator
 *
 */
public class jmfycxBean {
private String id;
private String fyxlbm;
private String   mc;
private String jmfybm;
private String jmfymc;
public jmfycxBean(String id, String fyxlbm, String mc, String jmfybm,
		String jmfymc) {
	super();
	this.id = id;
	this.fyxlbm = fyxlbm;
	this.mc = mc;
	this.jmfybm = jmfybm;
	this.jmfymc = jmfymc;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getFyxlbm() {
	return fyxlbm;
}
public void setFyxlbm(String fyxlbm) {
	this.fyxlbm = fyxlbm;
}
public String getMc() {
	return mc;
}
public void setMc(String mc) {
	this.mc = mc;
}
public String getJmfybm() {
	return jmfybm;
}
public void setJmfybm(String jmfybm) {
	this.jmfybm = jmfybm;
}
public String getJmfymc() {
	return jmfymc;
}
public void setJmfymc(String jmfymc) {
	this.jmfymc = jmfymc;
}

}
