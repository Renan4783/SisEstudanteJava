package br.unicentro.decomp.teste2.bd.modelpersistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unicentro.decomp.teste2.bd.modeldominio.*;

public class DisciplinaDAOJDBC implements DisciplinaDAO, IConst {
	private String sql;
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet result;

	private void open() throws SQLException {
		this.connection = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
	}

	private void close() throws SQLException {
		this.connection.close();
	}

	public void insere(DisciplinaBean disciplina) throws SQLException {
		open();
		this.sql = "INSERT INTO disciplina (codDisciplina, nome) VALUES(?,?)";
		this.statement = this.connection.prepareStatement(sql);
		this.statement.setInt(1, disciplina.getCodDisciplina());
		this.statement.setString(2, disciplina.getNome());
		this.statement.execute();
		close();
	}

	public void atualiza(DisciplinaBean disciplina) throws SQLException {
		open();
		this.sql = "UPDATE disciplina SET nome = ? WHERE codDisciplina = ?";
		this.statement = this.connection.prepareStatement(sql);
		this.statement.setString(1, disciplina.getNome());
		this.statement.setInt(2, disciplina.getCodDisciplina());
		this.statement.execute();
		close();
	}

	public void remove(DisciplinaBean disciplina) throws SQLException {
		open();
		this.sql = "DELETE FROM disciplina WHERE codDisciplina = ?";
		this.statement = this.connection.prepareStatement(sql);
		this.statement.setInt(1, disciplina.getCodDisciplina());
		this.statement.execute();
		close();
	}

	public DisciplinaBean buscaPorCodigo(Integer codigo) throws SQLException {
		open();
		this.sql = "SELECT * FROM disciplina WHERE codDisciplina = ?";
		this.statement = this.connection.prepareStatement(sql);
		this.statement.setInt(1, codigo);
		this.result = this.statement.executeQuery();
		if (this.result.next()) {
			DisciplinaBean disciplinaBean = new DisciplinaBean();
			disciplinaBean.setCodDisciplina(this.result.getInt("codDisciplina"));
			disciplinaBean.setNome(this.result.getString("nome"));
			close();
			return disciplinaBean;
		} else {
			close();
			return null;
		}
	}

	public List<DisciplinaBean> listaTodos() throws SQLException {
		open();
		this.sql = "SELECT * FROM disciplina";
		ArrayList<DisciplinaBean> disciplinas = new ArrayList<>();
		this.statement = this.connection.prepareStatement(sql);
		this.result = this.statement.executeQuery();
		while (this.result.next()) {
			DisciplinaBean disciplinaBean = new DisciplinaBean();
			disciplinaBean.setCodDisciplina(this.result.getInt("codDisciplina"));
			disciplinaBean.setNome(this.result.getString("nome"));
			disciplinas.add(disciplinaBean);
		}
		close();
		return disciplinas;
	}

}
