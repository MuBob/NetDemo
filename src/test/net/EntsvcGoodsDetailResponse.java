package test.net;

import com.zonetry.base.bean.BaseBean;
import com.zonetry.base.bean.BaseResponse;
import com.zonetry.base.bean.IResponseSuccess;
import com.zonetry.base.constant.Info;
import com.zonetry.base.util.StringUtil;

import java.util.List;

public class EntsvcGoodsDetailResponse extends BaseBean implements IResponseSuccess{
private List<QaListBean> qaList;
public java.util.List<QaListBean> getQaList(){
return qaList;
}
public void setQaList(List<QaListBean> qaList){
this.qaList=qaList;
}
public static class QaListBean extends BaseBean {
private String question;
public String getQuestion(){
return question;
}
public void setQuestion(String question){
this.question=question;
}
private String answer;
public String getAnswer(){
return answer;
}
public void setAnswer(String answer){
this.answer=answer;
}
}
private List<ProcessListBean> processList;
public java.util.List<ProcessListBean> getProcessList(){
return processList;
}
public void setProcessList(List<ProcessListBean> processList){
this.processList=processList;
}
public static class ProcessListBean extends BaseBean {
private String no;
public String getNo(){
return no;
}
public Integer getNoNumber(){
return (Integer.parseInt(no));
}
public void setNo(String no){
this.no=no;
}
private String desc;
public String getDesc(){
return desc;
}
public void setDesc(String desc){
this.desc=desc;
}
}
private String goodsID;
public String getGoodsID(){
return goodsID;
}
public void setGoodsID(String goodsID){
this.goodsID=goodsID;
}
private String orgFullName;
public String getOrgFullName(){
return orgFullName;
}
public void setOrgFullName(String orgFullName){
this.orgFullName=orgFullName;
}
private String serviceNote;
public String getServiceNote(){
return serviceNote;
}
public void setServiceNote(String serviceNote){
this.serviceNote=serviceNote;
}
private String orgID;
public String getOrgID(){
return orgID;
}
public void setOrgID(String orgID){
this.orgID=orgID;
}
private List<TypeListBean> typeList;
public java.util.List<TypeListBean> getTypeList(){
return typeList;
}
public void setTypeList(List<TypeListBean> typeList){
this.typeList=typeList;
}
public static class TypeListBean extends BaseBean {
private String districtName;
public String getDistrictName(){
return districtName;
}
public void setDistrictName(String districtName){
this.districtName=districtName;
}
private String price;
public String getPrice(){
return price;
}
public void setPrice(String price){
this.price=price;
}
private String typeName;
public String getTypeName(){
return typeName;
}
public void setTypeName(String typeName){
this.typeName=typeName;
}
private String typeID;
public String getTypeID(){
return typeID;
}
public Integer getTypeIDNumber(){
return (Integer.parseInt(typeID));
}
public void setTypeID(String typeID){
this.typeID=typeID;
}


public static class Location{
    int cityID;
    int districtID;
    String districtName;
    double price;
	
}
private Location locations;
public Location getLocations(){
return locations;
}
 
public void setLocations(Location locations){
this.locations=locations;
}
private String cityID;
public String getCityID(){
return cityID;
}
public Integer getCityIDNumber(){
return (Integer.parseInt(cityID));
}
public void setCityID(String cityID){
this.cityID=cityID;
}
}
private String service;
public String getService(){
return service;
}
public void setService(String service){
this.service=service;
}
private String snapshotNo;
public String getSnapshotNo(){
return snapshotNo;
}
public void setSnapshotNo(String snapshotNo){
this.snapshotNo=snapshotNo;
}
private String orgCustomerServiceIM;
public String getOrgCustomerServiceIM(){
return orgCustomerServiceIM;
}
public void setOrgCustomerServiceIM(String orgCustomerServiceIM){
this.orgCustomerServiceIM=orgCustomerServiceIM;
}
private List<ServiceImageListBean> serviceImageList;
public java.util.List<ServiceImageListBean> getServiceImageList(){
return serviceImageList;
}
public void setServiceImageList(List<ServiceImageListBean> serviceImageList){
this.serviceImageList=serviceImageList;
}
public static class ServiceImageListBean extends BaseBean {
}
private String orgShortName;
public String getOrgShortName(){
return orgShortName;
}
public void setOrgShortName(String orgShortName){
this.orgShortName=orgShortName;
}
private List<ImageListBean> imageList;
public java.util.List<ImageListBean> getImageList(){
return imageList;
}
public void setImageList(List<ImageListBean> imageList){
this.imageList=imageList;
}
public static class ImageListBean extends BaseBean {
}
private String categoryID;
public String getCategoryID(){
return categoryID;
}
public Integer getCategoryIDNumber(){
return (Integer.parseInt(categoryID));
}
public void setCategoryID(String categoryID){
this.categoryID=categoryID;
}

public String toString() {
	 
		return StringUtil.getClassToString(this);
 
}
}
