/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unaryOperator;

/**
 *
 * @author Matheus
 */
public class ExemploUnaryOperator {
    
    public static void main(String[] args) {
        
        java.util.function.UnaryOperator<Double> somaDois = 
                num -> num + 2;
        java.util.function.UnaryOperator<Double> multiplicaDois = 
                num -> num * 2;
        java.util.function.UnaryOperator<Double> raizDois = 
                num -> Math.sqrt(num);

        Double resultado1 = somaDois
                .andThen(multiplicaDois)
                .andThen(raizDois)
                .apply(2.0);
        
        System.out.println(resultado1);
        
        Double resultado2 = raizDois
                .compose(multiplicaDois)
                .compose(somaDois)
                .apply(2.0);
        
        System.out.println(resultado2);
        
        java.util.function.Predicate<Double> ehMaiorQue10 =
                num -> num > 10;
        
        System.out.println(resultado1+" é maior que 10: "+ehMaiorQue10.test(resultado1));
        System.out.println(resultado2+" é maior que 10: "+ehMaiorQue10.test(resultado2));
    }
    
}
