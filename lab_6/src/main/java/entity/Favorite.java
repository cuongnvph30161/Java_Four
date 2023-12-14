package entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "Favorites")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date likedate;
    @ManyToOne()
    @JoinColumn(name = "userid", referencedColumnName = "id")
    private User user;
    @ManyToOne()
    @JoinColumn(name = "videoid", referencedColumnName = "id")
    private Video video;

}
