package j101_interface;

import j101_interface.printers.AdvConsolePrinter;
import j101_interface.printers.ConsolePrinter;
import j101_interface.printers.IPrinter;
import j101_interface.readers.IReader;
import j101_interface.readers.PrdefinedReader;

/**
 * Created by dashenka on 25.08.15.
 */
public class Replacer {

    private final IReader reader;

    private final IPrinter printer;

    public Replacer(final IReader reader,
                    final IPrinter printer){
        this.reader = reader;
        this.printer = printer;
    }

    public void replace(){
        final String text = reader.read();
        final String replacedText = text.replace(":)", "=)");
        printer.print(replacedText);
    }

    public static void main(String[] args){
        final IReader reader = new PrdefinedReader("sdflk:)fskldjfklj:) ");
        final IPrinter printer = new ConsolePrinter();
        final IPrinter advPrinter = new AdvConsolePrinter();
        final Replacer replacer = new Replacer(reader, printer);
        final Replacer advReplacer = new Replacer(reader, advPrinter);
        replacer.replace();
        advReplacer.replace();


    }


}
