package fixtures;

import modelo.FachadaMercadoLeilaoComSerializacao;
import fit.ColumnFixture;

public class UsuarioColumnFixtureTest extends ColumnFixture {

	public String nome;
	public String endereco;
	public String email;
	public String cpf;
	FachadaMercadoLeilaoComSerializacao fachada = new FachadaMercadoLeilaoComSerializacao();

	public UsuarioColumnFixtureTest() {
		super();
	}

	public boolean cadastrarUsuario() {
		try {
			fachada.cadastrarUsuario(nome, endereco, email, cpf);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean verificarUsuarioExiste() {
		try {
			fachada.getUsuarioPor(cpf);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
