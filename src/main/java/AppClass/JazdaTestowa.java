package AppClass;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JazdaTestowa {

    private int jazdaId;
    private LocalDate data;
    private int limitKilometrow;
    private Integer ocena = null;
    @ManyToOne
    @JoinColumn(name = "id_klienta")
    private Klient klient;
    @ManyToOne
    private Samochod samochod;

    public void setKlient(Klient klient) {
        if (this.klient == null){
            this.klient = klient;
            klient.addOdbytaJazda(this);
        }

    }

    public void setSamochod(Samochod samochod) {
        if (this.samochod == null){
            this.samochod = samochod;
            samochod.addOdbyteJazdy(this);
        }

    }
}
