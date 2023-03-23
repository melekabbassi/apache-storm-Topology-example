package com.example;

import java.util.Map;
import java.util.Random;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

public class MySpout extends BaseRichSpout {

    private SpoutOutputCollector collector;
    private Random random;

    
    public MySpout(SpoutOutputCollector collector, Random random) {
        this.collector = collector;
        this.random = random;
    }

    public MySpout() {
    }

    public SpoutOutputCollector getCollector() {
        return collector;
    }

    public void setCollector(SpoutOutputCollector collector) {
        this.collector = collector;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    // open() is called when a task for this component is initialized within a worker on the cluster.
    @Override
    public void open(Map<String, Object> conf, TopologyContext context, SpoutOutputCollector collector) {
        this.collector = collector;
        this.random = new Random();
    }

    // nextTuple() is called to generate tuples to be emitted to the output streams.
    @Override
    public void nextTuple() {
        int number = random.nextInt(100);
        collector.emit(new Values(number));
    }

    // declareOutputFields() is called to let this component declare the output schema for all the streams.
    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("number"));
    }
}

/*
 * what does this code do? 
 *  - it creates a spout that emits a random number between 0 and 100
 * - it creates a bolt that receives the random number and doubles it
 * - it creates a bolt that receives the doubled number and prints it
 * 
 * what is the topology?
 * - spout -> bolt1 -> bolt2
 * 
 * what is the topology name?
 * - MyTopology
 * 
 * what is a spout?
 * - a spout is a source of data
 * 
 * what is the spout name?
 * - MySpout
 */