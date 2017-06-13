package fixtures;

import interfaces.ILeiloavel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import modelo.FachadaMercadoLeilaoComSerializacao;
import modelo.Produto;
import fit.ColumnFixture;
import fit.TypeAdapterTest.DateFormater;

public class ProdutoColumnFixtureTest extends ColumnFixture {

	public String nome;
	public String descricao;
	public String lanceMinimo;
	public String cpfLeiloador;
	public String dataLimite;
	FachadaMercadoLeilaoComSerializacao fachada = new FachadaMercadoLeilaoComSerializacao();

	public ProdutoColumnFixtureTest() {
		super();
	}

	public boolean cadastrarProduto() {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			fachada.cadastrarProduto(nome, descricao,
					Double.valueOf(lanceMinimo), cpfLeiloador,
					formatter.parse(dataLimite));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean produtoExiste() {
		boolean produtoExiste = false;
		try {
			List<? extends ILeiloavel> produtos = fachada.getProdutosEmLeilao();
			for (ILeiloavel produto : produtos) {
				if (nome.equals(produto.getNome())) {
					produtoExiste = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			produtoExiste = false;
		}
		return produtoExiste;
	}

	public boolean usuarioExiste() {
		try {
			fachada.getUsuarioPor(cpfLeiloador);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
