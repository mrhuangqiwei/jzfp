package Bean;
/**
 * 获取减免费用编码与减免费用项目名称
 * @author Administrator
 *
 */
public class jmfyxmbmBean {
private String jmfybm;
private String jmfymc;
public jmfyxmbmBean(String jmfybm, String jmfymc) {
	super();
	this.jmfybm = jmfybm;
	this.jmfymc = jmfymc;
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
