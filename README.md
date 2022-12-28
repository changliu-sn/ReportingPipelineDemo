# ReportingPipelineDemo


## clickhouse tables 

```sql
CREATE TABLE my_action
(
    `type` String,
    `id` Int64,
    `timestamp` Int64,
    `gender` String,
    `age` Int64
)
ENGINE = MergeTree
PARTITION BY (type, toYYYYMMDD(FROM_UNIXTIME(timestamp)))
ORDER BY (type, id, timestamp, gender, age)

CREATE TABLE my_report (
    `unixtime_hour` Int64,
    `id` Int64,
    `gender` String,
    `age` Int64,
    `impression_count` Int64,
    `viewable_impression_count` Int64,
    `click_count` Int64
)
ENGINE = SummingMergeTree
ORDER BY (unixtime_hour, id, gender, age)
PARTITION BY(toYYYYMMDD(FROM_UNIXTIME(unixtime_hour)))

CREATE MATERIALIZED VIEW my_mv TO my_report AS
SELECT
    timestamp - (timestamp % 3600) AS unixtime_hour,
    id,
    gender,
    age,
    countIf(type = 'imp') AS impression_count,
    countIf(type = 'vimp') AS viewable_impression_count,
    countIf(type = 'click') AS click_count
FROM my_action
GROUP BY
    unixtime_hour,
    id,
    gender,
    age
```
