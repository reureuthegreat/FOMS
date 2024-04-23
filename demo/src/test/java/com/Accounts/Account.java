package com.Accounts;

public abstract class Account {

    private String ID;
    private String Password;
    private String Name;
    private int age;
    private String gender;
    private  Role role;


    public Account() {
    }

    public Account(String ID, String name, int age,Role role, String gender) {
        this.Name = name;
        this.age = age;
        this.gender = gender;
        this.ID = ID;
        this.role = role;
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
    
    public String getName(){
        return this.Name;
    }
    public void setName(String name){
        this.Name = name;
    }
    public int getAge(){
        return this.age;
    }
    public void setAge(int Age){
        this.age = Age;
    }
    public String getGender(){
        return this.gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public Role getRole(){
        return this.role;
    }

    public void setRole(Role role){
        this.role = role;
    }
    public boolean verifyPassword(String inputPassword) {
        return inputPassword.equals(this.Password);
    }

    public boolean verifyID(String inputID) {
        return inputID.equals(this.ID);
    }

    public abstract String getBranchName();
}