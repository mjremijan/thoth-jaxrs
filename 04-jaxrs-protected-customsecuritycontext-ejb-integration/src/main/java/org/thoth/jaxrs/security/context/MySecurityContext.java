package org.thoth.jaxrs.security.context;

import java.security.Principal;
import javax.ws.rs.core.SecurityContext;
import org.thoth.jaxrs.security.principal.MyPrincipal;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class MySecurityContext implements SecurityContext {
    private MyPrincipal user;
    private String scheme;

    public MySecurityContext(MyPrincipal user, String scheme) {
        this.user = user;
        this.scheme = scheme;
    }

    @Override
    public Principal getUserPrincipal() {return this.user;}

    @Override
    public boolean isUserInRole(String s) {
        if (user.getRole() != null) {
            return user.getRole().contains(s);
        }
        return false;
    }

    @Override
    public boolean isSecure() {return "https".equals(this.scheme);}

    @Override
    public String getAuthenticationScheme() {
        return SecurityContext.BASIC_AUTH;
    }
}