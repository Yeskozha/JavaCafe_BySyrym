package entities;

public class Products {
    private int id;
    private String pname,price;

    public Products() {
    }

    public Products(int id, String pname, String price) {
        this.id = id;
        this.pname = pname;
        this.price = price;
    }

    public Products(String pname, String price) {
        this.pname = pname;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + price + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
