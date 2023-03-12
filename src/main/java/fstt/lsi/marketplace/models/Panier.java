package fstt.lsi.marketplace.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codePan;
    private int qteItems;
    private Double prixItems;

    @OneToMany(mappedBy = "panier", cascade = CascadeType.ALL)
    private List<Article_Panier> article_Paniers = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "codeUser")
    private User user;
}
