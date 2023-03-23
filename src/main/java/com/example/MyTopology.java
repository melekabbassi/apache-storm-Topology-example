package com.example;

// import org.apache.storm.Config;
// import org.apache.storm.LocalCluster;
import org.apache.storm.topology.ConfigurableTopology;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.tuple.Fields;

public class MyTopology extends ConfigurableTopology {
    public static void main(String[] args) throws Exception {
        ConfigurableTopology.start(new MyTopology(), args);
        // // Create a TopologyBuilder
        // TopologyBuilder builder = new TopologyBuilder();

        // // Create a Spout
        // builder.setSpout("mySpout", new MySpout());

        // // Create Bolts
        // builder.setBolt("myBolt1", new MyBolt1()).shuffleGrouping("mySpout");
        // builder.setBolt("myBolt2", new MyBolt2()).fieldsGrouping("myBolt1", new Fields("doubleNumber"));

        // // Configure and submit the topology
        // Config config = new Config();
        // config.setDebug(true);

        // // Submit the topology
        // LocalCluster cluster = new LocalCluster();
        // cluster.submitTopology("myTopology", config, builder.createTopology());

        // // Wait for 10 seconds
        // Thread.sleep(10000);

        // // Kill the topology
        // cluster.killTopology("myTopology");

        // // Shutdown the cluster
        // cluster.shutdown();
    }

    @Override
    protected int run(String[] args) throws Exception {
        // Create a TopologyBuilder
        TopologyBuilder builder = new TopologyBuilder();

        // Create a Spout
        builder.setSpout("mySpout", new MySpout(), 5);

        // Create Bolts
        builder.setBolt("myBolt1", new MyBolt1(), 8).shuffleGrouping("mySpout");
        builder.setBolt("myBolt2", new MyBolt2(), 12).fieldsGrouping("myBolt1", new Fields("doubleNumber"));

        // Configure and submit the topology
        conf.setDebug(true);
        String topologyName = "myTopology";
        conf.setNumWorkers(3);
        if (args != null && args.length > 0) {
            topologyName = args[0];
        }
        return submit(topologyName, conf, builder);
    }    
}

/*
 * 1. Create a TopologyBuilder
 * 2. Create a Spout
 * 3. Create Bolts
 * 4. Configure and submit the topology
 */

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
 * 
 * what is a bolt?
 * - a bolt is a processing unit
 * 
 * what is the bolt name?
 * - MyBolt1
 * - MyBolt2
 * 
 * what is the stream name?
 * - default
 * 
 * what is the field name?
 * - number
 * - doubleNumber
 */