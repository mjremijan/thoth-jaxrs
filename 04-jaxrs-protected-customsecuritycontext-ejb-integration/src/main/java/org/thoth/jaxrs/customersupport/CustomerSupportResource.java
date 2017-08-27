package org.thoth.jaxrs.customersupport;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.log4j.Logger;

@Path("customersupport")
public class CustomerSupportResource {

    private final Logger log = Logger.getLogger(CustomerSupportResource.class);

    @Inject
    protected CustomerSupportEjb customerSupport;

    public CustomerSupportResource() {
    }

    @GET
    @Path("help")
    @Produces(MediaType.APPLICATION_JSON)
    public CustomerSupportHelp getHelp() {
        log.info("ENTER #getHelp()");
        return customerSupport.getHelp();
    }
}
