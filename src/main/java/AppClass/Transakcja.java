package AppClass;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Transakcja")
public class Transakcja {

    private int id;
    private LocalDate data;
    private double cenaAuta;
    private String stan;
    private Samochod samochod;
    private Klient klient;
    private Osoba sprzedajacy;

    public Transakcja(int id, LocalDate data, double cenaAuta, String stan) {
        this.id = id;
        this.data = data;
        this.cenaAuta = cenaAuta;
        this.stan = stan;
    }

    public Transakcja() {
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getCenaAuta() {
        return cenaAuta;
    }

    public void setCenaAuta(double cenaAuta) {
        this.cenaAuta = cenaAuta;
    }

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }
    @OneToOne
    public Samochod getSamochod() {
        return samochod;
    }

    public void setSamochod(Samochod samochod) {
        if (this.samochod == null){
            this.samochod = samochod;
            samochod.setTransakcja(this);
        }

    }
    @ManyToOne
    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient klient) {
        if (this.klient == null) {
            this.klient = klient;
            klient.addTransakcja(this);
        }

    }
    @ManyToOne
    public Osoba getSprzedajacy() {
        return sprzedajacy;
    }

    public void setSprzedajacy(Osoba sprzedajacy) {
        if (this.sprzedajacy == null){
            this.sprzedajacy = sprzedajacy;
            sprzedajacy.addSprzedaz(this);
        }

    }
}
