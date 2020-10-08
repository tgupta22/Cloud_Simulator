package Mapper_Reducer;

import org.cloudbus.cloudsim.cloudlets.Cloudlet;
import org.cloudsimplus.builders.tables.CloudletsTableBuilder;

public class Time extends CloudletsTableBuilder {
    private static final String TIME_FORMAT = "%.0f";
    private static final String SECONDS = "Seconds";
    private static final String CPU_CORES = "CPU cores";

    public Time(List<? extends Cloudlet> list) {
        super(list);
    }
}
