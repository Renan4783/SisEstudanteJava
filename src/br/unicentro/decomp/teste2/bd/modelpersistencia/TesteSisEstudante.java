package br.unicentro.decomp.teste2.bd.modelpersistencia;

import java.sql.SQLException;

import br.unicentro.decomp.teste2.bd.modeldominio.*;

public class TesteSisEstudante {

    public static void main(String[] args) throws SQLException {
        EstudanteBean estudante = new EstudanteBean(1, "Andre", 22);
        EstudanteDAOJDBC estudanteDAO = new EstudanteDAOJDBC();
        
        System.out.println("######### Opera��es sobre a tabela Estudante ###########");
        
        System.out.println("Insere o estudante Andre:");
        estudanteDAO.insere(estudante);
        
        System.out.println("Lista os estudantes no banco:");
        //Chamadas a println com apenas um objeto fazem com que toString seja chamado
        //automaticamente.
        System.out.println(estudanteDAO.listaTodos());
        
        System.out.println("Muda o nome de Andr� para Andr� Galv�o e idade de 22 para 17:");
        EstudanteBean estudante01 = new EstudanteBean(1, "Andre Galvao", 17);
        estudanteDAO.atualiza(estudante01);
        
        System.out.println("Lista os estudantes no banco:");
        System.out.println(estudanteDAO.listaTodos());
        
        System.out.println("Insere o estudante Mario:");
        EstudanteBean estudante02 = new EstudanteBean(2, "Mario", 23);
        estudanteDAO.insere(estudante02);
        
        System.out.println("Lista os estudantes no banco:");
        System.out.println(estudanteDAO.listaTodos());
        
        System.out.println("Insere o estudante Carlos:");
        EstudanteBean estudante03 = new EstudanteBean(3, "Carlos", 27);
        estudanteDAO.insere(estudante03);
        
        System.out.println("Lista os estudantes no banco:");
        System.out.println(estudanteDAO.listaTodos());
        
        System.out.println("Retorna o estudante Mario:");
        System.out.println(estudanteDAO.buscaPorCodigo(2));
        
        System.out.println("Remove o estudante Mario:");
        estudanteDAO.remove(estudanteDAO.buscaPorCodigo(2));
        
        System.out.println("Lista os estudantes no banco:");
        System.out.println(estudanteDAO.listaTodos());        
        
        System.out.println("\n######### Opera��es sobre a tabela Disciplina ###########");
        
        DisciplinaBean disciplina = new DisciplinaBean(1, "Matem�tica");
        DisciplinaDAOJDBC disciplinaDAO = new DisciplinaDAOJDBC();

        System.out.println("Insere a disciplina Matem�tica:");
        disciplinaDAO.insere(disciplina);
        
        System.out.println("Lista as disciplinas no banco:");
        System.out.println(disciplinaDAO.listaTodos());
        
        System.out.println("Muda o nome de Matem�tica para C�lculo I:");
        DisciplinaBean disciplina01 = new DisciplinaBean("Calculo", 1);
        disciplinaDAO.atualiza(disciplina01);
        
        System.out.println("Lista as disciplinas no banco:");
        System.out.println(disciplinaDAO.listaTodos());
        
        System.out.println("Insere a disciplina Portugu�s:");
        DisciplinaBean disciplina02 = new DisciplinaBean(2, "Portugu�s");
        disciplinaDAO.insere(disciplina02);
        
        System.out.println("Lista as disciplinas no banco:");
        System.out.println(disciplinaDAO.listaTodos());
        
        System.out.println("Insere a disciplina Ingl�s:");
        DisciplinaBean disciplina03 = new DisciplinaBean(3, "Ingl�s");
        disciplinaDAO.insere(disciplina03);
        
        System.out.println("Lista as disciplinas no banco:");
        System.out.println(disciplinaDAO.listaTodos());
        
        System.out.println("Retorna a disciplina Portugu�s:");
        System.out.println(disciplinaDAO.buscaPorCodigo(2));
        
        System.out.println("Remove a disciplina Portugu�s:");
        disciplinaDAO.remove(disciplinaDAO.buscaPorCodigo(2));
        
        System.out.println("Lista as disciplinas no banco:");
        System.out.println(disciplinaDAO.listaTodos());        
        
        System.out.println("\n######### Opera��es sobre a tabela EstudanteDisciplina ###########");
        
        EstudanteDisciplinaBean estudanteDisciplinaBean = new EstudanteDisciplinaBean();
        estudanteDisciplinaBean.setEstudante(estudanteDAO.buscaPorCodigo(1));
        estudanteDisciplinaBean.setDisciplina(disciplinaDAO.buscaPorCodigo(1));
        		        
        System.out.println("Cria rela��o entre estudante e disciplina:");
        EstudanteDisciplinaDAOJDBC estudanteDisciplinaDAO = new EstudanteDisciplinaDAOJDBC();
        estudanteDisciplinaDAO.insere(estudanteDisciplinaBean);
        
        System.out.println("Lista todos as rela��es entre estudante e disciplina:");
        System.out.println(estudanteDisciplinaDAO.listaTodos());  
    }    
}