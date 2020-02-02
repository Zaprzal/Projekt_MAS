package AppClass;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity(name = "JazdaTestowa")
public class JazdaTestowa {

    private int jazdaId;
    private LocalDate data;
    private int limitKilometrow;
    private Integer ocena = null;
    private Klient klient;
    private Samochod samochod;

    public JazdaTestowa(int id, LocalDate data, int limitKilometrow) {
        this.jazdaId = id;
        this.data = data;
        this.limitKilometrow = limitKilometrow;
    }

    public JazdaTestowa(){
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public int getJazdaId() {
        return jazdaId;
    }

    public void setJazdaId(int id) {
        this.jazdaId = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getLimitKilometrow() {
        return limitKilometrow;
    }

    public void setLimitKilometrow(int limitKilometrow) {
        this.limitKilometrow = limitKilometrow;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    @ManyToOne
    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        if (this.klient == null){
            this.klient = klient;
            klient.addOdbytaJazda(this);
        }

    }
    @ManyToOne
    public Samochod getSamochod() {
        return samochod;
    }

    public void setSamochod(Samochod samochod) {
        if (this.samochod == null){
            this.samochod = samochod;
            samochod.addOdbyteJazdy(this);
        }

    }
}
