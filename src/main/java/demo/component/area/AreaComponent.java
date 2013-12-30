package demo.component.area;

import demo.model.ImageArea;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIOutput;

@FacesComponent("DemoArea")
public class AreaComponent extends UIOutput {

    private ImageArea imageArea;

    enum PropertyKeys {
        alt, coords, shape, targetImage;
    }
    public String getShape() {
        return (String) getStateHelper().eval(PropertyKeys.shape, null);
    }

    public void setShape(String shape) {
        getStateHelper().put(PropertyKeys.shape, shape);
    }

    public String getAlt() {
        return (String) getStateHelper().eval(PropertyKeys.alt, null);
    }

    public void setAlt(String alt) {
        getStateHelper().put(PropertyKeys.alt, alt);
    }

    public String getCoords() {
        return (String) getStateHelper().eval(PropertyKeys.coords, null);
    }

    public void setCoords(String coords) {
        getStateHelper().put(PropertyKeys.coords, coords);
    }

    public ImageArea getImageArea() {
        return imageArea;
    }

    public void setImageArea(ImageArea imageArea) {
        this.imageArea = imageArea;
    }

}
