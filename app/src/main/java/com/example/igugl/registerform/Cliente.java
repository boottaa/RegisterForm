package com.example.igugl.registerform;

public class Cliente {

    private String fname;
    private String lname;
    private String email;
    private String password;

    public Cliente(String fname, String lname, String email, String password){
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
    }

    public static String add(String clienteJson){

        return "{\"method\":\"add\",\"id\":\"1\",\"params\":" + clienteJson + "}";
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "{\"data\":{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"fname\":\"" + fname + "\",\"lname\":\"" + lname + "\"}}";
    }
}
