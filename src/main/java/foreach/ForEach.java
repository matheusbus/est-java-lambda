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
        
        System.out.println("\nMethod Reference #01");
        nomes.forEach(System.out::println);
        
        System.out.println("\nLambda #02");
        nomes.forEach(nome -> imprimePersonalizado(nome));
        
        System.out.println("\nMethod Reference #02");
        nomes.forEach(ForEach::imprimePersonalizado);
        
    }
    
    public static void imprimePersonalizado(String nome){
        System.out.println("Imprimindo personalizado: "+nome);
    }
    
}
