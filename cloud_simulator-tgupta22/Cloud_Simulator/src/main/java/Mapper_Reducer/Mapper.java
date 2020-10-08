package Mapper_Reducer;

import org.cloudbus.cloudsim.cloudlets.network.NetworkCloudlet;

/**
 * The NetworkCloudlet Interface already exists in the CloudSim Plus Codebase and we can use that interface to
 implement Mapper and Reducer.
 */


public class Mapper extends NetworkCloudlet {
    public Mapper(long cloudletLength, int PES) {
        super(cloudletLength, PES);
    }
}
