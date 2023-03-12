package fstt.lsi.marketplace.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codeUser;
    private String email;
    private String password;
    private String name;
    private String telephone;
    private  String pays;
    private String ville;
    private String address;
    @Column(columnDefinition = "INT DEFAULT 0")
    private int role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Transaction> transaction = new ArrayList<>();

    @OneToOne(mappedBy ="user",cascade = CascadeType.ALL )
    private Panier panier;
}
