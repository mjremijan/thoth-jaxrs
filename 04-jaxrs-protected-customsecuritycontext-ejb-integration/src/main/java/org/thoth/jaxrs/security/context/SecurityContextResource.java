package org.thoth.jaxrs.security.context;

import java.security.Principal;
import java.util.Arrays;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

@Path("securityContext")
@Stateless
public class SecurityContextResource {

    @Inject
    protected SecurityContextEjb ejb;

    public SecurityContextResource() {
    }

    @GET
    @Path("details")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public String getContract(@Context SecurityContext securityContext) {
        StringBuilder sp = new StringBuilder();
        Principal p = securityContext.getUserPrincipal();
        if (p == null) {
            sp.append("Principal is NULL");
        } else {
            sp.append(String.format("name=\"%s\"", p.getName()));

            Arrays.asList(
                new String[]{"ExecutiveRole", "CustomerSupportRole", "SalaryEmployeeRole"}
            ).forEach(r -> sp.append(String.format(", %s=%b", r, securityContext.isUserInRole(r))));

            Arrays.asList(
                new String[]{"GROUP_CUSTOMER_SUPPORTS", "GROUP_SALARY_EMPLOYEES", "GROUP_EXECUTIVES"}
            ).forEach(r -> sp.append(String.format(", %s=%b", r, securityContext.isUserInRole(r))));
        }
        return sp.toString();
    }

    @GET
    @Path("principalName")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    public String getPrincipalName() {
        return ejb.getPrincipalName();
    }
}
