# MapReduce Assignment 1

## Build projects with Maven

Download the git repository  

```
git clone "https://github.com/Beubz/mapReduceAssigment1.git"
```

There is two projects in this repository, to build one go in its directory 

```
mvn compile

mvn package

mvn install

```
You now have your .jar file, you need to put it on the serveur


```
scp LocationWealth-1.0-SNAPSHOT.jar beurel@hadoop-ece.tk:/home/beurel
```
or

```
scp AverageFriends-1.0-SNAPSHOT.jar beurel@hadoop-ece.tk:/home/beurel
```

## Practice 1

To run LocationWealth-1.0-SNAPSHOT.jar

```
hadoop jar LocationWealth-1.0-SNAPSHOT.jar /res/mapred_assignment/ /user/beurel/LocationWealth/output
```

Provide a csv export for your MapReduce result

```
hdfs dfs -get /user/beurel/LocationWealth/output/part-r-00000

mv part-r-00000 LocationWealthResult.csv
```


## Practice 2

To run AverageFriends-1.0-SNAPSHOT.jar

```
hadoop jar AverageFriends-1.0-SNAPSHOT.jar /res/mapred_assignment/ /user/beurel/AverageFriends/output
```

Provide a csv export for your MapReduce result

```
hdfs dfs -get /user/beurel/AverageFriends/output/part-r-00000

mv part-r-00000 LocationWealthResult.csv
```