package j101_interface.printers;

/**
 * Created by dashenka on 25.08.15.
 */
public class AdvConsolePrinter implements IPrinter {

    @Override
    public void print(String text) {
        System.out.println(text);
        System.out.println(String.format("String length: %d", text.length()));
    }
}
