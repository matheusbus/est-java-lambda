/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binaryOperatorAndBiFunction;

/**
 *
 * @author Matheus
 */
public class ExemploBinaryOperatorEBiFunction {
    
    public static void main(String[] args) {
        
        java.util.function.BinaryOperator<Double> media =
                (nota1, nota2) -> (nota1 + nota2) / 2;
        
        java.util.function.BiFunction<String, Double, String> conceito =
                (nome, nota) -> nota >= 7 
                            ? "Aluno " + nome + " com média "+nota+". Aprovado!"
                            : "Aluno " + nome + " com média "+nota+". Reprovado!";
        
        System.out.println(conceito.apply("Matheus", media.apply(5.5, 6.5)));
        System.out.println(conceito.apply("Joana", media.apply(8.0, 9.4)));
        
    }
    
}
