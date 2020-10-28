package br.com.pessolti.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "{cliente.campo.nome.obrigatorio}")
    private String nome;

    @Column(nullable = false, length = 14)
    @NotBlank(message = "{cliente.campo.cpf.obrigatorio}")
    @NotNull(message = "{cliente.campo.cpf.obrigatorio}")
    @CPF(message = "{cliente.campo.cpf.invalido}")
    private String cpf;

    @Column(name = "data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataCadastro;

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDateTime.now());
    }
}
