import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;

/**
 * Created by aluis on 8/31/16.
 */
public class Constants {
public static final String COOKIE_NAME = "login_example";
    public static final String COOKIE_CAR_NAME = "car_example";
    public static final String COOKIE_TRUE = "TRUE";
    public static final String COOKIE_FALSE = "FALSE";

    
    
    private static final String DATE_FORMAT = "MM-dd-yyyy HH:mm:ss";
    private static final Gson gson = new GsonBuilder().setDateFormat(DATE_FORMAT).create();
public static final File DATA_FILE = new File("Data.dat");


    public static <T> T convert(String data, Class<T> validClass) {
        if (data != null && !data.isEmpty()) {
            try {
                return gson.fromJson(data, validClass);
            } catch (Exception ignored) {
                return null;
            }
        }
        return null;
    }

    public static String stringify(Object object) {
        return gson.toJson(object);
    }
}