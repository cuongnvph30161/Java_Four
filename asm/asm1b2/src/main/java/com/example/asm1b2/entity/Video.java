package com.example.asm1b2.entity;

public class Video {
    String id ;
    String title;
    String description;
    boolean active;
    String image;

    public Video() {
    }

    public Video(String id, String title, String description, boolean active, String image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.active = active;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", image='" + image + '\'' +
                '}';
    }
}
