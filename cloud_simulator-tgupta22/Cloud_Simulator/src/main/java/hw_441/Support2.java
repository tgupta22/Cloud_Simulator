package hw_441;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Support2 {


    public static final Config config_app = ConfigFactory.load("Application2.conf");
    public static final Config config_simulator2 = ConfigFactory.load();
}
