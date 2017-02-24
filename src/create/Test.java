package create;
/**
 * Created by Administrator on 2016/8/17.
 */
public class Test {
    public static void main(String[] args){
//        String json="{\n" +
//                "                                                                                                               \"code\" : 200,\n" +
//                "                                                                                                               \"status\" : 0,\n" +
//                "                                                                                                               \"data\" : {\n" +
//                "                                                                                                                 \"uid\" : \"233038ada1f94e0a8b0a18ac285c5002\",\n" +
//                "                                                                                                                 \"countryCode\" : \"86\",\n" +
//                "                                                                                                                 \"mobile\" : \"15611681936\",\n" +
//                "                                                                                                                 \"imId\" : \"ZONETRY233038ada1f94e0a8b0a18ac285c5002\",\n" +
//                "                                                                                                                 \"imPassword\" : \"N7bOkhnz1YBFTgytbejZ1jCcpnBJjUel\",\n" +
//                "                                                                                                                 \"enabled\" : true,\n" +
//                "                                                                                                                 \"nick\" : \"15611681936\",\n" +
//                "                                                                                                                 \"name\" : \"\",\n" +
//                "                                                                                                                 \"firstName\" : \"\",\n" +
//                "                                                                                                                 \"middleName\" : \"\",\n" +
//                "                                                                                                                 \"lastName\" : \"\",\n" +
//                "                                                                                                                 \"realnameApplied\" : false,\n" +
//                "                                                                                                                 \"realnameReviewed\" : false,\n" +
//                "                                                                                                                 \"realnameReviewResult\" : false,\n" +
//                "                                                                                                                 \"isMsg\" : true,\n" +
//                "                                                                                                                 \"isMsgDetail\" : true,\n" +
//                "                                                                                                                 \"isVoice\" : true,\n" +
//                "                                                                                                                 \"isVibrate\" : true,\n" +
//                "                                                                                                                 \"isRealname\" : false,\n" +
//                "                                                                                                                 \"isAdmin\" : false,\n" +
//                "                                                                                                                 \"isCustomerService\" : false,\n" +
//                "                                                                                                                 \"isExpert\" : false,\n" +
//                "                                                                                                                 \"isInvestor\" : false,\n" +
//                "                                                                                                                 \"isIncubator\" : false,\n" +
//                "                                                                                                                 \"isEntrepreneur\" : false,\n" +
//                "                                                                                                                 \"balance\" : 0.00,\n" +
//                "                                                                                                                 \"freeze\" : 0.00,\n" +
//                "                                                                                                                 \"available\" : 0.00,\n" +
//                "                                                                                                                 \"focusCount\" : 0,\n" +
//                "                                                                                                                 \"fansCount\" : 0,\n" +
//                "                                                                                                                 \"collectCount\" : 0\n" +
//                "                                                                                                               }\n" +
//                "                                                                                                             }\n";
       
    	/*String json=  "{\n" +
                "    \"app\" : {\n" +
                "      \"chineseName\" : \"众创空间\",\n" +
                "      \"englishName\" : \"ZONETRY\",\n" +
                "      \"version\" : 100,\n" +
                "      \"versionDisplay\" : \"1.0.0\",\n" +
                "      \"synopsis\" : \"众创空间创业生态系统平台\",\n" +
                "      \"desc\" : \"让创业不再失败\",\n" +
                "      \"isForceUpdate\" : false,\n" +
                "      \"webUrl\" : \"http://www.zonetry.com\",\n" +
                "      \"downloadUrl\" : \"\",\n" +
                "      \"enabled\" : true\n" +
                "    },\n" +
                "    \"datadict\" : {\n" +
                "      \"_CertType\" : 1,\n" +
                "      \"_FinancingStage\" : 1,\n" +
                "      \"_MarketData\" : 1,\n" +
                "      \"_TransactionType\" : 1,\n" +
                "      \"_ProjectStage\" : 2,\n" +
                "      \"_ReportCause\" : 1,\n" +
                "      \"_Country\" : 1,\n" +
                "      \"_AppType\" : 1,\n" +
                "      \"_InvestorType\" : 1,\n" +
                "      \"_Province\" : 1,\n" +
                "      \"_MarketDataCategory\" : 1,\n" +
                "      \"_City\" : 1,\n" +
                "      \"_AccountChangeType\" : 1,\n" +
                "      \"_Nation\" : 1,\n" +
                "      \"_Degree\" : 1,\n" +
                "      \"_MoneyUnit\" : 1,\n" +
                "      \"_ArticleCategory\" : 1,\n" +
                "      \"_District\" : 1,\n" +
                "      \"_Channel\" : 1,\n" +
                "      \"_Gender\" : 1,\n" +
                "      \"_Location\" : 1,\n" +
                "      \"_ExpertiseField\" : 1,\n" +
                "      \"_IndustryCategory\" : 1,\n" +
                "      \"_HotWord\" : 1\n" +
                "    }\n" +
                "  }";
    	*/
    	String json="";
    	String targetPath="C://str2bean22//aaa";
        String targetFile="AbcBean";
        new Str2Bean(json, targetPath,targetFile).execute();
        System.out.println("创建结束");

    }
}
