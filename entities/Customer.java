package entities;

public class Customer {
    private int id;
    private String pname,phone;

    public Customer() {
    }

    public Customer(int id, String pname, String phone) {
        this.id = id;
        this.pname = pname;
        this.phone = phone;
    }

    public Customer(String name, String phone) {
        this.pname = pname;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return pname;
    }

    public void setName(String pname) {
        this.pname = pname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", product name='" + pname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
