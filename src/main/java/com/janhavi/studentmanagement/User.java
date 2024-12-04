package com.janhavi.studentmanagement;


public class User {
    private int id;
    private String name;
    private String email;
    private String password;

    
    public User(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setUsername(String username) {
        this.name = username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
    	
    	
        this.email = email;
    }
    
    public void setPassword(String password) {
    	
    	
        this.password = password;
    }
}
