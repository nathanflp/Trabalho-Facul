package controle.estoque.api.com.service;

import controle.estoque.api.com.entity.ProdutoEntity;
import controle.estoque.api.com.entity.dto.ProdutoEntityDTO;
import controle.estoque.api.com.repository.ProdutoRepository;
import controle.estoque.api.com.tratamentoExcecao.ProdutoException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository repository;

    //Método para listar todos os produto
    public List<ProdutoEntity> listarTodos() {
        return repository.findAll();
    }

    //Método para listar somente um produto
    public ProdutoEntity listarUm(Integer id) throws ProdutoException  {
        Optional<ProdutoEntity> umProduto = repository.findById(id);
        if (umProduto.isPresent()) {
            return umProduto.get();
        }
        else {
            throw new ProdutoException("Produto não encontrado na base de dados");
        }
    }

    //Método para criar um produto
    public ProdutoEntity criarProduto(ProdutoEntityDTO produtoDTO) {
        ProdutoEntity produto = new ProdutoEntity(produtoDTO);
        repository.save(produto);
        return produto;
    }

    //Método para atualizar um produto
    @Transactional
    public void atualizarProduto(ProdutoEntityDTO dto) throws ProdutoException {
        Optional<ProdutoEntity> optionalProduto = repository.findById(dto.id());
        if(optionalProduto.isPresent()) {
            ProdutoEntity produto = optionalProduto.get();
            produto.setNome(dto.nome());
            produto.setMarca(dto.marca());
            produto.setQuantidade(dto.quantidade());
            repository.save(produto);
        }
        else{
            throw new ProdutoException("Produto não encontrado na base de dados");
        }
    }

    //Método para excluir um produto
    public void deletarProduto(Integer id) throws ProdutoException {
        Optional<ProdutoEntity> optionalProduto = repository.findById(id);

        if (optionalProduto.isPresent()) {
            ProdutoEntity delProduto = optionalProduto.get();
            repository.deleteById(delProduto.getId());
        }
        else{
            throw new ProdutoException("Produto não encontrado na base de dados");
        }
    }

}