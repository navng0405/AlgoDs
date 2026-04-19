package StringProbs;

public class CountAndSay {

    public static String countAndSay(int n) {
        String currentString = "1";

       for(int i=1;i<n;i++){
           StringBuilder db = new StringBuilder();
           char currentChar = currentString.charAt(0);
           int count  =1;
           for(int j=1;j<currentString.length();j++){
               if(currentChar == currentString.charAt(j)){
                   count++;
               }else{
                   db.append(count).append(currentChar);
                   currentChar = currentString.charAt(j);
                   count=1;
               }
           }
           db.append(count).append(currentChar);

           currentString = db.toString();
           System.out.println(currentString);
       }

        return currentString;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Count and Say for " + n + ": " + countAndSay(n));
    }
}

