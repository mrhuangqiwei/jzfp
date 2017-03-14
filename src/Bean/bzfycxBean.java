package Bean;
/**
 * 补助费用查询
 * @author Administrator
 *
 */
public class bzfycxBean {
private String id;
private String zflxbm;
private String zflxmc;
private String bzfybm;
private String bzfymc;
public bzfycxBean(String id, String zflxbm, String zflxmc, String bzfybm,
		String bzfymc) {
	super();
	this.id = id;
	this.zflxbm = zflxbm;
	this.zflxmc = zflxmc;
	this.bzfybm = bzfybm;
	this.bzfymc = bzfymc;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getZflxbm() {
	return zflxbm;
}
public void setZflxbm(String zflxbm) {
	this.zflxbm = zflxbm;
}
public String getZflxmc() {
	return zflxmc;
}
public void setZflxmc(String zflxmc) {
	this.zflxmc = zflxmc;
}
public String getBzfybm() {
	return bzfybm;
}
public void setBzfybm(String bzfybm) {
	this.bzfybm = bzfybm;
}
public String getBzfymc() {
	return bzfymc;
}
public void setBzfymc(String bzfymc) {
	this.bzfymc = bzfymc;
}

}
