public class property {
    private final int ID;
    private String name;
    private String location;
    private int price;

    public property(int id, String name, String location, int price) {
        this.ID = id;
        this.name = name;
        this.location = location;
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return ID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return name ;
    }
}
