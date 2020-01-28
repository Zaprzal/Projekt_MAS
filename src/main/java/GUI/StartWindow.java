package GUI;

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

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;

public class StartWindow {

    protected Shell shlGarageManagement;


    Display mainDisplay;
    public static void main(String[] args) {


        try {
            StartWindow window = new StartWindow();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //trzeba dodać ładowanie z bazy danych


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

    }
}

