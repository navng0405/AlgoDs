package problems.Maths;

public class ReplaceZeroWithFive {
    public static void main(String args[]){
        System.out.println(replaceZeroWithFive(980));
    }
    private static int replaceZeroWithFive(int givenNum){
        if(givenNum == 0){
            return 5;
        }
        int result = 0;
        int multi = 1;
        boolean sign = false;
        if(givenNum<0){
            givenNum=givenNum*-1;
            sign=true;
        }else{
            sign=false;
        }

        while(givenNum>0){
            int lastDigit = givenNum%10;
            if(lastDigit == 0){
                lastDigit = 5;
            }
            result=lastDigit*multi+result;
            givenNum = givenNum/10;
            multi=multi*10;
        }
        return sign ? -1*result : result;
    }
}
