import java.util.Arrays;
import java.util.StringTokenizer;

 public class Strings {
    public String task1(final String in) {
        // BEGIN
        char[] charArray = in.toCharArray();
        char[] newString = new char[charArray.length];
        int l = charArray.length;
        for (int i = l; i >= l/2; i--){
            newString[l -1 - i] = charArray[i-1];
            newString[i-1] = charArray[l -1 -i];
        }
        return new String(newString);
        // END

    }
    public String task2(final String in) {
        // BEGIN
        String out = new String();
        StringTokenizer str = new StringTokenizer(in);
        while (str.hasMoreTokens()) {
            StringBuilder strBuilder = new StringBuilder().append(str.nextToken()).reverse();
            out = out + strBuilder.toString() + " ";

        }
        String[] strings = in.split(" ");
        final StringBuilder sb = new StringBuilder();
        Arrays.asList(strings).forEach(s -> sb.append(task1(s) + " "));
        //return sb.toString().trim();
        return out.trim();

// BEGIN



        // END
        // END

    }

     public int task3(final String in, final char target) {
         // BEGIN
        return 2;
         // END

     }
}
