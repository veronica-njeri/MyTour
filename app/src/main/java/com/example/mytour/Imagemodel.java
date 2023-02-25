package com.example.mytour;

public class Imagemodel {

    public String imageURL;
    public String name;
    public String description;

    public Imagemodel(){

    }

    public Imagemodel(String imageURL,String name, String description){
        this.imageURL = imageURL;
        this.name = name;
        this.description = description;
    }
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}