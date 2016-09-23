package org.thoth.jaxrs.inject;

import java.io.Serializable;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class InjectMe implements Serializable {

    private static final long serialVersionUID = 158775545474L;

    public String getFoo() {
        return foo;
    }

    public void setFoo(String foo) {
        this.foo = foo;
    }

    private String foo;
}
