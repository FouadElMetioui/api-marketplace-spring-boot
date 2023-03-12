package fstt.lsi.marketplace.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codeTra;
    private Double ttc;
    private Date dateTransa;

    @OneToMany(mappedBy = "transaction", cascade = CascadeType.ALL)
    private List<Article_Transaction> article_Transactions = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "codeUser")
    private User user;
}
