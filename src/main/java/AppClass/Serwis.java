package AppClass;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Serwis {
    @Column(name = "serwis_id")
    @Id
    @GeneratedValue(generator = "increment")
    private Integer id;
    @NonNull
    private Integer aktualnyPrzebieg;
    @NonNull
    private String opis;
    @NonNull
    private LocalDate data;
    @NonNull
    private Double wycena;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="id", orphanRemoval = true)
    private List<Usterka> usterkiDoWykonania = new ArrayList<Usterka>();
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pracownik_serwisant")
    private Serwisant serwisant;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "serwis_samochod")
    private Samochod samochod;



    public void addUsterka(Usterka usterka) {
        if (!this.usterkiDoWykonania.contains(usterka)){
            this.usterkiDoWykonania.add(usterka);
            usterka.setSerwis(this);
        }
    }



    public void setSerwisant(Serwisant serwisant) {
        if(this.serwisant == null){
            this.serwisant = serwisant;
            serwisant.addWykonanySerwis(this);
        }

    }

    public void setSamochod(Samochod samochod) {
        if(this.samochod == null){
            this.samochod = samochod;
            samochod.addSerwisPojazdu(this);
        }

    }
    public String getCarVin(){
        return samochod.getVin();
    }

//    public Serwis(Integer przebieg , String opis , LocalDate dateWykonania , Double wycena) {
//        this.aktualnyPrzebieg = przebieg;
//        this.opis = opis;
//        this.data = dateWykonania;
//        this.wycena = wycena;
//    }
}
