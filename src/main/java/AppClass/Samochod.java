package AppClass;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Samochod {
    @Column(name = "id_samochod")
    @Id
    @NonNull
    private String vin;
    @NonNull
    private String model;
    @NonNull
    private Integer rokProdukcji;
    @NonNull
    private String kodLakieru;
//    private Klient wlasciciel;
    private static Map<String,Samochod> pojazdy = new HashMap<String, Samochod>(); //Do zapewnienia unikalności win
    @OneToMany
    private List<JazdaTestowa> odbyteJazdy = new ArrayList<>();
    @OneToMany
    private List<Serwis> historiaSerwisowa = new ArrayList<>();
    @ManyToMany
    private List<AkcjaSerwisowa> wykonaneakcje;
	@OneToOne
    private Transakcja transakcja;

    public Samochod(String model, int rokProdukcji, String vin, String kodLakieru) {
        this.model = model;
        this.rokProdukcji = rokProdukcji;
        this.kodLakieru = kodLakieru;
            try {
            setVin(vin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setVin(String vin) throws Exception {
        if (pojazdy.containsKey(vin)){
            throw new Exception(String.format("Pojazd o numerze vin (%s) już istnieje" , vin));
        }else if (vin.length()!= 17) {
            throw new Exception(String.format("Nieprawidłowa długość numeru VIN"));
        }else{
            this.vin = vin;
            pojazdy.put(vin , this);
        }
    }


    public void addOdbyteJazdy(JazdaTestowa odbyta){
        if(!this.odbyteJazdy.contains(odbyta)){
            this.odbyteJazdy.add(odbyta);
            odbyta.setSamochod(this);
        }
    }

    public void addSerwisPojazdu(Serwis serwis) {
        if (!this.historiaSerwisowa.contains(serwis)){
            this.historiaSerwisowa.add(serwis);
            serwis.setSamochod(this);
        }
    }


    public void addWykonanaAkcjaSerwisowa(AkcjaSerwisowa akcjaSerwisowa) {
        if (!this.wykonaneakcje.contains(akcjaSerwisowa)){
            this.wykonaneakcje.add(akcjaSerwisowa);
            akcjaSerwisowa.addSamochodWykonanaAkcja(this);
        }
    }


    public void setTransakcja(Transakcja transakcja) {
        if (this.transakcja == null){
            this.transakcja = transakcja;
            transakcja.setSamochod(this);
        }

    }
}
