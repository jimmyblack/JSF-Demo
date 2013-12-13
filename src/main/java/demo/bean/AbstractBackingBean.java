// --------------------------------------------------------------------------
// Copyright © 2012 - 2013 Optymyze Pte. Ltd. All Rights Reserved.
// This program belongs to Optymyze Pte. Ltd. It is considered a TRADE SECRET
// and is not to be divulged or used by parties who have not received written
// authorization from Optymyze Pte. Ltd.
// --------------------------------------------------------------------------

package main.java.demo.bean;

import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@RequestScoped
public class AbstractBackingBean {

    @ManagedProperty(value="#{facesContext}")
    private FacesContext context;

    public FacesContext getContext() {
        return context;
    }

    public void setContext(FacesContext context) {
        this.context = context;
    }

}