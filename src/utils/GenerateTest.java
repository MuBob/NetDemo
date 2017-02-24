package utils;

/**
 * Created by Administrator on 2017/2/17.
 */
public class GenerateTest {
    public static void main(String[] args){
        String json="{\n" +
                "\t\"uid\" : \"b746f6088bb243f8878afa20e4f85f27\",\n" +
                "\t\"countryCode\" : [\"432\",\"213\",\"21\"]\n" +
                "}";
        GenerateConfig config = new GenerateConfig("TestBean", json);
        config.setExtendModelClass(true);
        String testBean = GenerateUtil.generate(config);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(testBean);
        System.out.println("---------------------------------------------------------------------------------");


    }
}
