package demo.component.area;

import demo.component.AbstractRenderer;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import java.io.IOException;

@FacesRenderer(componentFamily = "Map", rendererType = "demo.component.area.MapRenderer")
public class MapRenderer extends AbstractRenderer {

    @Override
    public void decode(FacesContext context, UIComponent component) {
        if ((context == null) || (component == null)) {
            throw new NullPointerException();
        }

        MapComponent map = (MapComponent) component;
        String key = getName(context, map);
        String value = (String) context.getExternalContext().getRequestParameterMap().get(key);

        if (value != null) {
            map.setCurrent(value);
        }
    }

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        if ((context == null) || (component == null)) {
            throw new NullPointerException();
        }

        MapComponent map = (MapComponent) component;
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("map", map);
        writer.writeAttribute("name", map.getId(), "id");
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        if ((context == null) || (component == null)) {
            throw new NullPointerException();
        }

        MapComponent map = (MapComponent) component;
        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("input", map);
        writer.writeAttribute("type", "hidden", null);
        writer.writeAttribute("name", getName(context, map), "clientId");
        writer.endElement("input");
        writer.endElement("map");
    }

}
