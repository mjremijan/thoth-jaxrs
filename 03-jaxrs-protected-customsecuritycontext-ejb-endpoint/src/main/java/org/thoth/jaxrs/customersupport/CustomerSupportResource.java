package org.thoth.jaxrs.customersupport;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("customersupport")
@Stateless
public class CustomerSupportResource {

    @Context
    private UriInfo context;

    public CustomerSupportResource() {
    }

    @GET
    @Path("help")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"GROUP_CUSTOMER_SUPPORTS"})
    public CustomerSupportHelp getHelp() {
        String phone
            = "555-1212";
        String email
            = "help@internet.com";
        String description
            = "method has no parameter";
        return new CustomerSupportHelp(phone, email, description);
    }
}
