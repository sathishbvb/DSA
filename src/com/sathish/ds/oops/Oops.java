package com.sathish.ds.oops;

public abstract class Oops {
    static{
        a=0;
    }

    public void run(){
        Object o= this.getClass();
        this.mustImplement();
    }
    private static Integer a;

    public abstract void mustImplement();

    public static void staticFunction(){
        System.out.println("staticFunction");
    }
    static class A extends Oops{

        @Override
        public void mustImplement() {
            staticFunction();
            a=a+1;
            System.out.println("using mustImplement function "+(a));
        }
    }
}
class B implements Parent<Integer>{

    @Override
    public void mustImplement(Integer data) {
        System.out.println(data);
    }

    @Override
    public void towMustImplement(Integer data) {
        System.out.println(data);
    }

    public static void main(String[] args) {
        B b = new B();
        b.run(23);
    }
}
