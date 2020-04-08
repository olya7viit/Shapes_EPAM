package shapes.by.matusevich.observer;

import shapes.by.matusevich.exception.ServiceException;
import shapes.by.matusevich.exception.WareHouseException;

import java.util.List;

public interface TriangleObservable {

    void attach(List<TriangleObserver> observers);

    void detach(TriangleObserver observer);

    void notifyObservers() throws ServiceException, WareHouseException;
}
/*
  for (int i=0;i<observers.size();i++){
            if(observers.get(i) != null){
                observers.get(i).triangleUpdate(this);
            }
        }
        
        private void initializeObservers(){
        observers.add(new PerimeterTriangleObserver());
        observers.add(new AreaTriangleObserver());
    }

 */
