package Bean;
/**
 * 获取明细费用项目编码
 * @author Administrator
 *
 */
public class mxfyxmbmBean {
private String mxfyxmbm;
private String mxfyxmmc;
public mxfyxmbmBean(String mxfyxmbm, String mxfyxmmc) {
	super();
	this.mxfyxmbm = mxfyxmbm;
	this.mxfyxmmc = mxfyxmmc;
}
public String getMxfyxmbm() {
	return mxfyxmbm;
}
public void setMxfyxmbm(String mxfyxmbm) {
	this.mxfyxmbm = mxfyxmbm;
}
public String getMxfyxmmc() {
	return mxfyxmmc;
}
public void setMxfyxmmc(String mxfyxmmc) {
	this.mxfyxmmc = mxfyxmmc;
}

}
