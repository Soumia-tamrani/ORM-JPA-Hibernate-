package ma.enset.university.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Patient {
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Id
    private Long id;
    @Column(name = "Nom")
    private String nom;
    @Column(name = "DateNaissance")
    private String dateNaissance;
    @Column(name = "Malade")
    private boolean malade;
    @Column(name = "Score")
    private int score;

}
