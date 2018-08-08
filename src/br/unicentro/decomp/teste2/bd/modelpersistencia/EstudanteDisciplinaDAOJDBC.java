package br.unicentro.decomp.teste2.bd.modelpersistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unicentro.decomp.teste2.bd.modeldominio.*;

public class EstudanteDisciplinaDAOJDBC implements EstudanteDisciplinaDAO, IConst {
	private String sql;
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet result;

	private void open() throws SQLException {
		this.connection = DriverManager.getConnection(stringDeConexao, usuario, senha);
	}

	private void close() throws SQLException {
		this.statement.close();
		this.connection.close();
	}

	public void insere(EstudanteDisciplinaBean estudanteDisciplina) throws SQLException {
		open();
		this.sql = "INSERT INTO EstudanteDisciplina(codEstudante, codDisciplina) VALUES(?,?)";
		this.statement = this.connection.prepareStatement(sql);
		this.statement.setInt(1, estudanteDisciplina.getEstudante().getCodEstudante());
		this.statement.setInt(2, estudanteDisciplina.getDisciplina().getCodDisciplina());
		this.statement.executeUpdate();
		close();
	}

	public void atualiza(EstudanteDisciplinaBean estudanteDisciplina) throws SQLException {
		open();
		this.sql = "UPDATE EstudanteDisciplina SET codDisciplina = ? WHERE codEstudante = ?";
		this.statement = this.connection.prepareStatement(sql);
		this.statement.setInt(2, estudanteDisciplina.getDisciplina().getCodDisciplina());
		this.statement.setInt(1, estudanteDisciplina.getEstudante().getCodEstudante());
		this.statement.execute();
		close();
	}

	public void remove(EstudanteDisciplinaBean estudanteDisciplina) throws SQLException {
		open();
		this.sql = "DELETE FROM EstudanteDisciplina WHERE codEstudante = ? AND codDisciplina = ?";
		this.statement = this.connection.prepareStatement(sql);
		this.statement.setInt(1, estudanteDisciplina.getEstudante().getCodEstudante());
		this.statement.setInt(2, estudanteDisciplina.getDisciplina().getCodDisciplina());
		this.statement.execute();
		close();
	}

	public EstudanteDisciplinaBean buscaRegistro(String registro, Integer codigo) throws SQLException {
		open();
		this.sql = "SELECT * FROM EstudanteDisciplina WHERE codEstudante = ? AND codDisciplina = ?";
		this.statement = this.connection.prepareStatement(sql);
		this.statement.setString(1, registro);
		this.statement.setInt(2, codigo);
		this.result = this.statement.executeQuery();
		EstudanteDAOJDBC estudanteDAO = new EstudanteDAOJDBC();
		DisciplinaDAOJDBC disciplinaDAO = new DisciplinaDAOJDBC();
		if (this.result.next()) {
			EstudanteDisciplinaBean estudanteDisciplina = new EstudanteDisciplinaBean();
			estudanteDisciplina.setEstudante(estudanteDAO.buscaPorCodigo(this.result.getInt("codEstudante")));
			estudanteDisciplina.setDisciplina(disciplinaDAO.buscaPorCodigo(this.result.getInt("codDisciplina")));
			close();
			return estudanteDisciplina;
		} else {
			close();
			return null;
		}
	}

	public List<EstudanteDisciplinaBean> listaTodos() throws SQLException {
		open();
		this.sql = "SELECT * FROM EstudanteDisciplina";
		// ArrayList - cria uma lista de array, que � um array com tamanho
		// din�mico
		// com refer�ncias a objetos
		ArrayList<EstudanteDisciplinaBean> estudanteDisciplinas = new ArrayList<>();
		this.statement = this.connection.prepareStatement(sql);
		// valores consultados com um comando SQL s�o retornados em objetos
		// do tipo ResultSet
		this.result = this.statement.executeQuery();
		EstudanteDAOJDBC estudanteDAO = new EstudanteDAOJDBC();
		DisciplinaDAOJDBC disciplinaDAO = new DisciplinaDAOJDBC();
		// ent�o move-se o cursor para o pr�ximo registro usando o
		// m�todo result.next()
		// e obt�m-se o valor da coluna desejada com result.getXXX()
		while (this.result.next()) {
			EstudanteDisciplinaBean estudanteDisciplina = new EstudanteDisciplinaBean();
			estudanteDisciplina.setEstudante(estudanteDAO.buscaPorCodigo(this.result.getInt("codEstudante")));
			estudanteDisciplina.setDisciplina(disciplinaDAO.buscaPorCodigo(this.result.getInt("codDisciplina")));
			// adiciona elementos ao fim da lista, um de cada vez
			estudanteDisciplinas.add(estudanteDisciplina);
		}
		close();
		return estudanteDisciplinas;
	}
}