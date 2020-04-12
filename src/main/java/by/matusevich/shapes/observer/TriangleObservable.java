package by.matusevich.shapes.observer;

import by.matusevich.shapes.exception.ServiceException;
import by.matusevich.shapes.exception.WareHouseException;

import java.util.List;

public interface TriangleObservable {

    void attach(List<TriangleObserver> observers);

    void detach(TriangleObserver observer);

    void notifyObservers() throws ServiceException, WareHouseException;
}

