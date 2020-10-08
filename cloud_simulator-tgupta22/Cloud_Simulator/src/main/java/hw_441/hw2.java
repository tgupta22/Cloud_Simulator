package hw_441;

import com.typesafe.config.Config;
import org.cloudbus.cloudsim.allocationpolicies.VmAllocationPolicyBestFit;
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
import org.cloudbus.cloudsim.utilizationmodels.UtilizationModelFull;
import org.cloudbus.cloudsim.vms.Vm;
import org.cloudbus.cloudsim.vms.VmSimple;
import org.cloudsimplus.builders.tables.CloudletsTableBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class hw2 {


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
        new hw2();
    }

    private hw2() {
        /*Enables just some level of log messages.
          Make sure to import org.cloudsimplus.util.Log;*/
        //Log.setLevel(ch.qos.logback.classic.Level.WARN);

        System.out.println("Starting " + getClass().getSimpleName());

        //List<? extends Config>  datacentersConfig = app_config.config_simulator.getConfigList(app_constants.Provider_Cloud);

//        List<? extends Config>  datacentersConfig = app_config.config_simulator.getConfigList(app_config.get_CLoudProvider);

        vmlist = new ArrayList<>();
        cloudletList = new ArrayList<>();
        datacenterList = new ArrayList<>();
        simulation = new CloudSim();

        //int Data_Centers = Integer.parseInt(config.getString("NUM_OF_Datacenter"));

        int Data_Centers = Integer.parseInt(app_config2.get_Number_of_Datacenter());

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

        final long length = Integer.parseInt(app_config2.get_Length());

        // final long length = 40000;
//        final long fileSize = 300;
//        final long outputSize = 300;

        final long fileSize = Integer.parseInt(app_config2.get_FileSize());
        final long outputSize = Integer.parseInt(app_config2.get_OutputSize());

        final UtilizationModel utilizationModel = new UtilizationModelFull();

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
        final long  Num_CloudLet = Integer.parseInt(app_config2.get_Num_Of_Cloudlet());

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

        final long  VM = Integer.parseInt(app_config2.get_VMS());

        final long  mips = Integer.parseInt(app_config2.get_MIPS());
        final long  ram = Integer.parseInt(app_config2.get_RAM());
        final long  bw = Integer.parseInt(app_config2.get_BW());
        final long  size = Integer.parseInt(app_config2.get_Size());

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

        final long  Number_of_PES= Integer.parseInt(app_config2.get_PES());

        // final long mips = Integer.parseInt(config.getString("MIPS"));
        final long  mips = Integer.parseInt(app_config2.get_MIPS());

        for (int c = 0; c < Number_of_PES; c++) {
            peList.add(new PeSimple(mips, new PeProvisionerSimple()));
        }

//        final int ram = 2048; //host memory (Megabyte)
//        final long storage = 1000000; //host storage
//        final long bw = 10000;

        //final int ram = Integer.parseInt(config.getString("RAM"));
        final long  ram = Integer.parseInt(app_config2.get_RAM());

        //final long storage = Integer.parseInt(config.getString("STORAGE"));

        final long  storage = Integer.parseInt(app_config2.get_Storage());

        //final long bw = Integer.parseInt(config.getString("BW"));

        final long  bw = Integer.parseInt(app_config2.get_BW());

        // int Number_of_Hosts = Integer.parseInt(config.getString("HOSTS"));

        final long  Number_of_Hosts = Integer.parseInt(app_config2.get_HOSTS());


        for (int d = 0; d < Number_of_Hosts; d++) {
            Host host = new HostSimple(ram, bw, storage, peList);
            hostList.add(host);
        }
//        hostList.add(host);

        return new DatacenterSimple(simulation, hostList, new VmAllocationPolicyBestFit());
    }

    //We strongly encourage users to develop their own broker policies, to submit vms and cloudlets according
    //to the specific rules of the simulated scenario
    private DatacenterBroker createBroker() {
        return new DatacenterBrokerSimple(simulation);
    }


}

