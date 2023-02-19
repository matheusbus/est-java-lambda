/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package function;

/**
 *
 * @author Matheus
 */
public class ExemploFunction {
    
    public static void main(String[] args) {
        
        java.util.function.Function<Integer,String> parOuImpar = 
                numero -> numero % 2 == 0 ? "Par" : "Impar";
        
        java.util.function.Function<String,String> imprimeResultado =
                valor -> "O resultado é: "+valor;
        
        java.util.function.Function<String,String> formataResultadoEmpolgado =
                resultado -> resultado + "!!!";
        
        java.util.function.Function<String,String> formataResultadoDuvida =
                resultado -> resultado + "???";
                
        String resultadoFinal1 = parOuImpar
                .andThen(imprimeResultado)
                .andThen(formataResultadoEmpolgado)
                .apply(24);
        
        String resultadoFinal2 = parOuImpar
                .andThen(imprimeResultado)
                .andThen(formataResultadoDuvida)
                .apply(25);
        
        System.out.println(resultadoFinal1);
        System.out.println(resultadoFinal2);
        
    }
    
}
