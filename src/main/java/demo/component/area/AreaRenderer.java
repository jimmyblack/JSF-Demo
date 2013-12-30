package demo.component.area;

import demo.model.ImageArea;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import java.io.IOException;

@FacesRenderer(componentFamily = "Area", rendererType = "demo.component.area.AreaRenderer")
public class AreaRenderer extends Renderer {

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        if ((context == null) || (component == null)) {
            throw new NullPointerException();
        }

        AreaComponent area = (AreaComponent) component;
        ImageArea imageArea = area.getImageArea();

        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("area", area);
        writer.writeAttribute("alt", imageArea.getAlt(), "alt");
        writer.writeAttribute("coords", imageArea.getCoords(), "coords");
        writer.writeAttribute("shape", imageArea.getShape(), "shape");
        writer.endElement("area");
    }


}
