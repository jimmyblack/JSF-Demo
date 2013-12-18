// --------------------------------------------------------------------------
// Copyright © 2012 - 2013 Optymyze Pte. Ltd. All Rights Reserved.
// This program belongs to Optymyze Pte. Ltd. It is considered a TRADE SECRET
// and is not to be divulged or used by parties who have not received written
// authorization from Optymyze Pte. Ltd.
// --------------------------------------------------------------------------

package demo.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class UITools {

    public static void addErrorMessage(FacesContext context, String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        context.addMessage(null, facesMsg);
    }

    public static void addSuccessMessage(FacesContext context, String msg) {
        FacesMessage facesMsg = new FacesMessage(msg, msg);
        context.addMessage(null, facesMsg);
    }

}