package Array;

public class FindTriplet {
    public static void FindTriplet(int array[], int n)
    {
        //lesser array
        //first element = -1
        //lesser[i] = index of element lesser in the left side of array[i]
        //lesser[i] = -1 if no such element found
        int lesser[] = new int[n];
        int min = 0;
        lesser[0] = -1;
        for (int i = 1; i < n; i++)
        {
            if(array[i] <= array[min])
            {
                min = i;
                lesser[i] = -1;
            }
            else
            {
                lesser[i] = min;
            }
        }
        //greater array
        //last element = -1
        //greater[i] = index of element gretaer in the right side of array[i]
        //greater[i] = -1 if no such element found
        int greater[] = new int[n];
        int max = n-1;
        greater[n-1] = -1;
        for (int k = n-2; k >= 0; k--)
        {
            if (array[k] >= array[max])
            {
                max = k;
                greater[k] = -1;
            }
            else
            {
                greater[k] = max;
            }
        }
        //if both smaller and greater has element otherthan -1 at same index.
        //print them if found.
        //else, traverse till end
        //if not found till end, print No triplet found
        for (int j = 0; j < n; j++)
        {
            if (lesser[j] != -1 && greater[j] != -1)
            {
                System.out.println("Triplet found is: " + array[lesser[j]] + " " + array[j] + " " + array[greater[j]]);
                return;
            }
        }
        System.out.println("No such triplet found");
    }
    public static void main(String[] args)
    {

        int a[] = {1,4,2,6,9,3,5};

        FindTriplet(a,7);
    }
}

