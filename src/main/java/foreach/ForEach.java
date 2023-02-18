/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package foreach;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Matheus
 */
public class ForEach {
    
    public static void main(String[] args) {
        
        List<String> nomes = Arrays.asList("Bia", "Ana", "Clara");
        System.out.println("ForEach tradicional...");
        for(String nome : nomes){
            System.out.println(nome);
        }
        
        System.out.println("\nLambda #01");
        nomes.forEach(nome -> System.out.println("Nome: "+nome));
        
        System.out.println("\nLambda #02 - Com Method Reference");
        nomes.forEach(System.out::println);
        
        
    }
    
}
