package GUI;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.*;

public class TestRideWindow {
    protected Shell shell;

    Display display;

    public static void main(String[] args) {
        try {
            StoryWindow window = new StoryWindow();
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


    }
}
