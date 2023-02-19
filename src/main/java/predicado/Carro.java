/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package predicado;

/**
 *
 * @author Matheus
 */
public class Carro {
    
    private String marca;
    private String nome;
    private double preco;
    private double desconto;
    private String cor;

    public Carro(String marca, String nome, double preco, double desconto, String cor) {
        this.marca = marca;
        this.nome = nome;
        this.preco = preco;
        this.desconto = desconto;
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return "Carro{" + "marca=" + marca + ", nome=" + nome + ", preco=" + preco + ", desconto=" + desconto + '}';
    }    
    
}
