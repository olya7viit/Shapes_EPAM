package by.matusevich.shapes.creator.impl;

import by.matusevich.shapes.creator.TriangleCreator;
import by.matusevich.shapes.exception.CreatorException;
import by.matusevich.shapes.exception.EntityException;
import by.matusevich.shapes.exception.ServiceException;
import by.matusevich.shapes.exception.WareHouseException;
import by.matusevich.shapes.model.entity.Triangle;
import by.matusevich.shapes.model.entity.factory.TriangleFactory;

import java.util.ArrayList;
import java.util.List;

public class TriangleCreatorImpl implements TriangleCreator {
    @Override
    public List<Triangle> createTriangles(List<String> correctListTriangles) throws EntityException, CreatorException, ServiceException, WareHouseException {

        if(correctListTriangles == null){
            throw new CreatorException("list is null");
        }

        Triangle tempTriangle;
        List<Triangle> triangleList = new ArrayList<>();

        for (int i=0;i<correctListTriangles.size();i++){
            tempTriangle = TriangleFactory.getInstance().getTriangle(correctListTriangles.get(i));
            triangleList.add(tempTriangle);
        }
        return triangleList;
    }
}
