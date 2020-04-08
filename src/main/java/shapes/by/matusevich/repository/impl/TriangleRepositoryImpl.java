package shapes.by.matusevich.repository.impl;

import shapes.by.matusevich.model.entity.Triangle;
import shapes.by.matusevich.repository.Specification;
import shapes.by.matusevich.repository.TriangleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleRepositoryImpl implements TriangleRepository {

    private static final TriangleRepositoryImpl INSTANCE = new TriangleRepositoryImpl();
    private List<Triangle> triangles = new ArrayList<>();


    private TriangleRepositoryImpl(){}

    public static TriangleRepositoryImpl getInstance(){
        return INSTANCE;
    }

    @Override
    public boolean addTriangle(Triangle triangle){
        return triangles.add(triangle);
    }

    @Override
    public boolean addAllTriangles(List<Triangle> triangleList) {
        return triangles.addAll(triangleList);
    }

    @Override
    public Triangle getTriangle(int index){
        return triangles.get(index);
    }

    @Override
    public boolean removeTriangle(Triangle triangle){
        return triangles.remove(triangle);
    }

    @Override
    public int size(){
        return triangles.size();
    }

    @Override
    public List<Triangle> query(Specification specification){
        List<Triangle> list = triangles.stream().filter(specification).collect(Collectors.toList());
        return list;
    }

}
