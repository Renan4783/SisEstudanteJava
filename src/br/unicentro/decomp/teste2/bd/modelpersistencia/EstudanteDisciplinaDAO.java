package br.unicentro.decomp.teste2.bd.modelpersistencia;

import java.sql.SQLException;
import java.util.List;

import br.unicentro.decomp.teste2.bd.modeldominio.EstudanteDisciplinaBean;

public interface EstudanteDisciplinaDAO {
	public void insere(EstudanteDisciplinaBean estudanteDisciplina) throws SQLException;

	public void atualiza(EstudanteDisciplinaBean estudanteDisciplina) throws SQLException;

	public void remove(EstudanteDisciplinaBean estudanteDisciplina) throws SQLException;

	public EstudanteDisciplinaBean buscaRegistro(String registro, Integer codigo) throws SQLException;

	public List<EstudanteDisciplinaBean> listaTodos() throws SQLException;
}