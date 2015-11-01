# MapReduce Assignment 1

### Build projects with Maven

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

### Practice 1

###### Using MapReduce, please compute for each location, the sum of the banking accounts to determine
location wealth.


To run LocationWealth-1.0-SNAPSHOT.jar

```
hadoop jar LocationWealth-1.0-SNAPSHOT.jar /res/mapred_assignment/ /user/beurel/LocationWealth/output
```

###### Is it useful to use the reducer class as a combiner ? Justify.

It is useful to use the reducer class as a combiner because there will be less data outputed so it will be faster. But the result is the same so it's not obligatory, but the more data you have, the more useful it will be.

###### Bonus : Provide a csv export for your MapReduce result

```
hdfs dfs -get /user/beurel/LocationWealth/output/part-r-00000

mv part-r-00000 LocationWealthResult.csv
```


### Practice 2

###### Using MapReduce, please compute for each age group listed below, the average number of friend.

0-5 years
6-12 years
13-17 years
18-25 years
26-35 years
36-45 years
46-60 years
60+ years


To run AverageFriends-1.0-SNAPSHOT.jar

```
hadoop jar AverageFriends-1.0-SNAPSHOT.jar /res/mapred_assignment/ /user/beurel/AverageFriends/output
```

###### Bonus : Provide a csv export for your MapReduce result

```
hdfs dfs -get /user/beurel/AverageFriends/output/part-r-00000

mv part-r-00000 LocationWealthResult.csv
```