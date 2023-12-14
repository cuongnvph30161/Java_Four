package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Videos")
public class Video {
    @Id
    String id;
    String title;
    String poster; // là image
    String description;
    Integer views;
    Boolean active;

    @OneToMany(mappedBy = "video", cascade = CascadeType.REMOVE)
    List<Favorite> favorites;

    public Video(){}

    public Video(String id, String title) {
        this.id = id;
        this.title = title;
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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", poster='" + poster + '\'' +
                ", description='" + description + '\'' +
                ", views=" + views +
                ", active=" + active +
                ", favorites=" + favorites +
                '}';
    }
}
