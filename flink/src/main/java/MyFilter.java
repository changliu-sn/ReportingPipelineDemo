import com.google.gson.Gson;
import org.apache.flink.api.common.functions.FilterFunction;

public class MyFilter implements FilterFunction<String> {
    private static Gson gson = new Gson();
    @Override
    public boolean filter(String s) {
        try {
            MyLog log = gson.fromJson(s, MyLog.class);
            if (!log.valid()) {
                System.out.println("Invalid: " + s);
                return false;
            }
            return true;
        } catch (Exception e) {
            System.out.println("Invalid: " + s);
            return false;
        }
    }
}
