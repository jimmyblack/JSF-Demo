package demo.component.area;

import javax.faces.component.FacesComponent;
import javax.faces.component.UICommand;
import javax.faces.context.FacesContext;
import java.io.IOException;

@FacesComponent("DemoMap")
public class MapComponent extends UICommand {

    private String current;

    @Override
    public String getFamily() {
        return "Map";
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        super.encodeBegin(context);
    }

    @Override
    public void encodeChildren(FacesContext context) throws IOException {
        super.encodeChildren(context);
    }

    @Override
    public void encodeEnd(FacesContext context) throws IOException {
        super.encodeEnd(context);
    }
}
