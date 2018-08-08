package br.unicentro.decomp.teste2.bd.modelpersistencia;

import java.sql.SQLException;
import java.util.List;

import br.unicentro.decomp.teste2.bd.modeldominio.EstudanteBean;

public interface EstudanteDAO {
	public void insere(EstudanteBean estudante) throws SQLException;

	public void atualiza(EstudanteBean estudante) throws SQLException;

	public void remove(EstudanteBean estudante) throws SQLException;

	public EstudanteBean buscaPorCodigo(Integer codEstudante) throws SQLException;

	public List<EstudanteBean> listaTodos() throws SQLException;
}