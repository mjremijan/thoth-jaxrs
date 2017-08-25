package org.thoth.jaxrs.security.principal;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

public class MyPrincipal implements Principal {

    private String name;
    private List<String> role;

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = Collections.unmodifiableList(role);
    }

}
