package utils;

/**
 * Created by Administrator on 2016/8/17.
 */
public class GenerateConfig {
    private String className;
    private String body;
    private boolean haveGetter;
    private boolean haveGetterNumber;
    private boolean haveSetter;
    private boolean haveConstructor;
    private boolean haveToString;
    private boolean haveEquals;
    private boolean isStaticClass;
    private boolean isExtendModelClass;

    /**
     * 生成JavaBean串，不包括文件所在的包名
     * @param className
     * @param body
     */
    public GenerateConfig(String className, String body){
        this(className, body, false);
    }
    public GenerateConfig(String className, String body, boolean isStaticClass){
        this.className=className;
        this.body=body;
        this.isStaticClass=isStaticClass;
        initConfig();
    }

    private void initConfig() {
        haveGetter=true;
        haveGetterNumber=false;
        haveSetter=true;
        haveConstructor=true;
        haveToString=false;
        haveEquals=false;
        isExtendModelClass=false;
    }

    public String getClassName() {
        return className;
    }

    public String getBody() {
        return body;
    }

    public void setStaticClass(boolean staticClass) {
        isStaticClass = staticClass;
    }

    public boolean isExtendModelClass() {
        return isExtendModelClass;
    }

    public void setExtendModelClass(boolean extendModelClass) {
        isExtendModelClass = extendModelClass;
    }

    public boolean isHaveGetter() {
        return haveGetter;
    }

    public boolean isHaveGetterNumber() {
        return haveGetterNumber;
    }

    public boolean isHaveSetter() {
        return haveSetter;
    }

    public boolean isHaveConstructor() {
        return haveConstructor;
    }

    public boolean isHaveToString() {
        return haveToString;
    }

    public boolean isHaveEquals() {
        return haveEquals;
    }

    public boolean isStaticClass() {
        return isStaticClass;
    }

}
