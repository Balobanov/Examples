package ua.org.oa.balobanov;

public class ArrayProd {
    public int [] array;

    public ArrayProd(int[] array) {
        this.array = array;
    }

    // Произведение эелементов
    public static int prod(int [] a) 
    {
        if(a.length <= 0)
            throw new NullPointerException();
        
        int prod = 1;
        for (int i = 0; i < a.length; i++) {
             prod*= a[i];
        }
        
        return prod;
    }
}