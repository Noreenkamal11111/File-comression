import java.io.FileInputStream;
import java.io.IOException;

class hhh{
    public String FileToString(String path) throws IOException{
        FileInputStream filess = new FileInputStream(path);
        int data;
        char dataincr;
        String lala = "";
        while(( data = filess.read())!= -1){
            dataincr = (char) data ;
            lala += Character.toString(dataincr);
        }
        return lala;
    } 
}