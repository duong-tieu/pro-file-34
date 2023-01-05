package Product;

public class Cake {
    private String IdCake;
    private String NameCake;
    private String Type;
    private String Size;
    private double Price;
    final boolean isStock = false;
    private int Stock;

    public Cake(String idCake, String nameCake, String type, String size, double price, int stock) {
        IdCake = idCake;
        NameCake = nameCake;
        Type = type;
        Size = size;
        Price = price;
        Stock = stock;
    }

    public Cake(String name, String id, String type, String size, Double price) {
    }

    public String getIdCake() {
        return IdCake;
    }

    public void setIdCake(String idCake) {
        IdCake = idCake;
    }

    public String getNameCake() {
        return NameCake;
    }

    public void setNameCake(String nameCake) {
        NameCake = nameCake;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public boolean isStock() {
        return isStock;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int stock) {
        Stock = stock;
    }
}

