import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

            fileClass sss = new fileClass();
            Path filepath = Paths.get("C:\\Users\\dell\\OneDrive\\Desktop\\a3333lmslkv.txt");
            String Filename = filepath.getFileName().toString();
            String FullFileName = Filename + ".huff" ; 
            String ss = sss.FileToString("C:\\Users\\dell\\OneDrive\\Desktop\\a3333lmslkv.txt");
            Binarydata bin = new Binarydata();
            bintree lala = new bintree();
            String aura = lala.encode(ss);
            byte[] auraInBytes = sss.convertToByteArrayWithPaddingInfo(aura);
            bin.encdata = auraInBytes;
            bin.enchash = lala.encodedmap;
            FileOutputStream filebin = new FileOutputStream(FullFileName);
            ObjectOutputStream binfilewriter = new ObjectOutputStream(filebin);
            binfilewriter.writeObject(bin);
            FileInputStream fileinput = new FileInputStream("a3333lmslkv.txt.huff"); 
            ObjectInputStream Objectinput = new ObjectInputStream(fileinput);
            Binarydata llaa33 = (Binarydata) Objectinput.readObject();
            String stringFordecoding = sss.recoverBinaryStringFromByteArray(llaa33.encdata);
            lala.encodedmap = llaa33.enchash;
            String decodedstring = lala.decode(stringFordecoding);
            FileOutputStream txtfile = new FileOutputStream("llllll.txt");
            txtfile.write(decodedstring.getBytes());
    }
}