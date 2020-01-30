package GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;


public class StoryWindow {
    protected Shell servisManagment;

    Display storyDisplay;

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
        servisManagment.setSize(960, 400);
        servisManagment.setText("Salon");
        Text vinInput = new Text(servisManagment, SWT.BORDER);
        vinInput.setMessage("Podaj Vin pojazdu");
        vinInput.setBounds(110, 10, 190, 20);


        Button btnSzukaj = new Button(servisManagment, SWT.NONE);
        btnSzukaj.setBounds(320, 10, 120, 20);
        btnSzukaj.setText("Zweryfikuj");
        btnSzukaj.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event arg0) {
//                java.util.List<Naprawa> listN = naprawaService.findAll();
//                for (Naprawa a:listN) {
//                    //TableItem tableItem = new TableItem(orderTable, SWT.NONE);
//                    //tableItem.setText(""+a.getId()+"; "+a.getTypNaprawy()+"; "+ a.getDataRozpoczeciaNaprawy()+"; "+(a.getPracownik() != null && a.getPracownik().size() > 0 ? new ArrayList<>(a.getPracownik()).get(0).getPesel() : "brak pracownika"));
//                    TableItem item = new TableItem(orderTable, SWT.NONE);
//                    item.setText(0, ""+a.getId());
//                    item.setText(1, a.getTypNaprawy());
//                    item.setText(2, ""+a.getDataRozpoczeciaNaprawy());
//                    item.setText(3, ""+(a.getPracownik() != null && a.getPracownik().size() > 0 ? new ArrayList<>(a.getPracownik()).get(0).getPesel() : "brak pracownika"));
//                }
            }
        });

        Button btnClearVin = new Button(servisManagment, SWT.NONE);
        btnClearVin.setBounds(460, 10, 120, 20);
        btnClearVin.setText("Skasuj");
        btnClearVin.addListener(SWT.Selection, new Listener() {
            @Override
            public void handleEvent(Event arg0) {
                vinInput.setText("");
            }
        });

        Table infoTable = new Table(servisManagment, SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL);
        infoTable.setBounds(110, 60, 705, 250);
        infoTable.setLinesVisible(true);
        infoTable.setHeaderVisible(true);


        String[] titles = {"ID", "DATA WIZYTY", "OPIS", "PRACOWNIK"};

        TableColumn columnID = new TableColumn(infoTable, SWT.CENTER);
        columnID.setWidth(50);
        columnID.setText(titles[0]);
        TableColumn columnData = new TableColumn(infoTable, SWT.CENTER);
        columnData.setWidth(160);
        columnData.setText(titles[1]);
        TableColumn columnOpis = new TableColumn(infoTable, SWT.CENTER);
        columnOpis.setWidth(308);
        columnOpis.setText(titles[2]);
        TableColumn columnPracownik = new TableColumn(infoTable, SWT.CENTER);
        columnPracownik.setWidth(180);
        columnPracownik.setText(titles[3]);


        Button btnWyjdz = new Button(servisManagment, SWT.NONE);
        btnWyjdz.setBounds(670, 324, 274, 37);
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
