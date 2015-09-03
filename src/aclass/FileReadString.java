package aclass;

/**
 * Created by dashenka on 26.08.15.
 */
public class FileReadString extends AbstractSmileProcessor {

    public String readString(){
        return "text from smilefile :) :))";
    }

    public static void main(String[] args){
        final FileReadString fileReadString = new FileReadString();
        fileReadString.process();
    }

}
