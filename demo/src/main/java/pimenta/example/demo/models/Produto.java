package pimenta.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// @Document indica que essa classe será salva na coleção "produtos"
@Document(collection = "produtos")
public class Produto {

    // @Id indica que este campo é o identificador único do documento no MongoDB
    @Id
    private String id;

    private String nome;

    private double preco;

    public Produto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
