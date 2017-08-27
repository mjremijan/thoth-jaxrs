package org.thoth.jaxrs.customersupport;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class CustomerSupportEjb {

    @Resource
    private SessionContext ctx;

    public CustomerSupportEjb() {
    }

    @RolesAllowed({"GROUP_CUSTOMER_SUPPORTS"})
    public CustomerSupportHelp getHelp() {
        String phone
            = "555-1212";
        String email
            = "help@jaspicapp.com";
        String description
            = "EJB SessionContext Principal name: " + ((ctx.getCallerPrincipal() != null) ? "NULL" : ctx.getCallerPrincipal().getName());

        return new CustomerSupportHelp(phone, email, description);
    }
}
