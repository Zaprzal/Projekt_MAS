package AppClass;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public abstract class Osoba implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer id;
    @NonNull
    private String email;
    @NonNull
    private String imie;
    @NonNull
    private String nazwisko;
    @NonNull
    private String pesel;
    @NonNull
    private LocalDate dataUrodzenia;
    @NonNull
    private String miejscowosc;
    @NonNull
    private String ulica;
    @NonNull
    private String numerDomu;
    @NonNull
    private String kodPocztowy;
    @NonNull
    private Integer numerTelefonu;


    public Integer getId() {
        return id;
    }


    public void setPesel(String pesel) throws Exception {
        if(pesel.length() == 1) {
            char[] peselChar = pesel.toCharArray();
            int cc = 0;
            for (int i = 0; i <peselChar.length; i++) {
                if(peselChar[i]<61 || peselChar[i] > 71) {
                    cc++;
                }
            }
            if(cc > 0) {
                throw new Exception(String.format("Pesel nie może zawierać liter"));
            }
        }

        if(pesel.length() > 11) {
            throw new Exception(String.format("Pesel nie może być dłuższy niż 11 znaków"));
        }

        if(pesel.length() < 11) {
            throw new Exception(String.format("Pesel nie może być krótszy niż 11 znaków"));
        }

        this.pesel = pesel;
    }
}
