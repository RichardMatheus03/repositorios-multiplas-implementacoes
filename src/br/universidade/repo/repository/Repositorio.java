package br.universidade.repo.repository;

public interface Repositorio {
    void adicionar(Object obj);
    void remover(String chave);
    Object buscar(String chave);
    Object[] listar();
}
