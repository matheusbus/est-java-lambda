/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package predicado;

/**
 *
 * @author Matheus
 */
public class ExemploComposicaoPredicate {
 
    public static void main(String[] args) {
       
        Carro carroTeste1 = new Carro("Renault", "Picasso", 65000D, 0.15, "Azul");
        Carro carroTeste2 = new Carro("Renault", "Sandero", 40000D, 0.15, "Azul");
        java.util.function.Predicate<Carro> isAzul = carro -> carro.getCor().equals("Azul");
        java.util.function.Predicate<Carro> isCaro = carro -> carro.getPreco() >= 50000D;
        
        System.out.println(isAzul.test(carroTeste1));
        System.out.println(isAzul.and(isCaro).test(carroTeste1));
        System.out.println(isAzul.test(carroTeste2));
        // And
        System.out.println(isAzul.and(isCaro).test(carroTeste2));
        // Or
        System.out.println(isAzul.or(isCaro).test(carroTeste2));
        // Negate
        System.out.println(isAzul.or(isCaro).negate().test(carroTeste2));
        
    }
    
}
