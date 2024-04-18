package com.Accounts;

public class Account {

    private String ID;
    private String Password;
    private Personalinfo PersInfo;

    public Account() {
    }

    public Account(String ID, String name, int age, String gender) {
        this.PersInfo = new Personalinfo(name, age, gender);
        this.ID = ID;
        this.Password = "password";
    }


    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public Personalinfo getPersInfo() {
        return this.PersInfo;
    }

    public void setPersInfo(Personalinfo PersInfo) {
        this.PersInfo = PersInfo;
    }

    public boolean verifyPassword(String inputPassword) {
        return inputPassword.equals(this.Password);
    }

    public boolean verifyID(String inputID) {
        return inputID.equals(this.ID);
    }
}