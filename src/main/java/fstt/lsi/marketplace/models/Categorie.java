package fstt.lsi.marketplace.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(of= {"nomCat"})
public class Categorie {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long codeCat;
    private String nomCat;

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<Article> articles = new ArrayList<>();
}
