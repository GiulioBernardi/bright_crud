package br.com.fiap.bright.main;

import br.com.fiap.bright.model.Usuario;
import br.com.fiap.bright.service.impl.UsuarioServiceImpl;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        UsuarioServiceImpl usuarioService = UsuarioServiceImpl.getInstance();
//		String nome, String email, LocalDate dataNascimento, String apelido, String senha, String genero, String pais
        Usuario u1 = new Usuario("Giulio", "giulio@gmail.com", LocalDate.of(2000, 10, 1), "GiulioBernardi", "miNhasenHaForte@123", "M", "BR");
        Usuario u2 = new Usuario("Andre", "andre@gmail.com", LocalDate.of(1999, 7, 22), "AndreM", "batatafrita", "M", "BR");
        Usuario u3 = new Usuario("Kaike", "kaike@gmail.com", LocalDate.of(2000, 5, 13), "Kaikek", "123456789", "M", "BR");
        Usuario u4 = new Usuario("Raissa", "raissa@gmail.com", LocalDate.of(1996, 1, 5), "RaissaRa", "aodjasd", "F", "BR");

        usuarioService.cadastrar(u1);
        usuarioService.cadastrar(u2);
        usuarioService.cadastrar(u3);
        usuarioService.cadastrar(u4);

        usuarioService.listar().forEach(System.out::println);
    }
}
