package GUI;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

public class WindowsFormat {
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

    }
}
