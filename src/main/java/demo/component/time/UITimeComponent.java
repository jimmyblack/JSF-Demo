// --------------------------------------------------------------------------
// Copyright © 2012 - 2013 Optymyze Pte. Ltd. All Rights Reserved.
// This program belongs to Optymyze Pte. Ltd. It is considered a TRADE SECRET
// and is not to be divulged or used by parties who have not received written
// authorization from Optymyze Pte. Ltd.
// --------------------------------------------------------------------------

package demo.component.time;


import demo.util.UIConstants;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Bogdan Buzac
 * @since 2013.12.12
 *
 */
@FacesComponent(value = "timeCC")
public class UITimeComponent extends UIComponentBase {

    private static final String COMPONENT_TYPE = "timeCC";

    @Override
    public String getFamily() {
        return COMPONENT_TYPE;
    }

    @Override
    public void encodeAll(FacesContext context) throws IOException {
        ResponseWriter writer = context.getResponseWriter();

        writer.startElement(UIConstants.SPAN_TAG, this);
        writer.writeAttribute("id", getClientId(context), null);
        writer.writeAttribute("class", "timeCC", null);

        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm  dd.MM.yyyy");
        String formattedDate = sdf.format(new Date());
        writer.writeText(formattedDate, null);

        writer.endElement(UIConstants.SPAN_TAG);
    }

}