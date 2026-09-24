package br.com.dito.restaurante.controller;

import br.com.dito.restaurante.DTO.ProdutoDTO;
import br.com.dito.restaurante.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {


    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoDTO> listarTodos() {
        return produtoService.listarTodos();
    }

    @PostMapping
    public  ProdutoDTO criarProduto(ProdutoDTO dto) {
        return produtoService.adicionarProduto(dto);
    }

    @PutMapping("/{id}")
    public ProdutoDTO atualizarProduto( Long id, ProdutoDTO dto) {
       return produtoService.atualizarProduto(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deletarProduto(Long id) {
        return produtoService.deletarProduto(id);
    }

    @GetMapping("/nome")
    public List<ProdutoDTO> buscarPorNome(String nome) {
        return produtoService.buscarPorNome(nome);
    }

    @GetMapping("/precos")
    public List<ProdutoDTO> buscarProdutoEntrePrecos(Double min, Double max) {
        return produtoService.buscarProdutoEntrePrecos(min, max);
    }


}
