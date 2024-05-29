package controle.estoque.api.com.entity;

import controle.estoque.api.com.entity.dto.ProdutoEntityDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Table(name="produto")
@Entity(name="produto")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

@Schema(name = "Entidade Produto ", description = "Entidade usada para criar os produtos")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotBlank
    String nome;

    @NotNull
    Integer quantidade;

    String marca;

    public ProdutoEntity(ProdutoEntityDTO dto){
        this.nome = dto.nome();
        this.marca = dto.marca();
        this.quantidade = dto.quantidade();
    }
}
