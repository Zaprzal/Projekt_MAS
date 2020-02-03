package AppClass;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pracownik extends Osoba {

    @NonNull
    private Integer pensja;
    @NonNull
    private Double prowizja;
    private List<String> wyksztalcenie = new ArrayList<String>();
    private List<Transakcja> listaTransakcji = new ArrayList<Transakcja>();

//    public void addSprzedaz(Transakcja transakcja) {
//        if(!this.listaTransakcji.contains(transakcja)){
//            this.listaTransakcji.add(transakcja);
//            transakcja.setSprzedajacy(this);
//        }
//    }

}
