// --------------------------------------------------------------------------
// Copyright © 2012 - 2013 Optymyze Pte. Ltd. All Rights Reserved.
// This program belongs to Optymyze Pte. Ltd. It is considered a TRADE SECRET
// and is not to be divulged or used by parties who have not received written
// authorization from Optymyze Pte. Ltd.
// --------------------------------------------------------------------------

package main.java.demo.component.time;


import main.java.demo.component.util.UITags;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import java.io.IOException;
import java.util.Date;

@FacesComponent(value = "timeComponent")
public class UITimeComponent extends UIComponentBase {

    @Override
    public String getFamily() {
        return null;
    }

    @Override
    public void encodeAll(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();

        writer.startElement(UITags.DIV_TAG, this);
        writer.writeAttribute("id", getClientId(context), null);
        writer.writeAttribute("style", "color: red", null);
        writer.writeText("the time is: " + new Date(), null);
        writer.endElement(UITags.DIV_TAG);
    }

}