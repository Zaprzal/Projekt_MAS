package AppClass;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transakcja {

    private int id;
    private LocalDate data;
    private double cenaAuta;
    private String stan;
    @OneToOne
    @JoinColumn(name = "id_samochod")
    private Samochod samochod;
    private Klient klient;
    private Osoba sprzedajacy;


    public void setSamochod(Samochod samochod) {
        if (this.samochod == null){
            this.samochod = samochod;
            samochod.setTransakcja(this);
        }
    }

    public void setKlient(Klient klient) {
        if (this.klient == null) {
            this.klient = klient;
            klient.addTransakcja(this);
        }
    }

    // public void setSprzedajacy(Osoba sprzedajacy) {
    //     if (this.sprzedajacy == null){
    //         this.sprzedajacy = sprzedajacy;
    //         sprzedajacy.addSprzedaz(this);
    //     }
    // }
}
