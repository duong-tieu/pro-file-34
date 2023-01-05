package Customer;

public class Customer {
    private String name;
    private String address;
    private String phone;
    private String id;

    public Customer(String name, String address, String phone, String id) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.id = id;
    }

    public Customer(String newName, String newPhone, String newAddress) {
       this.name = newName;
       this.phone = newPhone;
       this.address = newAddress;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
