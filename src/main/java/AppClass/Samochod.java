package AppClass;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Samochod {
    @Column(name = "id_samochod")
    @Id
    @GeneratedValue(generator = "increment")
    private Integer id;
    @NonNull
    private String vin;
    @NonNull
    private String model;
    @NonNull
    private int rokProdukcji;
    @NonNull
    private String kodLakieru;
//    private Klient wlasciciel;
    private List<String> wyposazenieDodatkowe = new ArrayList<String>();
    private static Map<String,Samochod> pojazdy = new HashMap<String, Samochod>(); //Do zapewnienia unikalności win
    private List<JazdaTestowa> odbyteJazdy = new ArrayList<>();
    @OneToMany
    private List<Serwis> historiaSerwisowa = new ArrayList<>();
	@ManyToMany(mappedBy = "samochod")
    private List<AkcjaSerwisowa> wykonaneAkcje = new ArrayList<>();
    private Transakcja transakcja;

    public Samochod(String model, int rokProdukcji, String vin, String kodLakieru, List<String> wyposazenieDodatkowe) {
        this.model = model;
        this.rokProdukcji = rokProdukcji;
        this.kodLakieru = kodLakieru;
        this.wyposazenieDodatkowe = wyposazenieDodatkowe;
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


    public void setOdbyteJazdy(List<JazdaTestowa> odbyteJazdy) {
        this.odbyteJazdy = odbyteJazdy;
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
        if (!this.wykonaneAkcje.contains(akcjaSerwisowa)){
            this.wykonaneAkcje.add(akcjaSerwisowa);
            akcjaSerwisowa.addSamochodWykonany(this);
        }
    }


    public void setTransakcja(Transakcja transakcja) {
        if (this.transakcja == null){
            this.transakcja = transakcja;
            transakcja.setSamochod(this);
        }

    }
}
