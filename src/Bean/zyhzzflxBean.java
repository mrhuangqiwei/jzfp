package Bean;
/**
 * 住院患者支付类型Bean
 * @author Administrator
 *
 */
public class zyhzzflxBean {
private String zyh;
private String ylfybm;
private String ylfymc;
private String zflxbm;
private String zflxmc;
private String zfje;
public zyhzzflxBean(String zyh, String ylfybm, String ylfymc, String zflxbm,
		String zflxmc, String zfje) {
	super();
	this.zyh = zyh;
	this.ylfybm = ylfybm;
	this.ylfymc = ylfymc;
	this.zflxbm = zflxbm;
	this.zflxmc = zflxmc;
	this.zfje = zfje;
}
public String getZyh() {
	return zyh;
}
public void setZyh(String zyh) {
	this.zyh = zyh;
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
public String getZfje() {
	return zfje;
}
public void setZfje(String zfje) {
	this.zfje = zfje;
}

}
