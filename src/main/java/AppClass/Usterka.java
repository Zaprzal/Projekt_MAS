package AppClass;
import lombok.*;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usterka {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @NonNull
    private LocalDate data;
    @NonNull
    private String opis;
    @NonNull
    private String rodzaj;
    @ManyToOne
    @JoinColumn(name = "id_klienta")
    private Klient klient;
    @ManyToOne
    @JoinColumn(name = "serwis_usterki")
    private Serwis serwis;



    public void setKlient(Klient klient) {
        if (this.klient == null){
            this.klient = klient;
            klient.addZgloszenieUsterki(this);
        }
    }

     public void setSerwis(Serwis serwis) {
         if (this.serwis == null){
             this.serwis = serwis;
             serwis.addUsterka(this);
         }
     }
}
