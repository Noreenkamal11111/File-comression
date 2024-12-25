
import java.io.Serializable;
import java.util.HashMap;

public class Binarydata implements Serializable {
    public HashMap<Character, String> enchash;
    public byte[] encdata;

    public Binarydata() {
        enchash = new HashMap<>();
    }
    
}
