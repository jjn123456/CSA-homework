package com.example.next_studymain;

public class Food {
    private String name;
    private int imageId;

    public Food(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}
