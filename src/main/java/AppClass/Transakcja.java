package AppClass;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Transakcja {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private LocalDate data;
    private double cenaAuta;
    private String stan;
    @OneToOne
    @JoinColumn(name = "id_samochod")
    private Samochod samochod;
    @ManyToOne
    @JoinColumn(name = "id_klient")
    private Klient klient;
    @ManyToOne
    @JoinColumn(name = "id_sprzedajacy")
    private Pracownik sprzedajacy;


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

     public void setSprzedajacy(Pracownik sprzedajacy) {
         if (this.sprzedajacy == null){
             this.sprzedajacy = sprzedajacy;
             sprzedajacy.addSprzedaz(this);
         }
     }
}
