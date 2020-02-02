package AppClass;
import lombok.*;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Klient extends Osoba{

    private List<JazdaTestowa> odbyteJazdy;
    private List<Usterka> zgloszoneUsterki;
    private List<Transakcja> historiaTransakcji;
    private List<Samochod> listaSamochodow;




    public void addOdbytaJazda(JazdaTestowa odbyta){
        if(!this.odbyteJazdy.contains(odbyta)){
            this.odbyteJazdy.add(odbyta);
            odbyta.setKlient(this);
        }
    }

    public void addZgloszenieUsterki(Usterka usterka){
        if(!this.zgloszoneUsterki.contains(usterka)){
            this.zgloszoneUsterki.add(usterka);
            usterka.setKlient(this);
        }
    }

    public void addTransakcja(Transakcja transakcja) {
        if (!this.historiaTransakcji.contains(transakcja)){
            this.historiaTransakcji.add(transakcja);
            transakcja.setKlient(this);
        }
    }

}
