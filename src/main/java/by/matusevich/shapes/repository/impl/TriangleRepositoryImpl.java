package by.matusevich.shapes.repository.impl;

import by.matusevich.shapes.model.entity.Triangle;
import by.matusevich.shapes.repository.Specification;
import by.matusevich.shapes.repository.TriangleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleRepositoryImpl implements TriangleRepository {

    private final static TriangleRepositoryImpl INSTANCE = new TriangleRepositoryImpl();
    private List<Triangle> triangles = new ArrayList<>();


    private TriangleRepositoryImpl(){}

    public static TriangleRepositoryImpl getInstance(){
        return INSTANCE;
    }

    @Override
    public boolean add(Triangle triangle){
        return triangles.add(triangle);
    }

    @Override
    public boolean addAll(List<Triangle> triangleList) {
        return triangles.addAll(triangleList);
    }

    @Override
    public Triangle get(int index){
        return triangles.get(index);
    }

    @Override
    public boolean remove(Triangle triangle){
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
