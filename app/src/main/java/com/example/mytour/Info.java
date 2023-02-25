package com.example.mytour;
import com.google.firebase.database.Exclude;

public class Info {
    private String name;
    private String imageURL;
    private String key;
    private String description;
    private int position;

    public Info(String trim){
        //empty constructor needed
    }
    public Info(int position){
        this.position = position;
    }
    public Info(String name, String imageURL, String Des){
        if (name.trim().equals("")){
            name = "No name";
        }
        this.name = name;
        this.imageURL = imageURL;
        this.description= Des;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String Description){
        this.description = description;
    }

    public String getName(){
        return name;
    }
    public void setName(String Name){
        this.name = name;
    }
    public String getImageURL(){
        return imageURL;
    }
    public void setImageURL(String imageURL){
        this.imageURL = imageURL;
    }
    @Exclude
    public String getKey(){
        return key;
    }
    @Exclude
    public void setKey(String key){
        this.key = key;
    }


}
