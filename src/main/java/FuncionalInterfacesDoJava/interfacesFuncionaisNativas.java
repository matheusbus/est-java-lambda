/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package FuncionalInterfacesDoJava;

/**
 *
 * @author Matheus
 */
public class interfacesFuncionaisNativas {
    /*
        | ------------------------------------------------ |
        |       ASSINATURA         |          NOME         |
        | ------------------------ | --------------------- |
        |       nada -> T          |        Supplier       |
        |       T -> nada          |        Consumer       |
        |         T -> T           |      UnaryOperator    |
        |       T, T -> T          |     BinaryOperator    |
        |         S -> T           |        Function       |
        |        T -> Boolean      |       Predicate       |
        | ------------------------ | --------------------- |
    
    */
    
    public static void main(String[] args) {
        
        java.util.function.Function<String,Double> funcao = (numero) -> { double a = Double.parseDouble(numero); return a; };
        System.out.println(funcao.apply("2"));
        
    }
}
