package Array;

/**
 * Voting count
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] votingCount = {2,2,1,1,1,2,2};
        System.out.println("Majority : "+getMajority(votingCount));
    }

    private static int getMajority(int[] votingCount) {
        Integer majority = null;
        int count = 0;
        for(int i : votingCount){
            if(count == 0){
                majority = i;
            }
            count = count + (majority == i ? 1 : -1);
        }

        return majority;
    }

}
