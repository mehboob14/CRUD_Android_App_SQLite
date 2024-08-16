package com.example.crud_app_sql_lite;
public class UserData {
    int _id;
    String _name;
    String _description;
    public UserData(){   }
    public UserData(int id, String name, String description){
        this._id = id;
        this._name = name;
        this._description = description;
    }

    public UserData(String name, String _description){
        this._name = name;
        this._description = _description;
    }
    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    public String getName(){
        return this._name;
    }

    public void setName(String name){
        this._name = name;
    }

    public String get_description(){
        return this._description;
    }

    public void set_description(String _desc){
        this._description = _desc;
    }
}
