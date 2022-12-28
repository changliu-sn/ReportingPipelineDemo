import java.lang.reflect.Field;

public class MyLog {
    public MyLog(String type, Long id, Long timestamp, String gender, Long age) {
        this.type = type;
        this.id = id;
        this.timestamp = timestamp;
        this.gender = gender;
        this.age = age;
    }

    final String type;
    final Long id;
    final Long timestamp;
    final String gender;
    final Long age;

    @Override
    public String toString() {
        return "MyLog{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", timestamp=" + timestamp +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    public boolean valid() throws IllegalAccessException {
        for (Field f : getClass().getDeclaredFields()) {
            if (f.get(this) == null) {
                return false;
            }
        }
        return true;
    }
}
