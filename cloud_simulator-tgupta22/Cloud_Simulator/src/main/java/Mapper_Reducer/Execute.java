package Mapper_Reducer;


import com.typesafe.config.Config;
import org.cloudbus.cloudsim.brokers.DatacenterBroker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;



/**
 *
 *  The class execute is the class that enables the working of Mapper & Reducer Class.
 */
public class Execute {

    private static final Logger LOGGER = LoggerFactory.getLogger(Execute.class);
    private Config config;
    private DatacenterBroker datacenterBroker;
    private Helper help;

    private List<Mapper> mappers;
    private List<Reducer> reducers;

    public Execute(Config config, DatacenterBroker datacenterBroker) {
        this.config = config;
        this.datacenterBroker = datacenterBroker;
    }


    /**
     * This method generates cloudlets corresponding to the job.
     *
     */

    public void submitJob() throws Exception {

        ArrayList<Object> cloudlets = new ArrayList<Object>();

        LOGGER.info("Get reducers and mappers from the resource manager");

        List<Mapper> mappers = getMappers();
        List<Reducer> reducers = getReducers();



    }

    public List<Mapper> getMappers() {
        return mappers;
    }

    /**
     * Workers as Getters and setters for mapper and reducer.
     * @param mappers
     */
    public void setMappers(List<Mapper> mappers) {
        this.mappers = mappers;
    }

    public List<Reducer> getReducers() {
        return reducers;
    }

    public void setReducers(List<Reducer> reducers) {
        this.reducers = reducers;
    }
}