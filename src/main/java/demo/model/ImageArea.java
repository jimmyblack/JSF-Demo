package demo.model;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ImageArea {

    private String shape;
    private String alt;
    private String coords;

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getCoords() {
        return coords;
    }

    public void setCoords(String coords) {
        this.coords = coords;
    }

    public List<Coord> getCoordList() {
        if ((coords == null) || (coords.length() == 0)) {
            return null;
        }

        String[] coordsArr = coords.split(",");
        List<Coord> coordList = new ArrayList<Coord>();

        for (int idx = 0, max = coords.length(); idx < max; idx=+2) {
            coordList.add(new Coord(Integer.parseInt(coordsArr[idx].trim()), Integer.parseInt(coordsArr[idx + 1].trim())));
        }

        return coordList;
    }

    public void setCoordList(List<Coord> coordList) {
        if ((coordList == null) || (coordList.size() == 0)) {
            return;
        }

        String coordsStr = StringUtils.EMPTY;
        for (Coord coord : coordList) {
            if (!StringUtils.isBlank(coordsStr)) {
                coordsStr += ",";
            }
            coordsStr += coord.getX() + "," + coord.getY();
        }

        this.coords = coordsStr;
    }

}
