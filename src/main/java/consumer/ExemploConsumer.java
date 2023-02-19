/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consumer;

import predicado.Carro;

/**
 *
 * @author Matheus
 */
public class ExemploConsumer {
    
    public static void main(String[] args){
        
        Carro carro1 = new Carro("Chevrolet", "Chevette", 14000D, 0.12, "Prata");
        Carro carro2 = new Carro("Wolksvagen", "Jetta", 80000D, 0.03, "Branco");
        Carro carro3 = new Carro("Fiat", "Uno", 12000D, 0.10, "Chumbo");
        Carro carro4 = new Carro("Fiat", "Argo", 90000D, 0.08, "Laranja");
        
        System.out.println("Chamando Consumer #01");
        java.util.function.Consumer<Carro> meuConsumer = carro -> System.out.println("Nome: "+carro.getNome());
        meuConsumer.accept(carro1);
        
        System.out.println("\nChamando Consumer #02 - ForEach");
        java.util.List<Carro> carros = java.util.Arrays.asList(carro1, carro2, carro3, carro4);
        carros.forEach(meuConsumer); 
        // No método forEach já é esperado um Consumer. Neste caso, o Java entende que deve ser chamado o consumer.accept
        
        System.out.println("\nChamando Consumer #03 - Method Referece");
        carros.forEach(System.out::println);
    }

}
