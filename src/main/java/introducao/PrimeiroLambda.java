/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introducao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class PrimeiroLambda {
    
    public static void main(String[] args) {
        
        List<String> amigos = new ArrayList<>();
        amigos.add("Eduardo");
        amigos.add("Rafael");
        amigos.add("Carlos");
        
        amigos.forEach(amigo -> System.out.println("Meu amigo "+amigo));
        
        List<String> amigos2 = Arrays.asList("Cleber","Matheus");
        amigos2.forEach(amigo -> System.out.println("Meu novo amgigo "+amigo));
        
    }
    
}
