package network.webtech.labmvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import network.webtech.labmvc.models.Produto;
import network.webtech.labmvc.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarProduto(String id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Produto não encontrado! Id: " + id));
    }

    public Produto adicionarProduto(Produto produto) {
        // Garante que um novo documento será criado, com id gerado pelo MongoDB
        produto.setId(null);
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(String id, Produto produto) {
        Produto existente = buscarProduto(id);
        existente.setNome(produto.getNome());
        existente.setPreco(produto.getPreco());
        return produtoRepository.save(existente);
    }

    public void removerProduto(String id) {
        buscarProduto(id);
        produtoRepository.deleteById(id);
    }
}
