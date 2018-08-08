package br.unicentro.decomp.teste2.bd.modelpersistencia;

import java.sql.SQLException;
import java.util.List;

import br.unicentro.decomp.teste2.bd.modeldominio.DisciplinaBean;

public interface DisciplinaDAO {
	public void insere(DisciplinaBean disciplina) throws SQLException;

	public void atualiza(DisciplinaBean disciplina) throws SQLException;

	public void remove(DisciplinaBean disciplina) throws SQLException;

	public DisciplinaBean buscaPorCodigo(Integer codigo) throws SQLException;

	public List<DisciplinaBean> listaTodos() throws SQLException;
}
