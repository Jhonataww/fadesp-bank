package com.fadesp.bank.domain.models;


import com.fadesp.bank.domain.enums.EstadoCivil;
import com.fadesp.bank.domain.enums.Genero;
import com.fadesp.bank.domain.enums.Nacionalidade;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.util.Date;

@Entity
public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String nome;

    @NotNull(message = "A data de nascimento é obrigatória")
    @Past(message = "A data de nascimento deve ser no passado")
    private Date dataNascimento;

    @NotNull(message = "O gênero é obrigatório")
    private Genero genero;

    @NotBlank(message = "O endereço é obrigatório")
    @Size(max = 255, message = "O endereço deve ter no máximo 255 caracteres")
    private String endereco;

    @Size(max = 20, message = "O telefone deve ter no máximo 20 caracteres")
    private String telefone;

    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "O e-mail deve ser válido")
    private String email;

    @NotBlank(message = "O CPF é obrigatório")
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter apenas 11 dígitos")
    private String cpf;

    @NotBlank(message = "O RG é obrigatório")
    @Size(max = 20, message = "O RG deve ter no máximo 20 caracteres")
    private String rg;

    @NotNull(message = "O estado civil é obrigatório")
    private EstadoCivil estadoCivil;

    @NotNull(message = "A nacionalidade é obrigatória")
    private Nacionalidade nacionalidade;

    @NotBlank(message = "O nome do pai é obrigatório")
    @Size(max = 100, message = "O nome do pai deve ter no máximo 100 caracteres")
    private String nomePai;

    @NotBlank(message = "O nome da mãe é obrigatório")
    @Size(max = 100, message = "O nome da mãe deve ter no máximo 100 caracteres")
    private String nomeMae;

    @NotBlank(message = "O estado é obrigatório")
    @Size(max = 50, message = "O estado deve ter no máximo 50 caracteres")
    private String estado;

    @NotBlank(message = "O país é obrigatório")
    @Size(max = 50, message = "O país deve ter no máximo 50 caracteres")
    private String pais;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public Nacionalidade getNacionalidade() {
        return nacionalidade;
    }

    public String getNomePai() {
        return nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public String getEstado() {
        return estado;
    }

    public String getPais() {
        return pais;
    }
}
