package shapes.by.matusevich.runner;

import shapes.by.matusevich.creator.TriangleCreator;
import shapes.by.matusevich.creator.impl.TriangleCreatorImpl;
import shapes.by.matusevich.exception.*;
import shapes.by.matusevich.model.entity.Point;
import shapes.by.matusevich.model.entity.Triangle;
import shapes.by.matusevich.observer.WareHouse;
import shapes.by.matusevich.parser.TriangleParser;
import shapes.by.matusevich.parser.impl.TriangleParserImpl;
import shapes.by.matusevich.reader.TriangleReader;
import shapes.by.matusevich.reader.impl.TriangleReaderImpl;
import shapes.by.matusevich.repository.Specification;
import shapes.by.matusevich.repository.TriangleRepository;
import shapes.by.matusevich.repository.impl.TriangleFirstQuadrantSpecification;
import shapes.by.matusevich.repository.impl.TriangleIdSpecification;
import shapes.by.matusevich.repository.impl.TriangleRepositoryImpl;

import java.util.List;

public class TestMain {
    public static void main(String[] args) throws ReaderException, ParserException, CreatorException, EntityException, ServiceException, WareHouseException {
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
        triangleRepository.addAllTriangles(triangles);

        System.out.println("Треугольники в репозитории: ");
        for (int i=0;i<triangleRepository.size();i++){
            System.out.println(triangleRepository.getTriangle(i));
        }

        WareHouse wareHouse;
        wareHouse = WareHouse.getInstance();
        System.out.println("\nТреугольник 1: ");
        System.out.println(triangleRepository.getTriangle(0));
        System.out.println("area: " + wareHouse.getArea(1));
        System.out.println("perimeter: " + wareHouse.getPerimeter(1));

        System.out.println("\nИзмененный треугольник 1: ");
        triangleRepository.getTriangle(0).setPoint1(new Point(5,2));
        System.out.println(triangleRepository.getTriangle(0));
        System.out.println("area: " + wareHouse.getArea(1));
        System.out.println("perimeter: " + wareHouse.getPerimeter(1));

        System.out.println("");
        System.out.println("\nТреугольник id = 2: ");
        Specification idSpecification = new TriangleIdSpecification(2);
        System.out.println(triangleRepository.query(idSpecification));

        System.out.println("");
        System.out.println("\nТреугольники все точки которых находятся в первом квадранте: ");
        Specification firstQuadrantSpecification = new TriangleFirstQuadrantSpecification();
        List listTriangles = triangleRepository.query(firstQuadrantSpecification);
        for (int i=0;i<listTriangles.size();i++){
            System.out.println(listTriangles.get(i));
        }
    }
}
