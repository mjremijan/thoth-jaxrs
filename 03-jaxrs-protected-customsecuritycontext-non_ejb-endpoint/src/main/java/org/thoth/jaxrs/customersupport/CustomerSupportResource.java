package org.thoth.jaxrs.customersupport;

import java.security.Principal;
import java.util.Arrays;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

@Path("customersupport")
public class CustomerSupportResource {

    @Context
    private UriInfo context;

    public CustomerSupportResource() {
    }

    @GET
    @Path("help")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"GROUP_CUSTOMER_SUPPORTS"})
    public CustomerSupportHelp getHelp(@Context SecurityContext sc) {
        String phone
            = "555-1212";
        String email
            = "help@internet.com";

        StringBuilder sp = new StringBuilder();
        Principal p = sc.getUserPrincipal();
        if (p == null) {
            sp.append("Principal is NULL");
        } else {
            sp.append(String.format("name=\"%s\"", p.getName()));

            Arrays.asList(
                new String[]{"ExecutiveRole", "CustomerSupportRole", "SalaryEmployeeRole"}
            ).forEach(r -> sp.append(String.format(", %s=%b", r, sc.isUserInRole(r))));

            Arrays.asList(
                new String[]{"GROUP_CUSTOMER_SUPPORTS", "GROUP_SALARY_EMPLOYEES", "GROUP_EXECUTIVES"}
            ).forEach(r -> sp.append(String.format(", %s=%b", r, sc.isUserInRole(r))));
        }
        return new CustomerSupportHelp(phone, email, sp.toString());
    }
}
