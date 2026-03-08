package com.mycompany.homework1;
import java.util.Scanner;
public class NewClass {
    public static void main(String args[]){
        Scanner input = new Scanner (System.in);
        String name = input.nextLine();
        int points = input.nextInt();
        double balance = input.nextDouble();
        System.out.println("name points balance");
    }
}