package br.com.dito.restaurante.service;

import br.com.dito.restaurante.model.Produto;
import br.com.dito.restaurante.DTO.ProdutoDTO;
import br.com.dito.restaurante.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public List<ProdutoDTO> listarTodos() {
        return produtoRepository.findAll()
                .stream()
                .map(p -> new ProdutoDTO(p.getNome(), p.getPreco(), p.getId()))
                .collect(Collectors.toList());
    }


    public  ProdutoDTO adicionarProduto (ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());

        produto = produtoRepository.save(produto);
        return new ProdutoDTO(produto.getNome(), produto.getPreco(), produto.getId());

    }


    public ProdutoDTO atualizarProduto( Long id, ProdutoDTO dto) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());
        produto = produtoRepository.save(produto);
        return new ProdutoDTO(produto.getNome(), produto.getPreco(), produto.getId());
    }

    public String deletarProduto(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produtoRepository.delete(produto);
        return "Produto removido com sucesso!";
    }

    public List<ProdutoDTO> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContaining(nome)
                .stream()
                .map(p -> new ProdutoDTO(p.getNome(), p.getPreco(), p.getId()))
                .collect(Collectors.toList());
    }

    public List<ProdutoDTO> buscarProdutoEntrePrecos(Double min, Double max) {
        return produtoRepository.findByPrecoBetween(min, max)
                .stream()
                .map(p -> new ProdutoDTO(p.getNome(), p.getPreco(), p.getId()))
                .collect(Collectors.toList());
    }

}
