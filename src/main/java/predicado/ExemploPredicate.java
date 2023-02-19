/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package predicado;

import java.util.function.Predicate;

/**
 *
 * @author Matheus
 */
public class ExemploPredicate {
    
    public static void main(String[] args) {
        
        Carro carroTeste1 = new Carro("Wolksvagen", "Gol", 80000D, 0.10, "Azul");
        Carro carroTeste2 = new Carro("Wolksvagen", "Jetta", 120000D, 0.03, "Preto");
        
        // Predicate é instanciado passando um tipo e retorna -> {true/false}
        Predicate<Carro> carroIsAzul = carro -> carro.getCor().equals("Azul");
        
        System.out.println(carroIsAzul.test(carroTeste1));
        System.out.println(carroIsAzul.test(carroTeste2));
        
    }
    
}
