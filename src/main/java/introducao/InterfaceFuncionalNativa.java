/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introducao;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 *
 * @author Matheus
 */
public class InterfaceFuncionalNativa {
    
    public static void main(String[] args) {
        
        BinaryOperator<Integer> calc = (a,b) -> { return a / b;};
        System.out.println(calc.apply(10, 1));
        
        BiFunction<String, Integer, String> func = (t, u) -> { return "Nome: "+t+ ", Idade: "+u; };
        System.out.println(func.apply("Matheus", 20));   
        
    }
}
