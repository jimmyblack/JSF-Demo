package demo.component;

import demo.component.area.MapComponent;

import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;

public abstract class AbstractRenderer extends Renderer {

    protected String getName(FacesContext context, MapComponent map) {
        return null;
    }

}
