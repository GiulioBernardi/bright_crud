package br.com.fiap.bright.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@SequenceGenerator(name = "usuario", sequenceName = "sq_tb_usuario", allocationSize = 1)
@Table(name = "TB_USUARIO_CHALLENGE")
public class Usuario implements Serializable {

    private static final long serialVersionUID = -4336426250597723181L;

    public Usuario() {
        this.dataCadastro = LocalDateTime.now();
        this.situacao = true;
    }

    public Usuario(String nome, String email, LocalDate dataNascimento, String apelido, String senha, String genero, String pais) {
        this();
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.apelido = apelido;
        this.senha = senha;
        this.genero = genero;
        this.pais = pais;
    }

    @Id
    @GeneratedValue(generator = "usuario", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_usuario")
    private Long id;

    @Column(name = "nm_usuario", length = 50, nullable = false)
    private String nome;

    @Column(name = "ds_email", unique = true, nullable = false, length = 50)
    private String email;

    @Column(name = "dt_nascimento", nullable = false, updatable = false)
    private LocalDate dataNascimento;

    @Column(name = "dt_cadastro", nullable = false, updatable = false)
    private LocalDateTime dataCadastro;

    @Column(name = "ds_apelido", length = 50)
    private String apelido;

    @Column(name = "ds_senha", nullable = false)
    private String senha;

    @Column(name = "st_usuario", nullable = false)
    private Boolean situacao;

    @Column(name = "ds_genero", length = 2)
    private String genero;

    @Column(name = "ds_pais", length = 3, nullable = false)
    private String pais;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Usuário: "
                + "\n Id: " + this.getId()
                + "\n Nome:" + this.getNome()
                + "\n Email: " + this.getEmail()
                + "\n Data de nascimento: " + this.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + "\n Data de cadastro: " + this.getDataCadastro()
                + "\n Apelido (Nickname): " + this.getApelido()
                + "\n Senha: " + this.getSenha()
                + "\n Situação: " + this.getSituacao()
                + "\n Gênero: " + this.getGenero()
                + "\n País: " + this.getPais();

    }
}
