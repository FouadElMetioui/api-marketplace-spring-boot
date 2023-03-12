package fstt.lsi.marketplace.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@ToString(of= {"nomArticle","description","prixUnitaire"})
public class Article {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long codeArt;
    private String nomArt;
    private String description;
    private String image;
    private Double prixUnit;
    private int qteStock;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_id", referencedColumnName = "codeCat")
    private Categorie categorie;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Article_Panier> article_Paniers = new ArrayList<>();

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Article_Transaction> article_Transactions = new ArrayList<>();
    public Article(String nomArt, String description, String image, Double prixUnit, int qteStock) {
        this.nomArt = nomArt;
        this.description = description;
        this.image = image;
        this.prixUnit = prixUnit;
        this.qteStock = qteStock;
    }
}
