import java.util.List;

import contracts.iAlunoRepository;
import exceptions.AlunoNaoEncontradoException;
import exceptions.MatriculaInvalidaException;
import repositories.ArrayListAlunoRepository;
import models.Aluno;


public class App {
    public static void main(String[] args) throws AlunoNaoEncontradoException {
        try {
            iAlunoRepository repository = new ArrayListAlunoRepository();

            repository.adicionar(new Aluno("Francisco Apolinário da Silva", "2546321542"));
            repository.adicionar(new Aluno("Laila Fenandes Lima", "4124563851"));
            repository.adicionar(new Aluno("Carol Francisma Pereira", "8896521554"));
            repository.adicionar(new Aluno("Rafael Bernardo Marques", "3652154785"));
            repository.adicionar(new Aluno("João Paulo Cintra", "2545165266"));
            
            List<Aluno> listaAlunos = repository.listar();
            System.out.println("Lista de Alunos:");
            for (Aluno aluno : listaAlunos) {
                System.out.println("Nome: " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula());
            }

            Aluno alunoBuscado = repository.buscar("Rafael Bernardo Marques");
            System.out.println("\nAluno buscado: " + alunoBuscado.getNome() + ", Matrícula: " + alunoBuscado.getMatricula());

            Aluno excluiraluno = repository.buscar("Laila Fenandes Lima");
            System.out.println("\nAluno apagado: " + excluiraluno.getNome() + ", Matrícula: " + excluiraluno.getMatricula());
            repository.remover(excluiraluno);

            List<Aluno> alunosRestantes = repository.listar();
            System.out.println("\nLista de Alunos atualizada:");
            for (Aluno aluno : alunosRestantes) {
                System.out.println("Nome: " + aluno.getNome() + ", Matrícula: " + aluno.getMatricula());
            }
        } catch (MatriculaInvalidaException e) {
            e.printStackTrace();
        }
    }
}
