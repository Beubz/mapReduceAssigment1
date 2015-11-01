package com.ece.hadoop;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class AverageFriends {

  public static class TokenizerMapper
  extends Mapper<Object, Text, Text, IntWritable>{

    private final static IntWritable nb = new IntWritable();
    private Text age = new Text();
    private int i = 0;
    public void map(Object key, Text value, Context context
      ) throws IOException, InterruptedException {

      String[] result = value.toString().split(";");

      try{

        i=Integer.parseInt(result[2]);

        if (i>=0 && i<=5) age.set("0-5 Years");

        if (i>=6 && i<=12) age.set("6-12 Years");  

        if (i>=13 && i<=17) age.set("13-17 Years");

        if (i>=18 && i<=25) age.set("18-25 Years");  

        if (i>=26 && i<=35) age.set("26-35 Years");  

        if (i>=36 && i<=45) age.set("36-45 Years");  

        if (i>=46 && i<=60) age.set("46-60 Years");  

        if (i>60) age.set("60+ Years");

        nb.set(Integer.parseInt(result[4]));
        context.write(age, nb);


      }
      catch(Exception e){

      }
    }
  }

  public static class IntSumReducer
  extends Reducer<Text,IntWritable,Text,IntWritable> {
    private IntWritable result = new IntWritable();

    public void reduce(Text key, Iterable<IntWritable> values,
     Context context
     ) throws IOException, InterruptedException {

      int sum = 0;
      int average = 0;
      int nb = 0;

      for (IntWritable val : values) {
        sum += val.get();
        nb++;
      }
      average = sum / nb;

      result.set(average);
      context.write(key, result);
    }
  }

  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    conf.set("mapred.textoutputformat.separator", ";");
    Job job = Job.getInstance(conf, "word count");
    job.setJarByClass(AverageFriends.class);
    job.setMapperClass(TokenizerMapper.class);
    job.setCombinerClass(IntSumReducer.class);
    job.setReducerClass(IntSumReducer.class);
    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(IntWritable.class);
    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));
    System.exit(job.waitForCompletion(true) ? 0 : 1);
  }
}