package GUI;

import AppClass.Samochod;
import AppClass.Serwis;
import AppServices.SamochodService;
import AppServices.SerwisService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

import java.util.List;


public class StoryWindow {
    protected Shell servisManagment;

    Display storyDisplay;
    private SamochodService samochodService = new SamochodService();

    public static void main(String[] args) {
        try {
            StoryWindow window = new StoryWindow();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void open() {
        storyDisplay = Display.getDefault();
        createContents();
        servisManagment.open();
        Monitor primary = storyDisplay.getPrimaryMonitor();
        Rectangle bounds = primary.getBounds();
        Rectangle rect = servisManagment.getBounds();
        int x = bounds.x + (bounds.width - rect.width) / 2;
        int y = bounds.y + (bounds.height - rect.height) / 2;
        servisManagment.setLocation(x, y);
        servisManagment.layout();
        while (!servisManagment.isDisposed()) {
            if (!storyDisplay.readAndDispatch()) {
                storyDisplay.sleep();
            }
        }
    }

    protected void createContents() {

        servisManagment = new Shell();
        servisManagment.setSize(720, 400);
        servisManagment.setText("Salon");
        Text vinInput = new Text(servisManagment, SWT.BORDER);
        vinInput.setMessage("Podaj Vin pojazdu");
        vinInput.setBounds(110, 10, 190, 20);

        Table infoTable = new Table(servisManagment, SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL);
        infoTable.setBounds(110, 60, 490, 250);
        infoTable.setLinesVisible(true);
        infoTable.setHeaderVisible(true);

        String[] titles = {"Vin", "Model", "Rok produkcji"};

        TableColumn columnID = new TableColumn(infoTable, SWT.CENTER);
        columnID.setWidth(160);
        columnID.setText(titles[0]);
        TableColumn columnData = new TableColumn(infoTable, SWT.CENTER);
        columnData.setWidth(160);
        columnData.setText(titles[1]);
        TableColumn columnRokProd = new TableColumn(infoTable, SWT.CENTER);
        columnRokProd.setWidth(160);
        columnRokProd.setText(titles[2]);


        List<Samochod> samochods = samochodService.findAll();
        if (samochods != null) {
            for (Samochod a : samochods) {
                TableItem item = new TableItem(infoTable, SWT.NONE);
                item.setText(0, "" + a.getVin());
                item.setText(1, String.valueOf(a.getModel()));
                item.setText(2, String.valueOf(a.getRokProdukcji()));

            }
        }

        infoTable.addListener(SWT.DefaultSelection, new Listener() {
            @Override
            public void handleEvent(Event event) {
                String s = infoTable.getItem(infoTable.getSelectionIndex()).toString();
                String sout = s.substring(11,28);
                for (Samochod a : samochods) {
                    if(a.getVin().contains(sout)) {
                        StoryDetalisWindow details = new StoryDetalisWindow();
                        details.createContents(a);
                        details.open();
                    }
                }
            }
        });


        Button btnSzukaj = new Button(servisManagment, SWT.NONE);
        btnSzukaj.setBounds(320, 10, 120, 20);
        btnSzukaj.setText("Znajdz");
        btnSzukaj.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event arg0) {
                infoTable.removeAll();
                if (samochods != null) {
                    for (Samochod a : samochods) {
                        if (a.getVin().contains(vinInput.getText())) {
                            TableItem item = new TableItem(infoTable, SWT.NONE);
                            item.setText(0, "" + a.getVin());
                            item.setText(1, String.valueOf(a.getModel()));
                            item.setText(2, String.valueOf(a.getRokProdukcji()));
                        }
                    }
                }
            }
        });

        Button btnClearVin = new Button(servisManagment, SWT.NONE);
        btnClearVin.setBounds(460, 10, 120, 20);
        btnClearVin.setText("Skasuj");
        btnClearVin.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event arg0) {
                vinInput.setText("");
                infoTable.removeAll();
                if (samochods != null) {
                    for (Samochod a : samochods) {
                        TableItem item = new TableItem(infoTable, SWT.NONE);
                        item.setText(0, "" + a.getVin());
                        item.setText(1, String.valueOf(a.getModel()));
                        item.setText(2, String.valueOf(a.getRokProdukcji()));
                    }
                }
            }
        });


        Button btnWyjdz = new Button(servisManagment, SWT.NONE);
        btnWyjdz.setBounds(430, 324, 274, 37);
        btnWyjdz.setText("Cofnij");
        btnWyjdz.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event arg0) {
                storyDisplay.dispose();
                StartWindow start = new StartWindow();
                start.createContents();
                start.open();
            }
        });


    }

}
