package org.thoth.jaxrs.customersupport;

public class CustomerSupportHelp {
    protected String phone, email, description;

    public CustomerSupportHelp(String phone, String email, String description) {
        this.phone = phone;
        this.email = email;
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

}
