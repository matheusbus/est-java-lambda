/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package introducao;

/**
 *
 * @author Matheus
 */
public class CalculoTesteComLambda {
    
    public static void main(String[] args) {
        
        // Isso pode ocorrer porque a interface Calculo possui apenas 1 método
        // Método esse que espera dois valores double e retorna um double.
        
        //Calculo calculo = (x,y) -> { return x + y; };
        Calculo calculo = (x,y) -> { double a = x + y; return a; };
        System.out.println(calculo.executar(5, 5));
        
        
        calculo = (x,y) -> x + y;
        System.out.println(calculo.executar(5, 5));
        
        calculo = (x,y) -> x * y;
        System.out.println(calculo.executar(5, 5));
        
    }
    
}
