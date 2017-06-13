package fixtures;

import java.text.SimpleDateFormat;

import modelo.FabricaDeMercado;
import modelo.MercadoLeilao;
import fitlibrary.SetUpFixture;

public class UsuarioEProdutoSetUpFixtureTest extends SetUpFixture {

	public UsuarioEProdutoSetUpFixtureTest() {
		super();
	}

	public void nomeEnderecoEmailCpfNomeProdutoDescricaoLanceMinimoCpfLeiloadorDataLimite(
			String nome, String endereco, String email, String cpf,
			String nomeProduto, String descricao, String lanceMinimo,
			String cpfLeiloador, String dataLimite) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			FabricaDeMercado fabrica = new FabricaDeMercado();
			MercadoLeilao mercado = new MercadoLeilao();
			mercado.cadastrarUsuario(nome, endereco, email, cpf);
			mercado.cadastrarProduto(nomeProduto, descricao,
					Double.valueOf(lanceMinimo), cpfLeiloador,
					formatter.parse(dataLimite));
			fabrica.desmontar(mercado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
