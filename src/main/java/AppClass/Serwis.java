package AppClass;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Serwis")
public class Serwis {

    private Integer id;
    private int aktualnyPrzebieg;
    private LocalDate data;
    private double wycena;
    private String opis;
    private List<Usterka> usterkiDoWykonania = new ArrayList<Usterka>();
    private Serwisant serwisant;
    private Samochod samochod;

    public Serwis(int aktualnyPrzebieg, LocalDate data, double wycena, List<String> wykonaneCzynnosci) {
        this.aktualnyPrzebieg = aktualnyPrzebieg;
        this.data = data;
        this.wycena = wycena;
//        this.wykonaneCzynnosci = wykonaneCzynnosci;
    }

    public Serwis() {
    }

    public int getAktualnyPrzebieg() {
        return aktualnyPrzebieg;
    }

    public void setAktualnyPrzebieg(int aktualnyPrzebieg) {
        this.aktualnyPrzebieg = aktualnyPrzebieg;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getWycena() {
        return wycena;
    }

    public void setWycena(double wycena) {
        this.wycena = wycena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
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

    @OneToMany
    public List<Usterka> getUsterkiDoWykonania() {
        return usterkiDoWykonania;
    }

    public void setUsterkiDoWykonania(List<Usterka> usterkiDoWykonania) {
        this.usterkiDoWykonania = usterkiDoWykonania;
    }

    public void addUsterka(Usterka usterka) {
        if (!this.usterkiDoWykonania.contains(usterka)){
            this.usterkiDoWykonania.add(usterka);
//            usterka.setSerwis(this);
        }
    }
    @ManyToOne
    public Serwisant getSerwisant() {
        return serwisant;
    }

    public void setSerwisant(Serwisant serwisant) {
        if(this.serwisant == null){
            this.serwisant = serwisant;
//            serwisant.addWykonanySerwis(this);
        }

    }


    @ManyToOne
    public Samochod getSamochod() {
        return samochod;
    }

    public void setSamochod(Samochod samochod) {
        if(this.samochod == null){
            this.samochod = samochod;
//            samochod.addSerwisPojazdu(this);
        }

    }
}
