package org.thoth.jaxrs.application;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.apache.log4j.Logger;
import org.thoth.jersey.server.MyResourceConfig;

@ApplicationPath("rest")
public class MyApplication extends Application {

    private static Logger log = Logger.getLogger(MyResourceConfig.class);

    public MyApplication() {
        super();
        log.info(">>>>>>>> CONFIGURING JAX-RS (Application) <<<<<<<<<<<<<<<");
    }
}
