package org.thoth.jaspic.security.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import org.apache.log4j.Logger;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@Provider
@PreMatching
public class AuthFilter implements ContainerRequestFilter {

    private static final Logger log = Logger.getLogger(AuthFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        log.info("ENTER #filter()");

        String scheme = requestContext.getUriInfo().getRequestUri().getScheme();

        String name = "thoth-jaspic-usr";

        List<String> roles = Arrays.asList("GROUP_CUSTOMER_SUPPORTS,GROUP_SALARY_EMPLOYEES".split(","));

        User user = new User();
        user.setName(name);
        user.setRole(roles);

        MyApplicationSecurityContext sc
            = new MyApplicationSecurityContext(user, scheme);

        log.info(String.format("Setting security context"));
        requestContext.setSecurityContext(sc);
    }

}
