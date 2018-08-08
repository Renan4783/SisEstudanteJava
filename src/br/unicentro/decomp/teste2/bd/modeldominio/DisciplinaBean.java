package br.unicentro.decomp.teste2.bd.modeldominio;

public class DisciplinaBean {
   private Integer codDisciplina;
   private String nome;

   public DisciplinaBean() {
   }
   
   public DisciplinaBean(String nome) {
       this.nome = nome;
   }
   
   public DisciplinaBean(Integer codDisciplina, String nome) {
       this.codDisciplina = codDisciplina;
       this.nome = nome;
   }
   
   public DisciplinaBean(String nome, Integer codDisciplina) {
       this.codDisciplina = codDisciplina;
       this.nome = nome;
   }

   public Integer getCodDisciplina() {
       return codDisciplina;
   }

   public void setCodDisciplina(Integer codDisciplina) {
       this.codDisciplina = codDisciplina;
   }

   public String getNome() {
       return nome;
   }

   public void setNome(String nome) {
       this.nome = nome;
   }

   @Override
   public String toString() {
       return "DisciplinaBean{" + "codigo=" + codDisciplina + ", nome=" + nome + '}';
   }
}