/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package board;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author alice
 */
public class MainClass {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        String [] input_array;
        
        do {
            System.out.print("Enter  command: ");
            input = scanner.nextLine();
            
            
            //create canvas
            if(input.contains("C")){
                System.out.println("Create canvas");
                input_array =  input.split(" ");
                
            }
            else if(input.contains("L")){
                System.out.println("DrawLine");
            }
            else if(input.contains("R")){
                System.out.println("Draw Rectangle");
            }
            else if(input.contains("B")){
                System.out.println("Bucket");
            }
          
        } while (!input.contains("q"));
        System.out.print("Rest of program here..");

    }

}
