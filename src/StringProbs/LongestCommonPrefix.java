package StringProbs;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for(int i =1;i<strs.length;i++){
            System.out.println(strs[i].indexOf(prefix));
            while(strs[i].indexOf(prefix) != 0){
                int test = strs[i].indexOf(prefix);
                System.out.println(test);
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] input = {"Club", "Clap", "Clove","Clop","Clopper"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(input));
    }
}

