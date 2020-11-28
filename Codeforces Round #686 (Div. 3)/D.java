import java.util.*;
import java.lang.*;
import java.io.*;

public class D {
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
    static boolean isPrime(long n){
        if(n==0 || n==1)
		    return false;
        else if(n==2 || n==3)
            return true;
        else if(n%2==0 || n%3==0)
            return false;
        for(int i=5;i*i<=n;i+=6)
            if(n%i==0 || n%(i+2)==0)
                return false;
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
        /*a(i+1)  is divisible by a(i) for each i from 1 to k−1;
            for 360
            2 2 90
            a(2) divisible by a(1) -- as 2 divides 2
            a(3) divisible by a(1) and a(2) -- as 90 is divisible by both 2 which comes earlier

         My approach just check for each i which divides the n and store the i which divides it maximum time
        */
        long n=scan.nextLong();
        long count=1; //total count when divisible by that number
        long finalDivisor=0; //after checking which number(i) divides maximum times the given number
        for(int i=2;i<=Math.sqrt(n);i++){ //loop terminating till Square Root and checking which number divides maximum time
            long temp=n;//temporary variable
            long tempCount=0; // temporary count
            while(temp%i==0){
                temp/=i;
                tempCount++;
            }
            if(count<tempCount){ // after the loop checking if count is less then tempCount if yes update the count and finalDivisor
                count=tempCount;
                finalDivisor=i;
            }
        }
        //Printing the output   O(1)--space  and 0(SqureRoot(n)*(log(n)))--time complexity
        pw.println(count);
        for(int i=1;i<=count-1;i++){
            pw.print(finalDivisor+" ");
            n/=finalDivisor;
        }
        pw.print(n);
        pw.println();
            
        

		
    
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
