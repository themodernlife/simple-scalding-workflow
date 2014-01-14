To run locally, you will need to have an "über jar" with all the Scalding dependencies on the Hadoop classpath

```bash
$> export HADOOP_CLASSPATH=$HADOOP_CLASSPATH:dependencies.jar
$> hadoop jar target/scala-2.10/example-workflow_2.10-0.1.jar example.WordCountJobRunner --hdfs --input src/test/resources/alice.txt --output target/word-count
$> hadoop fs -getmerge target/word-count/ target/wordcount.txt
```

To run on EMR, you will need to have the "über jar" installed via a bootstrap action

```bash
elastic-mapreduce \
	--create \
		--name "My Cluster" \
		--enable-debugging \
		--log-uri "s3://bucket/logs" \
		--instance-group master --instance-type m1.large --instance-count 1 \
		--instance-group core --instance-type m1.xlarge --instance-count 8 \
	--bootstrap-action "s3://bucket/install-dependencies" \
	    --bootstrap-name "install-dependencies" \
	--jar \
		target/scala-2.10/example-workflow_2.10-0.1.jar \
		--activity-name "WordCount Activity" \
		--arg example.WordCountJobRunner \
    	--args "--hdfs,--tool.partialok" \
		--args "--input,s3://bucket/input" \
		--args "--output,s3://bucket/output"
```

Example bootstrap action

```bash
#! /bin/bash -ex

hadoop fs -copyToLocal s3://bucket/dependencies.jar /home/hadoop/lib/
```