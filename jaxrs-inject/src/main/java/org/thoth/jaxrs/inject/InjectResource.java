package org.thoth.jaxrs.inject;

import java.security.Principal;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

/**
 * REST Web Service
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@Path("inject")
public class InjectResource {

    @Inject
    private InjectMe injectMe;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getText(@Context SecurityContext context) {
        Principal p = context.getUserPrincipal();
        String retval = "";
        retval += "<!DOCTYPE html>\n";
        retval += "<h3>Thoth</h3>\n";
        retval += "<h4>jaxrs-inject</h4>\n";
        retval += String.format("<p>injectMe=[%s]</p>\n", injectMe);
        return retval;
    }

}
