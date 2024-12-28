import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Choose an operation:\n 1:Compress a text file \n 2:Decompress a text file");
        System.out.print("Choice:");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        if (choice == 1) {
            System.out.println("Enter the path of the file to compress:");
            String inputFilePath = scanner.nextLine();

            fileClass sss = new fileClass();
            Path filepath = Paths.get(inputFilePath);
            String Filename = filepath.getFileName().toString();
            String FullFileName = Filename + ".huff";
            String ss = sss.FileToString(inputFilePath);

            Binarydata bin = new Binarydata();
            bintree lala = new bintree();
            String aura = lala.encode(ss);
            byte[] auraInBytes = sss.convertToByteArrayWithPaddingInfo(aura);
            bin.encdata = auraInBytes;
            bin.enchash = lala.encodedmap;

            FileOutputStream filebin = new FileOutputStream(FullFileName);
            ObjectOutputStream binfilewriter = new ObjectOutputStream(filebin);
            binfilewriter.writeObject(bin);

            System.out.println("Compression completed. File saved as: " + FullFileName);
        } else if (choice == 2) {
            System.out.println("Enter the path of the file to decompress:");
            String inputFilePath = scanner.nextLine();

            fileClass sss = new fileClass();
            File inputFile = new File(inputFilePath);
            String inputFileName = inputFile.getName();
            String RealFileName = inputFileName.substring(0, inputFileName.length() - 5);
            FileInputStream fileinput = new FileInputStream(inputFilePath);
            ObjectInputStream Objectinput = new ObjectInputStream(fileinput);
            Binarydata llaa33 = (Binarydata) Objectinput.readObject();
            String stringFordecoding = sss.recoverBinaryStringFromByteArray(llaa33.encdata);

            bintree lala = new bintree();
            lala.encodedmap = llaa33.enchash;
            String decodedstring = lala.decode(stringFordecoding);

            FileOutputStream txtfile = new FileOutputStream(RealFileName);
            txtfile.write(decodedstring.getBytes());

            System.out.println("Decompression completed. File saved as: "+RealFileName);
        } else {
            System.out.println("Invalid choice. Exiting.");
        }

        scanner.close();
    }
}