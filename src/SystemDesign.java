import java.util.HashSet;
import java.util.Set;

/**
 * int 2 power31 =?
 * long 2 63 22222222222
 */
public class SystemDesign {

    private static final String ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";
    private static final int BASE = ALPHABET.length();

    // Method to encode a number to Base58
    public static String encodeToBase58(long number, Set<String> temp) {
        StringBuilder encoded = new StringBuilder();
        while (number > 0) {
            encoded.insert(0, ALPHABET.charAt((int) (number % BASE)));//2468135791013L % 58 = > 34
            number /= BASE; //2468135791013L / 58 = > 1112213131123
        }
        temp.add(encoded.toString());
        return encoded.toString();
    }

    public static void main(String[] args) {
        Set<String> temp = new HashSet<>();
        for(long value=9999999999999L;value>=0;value--){
            String uniqueId = encodeToBase58(value , temp);

            //System.out.println("Unique ID: " + uniqueId);
            if(temp.size() == 100000){
                break;
            }
        }
        for(String uniqueId : temp){
            System.out.println(uniqueId);
        }

    }



}
