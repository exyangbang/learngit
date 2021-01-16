package cn.buyforyou.sign.crypto.custom;

public final class UnionCertInfo {
	private String subject; /* 证书主题 */
	private String ser_number; /* 证书序号 */
	private String issuer_subject; /* 证书颁发者 */
	private String start_time; /* 证书生效日期yyyyMMdd */
	private String end_time; /* 证书失效日期yyyyMMdd */
	private String alg_id; /* 证书算法标识 "RSA"或"SM2" */
	private String pk; /* 证书公钥(RSA公钥格式为DER Hex格式,SM2公钥 为”04||xHex||yHex”) */
	private String base64Cert; // 证书数据(base64)

	public final String getSubject() {
		return subject;
	}

	public final void setSubject(String subject) {
		this.subject = subject;
	}

	public final String getSer_number() {
		return ser_number;
	}

	public final void setSer_number(String ser_number) {
		this.ser_number = ser_number;
	}

	public final String getIssuer_subject() {
		return issuer_subject;
	}

	public final void setIssuer_subject(String issuer_subject) {
		this.issuer_subject = issuer_subject;
	}

	public final String getStart_time() {
		return start_time;
	}

	public final void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public final String getEnd_time() {
		return end_time;
	}

	public final void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public final String getAlg_id() {
		return alg_id;
	}

	public final void setAlg_id(String alg_id) {
		this.alg_id = alg_id;
	}

	public final String getPk() {
		return pk;
	}

	public final void setPk(String pk) {
		this.pk = pk;
	}

	public final String getBase64Cert() {
		return base64Cert;
	}

	public final void setBase64Cert(String base64Cert) {
		this.base64Cert = base64Cert;
	}

}
