import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
       FilePartReader filePartReader = new FilePartReader();
       filePartReader.setup("/home/ozukyo/Dokumenty/web/assignments/filepartreader-testing-with-junit-Ozukyo/src/resources/sample.txt", 1, 1);
//        System.out.println(filePartReader.read());
        System.out.println(filePartReader.readLines());
    }
}
