package euro2016;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gabi
 */
public class Users {
    private String user_id;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String department;

    public Users(String user_id, String password, String name, String surname) {
        this.user_id = user_id;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public Users() {
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    

    public String getUser_id() {
        return user_id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }
    
    
}
