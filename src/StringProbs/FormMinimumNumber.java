package StringProbs;

public class FormMinimumNumber {
    public static String formMinimumNumber(String str) {
        int n = str.length();
        if (n >= 9)
            return "-1";
        char output[] = new char[n + 1];
        int count = 1;
        for (int i = 0; i <= n; i++)
        {
            if (i == n || str.charAt(i) == 'I')
            {
                for (int j = i - 1; j >= -1; j--)
                {
                    output[j + 1] = (char) ((int) '0' + count++);
                    if (j >= 0 && str.charAt(j) == 'I')
                        break;
                }
            }
        }
        return new String(output);
    }

    public static void main(String[] args) {
        System.out.println(formMinimumNumber("IIDDD")); // Output: "126543"
        System.out.println(formMinimumNumber("DIDI"));  // Output: "21435"
        System.out.println(formMinimumNumber("DD"));    // Output: "321"
    }
}
