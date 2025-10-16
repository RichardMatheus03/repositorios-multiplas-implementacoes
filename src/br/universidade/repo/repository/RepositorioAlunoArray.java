package br.universidade.repo.repository;

import br.universidade.repo.modelo.Aluno;

public class RepositorioAlunoArray implements Repositorio {
    private Aluno[] alunos = new Aluno[10];
    private int indice = 0;

    @Override
    public void adicionar(Object obj) {
        if (indice < alunos.length) {
            alunos[indice++] = (Aluno) obj;
        } else {
            throw new NegocioException("O repositório de alunos está cheio.");
        }
    }

    @Override
    public void remover(String chave) {
        for (int i = 0; i < indice; i++) {
            if (alunos[i] != null && alunos[i].getMatricula().equals(chave)) {
                alunos[i] = null;
                compactar();
                indice--;
                return;
            }
        }
        throw new NegocioException("Aluno com a matrícula " + chave + " não encontrado.");
    }

    @Override
    public Object buscar(String chave) {
        for (int i = 0; i < indice; i++) {
            if (alunos[i] != null && alunos[i].getMatricula().equals(chave)) {
                return alunos[i];
            }
        }
        return null;
    }

    @Override
    public Object[] listar() {
        Aluno[] copia = new Aluno[indice];
        System.arraycopy(alunos, 0, copia, 0, indice);
        return copia;
    }

    private void compactar() {
        int i = 0;
        for (int j = 0; j < alunos.length; j++) {
            if (alunos[j] != null) {
                alunos[i++] = alunos[j];
            }
        }
        while (i < alunos.length) {
            alunos[i++] = null;
        }
    }
}
