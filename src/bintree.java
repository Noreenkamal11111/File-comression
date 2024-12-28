import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class bintree{
    private  charfreq head;
    public HashMap<Character,String> encodedmap ;
    bintree(){
        head = null;
        encodedmap = new HashMap<>();
    }

    public String encode(String ss) {
            StringBuilder currentCode = new StringBuilder();
            HashMap<Character , Integer > charecterFreaquancy = new HashMap<>();
            PriorityQueue<charfreq> pq = new PriorityQueue<>();
            
            String encString = "";
            
            for (int i = 0; i < ss.length(); i++) {
                char c = ss.charAt(i);
                if (!charecterFreaquancy.containsKey(c)) {
                    charecterFreaquancy.put(c,1);
                }
                else{
                    int value = charecterFreaquancy.get(c);
                    charecterFreaquancy.put(c, value+1);
                }
            }
            for (Character key : charecterFreaquancy.keySet()) {
                pq.add(new charfreq( charecterFreaquancy.get(key) , key));
            }
            while (pq.size()>1) {
                charfreq node = pq.poll();
                charfreq node1 = pq.poll();
                int newfreq = node.frequncy+node1.frequncy;
                charfreq newnode = new charfreq( newfreq , '\0');
                newnode.left = node;
                newnode.right = node1;
                pq.add(newnode);
            }
            head = pq.poll();
            if(head.cr != '\0'){
                encodedmap.put(head.cr, "1");
            }
            else{
                mapping(head, encodedmap,currentCode );
            }
           

            for (int i=0 ; i< ss.length() ; i++) {
                char crr = ss.charAt(i);
                encString = encString +encodedmap.get(crr);
            }

           return encString;
}

    private void mapping(charfreq node, HashMap<Character, String> encodedmap, StringBuilder currentCode) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            encodedmap.put(node.cr, currentCode.toString());
            return;
        }
        currentCode.append('0');
        mapping(node.left, encodedmap, currentCode);
        currentCode.deleteCharAt(currentCode.length() - 1);

        currentCode.append('1');
        mapping(node.right, encodedmap, currentCode);

        currentCode.deleteCharAt(currentCode.length() - 1);
    }
    
    
    
    

    public String decode(String encodedString) {
    StringBuilder decodedString = new StringBuilder();
    StringBuilder tempCode = new StringBuilder();

    for (char bit : encodedString.toCharArray()) {
        tempCode.append(bit);


        for (Map.Entry<Character, String> entry : encodedmap.entrySet()) {
            if (entry.getValue().equals(tempCode.toString())) {
                decodedString.append(entry.getKey());
                tempCode.setLength(0);
                break;
            }
        }
    }

    return decodedString.toString();
}

    

}