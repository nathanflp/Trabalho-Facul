package controle.estoque.api.com.controller;

import controle.estoque.api.com.entity.ProdutoEntity;
import controle.estoque.api.com.entity.dto.ProdutoEntityDTO;
import controle.estoque.api.com.service.ProdutoService;
import controle.estoque.api.com.tratamentoExcecao.ProdutoException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

//Link para o swagger: http://localhost:8080/swagger-ui.html
@RestController
@RequestMapping(value = "/produto")
@Tag(name = "Produto", description = "Controller para interagir com os produtos")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @Operation(summary = "Lista todos os produtos", method = "GET")
    @GetMapping
    public ResponseEntity getAllProduct(){
        List<ProdutoEntity> produto = service.listarTodos();
        return ResponseEntity.ok(produto);
    }

    @Operation(summary = "Lista um produto", method = "GET")
    @GetMapping("/{id}")
    public ProdutoEntity getOneProduct(@PathVariable("id") Integer id){
        ProdutoEntity produto = null;
        try {
            produto = service.listarUm(id);
        } catch (ProdutoException e) {
            System.out.println(e.getMessage());
        }
        return produto;
    }

    @Operation(summary = "Cadastra um produto", method = "POST")
    @PostMapping
    public ResponseEntity createProduct(@RequestBody @Valid ProdutoEntityDTO dto){
        ProdutoEntity novoProduto = service.criarProduto(dto);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @Operation(summary = "Atualiza um produto", method = "PUT")
    @PutMapping
    public ResponseEntity updateProduct(@RequestBody ProdutoEntityDTO dto) throws ProdutoException {
        service.atualizarProduto(dto);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Exclui um produto", method = "DELETE")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") Integer id){
        try {
            service.deletarProduto(id);
        } catch (ProdutoException e) {
            System.out.println(e.getMessage());
        }
        return ResponseEntity.noContent().build();
    }
}

