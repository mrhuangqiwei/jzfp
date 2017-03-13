package Bean;
/**
 * 医疗费用对码Bean
 * @author Administrator
 *
 */
public class ylfydmBean {
private String id;
private String zflxbm;
private String zflxmc;
private String ylfybm;
private String ylfymc;
public ylfydmBean(String id, String zflxbm, String zflxmc, String ylfybm,
		String ylfymc) {
	super();
	this.id = id;
	this.zflxbm = zflxbm;
	this.zflxmc = zflxmc;
	this.ylfybm = ylfybm;
	this.ylfymc = ylfymc;
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
public String getYlfybm() {
	return ylfybm;
}
public void setYlfybm(String ylfybm) {
	this.ylfybm = ylfybm;
}
public String getYlfymc() {
	return ylfymc;
}
public void setYlfymc(String ylfymc) {
	this.ylfymc = ylfymc;
}

}
