package org.thoth.jersey.server;

import javax.ws.rs.ApplicationPath;
import org.apache.log4j.Logger;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

@ApplicationPath("jersey")
public class MyResourceConfig  extends org.glassfish.jersey.server.ResourceConfig {

    private static Logger log = Logger.getLogger(MyResourceConfig.class);
    public MyResourceConfig() {
        super();
        log.info(">>>>>>>> CONFIGURING JAX-RS (MyResourceConfig) <<<<<<<<<<<<<<<");
        register(RolesAllowedDynamicFeature.class);
        super.packages(true, "org.thoth.jaxrs");
    }
}
