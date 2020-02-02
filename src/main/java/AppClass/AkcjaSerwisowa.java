package AppClass;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "AkcjaSerwisowa")
public class AkcjaSerwisowa {

    private Integer id;
    private List<String> czynnosci = new ArrayList<String>();
    private List<String> modeleObjete = new ArrayList<String>();
    private LocalDate dataRozpoczecia;
    private LocalDate dataZakonczenia;
    private Serwisant serwisant;
    private List<Samochod> listaWykonanych = new ArrayList<Samochod>();

    public AkcjaSerwisowa(List<String> czynnosci, List<String> modeleObjete, LocalDate dataRozpoczecia, LocalDate dataZakonczenia) {
        this.czynnosci = czynnosci;
        this.modeleObjete = modeleObjete;
        this.dataRozpoczecia = dataRozpoczecia;
        this.dataZakonczenia = dataZakonczenia;
    }

    public AkcjaSerwisowa() {
    }

    @ElementCollection
    public List<String> getCzynnosci() {
        return czynnosci;
    }

    public void setCzynnosci(List<String> czynnosci) {
        this.czynnosci = czynnosci;
    }
    public void addCzynnosc(String czynnosc) {
        this.czynnosci.add(czynnosc);
    }
    @ElementCollection
    public List<String> getModeleObjete() {
        return modeleObjete;
    }

    public void setModeleObjete(List<String> modeleObjete) {
        this.modeleObjete = modeleObjete;
    }
    public void addModelObjety(String model) {
        this.modeleObjete.add(model);
    }

    public LocalDate getDataRozpoczecia() {
        return dataRozpoczecia;
    }

    public void setDataRozpoczecia(LocalDate dataRozpoczecia) {
        this.dataRozpoczecia = dataRozpoczecia;
    }

    public LocalDate getDataZakonczenia() {
        return dataZakonczenia;
    }

    public void setDataZakonczenia(LocalDate dataZakonczenia) {
        this.dataZakonczenia = dataZakonczenia;
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
    public Serwisant getSerwisant() {
        return serwisant;
    }

    public void setSerwisant(Serwisant serwisant) {
        if(this.serwisant==null){
            this.serwisant = serwisant;
            serwisant.addAkcjeSerwisowa(this);
        }
    }
    @ManyToMany
    public List<Samochod> getListaWykonanych() {
        return listaWykonanych;
    }

    public void setListaWykonanych(List<Samochod> listaWykonanych) {
        this.listaWykonanych = listaWykonanych;
    }
    public void addSamochodWykonany(Samochod samochod){
        if(!this.listaWykonanych.contains(samochod)){
            this.listaWykonanych.add(samochod);
            samochod.addWykonanaAkcjaSerwisowa(this);
        }
    }
}
