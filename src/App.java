

public class App {
    public static void main(String[] args) {

            String ss = "lalaland hellos world \n gggg";
            bintree lala = new bintree();
            String aura = lala.encode(ss);
            System.out.println(aura);
            System.out.println(lala.encodedmap);
            System.out.println(lala.decode(aura));
        }
       
    }
