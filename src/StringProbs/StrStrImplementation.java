package StringProbs;

public class StrStrImplementation {

    public static int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        int hayStacklen = haystack.length();
        int needlelen = needle.length();
        for(int i=0;i<=hayStacklen-needlelen;i++){
            int j;
            for( j=0;j<needlelen;j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }

            }
            if (j == needlelen) return i;

        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println("Index: " + strStr(haystack, needle));
    }
}

