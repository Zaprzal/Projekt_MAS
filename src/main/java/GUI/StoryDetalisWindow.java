package GUI;

import AppClass.Samochod;
import AppClass.Serwis;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

import java.util.List;

public class StoryDetalisWindow {
    protected Shell shell;

    Display display;

    public static void main(String[] args) {
        try {
            StoryDetalisWindow window = new StoryDetalisWindow();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void open() {
        display = Display.getDefault();
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

    protected void createContents(Samochod samochod) {
        shell = new Shell();
        shell.setSize(720, 400);
        shell.setText("Salon");
        Label info = new Label(shell, SWT.NONE);
        info.setBounds(30, 20, 200, 20);
        info.setText("Historia pojazdu: " + samochod.getVin());

        Table infoTable = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION | SWT.V_SCROLL);
        infoTable.setBounds(30, 60, 650, 250);
        infoTable.setLinesVisible(true);
        infoTable.setHeaderVisible(true);

        String[] titles = {"Data", "Przebieg", "Wycena", "Opis" , "Serwisant"};

        TableColumn data = new TableColumn(infoTable, SWT.CENTER);
        data.setWidth(100);
        data.setText(titles[0]);
        TableColumn przebieg = new TableColumn(infoTable, SWT.CENTER);
        przebieg.setWidth(120);
        przebieg.setText(titles[1]);
        TableColumn wycena = new TableColumn(infoTable, SWT.CENTER);
        wycena.setWidth(120);
        wycena.setText(titles[2]);
        TableColumn opis = new TableColumn(infoTable, SWT.CENTER);
        opis.setWidth(180);
        opis.setText(titles[3]);
        TableColumn serwisant = new TableColumn(infoTable, SWT.CENTER);
        serwisant.setWidth(120);
        serwisant.setText(titles[4]);

        List<Serwis> serwis = samochod.getHistoriaSerwisowa();
        System.out.println(samochod.getVin());

        for(Serwis a : serwis){
            TableItem item = new TableItem(infoTable, SWT.NONE);
            item.setText(0, "" + a.getData());
            item.setText(1, String.valueOf(a.getAktualnyPrzebieg()));
            item.setText(2, String.valueOf(a.getWycena()));
            item.setText(3, String.valueOf(a.getOpis()));
            item.setText(4, a.getSerwisant().getImie() + " " + a.getSerwisant().getNazwisko());
        }

    }
}
