package org.thoth.jaxrs.security.context;

import java.security.Principal;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@Stateless
public class SecurityContextEjb {

    @Resource
    private SessionContext ctx;

    public String getPrincipalName() {
        String name = "UNKNOWN";
        if (ctx == null) {
            name = "CTX is null";
        } else {
            Principal p = ctx.getCallerPrincipal();
            if (p == null) {
                name = "Principal is null";
            } else {
                name = String.format("Principal Name: \"%s\"", p.getName());
            }
        }
        return
            name;
    }
}
