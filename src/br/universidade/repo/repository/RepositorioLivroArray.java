package br.universidade.repo.repository;

import br.universidade.repo.modelo.Livro;

public class RepositorioLivroArray implements Repositorio {
    private Livro[] livros = new Livro[10];
    private int indice = 0;

    @Override
    public void adicionar(Object obj) {
        if (indice < livros.length) {
            livros[indice++] = (Livro) obj;
        } else {
            throw new NegocioException("O repositório de livros está cheio.");
        }
    }

    @Override
    public void remover(String chave) {
        for (int i = 0; i < indice; i++) {
            if (livros[i] != null && livros[i].getTitulo().equals(chave)) {
                livros[i] = null;
                compactar();
                indice--;
                return;
            }
        }
        throw new NegocioException("Livro com o título " + chave + " não encontrado.");
    }

    @Override
    public Object buscar(String chave) {
        for (int i = 0; i < indice; i++) {
            if (livros[i] != null && livros[i].getTitulo().equals(chave)) {
                return livros[i];
            }
        }
        return null;
    }

    @Override
    public Object[] listar() {
        Livro[] copia = new Livro[indice];
        System.arraycopy(livros, 0, copia, 0, indice);
        return copia;
    }

    private void compactar() {
        int i = 0;
        for (int j = 0; j < livros.length; j++) {
            if (livros[j] != null) {
                livros[i++] = livros[j];
            }
        }
        while (i < livros.length) {
            livros[i++] = null;
        }
    }
}
