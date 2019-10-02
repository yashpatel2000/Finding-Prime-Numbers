import java.util.*;
import java.io.*;
import java.lang.Math;
class MAX
{
    
    static int crosssum(int []A, int l,int m,int h)
    {
      int rightsum=Integer.MIN_VALUE;
      int sum=0;
        for(int i=m+1;i<=h;i++)
        {
            sum=sum+A[i];
            if(sum>rightsum)
            {
            rightsum =sum;
            }
        }
        sum=0;
        int leftsum=Integer.MIN_VALUE;
        for(int i=m;i>=l;i--)
        {
            sum=sum+A[i];
            if(sum>leftsum)
            {
                leftsum=sum;
            }
        }
        return rightsum+leftsum;
    }



    static int maxsumarray(int A[],int l,int h)
    {
    if(l==h)
    {
      return A[1];
    }
    int m=(l+h)/2;
    return Math.max(Math.max(maxsumarray(A,l,m),maxsumarray(A,m+1,h)),crosssum(A,l,m,h));
    }
    public static void main(String[] args)
    {
        Scanner cs=new Scanner(System.in);
        int A[] =new int[5];
        for(int i=0;i<5;i++)
        {
            A[i]=cs.nextInt();
        }
        int n=A.length;
        int maximumsum = maxsumarray(A,0, n-1); 
        System.out.println("Maximum contiguous sum is "+ maximumsum); 
    }
}
