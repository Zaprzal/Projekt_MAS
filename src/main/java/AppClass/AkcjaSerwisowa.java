package AppClass;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
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
    private List<String> czynnosci = new ArrayList<String>();
    @NonNull
    private List<String> modeleObjete = new ArrayList<String>();
    @NonNull
    private LocalDate dataRozpoczecia;
    @NonNull
    private LocalDate dataZakonczenia;
    @ManyToOne
    @JoinColumn(name = "pracownik_serwisant")
    private Serwisant serwisant;
    @ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "akcja_samochod",
			joinColumns = { @JoinColumn(name = "id_akcja") },
			inverseJoinColumns = { @JoinColumn(name = "id_samochod") }
	)
    private List<Samochod> listaWykonanych = new ArrayList<Samochod>();


    public void setSerwisant(Serwisant serwisant) {
        if(this.serwisant==null){
            this.serwisant = serwisant;
            serwisant.addAkcjeSerwisowa(this);
        }
    }

    public void addSamochodWykonany(Samochod samochod){
        if(!this.listaWykonanych.contains(samochod)){
            this.listaWykonanych.add(samochod);
            samochod.addWykonanaAkcjaSerwisowa(this);
        }
    }
}
