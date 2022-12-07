package controllers;

import play.*;
import play.mvc.Controller;
import java.util.*;
import models.*;

public class Usuarios extends Controller {
	
	/*Todas são actions responsáveis por determinadas funcionalidades existentes no projeto;
	 * funcionalidades essas: salvar, editar, listar, detalhar e remover;
	 * a implementação do CRUD;
	*/

	//salvamento de todas as informações inseridas, e após, é listada todas elas em uma table;
	public static void salvar(Usuario usu) {
		usu.save();
		listar();
	}
	//detalha as informações inseridas nos campos, mas que por enquanto está inativo no nosso site;
	public  static void detalhar(Usuario a, String mensagem) {
		Usuario p = a;
		render(p, mensagem);
		
	}
	/*Barra de pesquisa;
	 * Realiza a pesquisa pela instituição a partir de qualquer caractere, estando no começo, no meio ou no final da palavra;
	 */
	public static void listar() {
		String pesquisar = params.get("pesquisar");

		List<Usuario> lista = Collections.EMPTY_LIST;
		if (pesquisar == null || pesquisar.isEmpty()) {
			lista = Usuario.findAll();
		} else {
			lista = Usuario.find("lower(nome) like ?1", "%" + pesquisar.toLowerCase() + "%").fetch();
		}
		render(lista, pesquisar);
		
	}
	
	public static void form() {
		render();
	}
	//opção de editar ou corrigir dados
	public static void editar(Long id) {
		Usuario usu = Usuario.findById(id);
		renderTemplate("Usuarios/form.html", usu);
	}
	//remover usuário do BD
	public static void remover(Long id) {
		Usuario usu = Usuario.findById(id);
		usu.delete();
		listar();
	}
	
	
}