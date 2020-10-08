package hw_441;

public class app_config {
    public static java.lang.Integer Integer;

    // public static final Config config_app = ConfigFactory.load("Application.conf");
//    public static final  Config config_simulator = ConfigFactory.load("data_simulation.conf");
//    public static final  Config config_simulator = ConfigFactory.load();
//    public static ResourceBundle applicationconfig;
   // public static String get_CLoudProvider;


    public static final String get_Length()
    {
        return Support.config_simulator.getString("LENGTH");
    }

    public static final String get_MIPS()
    {
        return Support.config_simulator.getString("MIPS");
    }

    public static final String get_RAM()
    {
        return Support.config_simulator.getString("RAM");
    }

    public static final String get_VMS()
    {
        return Support.config_simulator.getString("VMS");
    }

    public static final String get_HOSTS()
    {
        return Support.config_simulator.getString("HOSTS");
    }


    public static final String get_PES()
    {
        return Support.config_simulator.getString("PES");
    }

    public static final String get_BW()
    {
        return Support.config_simulator.getString("BW");
    }


    public static final String get_Num_Of_Cloudlet()
    {
        return Support.config_simulator.getString("NUM_OF_CLOUDLET");
    }

    public static final String get_Number_of_Datacenter()
    {
        return Support.config_simulator.getString("NUM_OF_Datacenter");
    }

    public static final String get_Storage()
    {
        return Support.config_simulator.getString("STORAGE");
    }

    public static final String get_Size()
    {
        return Support.config_simulator.getString("SIZE");
    }

    public static final String get_FileSize()
    {
        return Support.config_simulator.getString("FILESIZE");
    }

    public static final String get_OutputSize()
    {
        return Support.config_simulator.getString("OUTPUTSIZE");
    }
//
    public static final String get_Storage_Cost()
    {
        return Support.config_simulator.getString("costPerStorage");
    }

    public static final String get_Cost_Per_Sec()
    {
        return Support.config_simulator.getString("costPerSec");
    }

    public static final String get_vmConfigs()
    {
        return Support.config_simulator.getString("VM_CONFIGS");
    }

    public static final String get_vm_Policy()
    {
        return Support.config_simulator.getString("VM_Allocation_Policy");
    }

    public static final String get_Simple()
    {
        return Support.config_simulator.getString("Simple");
    }

    public static final String get_vm_Best()
    {
        return Support.config_simulator.getString("Best_Fit");
    }

    public static final String get_vm_Fit()
    {
        return Support.config_simulator.getString("Worst_Fit");
    }

}