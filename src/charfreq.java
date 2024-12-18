
public class charfreq implements Comparable {
        public int frequncy;
        public char cr;
        public charfreq left,right;


        charfreq(int f , char c){
            this.frequncy = f;
            this.cr = c;
        }

    @Override
    public int compareTo(Object o) {
        charfreq n = (charfreq) o;
        return this.frequncy > n.frequncy ? 1 : -1;
    }
}
    
