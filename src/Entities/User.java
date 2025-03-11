package Entities;

public class User {
    private String Name , Address , PhoneNumber;
    private int Id;

    public User(String name, String address, String phoneNumber, int id) {
        Name = name;
        Address = address;
        PhoneNumber = phoneNumber;
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "User{" +
               "Name='" + Name + '\'' +
               ", Address='" + Address + '\'' +
               ", PhoneNumber='" + PhoneNumber + '\'' +
               ", Id=" + Id +
               '}';
    }
}
