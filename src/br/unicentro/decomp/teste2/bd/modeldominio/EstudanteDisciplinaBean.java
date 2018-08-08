package br.unicentro.decomp.teste2.bd.modeldominio;

public class EstudanteDisciplinaBean {
	// A classe EstudanteDisciplina reutiliza a classe EstudanteBean por meio de Composi��o
	// O atributo ou vari�vel de inst�ncia estudante � uma refer�ncia a objetos da classe
	// EstudanteBean
	private EstudanteBean estudante;
	private DisciplinaBean disciplina;

	public EstudanteDisciplinaBean() {
	}

	public EstudanteDisciplinaBean(EstudanteBean estudante,
			DisciplinaBean disciplina) {
		this.estudante = estudante;
		this.disciplina = disciplina;
	}

	public EstudanteBean getEstudante() {
		return estudante;
	}

	public void setEstudante(EstudanteBean estudante) {
		this.estudante = estudante;
	}

	public DisciplinaBean getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(DisciplinaBean disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public String toString() {
		return "EstudanteDisciplinaBean{" + "estudante=" + this.estudante
				+ ", disciplina=" + this.disciplina + '}';
	}
}