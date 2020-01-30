package GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class TestRideWindow {
    protected Shell shell;

    Display display;

    public static void main(String[] args) {
        try {
            TestRideWindow window = new TestRideWindow();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void open() {
        display = Display.getDefault();
        createContents();
        shell.open();
        Monitor primary = display.getPrimaryMonitor();
        Rectangle bounds = primary.getBounds();
        Rectangle rect = shell.getBounds();
        int x = bounds.x + (bounds.width - rect.width) / 2;
        int y = bounds.y + (bounds.height - rect.height) / 2;
        shell.setLocation(x, y);
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    protected void createContents() {
        shell = new Shell();
        shell.setSize(960, 400);
        shell.setText("Salon");

        Label lblAuto = new Label(shell, SWT.NONE);
        lblAuto.setAlignment(SWT.LEFT);
        lblAuto.setBounds(10, 30, 50, 20);
        lblAuto.setText("Pojazd: ");
        Combo cars = new Combo(shell, SWT.READ_ONLY);
        cars.setBounds(120 , 26 , 150, 50);
        cars.add("Pojazd testowy" , 0);
        cars.add("Pojazd testowy 2" , 1);


        Label lblImieKlienta = new Label(shell, SWT.NONE);
        lblImieKlienta.setAlignment(SWT.LEFT);
        lblImieKlienta.setBounds(10, 70, 80, 20);
        lblImieKlienta.setText("Imie klienta: ");
        Text inputName = new Text(shell, SWT.BORDER);
        inputName.setMessage("Imie");
        inputName.setBounds(120, 68, 150, 20);


        Label lblNazwisko = new Label(shell, SWT.NONE);
        lblNazwisko.setAlignment(SWT.LEFT);
        lblNazwisko.setBounds(10, 110, 110, 20);
        lblNazwisko.setText("Nazwisko klienta: ");
        Text inputSurname = new Text(shell, SWT.BORDER);
        inputSurname.setMessage("Nazwisko");
        inputSurname.setBounds(120, 108, 150, 20);

        Label lblDystans = new Label(shell, SWT.NONE);
        lblDystans.setAlignment(SWT.LEFT);
        lblDystans.setBounds(10, 150, 110, 20);
        lblDystans.setText("Dystans: ");
        Text inputLimit = new Text(shell, SWT.BORDER);
        inputLimit.setMessage("Limit km");
        inputLimit.setBounds(120, 148, 150, 20);



        Label lblData = new Label(shell, SWT.NONE);
        lblData.setAlignment(SWT.CENTER);
        lblData.setBounds(560, 80, 100, 50);
        lblData.setText("Data testu: ");
        DateTime calendar = new DateTime (shell, SWT.CALENDAR);
        calendar.setBounds(670, 10 , 260, 140);
        calendar.addSelectionListener (new SelectionAdapter() {
            public void widgetSelected (SelectionEvent e) {
                System.out.println ("calendar date changed");
            }
        });

        Button btnWyjdz = new Button(shell, SWT.NONE);
        btnWyjdz.setBounds(670, 324, 274, 37);
        btnWyjdz.setText("Cofnij");
        btnWyjdz.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event arg0) {
                display.dispose();
                StartWindow start = new StartWindow();
                start.createContents();
                start.open();
            }
        });



        Button btnZapisz = new Button(shell, SWT.NONE);
        btnZapisz.setBounds(397, 324, 274, 37);
        btnZapisz.setText("Zapisz");
        btnZapisz.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event arg0) {
                display.dispose();
                System.out.println("Jazda testowa umówiona");
                StartWindow start = new StartWindow();
                start.createContents();
                start.open();
            }
        });

    }
}
