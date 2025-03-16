package Entities;

public class User {
    private String name, address, phoneNumber;
    private int id;

    public User( int id ,String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
               "Name='" + name + '\'' +
               ", Address='" + address + '\'' +
               ", PhoneNumber='" + phoneNumber + '\'' +
               ", Id=" + id +
               '}';
    }
}
