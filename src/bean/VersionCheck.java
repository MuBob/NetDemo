package bean;

import com.zonetry.base.bean.BaseResponse;

public class VersionCheck extends BaseResponse {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8571997400510858518L;

 
	
	int version;
	String displayVersion;

	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getDisplayVersion() {
		return displayVersion;
	}
	public void setDisplayVersion(String displayVersion) {
		this.displayVersion = displayVersion;
	}
 
	
	
	
	
	
	
	
}
