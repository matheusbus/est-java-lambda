# Java - Estudos sobre Expressões Lambda

# 1 - Primeiras expressões Lambda

---

## 1.1 - Atribuindo Lambda ao valor de Variável de tipo Interface

---

No código abaixo, atribuo o valor de uma lambda expression para uma variável do tipo interface.

> Atenção: para funcionar, a expressão lambda tem que bater exatamente com o **único** método que existe em minha interface.
>

```java
public class CalculoTesteComLambda {
    
    public static void main(String[] args) {
        
        // Isso pode ocorrer porque a interface Calculo possui apenas 1 método
        // Método esse que espera dois valores double e retorna um double.
        
        Calculo calculo = (x,y) -> { return x + y; };
        System.out.println(calculo.executar(5, 5));
        
        
        calculo = (x,y) -> x + y;
        System.out.println(calculo.executar(5, 5));
        
        calculo = (x,y) -> x * y;
        System.out.println(calculo.executar(5, 5));
        
    }
    
}
```

<aside>
💡 Quando eu tiver mais de uma sentença de código preciso obrigatoriamente colocar a sentença entre chaves { }.
Já quando eu tiver apenas uma sentença, posso omitir as chaves, e também a palavra chave **return**

</aside>

---

# 2 - Interfaces funcionais @functionalInterface

---

A partir das interfaces funcionais é que vamos poder criar as expressões lambdas.

Podemos utilizar a notação:

- @FunctionalInterface

Em interfaces. **Essa anotação irá obrigar a interface a ter somente um único método.**

```java
@FunctionalInterface
public interface Calculo {
    
    double executar(double a, double b);
    
}
```

Para consultarmos as Interfaces Funcionais nativas do Java:

[java.util.function (Java Platform SE 8 )](https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html)

## 2.1 - Utilizando Interfaces funcionais nativas do Java

```java
public class InterfaceFuncionalNativa {
    
    public static void main(String[] args) {
        
        BinaryOperator<Integer> calc = (a,b) -> { return a / b;};
        System.out.println(calc.apply(10, 1));
        
        BiFunction<String, Integer, String> func = (t, u) -> 
									{ return "Nome: "+t+ ", Idade: "+u; };
        System.out.println(func.apply("Matheus", 20));   
        
    }
}
```

# 3 - ForEach funcional

---

## 3.1 - Method Reference

---

```java
System.out.println("\nLambda #02 - Com Method Reference");
nomes.forEach(System.out::println);
```

<aside>
💡 O que acontece aqui: para cada objeto em nomes, será chamado o system.out.println passando o nome por parâmetro.

</aside>

Posso também chamar por method reference um método meu.

```java
		public static void main(String[] args) {

        System.out.println("\nMethod Reference #02");
        nomes.forEach(ForEach::imprimePersonalizado);
        
    }
    
    public static void imprimePersonalizado(String nome){
        System.out.println("Imprimindo personalizado: "+nome);
    }
```

---

Todos os exemplo de forEach feitos em aula, utilizando lambda e method reference:

```java
public class ForEach {
    
    public static void main(String[] args) {
        
        List<String> nomes = Arrays.asList("Bia", "Ana", "Clara");
        System.out.println("ForEach tradicional...");
        for(String nome : nomes){
            System.out.println(nome);
        }
        
        System.out.println("\nLambda #01");
        nomes.forEach(nome -> System.out.println("Nome: "+nome));
        
        System.out.println("\nMethod Reference #01");
        nomes.forEach(System.out::println);
        
        System.out.println("\nLambda #02");
        nomes.forEach(nome -> imprimePersonalizado(nome));
        
        System.out.println("\nMethod Reference #02");
        nomes.forEach(ForEach::imprimePersonalizado);
        
    }
    
    public static void imprimePersonalizado(String nome){
        System.out.println("Imprimindo personalizado: "+nome);
    }
    
}
```

# 4 - Interface Funcional: Predicate

---

O predicate é uma interface funcional nativa do Java que consiste em receber um valor de tipo Generics passado na instância e retorna um valor do tipo booleano.

Exemplo:

```java
public class ExemploPredicate {
    
    public static void main(String[] args) {
        
        Carro carroTeste1 = new Carro("Wolksvagen", "Gol", 80000D, 0.10, "Azul");
        Carro carroTeste2 = new Carro("Wolksvagen", "Jetta", 120000D, 0.03, "Preto");
        
        // Predicate é instanciado passando um tipo e retorna -> {true/false}
        Predicate<Carro> carroIsAzul = carro -> carro.getCor().equals("Azul");
        
        System.out.println(carroIsAzul.test(carroTeste1));
        System.out.println(carroIsAzul.test(carroTeste2));
        
    }
    
}
```

## 4.1 - Composição de Predicate

---

Em alguns casos, vou precisar fazer uma validação com &&.

Neste caso, posso utilizar a composição de Predicate

- **meuPredicate.and(outroPredicate).teste(meuArgumento);**
- **meuPredicate.or(outroPredicate).teste(meuArgumento);**

Posso fazer uma negação também:

- **isAzul.or(isCaro).negate().test(carroTeste2)**

```java
public class ExemploComposicaoPredicate {
 
    public static void main(String[] args) {
       
        Carro carroTeste1 = new Carro("Renault", "Picasso", 65000D, 0.15, "Azul");
        Carro carroTeste2 = new Carro("Renault", "Sandero", 40000D, 0.15, "Azul");
        java.util.function.Predicate<Carro> isAzul = carro -> carro.getCor().equals("Azul");
        java.util.function.Predicate<Carro> isCaro = carro -> carro.getPreco() >= 50000D;
        
        System.out.println(isAzul.test(carroTeste1));
        System.out.println(isAzul.and(isCaro).test(carroTeste1));
        System.out.println(isAzul.test(carroTeste2));
        // And
        System.out.println(isAzul.and(isCaro).test(carroTeste2));
        // Or
        System.out.println(isAzul.or(isCaro).test(carroTeste2));
        // Negate
        System.out.println(isAzul.or(isCaro).negate().test(carroTeste2));

				/*
					Resultados:
						true
						true
						true
						false
				*/

    }
    
}
```

---

# 5 - Interface Funcional: Consumer

---

**O Consumer é uma interface funcional que recebe um parâmetro de um tipo passado e não retorna nada → Retorno void.**

Exemplo:

```java
public class ExemploConsumer {
    
    public static void main(String[] args){
        
        Carro carro1 = new Carro("Chevrolet", "Chevette", 14000D, 0.12, "Prata");
        Carro carro2 = new Carro("Wolksvagen", "Jetta", 80000D, 0.03, "Branco");
        Carro carro3 = new Carro("Fiat", "Uno", 12000D, 0.10, "Chumbo");
        Carro carro4 = new Carro("Fiat", "Argo", 90000D, 0.08, "Laranja");
        
        System.out.println("Chamando Consumer #01");
        java.util.function.Consumer<Carro> meuConsumer = 
						carro -> System.out.println("Nome: "+carro.getNome());
        meuConsumer.accept(carro1);
        
        System.out.println("\nChamando Consumer #02 - ForEach");
        java.util.List<Carro> carros = java.util.Arrays.asList(carro1, carro2, 
																															 carro3, carro4);
        carros.forEach(meuConsumer); 
        // No método forEach já é esperado um Consumer. Neste caso, o Java entende que deve ser chamado o consumer.accept
        
        System.out.println("\nChamando Consumer #03 - Method Referece");
        carros.forEach(System.out::println);
    }

}
```

Saída:

```
Chamando Consumer #01
Nome: Chevette

Chamando Consumer #02 - ForEach
Nome: Chevette
Nome: Jetta
Nome: Uno
Nome: Argo

Chamando Consumer #03 - Method Referece
Carro{marca=Chevrolet, nome=Chevette, preco=14000.0, desconto=0.12}
Carro{marca=Wolksvagen, nome=Jetta, preco=80000.0, desconto=0.03}
Carro{marca=Fiat, nome=Uno, preco=12000.0, desconto=0.1}
Carro{marca=Fiat, nome=Argo, preco=90000.0, desconto=0.08}
```

---

# 6 - Interface funcional: Function

---

**A interface function representa uma função que aceita um argumento de um tipo e produz um resultado de um tipo.**

- java.util.function.Function<TipoEsperado, TipoResultado> minhaFuncao
- Para utilizar a função: **minhaFuncao.apply(meuArgumento);**

Exemplo de utilização:

```java
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
```

<aside>
💡 Eu posso aninhar mais de uma função, chamando uma através do resultado da outra.
Para isso é utilizado o **andThen**, que recebe como argumento outra função.

</aside>

---

# 7 - Interface funcional: Supplier

---

**O supplier é uma interface que não espera nenhum parâmetro, mas devolve alguma coisa.**

- java.util.function.Supplier<TipoRetorno> meuSupplier = ( ) → { sentença };

```java
public class ExecmploSupplier {
    
    public static void main(String[] args) {
        
        java.util.function.Supplier<List<Carro>> getCarros =
                () -> { return Arrays.asList(
													 new Carro("Fiat", "Uno", 10000D, 0.10, "Preto"),
                           new Carro("Chery", "Arizzo 5", 78000D, 0.05, "Prata"));
                        };
        
        getCarros.get().forEach(System.out::println);
        
    }
    
}
```

Para chamar o Supplier:

- meuSupplier.get();

---

# 8 - Unary Operator

---

Represents an operation on a single operand that produces a result of the same type as its operand.

- **java.util.function.UnaryOperator<TipoParametro> minhaFunc = param → alguma coisa do mesmo tipo do parametro**

Exemplo:

```java
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
        
        System.out.println(resultado1+" é maior que 10:"+ehMaiorQue10.test(resultado1));
        System.out.println(resultado2+" é maior que 10:"+ehMaiorQue10.test(resultado2));

				/*
							Resultados:

						2.8284271247461903
						2.8284271247461903
						2.8284271247461903 é maior que 10: false
						2.8284271247461903 é maior que 10: false
				*/

		}
    
}
```

---

# 9 - Interfaces funcionais: Binary Operator e BiFunction

---

Exemplo de BinaryOperator e BiFunction:

```java
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
```

# 10 - Desafio

---

Desafio proposto em aula:

```java
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
```

