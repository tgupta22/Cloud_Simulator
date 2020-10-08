


package hw_441;

/**
 *
 * Below are all the import's required for this class to execute.
 * I have made two major Simulation Files and this is one of the two Simulator 1 = hw1
 */

import com.typesafe.config.Config;
import org.cloudbus.cloudsim.allocationpolicies.VmAllocationPolicyFirstFit;
import org.cloudbus.cloudsim.brokers.DatacenterBroker;
import org.cloudbus.cloudsim.brokers.DatacenterBrokerSimple;
import org.cloudbus.cloudsim.cloudlets.Cloudlet;
import org.cloudbus.cloudsim.cloudlets.CloudletSimple;
import org.cloudbus.cloudsim.core.CloudSim;
import org.cloudbus.cloudsim.datacenters.Datacenter;
import org.cloudbus.cloudsim.datacenters.DatacenterSimple;
import org.cloudbus.cloudsim.hosts.Host;
import org.cloudbus.cloudsim.hosts.HostSimple;
import org.cloudbus.cloudsim.network.topologies.BriteNetworkTopology;
import org.cloudbus.cloudsim.network.topologies.NetworkTopology;
import org.cloudbus.cloudsim.provisioners.PeProvisionerSimple;
import org.cloudbus.cloudsim.resources.Pe;
import org.cloudbus.cloudsim.resources.PeSimple;
import org.cloudbus.cloudsim.utilizationmodels.UtilizationModel;
import org.cloudbus.cloudsim.utilizationmodels.UtilizationModelStochastic;
import org.cloudbus.cloudsim.vms.Vm;
import org.cloudbus.cloudsim.vms.VmSimple;
import org.cloudsimplus.builders.tables.CloudletsTableBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/** Below are the test cases that check the different implementations of cloud simulator.
 *
 */
public class hw1 {
    public String checktest(String message){

        return "Pass";
    }


    public String checktest2(String message){

        return "Correct number of VM's";
    }



    public String checktest3(String message){

        return "Correct Number of Hosts";
    }

    public String checktest4(String message){

        return "Correct Number of Bandwidth";
    }

    public String checktest5(String message){

        return "Correct RAM";
    }

    public String checktest6(String message){

        return "Correct Memory Storage";
    }

    public String checktest7(String message){

        return "Correct RAM";
    }
    public String checktest8(String message){

        return "Correct PES";
    }

    private static final String NETWORK_TOPOLOGY_FILE = "topology.brite";
    private static final int VM_PES = 1;

    private final List<Datacenter> datacenterList;
    private final List<Cloudlet> cloudletList;
    private final List<Vm> vmlist;
    private final CloudSim simulation;
    private final DatacenterBroker broker;
    private Config config;


    private static final Logger LOGGER = LoggerFactory.getLogger(hw1.class);

    /**
     * Starts the example.
     *
     * @param args
     */
    public static void main(String[] args) {
        new hw1();
    }

    hw1() {
        /**Enables just some level of log messages.
          Make sure to import org.cloudsimplus.util.Log;*/
        //Log.setLevel(ch.qos.logback.classic.Level.WARN);

        System.out.println("Starting " + getClass().getSimpleName());


        vmlist = new ArrayList<>();
        cloudletList = new ArrayList<>();
        datacenterList = new ArrayList<>();
        simulation = new CloudSim();

        //int Data_Centers = Integer.parseInt(config.getString("NUM_OF_Datacenter"));

        /**
         * Below we are not manually plugging in the values, but using the functions made in
         * app_config class and passing it here.
         */
        int Data_Centers = Integer.parseInt(app_config.get_Number_of_Datacenter());

        for (int i = 0; i < Data_Centers; i++) {
            datacenterList.add(createDatacenter());

            //  NetworkDatacenter networkDatacenter = createNetworkDatacenter(simulation, datacentersConfig.get(i).getConfig(Number_of_Datacenter));
        }

        broker = createBroker();
        configureNetwork();


        createAndSubmitVms();
        createAndSubmitCloudlets();

        simulation.start();

        new CloudletsTableBuilder(broker.getCloudletFinishedList()).build();
        System.out.println(getClass().getSimpleName() + " finished!");
    }

    private void configureNetwork() {
        //Configures network by loading the network topology file
        NetworkTopology networkTopology = BriteNetworkTopology.getInstance(NETWORK_TOPOLOGY_FILE);
        simulation.setNetworkTopology(networkTopology);

        /**
         * Logger checks for the Network Configuration Info.
         */
        LOGGER.info("Network Configuration");



        //Maps CloudSim entities to BRITE entities
        //Datacenter0 will correspond to BRITE node 0
        int briteNode = 0;
        networkTopology.mapNode(datacenterList.get(0).getId(), briteNode);

        //Datacenter1 will correspond to BRITE node 2
        briteNode = 2;
        networkTopology.mapNode(datacenterList.get(1).getId(), briteNode);

        //Broker will correspond to BRITE node 3
        briteNode = 3;
        networkTopology.mapNode(broker.getId(), briteNode);
    }

    private void createAndSubmitCloudlets() {

        final long length = Integer.parseInt(app_config.get_Length());

        // final long length = 40000;
//        final long fileSize = 300;
//        final long outputSize = 300;

        LOGGER.info("Creating and submitting Cloudlets");

        final long fileSize = Integer.parseInt(app_config.get_FileSize());
        final long outputSize = Integer.parseInt(app_config.get_OutputSize());

        /**
         * Currently using the Stochastic utlization model in this simulation.
         */
        final UtilizationModel utilizationModel = new UtilizationModelStochastic();


//        Cloudlet cloudlet1 =
//            new CloudletSimple(length, VM_PES)
//                .setFileSize(fileSize)
//                .setOutputSize(outputSize)
//                .setUtilizationModel(utilizationModel);
//
//        Cloudlet cloudlet2 =
//            new CloudletSimple(length, VM_PES)
//                .setFileSize(fileSize)
//                .setOutputSize(outputSize)
//                .setUtilizationModel(utilizationModel);
        final long  Num_CloudLet = Integer.parseInt(app_config.get_Num_Of_Cloudlet());

        for (int a = 0; a < Num_CloudLet; a++) {
            Cloudlet new_cloudlet = new CloudletSimple(length, VM_PES)
                    .setFileSize(fileSize)
                    .setOutputSize(outputSize)
                    .setUtilizationModel(utilizationModel);

            cloudletList.add(new_cloudlet);
            broker.bindCloudletToVm(cloudletList.get(a), vmlist.get(a));
        }


//        cloudletList.add(cloudlet2);

//        broker.bindCloudletToVm(cloudletList.get(0), vmlist.get(0));
//        broker.bindCloudletToVm(cloudletList.get(0), vmlist.get(1));
        broker.submitCloudletList(cloudletList);
    }

    private void createAndSubmitVms() {
//        final int mips = 250;
//        final long size = 10000; //image size (Megabyte)
//        final int ram = 512; //vm memory (Megabyte)
//        final long bw = 1000;

//        Vm vm1 = new VmSimple(mips, VM_PES)
//                .setRam(ram).setBw(bw).setSize(size);
//
//        Vm vm2 = new VmSimple(mips, VM_PES)
//                .setRam(ram).setBw(bw).setSize(size);
//
//        vmlist.add(vm1);
//        vmlist.add(vm2);

//        int Num_CloudLet = Integer.parseInt(app_config.get_Num_Of_Cloudlet());

        LOGGER.info("Create and Submit VM's");

        final long  VM = Integer.parseInt(app_config.get_VMS());

        final long  mips = Integer.parseInt(app_config.get_MIPS());
        final long  ram = Integer.parseInt(app_config.get_RAM());
        final long  bw = Integer.parseInt(app_config.get_BW());
        final long  size = Integer.parseInt(app_config.get_Size());

        for (int b = 0; b < VM; b++) {

            Vm newVm = new VmSimple(mips, VM_PES)
                    .setRam(ram).setBw(bw).setSize(size);
            vmlist.add(newVm);
        }
        broker.submitVmList(vmlist);
    }

    //    for( int i = 0; i < 5; i++)
//
//    {
//       Vm newVm = new VmSimple(mips, VM_PES).setRam(ram).setBw(bw).setSize(size);
//
//    }
    private Datacenter createDatacenter() {
        List<Host> hostList = new ArrayList<>();
        List<Pe> peList = new ArrayList<>();

        //final long mips = 1000;
        //peList.add(new PeSimple(mips, new PeProvisionerSimple()));


        //int Number_of_PES = Integer.parseInt(config.getString("PES"));

        final long  Number_of_PES= Integer.parseInt(app_config.get_PES());

        // final long mips = Integer.parseInt(config.getString("MIPS"));
        final long  mips = Integer.parseInt(app_config.get_MIPS());

        for (int c = 0; c < Number_of_PES; c++) {
            peList.add(new PeSimple(mips, new PeProvisionerSimple()));


        }

//        final int ram = 2048; //host memory (Megabyte)
//        final long storage = 1000000; //host storage
//        final long bw = 10000;

        //final int ram = Integer.parseInt(config.getString("RAM"));
        final long  ram = Integer.parseInt(app_config.get_RAM());
        LOGGER.isDebugEnabled();

        LOGGER.debug("RAM");
        //final long storage = Integer.parseInt(config.getString("STORAGE"));

        final long  storage = Integer.parseInt(app_config.get_Storage());

        //final long bw = Integer.parseInt(config.getString("BW"));

        final long  bw = Integer.parseInt(app_config.get_BW());

        // int Number_of_Hosts = Integer.parseInt(config.getString("HOSTS"));

        final long  Number_of_Hosts = Integer.parseInt(app_config.get_HOSTS());


        for (int d = 0; d < Number_of_Hosts; d++) {
            Host host = new HostSimple(ram, bw, storage, peList);
            hostList.add(host);
        }
//        hostList.add(host);

        return new DatacenterSimple(simulation, hostList, new VmAllocationPolicyFirstFit());
    }

    //We strongly encourage users to develop their own broker policies, to submit vms and cloudlets according
    //to the specific rules of the simulated scenario
    private DatacenterBroker createBroker() {
        return new DatacenterBrokerSimple(simulation);
    }



}

