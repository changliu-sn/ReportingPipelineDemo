import com.google.gson.Gson;
import org.apache.flink.api.common.functions.MapFunction;

public class MyMapper implements MapFunction<String, MyLog> {
    private static Gson gson = new Gson();
    @Override
    public MyLog map(String s) throws Exception {
        return gson.fromJson(s, MyLog.class);
    }
}
