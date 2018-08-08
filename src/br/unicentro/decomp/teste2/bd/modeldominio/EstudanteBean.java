package br.unicentro.decomp.teste2.bd.modeldominio;

public class EstudanteBean {
   private Integer codEstudante;
   private String nome;
   private Integer idade;

   
   public EstudanteBean() {
   }

   public EstudanteBean(String nome) {
       this.nome = nome;
   }
   
   public EstudanteBean(Integer codEstudante, String nome, Integer idade) {
       this.codEstudante = codEstudante;
	   this.nome = nome;
       this.idade = idade;
   }

   public Integer getCodEstudante() {
       return codEstudante;
   }

   public void setCodEstudante(Integer codEstudante) {
       this.codEstudante = codEstudante;
   }
   
   public String getNome() {
       return nome;
   }

   public void setNome(String nome) {
       this.nome = nome;
   }

   public Integer getIdade() {
       return idade;
   }

   public void setIdade(Integer idade) {
       this.idade = idade;
   }

   @Override
   public String toString() {
       return "EstudanteBean{" + "codigo=" + codEstudante + ", nome=" + nome + ", idade=" + idade + '}';
      
   }
}