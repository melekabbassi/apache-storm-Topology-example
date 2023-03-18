package com.example;

import java.util.Map;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichBolt;
import org.apache.storm.tuple.Tuple;

public class MyBolt2 extends BaseRichBolt {

    public MyBolt2(){}

    @Override
    public void prepare(Map<String, Object> topoConf, TopologyContext context, OutputCollector collector) {


    }

    @Override
    public void execute(Tuple input) {
        int number = input.getIntegerByField("doubleNumber");
        System.out.println("MyBolt2: " + number);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        
    }
    
}
