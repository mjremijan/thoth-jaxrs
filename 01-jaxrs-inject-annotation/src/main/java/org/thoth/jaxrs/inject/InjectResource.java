package org.thoth.jaxrs.inject;

import java.security.Principal;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("inject")
@RequestScoped
public class InjectResource {

    @Inject
    private InjectMe injectMe;

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getText(@Context SecurityContext context) {
        Principal p = context.getUserPrincipal();
        String retval = "";
        retval += "<!DOCTYPE html>\n";
        retval += "<h3>01-jaxrs-inject-annotation</h3>\n";
        retval += "<h4>Success!</h4>\n";
        retval += "<blockquote>\n";
            retval += String.format("<p>this=[%s]</p>\n", this);
            retval += String.format("<p>injectMe=[%s]</p>\n", injectMe);
        retval += "</blockquote>\n";
        return retval;
    }
}
