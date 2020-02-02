package AppClass;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity(name = "Usterka")
public class Usterka {

    private Integer id;
    private LocalDate data;
    private String opis;
    private String rodzaj;
    private Klient klient;
    private Serwis serwis;


    public Usterka(LocalDate data, String opis, String rodzaj) {
        this.data = data;
        this.opis = opis;
        this.rodzaj = rodzaj;
    }

    public Usterka() {
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @ManyToOne
    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        if (this.klient == null){
            this.klient = klient;
            klient.addZgloszenieUsterki(this);
        }

    }
    @ManyToOne
    public Serwis getSerwis() {
        return serwis;
    }

    public void setSerwis(Serwis serwis) {
        if (this.serwis == null){
            this.serwis = serwis;
            serwis.addUsterka(this);
        }

    }
}
