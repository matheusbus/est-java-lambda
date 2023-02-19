/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binaryOperatorAndBiFunction;

import predicado.Carro;

/**
 *
 * @author Matheus
 */
public class Desafio {
    
    public static void main(String[] args) {
        
        Carro carro = new Carro("Fiat", "Mobi", 47990.90, 0.08, "Preto");
        
        /*
            Desafio implementar toda a lógica utilizando as interfaces funcionais:
        
            1. A partir do carro calcular o preco real, com desconto.
            2. Imposto Municipal: >= 25000 (8.5%) / < 25000 (Isento)
            3. Frete: >= 30000 (500) / < 30000 (150)
            4. Formatar: R$1234,56
        */
        
        java.util.function.Function<Carro, Double> calculaPrecoComDesconto =
                (carrp) -> carro.getPreco() * (1 - carro.getDesconto());
        
        java.util.function.Function<Double, Double> calculaPrecoComFrete =
                (precoComDesconto) -> precoComDesconto >= 25000D 
                    ? precoComDesconto + (precoComDesconto * 0.085)
                    : precoComDesconto;
        
        java.util.function.Function<Double, String> formataValor =
                valor -> "R$" + String.format("%.2f", valor);
        
        String valorFinal = calculaPrecoComDesconto
                .andThen(calculaPrecoComFrete)
                .andThen(formataValor)
                .apply(carro);
        
        System.out.println("Preço final: "+valorFinal);
        
    }
    
}
