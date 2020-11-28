import java.util.*;
import java.lang.*;
import java.io.*;

public class A {
    //-----------Integer Array Input----------
    static int[] readIntArray(int n){
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scan.nextInt();
        return arr;
    }
    
    //-----------Long Array Input----------
    static long[] readLongArray(int n){
        long arr[]=new long[n];
        for(int i=0;i<n;i++)
            arr[i]=scan.nextLong();
        return arr;
    }
    
    //------------Boolean Array of Prime number----------------
    static boolean[] isPrimeArray(int e){
        boolean arr[] = new boolean[e+1];
        Arrays.fill(arr,true);
        arr[0]=false;
        arr[1]=false;
        for(int i=2;i*i<=e;i++){
            for(int j=2*i;j<=e;j+=i)
                arr[j]=false;
        }
        return arr;
            
    }
    
    //-----------Prime number Check----------------
    static boolean isPrime(int e){
        for(int i=2;i*i<=e;i++)
            if(e%i==0)
                return false;
        
        if(e==1) return false;
        return true;
    }
    
    //----------------Fast Power in range of MOD ------------------
    static long fastPower(long a,long b){
        long res=1;
        while(b>0){
            if(b%2!=0){
                res=(res*a%MOD)%MOD;
            }
            a=(a%MOD*a%MOD)%MOD;
            b=b>>1;
        }
        return res;
    }
    
    // ----------------Function for GCD(using recursion)-----------
    static long gcd(int a,int b){
    if(b==0)
        return a;
    else
        return gcd(b,a%b);
    }
    
    //---------Function for Counting Set Bits------------
    static int countSetBits(int n){
        int count=0;
        while(n>0){
            n=n&(n-1);
            count++;
        }
        return count;
    }
    
    //-------Function for lastDigit --------
    static boolean lastDigit(int n){
        int a=n;
        while(a>0){
            int ld=a%10;
            if(ld!=4 || ld!=7)
                return false;
            a=a/10;
        }
        return true;
    }
    
    //--------- Swap function--------------
    static void swap(long[] rank2,int a,int b){
        int temp=(int) rank2[a];
        rank2[b]=rank2[a];
        rank2[a]=temp;
        
    }
    //---------- Inverse of a Number in Range of MOD-----------
    static long Inverse(long n) {
    	return fastPower(n,MOD-2);
    }
    //----------Multiplication of two NUMBERS IN MOD-------------
    static long multiply(long a,long b) {
    	return ((a%MOD * b%MOD)%MOD);
    }
    
    //-----------Factorial of a Number-------------
    static final int SIZE=1000003;
    static long FACT[];
	static void computeFactorial() {
		FACT=new long[SIZE];
		FACT[0]=1;
		for(int i=1;i<SIZE;i++) {
			FACT[i]=multiply(FACT[i-1],i);
		}
	}
	
	//---------------COMPUTER NcR_MOD------------
	static long NCR(long n,long r) {
		if(r==0 || r==n)
			return 1;
		return (multiply(multiply(FACT[(int) n],Inverse(FACT[(int) r])),Inverse(FACT[(int) (n-r)])));
	}
	
	//-------------------MOD----------------------
    //static final long MOD= 1L<<32;
    static final long MOD= 1000000007;
    
    //-----------PrintWriter for faster output---------------------------------
    static final PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
    
    //-----------MyScanner Object----------------------------------
    public static MyScanner scan = new MyScanner();
    
    //-----------------Main method----------------
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int tc = scan.nextInt();
		//computeFactorial();
        for (int i = 0; i < tc; i++) {
            solve();
        }
		pw.close();
	}
	//-----------------Main function Ends here-----------------
	public static long SUM(long a,long b) {
		return (a+b)%MOD;
	}
	
	//------------Solve function for solving queries-----------------------
	private static void solve() {
        /* We need to print the permuntation so that for every position i(Pi) the value is not equal to i
         Pi != i

         My approach just shift every element one index either right or left and put the first/last at end;
        */
		int n=scan.nextInt();
        for(int i=2;i<=n;i++){
            pw.print(i+" ");  // shifted 1 position for every elment for 2nd position till last
        }
        pw.print(1); // finally print the 1st element at last as i shifted right
        pw.println(); // this is for line changing
        
    
		
    
    }
    //------------Solve function ends here-----------------
	
	

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

    }
    //-----------MyScanner class ends here------------------------
}
