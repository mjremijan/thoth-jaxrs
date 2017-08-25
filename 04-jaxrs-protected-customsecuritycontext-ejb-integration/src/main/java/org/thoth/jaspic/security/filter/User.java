package org.thoth.jaspic.security.filter;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class User implements Principal {

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
