/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.user;

/**
 *
 * @author louis
 */
public class UserDTO {
    String username, password;
    int role, status;

    public UserDTO() {
    }

    public UserDTO(String username, String password, int role, int status) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }
    
    public UserDTO(String username, int role, int status) {
        this.username = username;
        this.role = role;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
}
