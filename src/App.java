import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

            hhh sss = new hhh();
            String ss = sss.FileToString("C:\\Users\\dell\\OneDrive\\Desktop\\a3333lmslkv.txt");
            bintree lala = new bintree();
            String aura = lala.encode(ss);
            System.out.println(aura);
            System.out.println(lala.encodedmap);
            System.out.println(lala.decode(aura));
        }
       
    }
