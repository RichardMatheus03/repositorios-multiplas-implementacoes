package br.universidade.repo.app;

import br.universidade.repo.modelo.Aluno;
import br.universidade.repo.modelo.Livro;
import br.universidade.repo.repository.NegocioException;
import br.universidade.repo.repository.Repositorio;
import br.universidade.repo.repository.RepositorioAlunoArray;
import br.universidade.repo.repository.RepositorioLivroArray;

public class App {
    public static void main(String[] args) {
        
        // Repositório de Alunos
        Repositorio repositorioAlunos = new RepositorioAlunoArray();

        System.out.println("--- Repositório de Alunos ---");

        try {
            repositorioAlunos.adicionar(new Aluno("123", "João"));
            repositorioAlunos.adicionar(new Aluno("456", "Maria"));
            System.out.println("Alunos adicionados com sucesso!");
        } catch (NegocioException e) {
            System.err.println("Erro ao adicionar aluno: " + e.getMessage());
        }

        System.out.println("\nListando alunos:");
        for (Object obj : repositorioAlunos.listar()) {
            System.out.println(obj);
        }

        System.out.println("\nBuscando aluno com matrícula 456:");
        Object alunoEncontrado = repositorioAlunos.buscar("456");
        if (alunoEncontrado != null) {
            System.out.println("Aluno encontrado: " + alunoEncontrado);
        } else {
            System.out.println("Aluno não encontrado.");
        }

        try {
            System.out.println("\nRemovendo aluno com matrícula 123:");
            repositorioAlunos.remover("123");
            System.out.println("Aluno removido com sucesso!");
        } catch (NegocioException e) {
            System.err.println("Erro ao remover aluno: " + e.getMessage());
        }

        System.out.println("\nListando alunos após remoção:");
        for (Object obj : repositorioAlunos.listar()) {
            System.out.println(obj);
        }

        // Repositório de Livros
        Repositorio repositorioLivros = new RepositorioLivroArray();

        System.out.println("\n--- Repositório de Livros ---");

        try {
            repositorioLivros.adicionar(new Livro("O Senhor dos Anéis", "J.R.R. Tolkien"));
            repositorioLivros.adicionar(new Livro("O Hobbit", "J.R.R. Tolkien"));
            System.out.println("Livros adicionados com sucesso!");
        } catch (NegocioException e) {
            System.err.println("Erro ao adicionar livro: " + e.getMessage());
        }

        System.out.println("\nListando livros:");
        for (Object obj : repositorioLivros.listar()) {
            System.out.println(obj);
        }

        System.out.println("\nBuscando livro com título 'O Hobbit':");
        Object livroEncontrado = repositorioLivros.buscar("O Hobbit");
        if (livroEncontrado != null) {
            System.out.println("Livro encontrado: " + livroEncontrado);
        } else {
            System.out.println("Livro não encontrado.");
        }

        try {
            System.out.println("\nRemovendo livro com título 'O Senhor dos Anéis':");
            repositorioLivros.remover("O Senhor dos Anéis");
            System.out.println("Livro removido com sucesso!");
        } catch (NegocioException e) {
            System.err.println("Erro ao remover livro: " + e.getMessage());
        }

        System.out.println("\nListando livros após remoção:");
        for (Object obj : repositorioLivros.listar()) {
            System.out.println(obj);
        }
    }
}