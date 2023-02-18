/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package introducao;

@FunctionalInterface
public interface Calculo {
    
    double executar(double a, double b);
    
    default String algumMetodoDefault(){
        return "Posso ter um método default, que minha interface funcional continuará válida.";
    }
    
    static String algumMetodoStatic(){
        return "Posso ter um método static, que minha interface funcional continuará válida.";
    }
}
