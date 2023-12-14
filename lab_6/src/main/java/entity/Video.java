package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Videos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Video {
@Id
private String id ;
private String title;
private String poster;
private String description;
private int views;
private  int active;
}
