import java.io.*;
import java.util.*;
class MergeSort2{

	void merge(int arr[],int l, int m, int r)
		{
			int n1=m-l+1;
			int n2=r-m;
			int L[]=new int[n1];
			int R[]=new int[n2];
				 for (int i=0; i<n1; i++) 
				L[i] = arr[l + i]; 
			for (int j=0; j<n2; j++) 
				R[j] = arr[m + 1+ j];
			
			int i=0,j=0;
			int k=l;
			 while (i < n1 && j < n2) { 
				if (L[i] <= R[j]) { 
					arr[k] = L[i]; 
					i++; 
				} 
				else{ 
					arr[k] = R[j]; 
					j++; 
				} 
				k++; 
			} 
	 
			while (i < n1) { 
				arr[k] = L[i]; 
				i++; 
				k++; 
			} 
	  
		  
			while (j < n2) { 
				arr[k] = R[j]; 
				j++; 
				k++; 
			} 
		}
		void sort(int arr[], int l, int r){
			 if (l<r){
				 int m1=(l+r)/3;
				 int m2= (l+r)*2/3;
				 sort(arr,l,m1);
				 sort(arr,m1+1,m2);
				 sort(arr,m2+1,r);
				// merge(arr,l,m,r);
				merge(arr,l,m1,m2);
				merge(arr,l,m2,r);
			 }
		}
		
		static void printarray(int arr[]){
		 int n=arr.length;
		 for(int i=0;i<n;i++)
			{System.out.print(arr[i]+"  ");
			}
		}




	public static void main(String args[]) throws Exception{		
				File f= new File("files/File 1.txt");
				Scanner sc=new Scanner(f);
				Scanner ip=new Scanner(System.in);
				Integer n=new Integer(0);
				int i=0;
				int j=0;
				while(sc.hasNext()){
				n=sc.nextInt();
				i++;
				}
				Scanner wr=new Scanner(f);
				int[] arr=new int[i];
				while(wr.hasNext())
				{
				arr[j]=wr.nextInt();
				j++;
				}
			printarray(arr);	
			MergeSort ob =new MergeSort();
			long a1=System.nanoTime();
			ob.sort(arr,0,i-1);	// average case
			long b1=System.nanoTime();
			long t1=b1-a1;
			printarray(arr);
			long a2=System.nanoTime();
			ob.sort(arr,0,i-1);	// best case
			long b2=System.nanoTime();
			long t2=b2-a2;
			printarray(arr);
				System.out.println("time taken in average case	: "+t1);
				System.out.println("time taken in best case 	: "+t2);
			//	System.out.println("time taken in worst case	: "+t3);
	}
}		
