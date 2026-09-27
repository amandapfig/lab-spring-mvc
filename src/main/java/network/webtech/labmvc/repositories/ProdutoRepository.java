package network.webtech.labmvc.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import network.webtech.labmvc.models.Produto;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
    // Métodos de CRUD (save, findById, findAll, deleteById...) já vêm prontos.
    // Métodos de consulta personalizados podem ser adicionados aqui, se necessário.
}
