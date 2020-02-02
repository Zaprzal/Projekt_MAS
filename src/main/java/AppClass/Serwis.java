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
    private LocalDate data;
    @NonNull
    private Double wycena;
    private List<String> wykonaneCzynnosci = new ArrayList<String>();
    @NonNull
    private List<Usterka> usterkiDoWykonania = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "pracownik_serwisant")
    private Serwisant serwisant;
    @ManyToOne
    @JoinColumn(name = "serwis_samochod")
    private Samochod samochod;


//    @OneToMany
//    public List<Usterka> getUsterkiDoWykonania() {
//        return usterkiDoWykonania;
//    }
//
//    public void setUsterkiDoWykonania(List<Usterka> usterkiDoWykonania) {
//        this.usterkiDoWykonania = usterkiDoWykonania;
//    }
//
//    public void addUsterka(Usterka usterka) {
//        if (!this.usterkiDoWykonania.contains(usterka)){
//            this.usterkiDoWykonania.add(usterka);
//            usterka.setSerwis(this);
//        }
//    }



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
}
