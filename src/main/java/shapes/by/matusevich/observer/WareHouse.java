package shapes.by.matusevich.observer;

import shapes.by.matusevich.exception.WareHouseException;

import java.util.HashMap;
import java.util.Map;

public class WareHouse {

    private Map<Long, Double> perimeters = new HashMap<>();
    private Map<Long, Double> areas = new HashMap<>();

    private static final WareHouse INSTANCE = new WareHouse();

    private WareHouse(){}

    public static WareHouse getInstance(){
        return INSTANCE;
    }

    public void savePerimeter(long id, double perimeter) throws WareHouseException {
        if(perimeter<=0){
            throw new WareHouseException("negative perimeter");
        }
        perimeters.put(id, perimeter);
    }

    public void saveArea(long id, double area) throws WareHouseException {
        if(area<=0){
            throw new WareHouseException("negative area");
        }
        areas.put(id, area);
    }

    public double getPerimeter(long id){
        return perimeters.getOrDefault(id, 0.);
    }

    public double getArea(long id){
        return areas.getOrDefault(id, 0.);
    }

}
