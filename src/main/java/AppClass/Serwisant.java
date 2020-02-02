package AppClass;
import lombok.*;

import javax.persistence.ElementCollection;
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
public class Serwisant extends Osoba{
    @NonNull
    private Integer pensja;
    private List<String> wyksztalcenie = new ArrayList<String>();
    @OneToMany
    private List<Serwis> wykonaneSerwisy = new ArrayList<>();
    private List<AkcjaSerwisowa> wykonywaneAkcjeSerwisowe = new ArrayList<>();

    public void addWykonanySerwis(Serwis serwis) {
        if (!this.wykonaneSerwisy.contains(serwis)){
            this.wykonaneSerwisy.add(serwis);
            serwis.setSerwisant(this);
        }
    }

    public void addAkcjeSerwisowa(AkcjaSerwisowa akcjaSerwisowa) {
        if (!this.wykonywaneAkcjeSerwisowe.contains(akcjaSerwisowa)) {
            this.wykonywaneAkcjeSerwisowe.add(akcjaSerwisowa);
            akcjaSerwisowa.setSerwisant(this);
        }
    }

}
