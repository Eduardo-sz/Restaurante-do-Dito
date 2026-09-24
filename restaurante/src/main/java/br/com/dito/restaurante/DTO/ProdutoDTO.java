package br.com.dito.restaurante.DTO;

public class ProdutoDTO {
    private Long id;
    private String nome;
    private Double preco;


    //Constructor
    public ProdutoDTO(String nome, Double preco, Long id) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    //Getters and Setters
    public Double getPreco() {return preco;}
    public void setPreco(Double preco) {this.preco = preco;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
}
