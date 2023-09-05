package com.example.recyclerview_update_delete_insert;

public class Contact_Structure {
    int img;
    String number,name;

    public Contact_Structure(int img, String name , String number){
        this.img = img;
        this.number = number;
        this.name = name;
    }
    public Contact_Structure( String number , String name){
        this.number = number;
        this.name = name;}
}
