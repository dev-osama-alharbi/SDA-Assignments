package sa.osama_alharbi.sda.assigments.utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUtils {

    //We create this method to handle exception in test classes to have cleaner code.
    public static <T> T convertJsonToJava(String strJson, Class<T> valueType) {//Generic method

        try {
            return new ObjectMapper().readValue(strJson, valueType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}