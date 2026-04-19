package StringProbs;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s1 = "egg";
        String s2 = "add";
        System.out.println(areIsomorphic(s1, s2) ? "TRUE" : "FALSE"); // Output: TRUE

        s1 = "for";
        s2 = "bar";
        System.out.println(areIsomorphic(s1, s2) ? "TRUE" : "FALSE"); // Output: FALSE
    }

    private static boolean areIsomorphic(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }

        int[] mapS1toS2 = new int[126];
        int[] mapS2toS1 = new int[126];

        for(int i=0;i<s1.length();i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(mapS1toS2[ch1] == 0 && mapS2toS1[ch2] == 0){
                mapS1toS2[ch1] = ch2;
                mapS2toS1[ch2] = ch1;
            }else if(!(mapS1toS2[ch1] == ch2 && mapS2toS1[ch2] == ch1)){
                return false;
            }
        }
        return true;
    }
}
