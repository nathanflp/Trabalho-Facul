package controle.estoque.api.com.entity.dto;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(name = "Produto DTO", description = "Record usado para transferir dados para a entidade Produto")
public record ProdutoEntityDTO(Integer id, String nome, String marca, Integer quantidade) {
}
