package shapes.by.matusevich.creator.impl;

import shapes.by.matusevich.creator.TriangleCreator;
import shapes.by.matusevich.exception.CreatorException;
import shapes.by.matusevich.exception.EntityException;
import shapes.by.matusevich.model.entity.Triangle;
import shapes.by.matusevich.model.entity.TriangleFactory;

import java.util.ArrayList;
import java.util.List;

public class TriangleCreatorImpl implements TriangleCreator {
    @Override
    public List<Triangle> createTriangles(List<String> correctListTriangles) throws EntityException, CreatorException {

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
