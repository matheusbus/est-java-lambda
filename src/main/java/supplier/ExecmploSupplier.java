/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supplier;

import predicado.Carro;
import java.util.List;
import java.util.Arrays;

/**
 *
 * @author Matheus
 */
public class ExecmploSupplier {
    
    public static void main(String[] args) {
        
        java.util.function.Supplier<List<Carro>> getCarros =
                () -> { return Arrays.asList(new Carro("Fiat", "Uno", 10000D, 0.10, "Preto"),
                                             new Carro("Chery", "Arizzo 5", 78000D, 0.05, "Prata"));
                        };
        
        getCarros.get().forEach(System.out::println);
        
    }
    
}
