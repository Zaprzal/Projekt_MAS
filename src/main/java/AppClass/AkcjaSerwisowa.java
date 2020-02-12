package AppClass;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "AkcjaSerwisowa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AkcjaSerwisowa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_akcja")
    private Integer id;
    @NonNull
    private String czynnosci;
    @NonNull
    private LocalDate dataRozpoczecia;
    @NonNull
    private LocalDate dataZakonczenia;
    @ManyToOne
    @JoinColumn(name = "pracownik_serwisant")
    private Serwisant serwisant;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Samochod> naprawioneSamochody;


    public void setSerwisant(Serwisant serwisant) {
        if(this.serwisant==null){
            this.serwisant = serwisant;
            serwisant.addAkcjeSerwisowa(this);
        }
    }

    public void addSamochodWykonanaAkcja(Samochod samochod){
        if(!this.naprawioneSamochody.contains(samochod)){
            this.naprawioneSamochody.add(samochod);
            samochod.addWykonanaAkcjaSerwisowa(this);
        }
    }
}
