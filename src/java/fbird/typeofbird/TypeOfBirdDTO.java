/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fbird.typeofbird;

/**
 *
 * @author Admin
 */
public class TypeOfBirdDTO {
    int type_of_bird_id;
    String Name;

    public TypeOfBirdDTO() {
    }

    public TypeOfBirdDTO(int type_of_bird_id, String Name) {
        this.type_of_bird_id = type_of_bird_id;
        this.Name = Name;
    }

    public TypeOfBirdDTO(String Name) {
        this.Name = Name;
    }

    public int getType_of_bird_id() {
        return type_of_bird_id;
    }

    public void setType_of_bird_id(int type_of_bird_id) {
        this.type_of_bird_id = type_of_bird_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    
}
