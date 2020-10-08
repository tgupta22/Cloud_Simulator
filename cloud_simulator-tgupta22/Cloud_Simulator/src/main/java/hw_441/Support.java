package hw_441;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * This class majorly deals with config_simulator that is being used by Application.config,
 * which is being used by various functions in app_config to access the values and be able to pass the
 * functions in the hw1 file instead of hard coding the values.
 *
 * Support 2 is similar too, I have 2
 */
public class Support {

    public static final Config config_app = ConfigFactory.load("Application.conf");
    public static final Config config_simulator = ConfigFactory.load();


}
