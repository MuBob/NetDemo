package bean;

import com.zonetry.base.bean.BaseResponse;

public class UserLogonMobile extends BaseResponse {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3151683177951372249L;
	String uid;
	String countryCode;
	String mobile;
	String name;
	String nick;
 
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
 
	public String getNick(int i) {
		return nick;
	}
	public String getNick(String i) {
		return nick;
	}
	 
	
}
