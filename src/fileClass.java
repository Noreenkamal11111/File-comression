import java.io.FileInputStream;
import java.io.IOException;

class fileClass{
    public String FileToString(String path) 
    throws IOException{
        FileInputStream filess = new FileInputStream(path);
        int data;
        char dataincr;
        String datainString = "";
        while(( data = filess.read())!= -1){
            dataincr = (char) data ;
            datainString += Character.toString(dataincr);
        }
        return datainString;
    } 
}