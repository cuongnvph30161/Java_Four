package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Videos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Video {
    @Id
    private  String id ;
    private String title;
    private String poster;
    private String description;
    private int views;
    private int active;
    @OneToMany(mappedBy = "video", fetch = FetchType.LAZY)
    private List<Favorite> listFavorite;
}
