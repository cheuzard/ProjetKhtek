import java.util.*;


public class Manager {
    /*TODO
    *
    *
    * */

    List<property> sellingList = new ArrayList<>();
    List<property> SoldList = new ArrayList<>();
    private int numOfPropertys = 0;

    public List<property> getSoldList() {
        return SoldList;
    }
    public List<property> getSellingList() {
        return sellingList;
    }
    public Manager() {}

    void addProperty(String name, String location, int price) {
        numOfPropertys++;
        sellingList.add(new property(numOfPropertys, name, location, price));
    }
    void removeFromSelling(int id){
        sellingList.removeIf(property -> property.getId() == id);
    }
    void sellProperty(int id){
        property result = getProperty(id);
        if (result != null){
            removeFromSelling(result);
            SoldList.add(result);
        }
        else {
            throw new NoSuchElementException();
        }
    }

    property getProperty(int id){
        for(property property : sellingList){
            if(property.getId() == id){
                return property;
            }
        }
        return null;
    }
    void removeFromSelling(property target){
        sellingList.remove(target);
    }

}
