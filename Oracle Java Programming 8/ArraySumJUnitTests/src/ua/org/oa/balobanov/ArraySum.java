package ua.org.oa.balobanov;

public class ArraySum {
    public int [] array;

    public ArraySum(int[] array) {
        this.array = array;
    }

    // Сумма элементов
    public static int sum(int [] a)
    {
        if(a.length < 0)
            throw new NullPointerException();
        
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
             sum+= a[i];
        }
        
        return sum;
    }
}