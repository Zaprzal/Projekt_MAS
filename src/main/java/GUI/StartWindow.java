package GUI;

import AppClass.Pracownik;
import AppClass.Samochod;
import AppClass.Serwis;
import AppClass.Serwisant;
import AppServices.PracownikService;
import AppServices.SamochodService;
import AppServices.SerwisService;
import AppServices.SerwisantService;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Monitor;

import java.time.LocalDate;

public class StartWindow {

    protected Shell shlGarageManagement;
    private PracownikService pracownikService = new PracownikService();
    private SamochodService samochodService = new SamochodService();
    private SerwisService serwisService = new SerwisService();
    private SerwisantService serwisantService = new SerwisantService();


    Display mainDisplay;
    public static void main(String[] args) {


        try {
            StartWindow window = new StartWindow();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void open() {
        mainDisplay = Display.getDefault();
        createContents();
        shlGarageManagement.open();
        Monitor primary = mainDisplay.getPrimaryMonitor();
        Rectangle bounds = primary.getBounds();
        Rectangle rect = shlGarageManagement.getBounds();
        int x = bounds.x + (bounds.width - rect.width) / 2;
        int y = bounds.y + (bounds.height - rect.height) / 2;
        shlGarageManagement.setLocation(x,y);
        shlGarageManagement.layout();
        while (!shlGarageManagement.isDisposed()) {
            if (!mainDisplay.readAndDispatch()) {
                mainDisplay.sleep();
            }
        }
    }

    protected void createContents() {
        shlGarageManagement = new Shell();
        shlGarageManagement.setSize(960, 400);
        shlGarageManagement.setText("Salon");


        Label lblWitajWProgramie = new Label(shlGarageManagement, SWT.NONE);
        lblWitajWProgramie.setAlignment(SWT.CENTER);
        lblWitajWProgramie.setBounds(60, 30, 825, 50);
        lblWitajWProgramie.setText("Witaj w programie do zarz\u0105dzania salonem");


        Button btnhistoriaPojazdu = new Button(shlGarageManagement, SWT.NONE);
        btnhistoriaPojazdu.setBounds(35, 80, 274, 37);
        btnhistoriaPojazdu.setText("Sprawd\u017A histori\u0119 pojazdu");
        btnhistoriaPojazdu.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event arg0) {
                mainDisplay.dispose();
                StoryWindow story = new StoryWindow();
                story.createContents();
                story.open();
            }
        });


        Button btnlistaModeli = new Button(shlGarageManagement, SWT.NONE);
        btnlistaModeli.setBounds(335, 80, 274, 37);
        btnlistaModeli.setText("Lista dost\u0119pnych modeli");
        btnlistaModeli.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
            }
        });





        Button btnumowJazdeTestowa = new Button(shlGarageManagement, SWT.NONE);
        btnumowJazdeTestowa.setBounds(635, 80, 274, 37);
        btnumowJazdeTestowa.setText("Um\u00F3w jazd\u0119 testow\u0105");
        btnumowJazdeTestowa.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event arg0) {
                mainDisplay.dispose();
                TestRideWindow ride = new TestRideWindow();
                ride.createContents();
                ride.open();
            }
        });

        Button btnListaTransakcji = new Button(shlGarageManagement, SWT.NONE);
        btnListaTransakcji.setBounds(35, 200, 274, 37);
        btnListaTransakcji.setText("Lista moich transakcji");
        btnListaTransakcji.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event arg0) {
                mainDisplay.dispose();
            }
        });


        Button btnSprzedaz = new Button(shlGarageManagement, SWT.NONE);
        btnSprzedaz.setBounds(335, 200, 274, 37);
        btnSprzedaz.setText("Zainicjuj sprzeda\u017C");
        btnSprzedaz.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event arg0) {
                mainDisplay.dispose();
            }
        });



        Button btnWyjdz = new Button(shlGarageManagement, SWT.NONE);
        btnWyjdz.setBounds(635, 200, 274, 37);
        btnWyjdz.setText("Wyjd\u017A");
        btnWyjdz.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event arg0) {
                mainDisplay.dispose();
            }
        });

        Button daneTst = new Button(shlGarageManagement, SWT.NONE);
        daneTst.setBounds(670, 324, 274, 37);
        daneTst.setText("Dane testowe");
        daneTst.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event arg0) {
                Pracownik e = new Pracownik();
                try{
                    e.setPesel("97090210471");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                // Tworzenie danych testowych

                e.setImie("Patryk");
                e.setNazwisko("Zaprzaluk");
                e.setDataUrodzenia(LocalDate.of(1997,9,2));
                e.setEmail("niewiem@interia.pl");
                e.setKodPocztowy("03-134");
                e.setMiejscowosc("Warszawa");
                e.setNumerDomu("23B/4");
                e.setNumerTelefonu(518621219);
                e.setUlica("Nie wiem");
                e.setPensja(5600);
                e.setProwizja(25.0);
                pracownikService.persist(e);

                Samochod s = new Samochod("Astra J" , 2019 , "OPEL9911234567891" , "FAFAFA");
                samochodService.persist(s);
                Samochod s1 = new Samochod("Astra J" , 2015 , "ASTRA911234567856" , "FAFAF3");
                samochodService.persist(s1);
                Samochod s2 = new Samochod("Astra J" , 2017 , "OPEL9911234567836" , "C3C3C3");
                samochodService.persist(s2);

                Serwisant sr = new Serwisant();
                sr.setImie("Patryk");
                sr.setNazwisko("Zaprzaluk");
                sr.setDataUrodzenia(LocalDate.of(1997,9,2));
                sr.setEmail("niewiem@interia.pl");
                sr.setKodPocztowy("03-134");
                sr.setMiejscowosc("Warszawa");
                sr.setNumerDomu("23B/4");
                sr.setNumerTelefonu(518621219);
                sr.setUlica("Nie wiem");
                serwisantService.persist(sr);

                Serwisant sr1 = new Serwisant();
                sr1.setImie("Pawel");
                sr1.setNazwisko("Kowalski");
                sr1.setDataUrodzenia(LocalDate.of(1997,3,2));
                sr1.setEmail("niewiem2@interia.pl");
                sr1.setKodPocztowy("03-134");
                sr1.setMiejscowosc("Warszawa");
                sr1.setNumerDomu("23B/4");
                sr1.setNumerTelefonu(518621219);
                sr1.setUlica("Nie wiem");
                serwisantService.persist(sr1);

                Serwis ss = new Serwis();
                ss.setAktualnyPrzebieg(2);
                ss.setOpis("Przeglad poczatkowy");
                ss.setData(LocalDate.now());
                ss.setWycena(0.0);
                ss.setSamochod(s);
                ss.setSerwisant(sr);
                serwisService.persist(ss);
                Serwis ss1 = new Serwis();
                ss1.setAktualnyPrzebieg(5000);
                ss1.setOpis("Pierwsza wymiana oleju");
                ss1.setData(LocalDate.now());
                ss1.setWycena(0.0);
                ss1.setSamochod(s);
                ss1.setSerwisant(sr);
                serwisService.persist(ss1);
                Serwis ss2 = new Serwis();
                ss2.setAktualnyPrzebieg(20000);
                ss2.setOpis("Wymiana oleju, wymiana opon zima");
                ss2.setData(LocalDate.now());
                ss2.setWycena(150.50);
                ss2.setSamochod(s);
                ss2.setSerwisant(sr1);
                serwisService.persist(ss2);

                Serwis ss3 = new Serwis();
                ss3.setAktualnyPrzebieg(20000);
                ss3.setOpis("Wymiana oleju");
                ss3.setData(LocalDate.of(2016,8,21));
                ss3.setWycena(0.0);
                ss3.setSamochod(s1);
                ss3.setSerwisant(sr1);
                serwisService.persist(ss3);

                Serwis ss4 = new Serwis();
                ss4.setAktualnyPrzebieg(20000);
                ss4.setOpis("Wymiana tarcz i klockow - komplet");
                ss4.setData(LocalDate.now());
                ss4.setWycena(550.99);
                ss4.setSamochod(s1);
                ss4.setSerwisant(sr1);
                serwisService.persist(ss4);

                Serwis ss5 = new Serwis();
                ss5.setAktualnyPrzebieg(30000);
                ss5.setOpis("Wymiana oleju, przeglad");
                ss5.setData(LocalDate.now());
                ss5.setWycena(900.0);
                ss5.setSamochod(s2);
                ss5.setSerwisant(sr1);
                serwisService.persist(ss5);
            }
        });

    }
}

