package Bean;
/**
 * 支付类型编码bean
 * @author Administrator
 *
 */

public class zflxBean {
	private String zflxbm;
	private String zflxmc;
	public zflxBean(String zflxbm, String zflxmc) {
		super();
		this.zflxbm = zflxbm;
		this.zflxmc = zflxmc;
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

}
