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
public class Prezes extends Osoba{

    @NonNull
    private Double bonusSprzedażowy;
    private List<Transakcja> listaTransakcji = new ArrayList<Transakcja>();


    public void addSprzedaz(Transakcja transakcja) {
        if(!this.listaTransakcji.contains(transakcja)){
            this.listaTransakcji.add(transakcja);
            transakcja.setSprzedajacy(this);
        }
    }

}
