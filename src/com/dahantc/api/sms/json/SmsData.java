package com.dahantc.api.sms.json;

public class SmsData {
	private String msgid;
	private String phones;
	private String content;
	private String sign;
	private String subcode;
	private String sendtime;

	public SmsData(String phones, String content, String msgid, String sign, String subcode, String sendtime) {
		super();
		this.phones = phones;
		this.content = content;
		this.msgid = msgid;
		this.sign = sign;
		this.subcode = subcode;
		this.sendtime = sendtime;
	}

	public SmsData() {
		super();
	}

	public String getMsgid() {
		return msgid;
	}

	public void setMsgid(String msgid) {
		this.msgid = msgid;
	}

	public String getPhones() {
		return phones;
	}

	public void setPhones(String phones) {
		this.phones = phones;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSubcode() {
		return subcode;
	}

	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}

	public String getSendtime() {
		return sendtime;
	}

	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

}
