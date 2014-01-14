To run

```bash
$> export HADOOP_CLASSPATH=$HADOOP_CLASSPATH:data-platform-lib-0.1-dist.jar
$> hadoop jar target/scala-2.10/example-workflow_2.10-0.1.jar example.WordCountJobRunner --hdfs --input src/test/resources/alice.txt --output target/word-count
$> hadoop fs -getmerge  target/word-count/
```



