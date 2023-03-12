package fstt.lsi.marketplace.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article_Panier {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Double prix;
    private int quantite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id", referencedColumnName = "codeArt")
    private Article article;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "panier_id", referencedColumnName = "codePan")
    private Panier panier;
}
