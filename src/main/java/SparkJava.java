/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.SparkConf;

public class SparkJava {

    private static final String APP_NAME = "SparkJava";
    private static final String SEARCH_STRING = "spark";
    private static final String SPARK_MASTER = "local[*]";
    private static final String WORDS_FILE = "/usr/share/dict/words";

    public static void main(String[] args) {

        SparkConf sparkConf = new SparkConf()
                .setAppName(APP_NAME)
                .setMaster(SPARK_MASTER);

        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        // Define RDD from OS X words file and return words containing search string.
        JavaRDD<String> wordList = sc.textFile(WORDS_FILE).filter(s -> s.contains(SEARCH_STRING));

        // Print words containing search string.
        for (String word : wordList.collect()) System.out.println(word);

        sc.stop();
    }
}
