package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Usuario extends Model {
	//Aqui estão todos os atributos utilizados para o cadastro de uma instituição
	public String nome;
	public String email;
	public String instituicao;
	public String marca;
	public int quantidadePc;
}
