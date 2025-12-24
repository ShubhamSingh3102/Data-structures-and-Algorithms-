package OOPS_4_PILLAR;
import java.util.*;
import Bank.*;  // aapne package ka information dusre package me use kr skte hai and dusre package ka information aapne package me use kr skte hai...
public class Hierarchical_Inheritance {
    public static class Shape{
        public void area(){
            System.out.println("Display Area");
        }
    }
    public static class Triangle extends Shape {
        public void area(int h , int b){
            System.out.println(1/2*h*b);
        }
    }
    public static class Circle extends Shape{
        public void area(int r){
            System.out.println(3.14*r*r);
        }
    }
    public static void main(String[] args) {
        Single_Level_Inheritance.Triangle t = new Single_Level_Inheritance.Triangle();
        t.area();
        Circle c = new Circle();
        c.area();
        Bank.Account  account1 = new Bank.Account();
        account1.name = "Customer 1";
        System.out.println(account1.name);
    }
}
