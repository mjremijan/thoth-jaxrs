package org.thoth.jaspic.executive;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
@Stateless
public class ExecutiveBusinessRules {

    @Resource
    private SessionContext ctx;

    @RolesAllowed({"ExecutiveRole", "GROUP_EXECUTIVES"})
    public ExecutiveContract getContract() {
        String name
            = (ctx.getCallerPrincipal() != null) ? "NULL" : ctx.getCallerPrincipal().getName();;
        return new ExecutiveContract("Red Book ("+name+")", 1000000D);
    }
}
