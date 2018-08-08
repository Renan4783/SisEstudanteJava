package br.unicentro.decomp.teste2.bd.modelpersistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unicentro.decomp.teste2.bd.modeldominio.EstudanteBean;

public class EstudanteDAOJDBC implements EstudanteDAO, IConst {
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

	public void insere(EstudanteBean estudante) throws SQLException {
		open();
		this.sql = "insert into estudante (codestudante, nome, idade) VALUES(?,?,?)";
		this.statement = this.connection.prepareStatement(sql);
		this.statement.setInt(1, estudante.getCodEstudante());
		this.statement.setString(2, estudante.getNome());
		this.statement.setInt(3, estudante.getIdade());
		this.statement.execute();
		close();
	}

	public void atualiza(EstudanteBean estudante) throws SQLException {
		open();
		this.sql = "UPDATE estudante SET nome = ?, idade = ? WHERE codEstudante = ?";
		this.statement = this.connection.prepareStatement(sql);
		this.statement.setString(1, estudante.getNome());
		this.statement.setInt(2, estudante.getIdade());
		this.statement.setInt(3, estudante.getCodEstudante());
		this.statement.execute();
		close();
	}

	public void remove(EstudanteBean estudante) throws SQLException {
		open();
		this.sql = "DELETE FROM estudante WHERE codEstudante = ?";
		this.statement = this.connection.prepareStatement(sql);
		this.statement.setInt(1, estudante.getCodEstudante());
		this.statement.execute();
		close();
	}

	public EstudanteBean buscaPorCodigo(Integer codEstudante) throws SQLException {
		open();
		this.sql = "SELECT * FROM estudante WHERE codestudante = ?";
		this.statement = this.connection.prepareStatement(sql);
		this.statement.setInt(1, codEstudante);
		this.result = this.statement.executeQuery();
		if (this.result.next()) {
			EstudanteBean estudanteBean = new EstudanteBean();
			estudanteBean.setCodEstudante(this.result.getInt("codEstudante"));
			estudanteBean.setNome(this.result.getString("nome"));
			estudanteBean.setIdade(this.result.getInt("idade"));
			close();
			return estudanteBean;
		} else {
			close();
			return null;
		}
	}

	public List<EstudanteBean> listaTodos() throws SQLException {
		open();
		this.sql = "SELECT * FROM estudante";
		ArrayList<EstudanteBean> estudantes = new ArrayList<>();
		this.statement = this.connection.prepareStatement(sql);
		this.result = this.statement.executeQuery();
		while (this.result.next()) {
			EstudanteBean estudanteBean = new EstudanteBean();
			estudanteBean.setCodEstudante(this.result.getInt("codestudante"));
			estudanteBean.setNome(this.result.getString("nome"));
			estudanteBean.setIdade(this.result.getInt("idade"));
			estudantes.add(estudanteBean);
		}
		close();
		return estudantes;
	}
}
