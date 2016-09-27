package org.thoth.jaxrs.inject;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class InjectMe implements Serializable {

    private static final long serialVersionUID = 158775545474L;

    private String foo;

    public String getFoo() {
        return foo;
    }
    public void setFoo(String foo) {
        this.foo = foo;
    }
}
