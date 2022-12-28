import org.apache.flink.connector.jdbc.JdbcConnectionOptions;
import org.apache.flink.connector.jdbc.JdbcExecutionOptions;
import org.apache.flink.streaming.api.functions.sink.SinkFunction;
import org.apache.flink.connector.jdbc.JdbcSink;

public class ClickhouseSink {
    public static SinkFunction<MyLog> sink() {
        return JdbcSink.sink("INSERT INTO my_action VALUES (?, ?, ?, ?, ?)",
                (statement, log) -> {
                    System.out.println(log);
                    statement.setString(1, log.type);
                    statement.setLong(2, log.id);
                    statement.setLong(3, log.timestamp);
                    statement.setString(4, log.gender);
                    statement.setLong(5, log.age);
                },
                JdbcExecutionOptions.builder().
                        withBatchIntervalMs(100).
                        withBatchSize(100).
                        build(),
                new JdbcConnectionOptions.JdbcConnectionOptionsBuilder()
                        .withDriverName("com.clickhouse.jdbc.ClickHouseDriver")
                        .withUrl("jdbc:ch://localhost:8123")
                        .withUsername("default")
                        .withPassword("140323CcMac")
                        .build());
    }
}
