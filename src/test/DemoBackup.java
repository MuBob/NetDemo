package test;

import java.util.HashMap;
import java.util.Map;

import com.zonetry.base.constant.Info;
import com.zonetry.base.java.EncryptUtil;
import com.zonetry.base.java.NetUtil;
import com.zonetry.base.net.IResponseListenerSimpleImpl;

import bean.ProjectListReviewTrue;
import bean.UserLogonMobile;
import bean.VersionCheck;

 

public class DemoBackup {

	 public static void main(String[] args) {
		 
		 Map<String, Object>  params =new HashMap<String, Object>();
		 params.put("path", "/Version/Check");
		 
		NetUtil.request(params, new IResponseListenerSimpleImpl<VersionCheck>(){

			@Override
			public Class<VersionCheck> getTClass() {
				return VersionCheck.class;
			}
			 
		 });
		 
		 
		 params.put("path", "/User/Logon/Mobile");
		 params.put("countryCode", "86");
		 params.put("mobile", "18730288931");
		 params.put("password", EncryptUtil.encrypt("18730288931"));
		 
		NetUtil.request(params, new IResponseListenerSimpleImpl<UserLogonMobile>(){

			@Override
			public Class<UserLogonMobile> getTClass() {
				return UserLogonMobile.class;
			}
	 
			@Override
			public void onResponseSuccess(UserLogonMobile bean) {
				// TODO Auto-generated method stub
				super.onResponseSuccess(bean);
//				Info.setTOKEN(bean.getToken());
			}
			 
		 });
		 
		 
		 params.clear();
		 params.put("path", "/Project/Stage/Info");
		 params.put("path", "/Project/Stage/Info");
		 
		 
		 
		 
		 params.clear();
		 params.put("path", "/Project/Stage/Info");
//		 params.put("pageIndex", "1");
		 
		 NetUtil.request(params, new IResponseListenerSimpleImpl(){

//			@Override
//			protected Class<VersionCheck> getTClass() {
//				return VersionCheck.class;
//			}
			 
		 });
		 
		 
		 
		 params.clear();
		 params.put("path", "/Project/Random/List");
		 params.put("pageIndex", "1");
		 
		 NetUtil.request(params, new IResponseListenerSimpleImpl(){

	 
			 
		 });
		 
		 
		 params.clear();
		 params.put("path", "/Project/Random/List");
		 params.put("pageIndex", "1");
		 
		 NetUtil.request(params, new IResponseListenerSimpleImpl(){

	 
			 
		 });
		 
		 params.put("path", "/Project/List/Review/True");
		 params.put("pageIndex", 0);
		 
		 NetUtil.request(params, new IResponseListenerSimpleImpl<ProjectListReviewTrue>(){

				@Override
				public Class<ProjectListReviewTrue> getTClass() {
					return ProjectListReviewTrue.class;
				}
			 
		 });
		
		 
		 
		 
 
	}
	 
 
}
