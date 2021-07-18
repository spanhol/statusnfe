package testetecnico.spanhol.statusnfe;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import testetecnico.spanhol.statusnfe.modelo.Autorizador;
import testetecnico.spanhol.statusnfe.modelo.Servico;
import testetecnico.spanhol.statusnfe.modelo.ServicoColetado;

/**
 *
 * @author span
 */
public class ColetorDeStatusNFE {

	private static final String TEXTO_BOLA_VERDE = "imagens/bola_verde_P.png";
	private static final String TEXTO_BOLA_AMARELA = "imagens/bola_amarela_G.png";
	private static final String TEXTO_BOLA_VERMELHA = "imagens/bola_vermelho_G.png";

	ArrayList<Autorizador> autorizadores;
	ArrayList<Servico> listaDeServicos;

	public ColetorDeStatusNFE(Iterable<Servico> servicos) {
		autorizadores = new ArrayList<>();
		listaDeServicos = new ArrayList<>();
		for (Servico servico : servicos) {
			listaDeServicos.add(servico);
		}
	}

	public void buscarDados() {
		Document doc;
		Timestamp now = new Timestamp(System.currentTimeMillis());
		try {
			doc = Jsoup.connect("http://www.nfe.fazenda.gov.br/portal/disponibilidade.aspx").get();
			Element table = doc.selectFirst("#ctl00_ContentPlaceHolder1_gdvDisponibilidade2");

			boolean headerTabela = true;

			Autorizador atual = null;

			for (Element e : table.getElementsByTag("tr")) {
				if (headerTabela) {
					Elements ths = e.getElementsByTag("th");
					for (Element th : ths) {
						String texto = th.text();
						if (texto.compareTo("Autorizador") != 0 && texto.compareTo("Tempo Médio") != 0) {
							boolean encontrado = false;
							for (Servico serv : listaDeServicos) {
								if (serv.getNome().compareTo(texto) == 0) {
									encontrado = true;
								}
							}
							if (!encontrado) {
								listaDeServicos.add(new Servico(texto));
							}
						}
					}
					headerTabela = false;
				} else {
					String aut = e.getElementsByTag("td").first().text();
					atual = new Autorizador(aut, now);
					autorizadores.add(atual);

					Elements tds = e.getElementsByTag("td");
					Elements elementos = new Elements();
					for (int i = 0; i < tds.size(); i++) {
//						System.out.println(tds.get(i));
						elementos.addAll(tds.get(i).getElementsByTag("img"));
						elementos.addAll(tds.get(i).getElementsByTag("span"));
					}
					for (int i = 0; i < elementos.size(); i++) {
						String texto = "";
						if (elementos.get(i).tagName().compareTo("img") == 0) {
							texto = elementos.get(i).attr("src");
						}
						String disponibilidade = "";
						if (texto.compareTo(TEXTO_BOLA_VERDE) == 0) {
							disponibilidade = ServicoColetado.VERDE;
						} else if (texto.compareTo(TEXTO_BOLA_AMARELA) == 0) {
							disponibilidade = ServicoColetado.AMARELO;
						} else if (texto.compareTo(TEXTO_BOLA_VERMELHA) == 0) {
							disponibilidade = ServicoColetado.VERMELHOR;
						} else if (texto.isEmpty()) {
							disponibilidade = ServicoColetado.BLANK;
						}
						ServicoColetado novoServico = new ServicoColetado(disponibilidade, listaDeServicos.get(i));
						atual.getServicos().add(novoServico);
					}
				}
			}
		} catch (IOException ex) {
			Logger.getLogger(ColetorDeStatusNFE.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public ArrayList<Autorizador> getAutorizadores() {
		return autorizadores;
	}

	public ArrayList<Servico> getServicosColetados() {
		return listaDeServicos;
	}

}
