package fixtures;

import modelo.FachadaMercadoLeilaoComSerializacao;
import fit.ActionFixture;

public class MercadoActionFixtureTest extends ActionFixture {

	FachadaMercadoLeilaoComSerializacao fachada = new FachadaMercadoLeilaoComSerializacao();

	public void montarMercado() {
		fachada.montarMercado();
	}

	public void desmontarMercado() {
		fachada.desmontarMercado();
	}

	public void limparMercado() {
		fachada.limparMercado();
	}

	public Boolean mercadoMontado() {
		return fachada.isMercadoMontado();
	}

	public Boolean mercadoDesmontado() {
		return fachada.isMercadoDesmontado();
	}

	public Boolean mercadoLimpo() {
		return !fachada.isPossuiUsuario();
	}
}
