package com.sathish.ds.maths;

public class Episode1 {

    public static void main(String[] args) {
        //System.out.println(getCountOfANumber(1231));
        //System.out.println(checkNumberIsPalindrome(1));
        //System.out.println(getFactorialOfANumber(4));
        //System.out.println(getFactOfNumberRecur(14));
        //System.out.println(getCountOfTrailingZerosInFact(17));
        //System.out.println(getGcdOfTwoNumbers(13,7));
        //System.out.println(checkPrimeOrNot(10));
        //System.out.println(checkPrimeOrNot(22));
        //printPrimeFactorOfANumber(13);
        // printDivisorOfANumber(46);
        //printPowerOfANumber(40,0);
        int a=1,b=-2,c=1;
        double f,ans;
        f = Math.sqrt((b*b)-(4*a*c));
        ans = ((-1*b)+f)/(2*a);
        System.out.println(ans);


    }
    public static int getCountOfANumber(int n){
        int count=0;
        while(n!=0){
            count++;
            n=n/10;
        }
        return count;
    }
    public static boolean checkNumberIsPalindrome(int n){
        int tmp=n,rev=0;
        String s="";
        while(tmp>0){
            rev=rev*10+tmp%2;
            tmp=tmp/10;
        }
        if(rev==n){
            return true;
        }
        return false;
    }
    public static long getFactorialOfANumber(long n){
        long fact = 1;
        if(n==0){
            return 1;
        }
        for(int i=1;i<=n;i++){
            fact=fact*i;
        }
        return fact;
    }
    public static int getFactOfNumberRecur(int n){
        if(n==0){
            return 1;
        }
        return n*getFactOfNumberRecur((n-1));
    }
    public static int getCountOfTrailingZerosInFact(int n){
       //if we find number of 5 and 25 and so on 5 raise power n<input we can find number of zeros
        int res=0;
        for(int i = 5;i<=n;i=i*5){
            res = res+n/5;
        }
        return res;
    }
    public static int getGcdOfTwoNumbers(int a ,int b){
        if(b==0){
            return a;
        }
        return getGcdOfTwoNumbers(b,a%b);
    }
    public static boolean checkPrimeOrNot(int n){
       if(n==1){return false;}
       if(n==2 || n==3){return true;}
       if(n%2==0 || n%3==0){return false;}
       for (int i=5;i*i<=n;i=i+5){
           if(n%i==0 || n%(i+2)==0){
               return false;
           }
       }
        return true;
    }
    public static void printPrimeFactorOfANumber(int n) {
        if (n == 2 || n == 3) {
            System.out.println(n);
        }
            if (n % 2 == 0) {
                System.out.println(2);
                n=n/2;
            }
            if (n % 3 == 0) {
                System.out.println(3);
                n=n/3;
            }
            for (int i = 5; i * i <= n; i = i + 6) {
                while(n % i == 0) {
                    n=n/i;
                    System.out.println(i);
                }
                while (n % (i + 2) == 0) {
                    n=n/(i + 2);
                    System.out.println(i+2);
                }
            }
            if(n>3){
                System.out.println(n);
            }
        }
    public static void printDivisorOfANumber(int n){
        for(int i=1;i<=n;i++){
            if(n%i==0){
                System.out.println(i);
            }
        }
    }
    public static void printPowerOfANumber(int m,int n){
        Long power=1L;
        if(n==0){
            System.out.println(1);
            return;
        }
        if(n%2==0){
            for(int i = 1;i<=n/2;i++){
                power = power*(m*m);
            }
            System.out.println(power);
        }
        else{
            for(int i = 1;i<=(n-1)/2;i++){
                power = power*(m*m);
            }
            System.out.println((power*m));
        }
    }
}
