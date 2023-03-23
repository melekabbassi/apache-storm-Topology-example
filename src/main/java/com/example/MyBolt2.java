package com.example;

import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;

public class MyBolt2 extends BaseRichBolt {

    public MyBolt2(){}

    // prepare() is called when a task for this component is initialized within a worker on the cluster.
    @Override
    public void prepare(Map<String, Object> topoConf, TopologyContext context, OutputCollector collector) {


    }

    // execute() is called to process tuples from the input streams.
    @Override
    public void execute(Tuple input) {
        int number = input.getIntegerByField("doubleNumber");
        System.out.println("MyBolt2: " + number);
    }

    // declareOutputFields() is called to let this component declare the output schema for all the streams.
    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        
    }   
}

/*
 * what does this code do? 
 * - it prints the doubleNumber field
 *
 * what is a bolt?
 * - a bolt is a processing unit
 * 
 * what is the bolt name?
 * - MyBolt1
 * - MyBolt2
 * 
 * what is the field name?
 * - number
 * - doubleNumber
 */
