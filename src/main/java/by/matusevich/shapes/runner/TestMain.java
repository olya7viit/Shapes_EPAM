package by.matusevich.shapes.runner;

import by.matusevich.shapes.creator.TriangleCreator;
import by.matusevich.shapes.creator.impl.TriangleCreatorImpl;
import by.matusevich.shapes.model.entity.Point;
import by.matusevich.shapes.model.entity.Triangle;
import by.matusevich.shapes.observer.WareHouse;
import by.matusevich.shapes.parser.TriangleParser;
import by.matusevich.shapes.parser.impl.TriangleParserImpl;
import by.matusevich.shapes.reader.TriangleReader;
import by.matusevich.shapes.reader.impl.TriangleReaderImpl;
import by.matusevich.shapes.repository.Specification;
import by.matusevich.shapes.repository.TriangleRepository;
import by.matusevich.shapes.repository.impl.TriangleFirstQuadrantSpecification;
import by.matusevich.shapes.repository.impl.TriangleIdSpecification;
import by.matusevich.shapes.repository.impl.TriangleRepositoryImpl;
import by.matusevich.shapes.exception.*;

import java.util.List;

public class TestMain {
    public static void main(String[] args) throws ReaderException, ParserException, EntityException, ServiceException, WareHouseException, CreatorException {
        TriangleReader triangleReader = new TriangleReaderImpl();
        List<String> triangleLines;
        triangleLines = triangleReader.reedAllData("src/main/resources/file.txt");

        TriangleParser triangleParser = new TriangleParserImpl();
        List<String> correctListTriangles;
        correctListTriangles = triangleParser.parsTriangle(triangleLines);

        TriangleCreator triangleCreator = new TriangleCreatorImpl();
        List<Triangle> triangles;
        triangles = triangleCreator.createTriangles(correctListTriangles);

        TriangleRepository triangleRepository = TriangleRepositoryImpl.getInstance();
        triangleRepository.addAll(triangles);

        System.out.println("Треугольники в репозитории: ");
        for (int i=0;i<triangleRepository.size();i++){
            System.out.println(triangleRepository.get(i));
        }

        WareHouse wareHouse;
        wareHouse = WareHouse.getInstance();
        System.out.println("\nТреугольник 1: ");
        System.out.println(triangleRepository.get(0));
        System.out.println("area: " + wareHouse.getArea(1));
        System.out.println("perimeter: " + wareHouse.getPerimeter(1));

        System.out.println("\nИзмененный треугольник 1: ");
        triangleRepository.get(0).setPoint1(new Point(5,2));
        System.out.println(triangleRepository.get(0));
        System.out.println("area: " + wareHouse.getArea(1));
        System.out.println("perimeter: " + wareHouse.getPerimeter(1));

        System.out.println();
        System.out.println("\nТреугольник id = 2: ");
        Specification idSpecification = new TriangleIdSpecification(2);
        System.out.println(triangleRepository.query(idSpecification));

        System.out.println();
        System.out.println("\nТреугольники все точки которых находятся в первом квадранте: ");
        Specification firstQuadrantSpecification = new TriangleFirstQuadrantSpecification();
        List listTriangles = triangleRepository.query(firstQuadrantSpecification);
        for (Object listTriangle : listTriangles) {
            System.out.println(listTriangle);
        }
    }
}
