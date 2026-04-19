package Array;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Map<Integer,Integer> temp = new HashMap<>();
        for(int i=0;i<n;i++){
            temp.put(ar.get(i),temp.getOrDefault(ar.get(i),0)+1);
        }
        int count = 0;
        for(Map.Entry<Integer,Integer> entry : temp.entrySet()){
            Integer value = entry.getValue();
            if(value>=2){
                count += value/2;

            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        //int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> ar1= new ArrayList<>(Arrays.asList(1,2,1,2,1,3,2));


        int result = Result.sockMerchant(7, ar1);


    }

}



