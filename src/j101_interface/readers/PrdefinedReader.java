package j101_interface.readers;

import j101_interface.readers.IReader;

/**
 * Created by dashenka on 25.08.15.
 */
public class PrdefinedReader implements IReader {

    private final String str;

    public PrdefinedReader(final String str){
        this.str = str;
    }

    @Override
    public String read() {
        return str;
    }
}
