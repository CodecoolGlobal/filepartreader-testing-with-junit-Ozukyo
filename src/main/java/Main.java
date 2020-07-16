
import java.io.IOException;
import java.net.URL;


public class Main {

    public static void main(String[] args) throws IOException {
       FilePartReader filePartReader = new FilePartReader();
       URL url = Main.class.getResource("sample.txt");
       filePartReader.setup((url.getPath()), 1, 1);
       FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
       System.out.println(fileWordAnalyzer.getStringsWhichPalindromes());

    }
}
