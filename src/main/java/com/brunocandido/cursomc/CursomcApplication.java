package com.brunocandido.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.brunocandido.cursomc.domain.Categoria;
import com.brunocandido.cursomc.domain.Cidades;
import com.brunocandido.cursomc.domain.ClassificacaoProduto;
import com.brunocandido.cursomc.domain.Cliente;
import com.brunocandido.cursomc.domain.Enderecos;
import com.brunocandido.cursomc.domain.Estado;
import com.brunocandido.cursomc.domain.Produto;
import com.brunocandido.cursomc.domain.TipoProduto;
import com.brunocandido.cursomc.enuns.TipoCliente;
import com.brunocandido.cursomc.repositories.CategoriaRepository;
import com.brunocandido.cursomc.repositories.CidadeRepository;
import com.brunocandido.cursomc.repositories.ClassificacaoProdutoRepository;
import com.brunocandido.cursomc.repositories.ClienteRepository;
import com.brunocandido.cursomc.repositories.EnderecosRepository;
import com.brunocandido.cursomc.repositories.EstadoRepository;
import com.brunocandido.cursomc.repositories.ProdutoRepository;
import com.brunocandido.cursomc.repositories.TipoProdutoRepository;


@SpringBootApplication
public class CursomcApplication implements CommandLineRunner { // Acrescentei o implemento CommandLineRunner serve para
																// Dar o Start no Banco nas opçoes de tabelas
																// cadastradas conforme exemplo abaixo
	@Autowired
	CategoriaRepository categoriaRepository; // Acrescenta na tabela Categoria

	@Autowired
	ClassificacaoProdutoRepository classificacaoProdutoRepository;

	@Autowired
	TipoProdutoRepository tipoProdutoRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	EstadoRepository estadoRepository;

	@Autowired
	CidadeRepository cidadeRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	EnderecosRepository enderecosRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// ****************************************************************************************************************
		// Dominio Categoria

		Categoria c1 = new Categoria(null, "Camisetas");
		Categoria c2 = new Categoria(null, "Camisas");
		Categoria c3 = new Categoria(null, "Camisas Polo");
		Categoria c4 = new Categoria(null, "Calças Djeans");
		Categoria c5 = new Categoria(null, "Bermudas");

		// ****************************************************************************************************************
		// Dominio Produtos
		// Camisetas
		Produto p1 = new Produto(null, "Camiseta Lacoste", 40.00, "Branca");
		Produto p2 = new Produto(null, "Camiseta Lacoste", 40.00, "Preta");
		// Camisas
		Produto p3 = new Produto(null, "Camisa Tommy Higgifilguer", 80.00, "Branca");
		Produto p4 = new Produto(null, "Camisa Tommy Higgifilguer", 80.00, "Preta");
		// Camisa Polo
		Produto p5 = new Produto(null, "Camisa Polo Pollo", 80.00, "Amarela");
		Produto p6 = new Produto(null, "Camisa Polo Pollo", 80.00, "Vermelha");
		// Calça Djeans
		Produto p7 = new Produto(null, "Calça Djeans", 80.00, "Djeans");
		Produto p8 = new Produto(null, "Calça Djeans", 80.00, "Preta");
		// Bermudas
		Produto p9 = new Produto(null, "Bermuda Djeans", 80.00, "Djeans");
		Produto p10 = new Produto(null, "Bermuda Djeans", 80.00, "Preta");
		// ****************************************************************************************************************
		// Acrescentando o Categoria ao Produto

		c1.getProdutos().addAll(Arrays.asList(p1, p2));
		c2.getProdutos().addAll(Arrays.asList(p3, p4));
		c3.getProdutos().addAll(Arrays.asList(p5, p6));
		c4.getProdutos().addAll(Arrays.asList(p7, p8));
		c5.getProdutos().addAll(Arrays.asList(p9, p10));
		// ****************************************************************************************************************
		// Acrescentando o Produto a Categoria

		p1.getCategorias().addAll(Arrays.asList(c1));
		p2.getCategorias().addAll(Arrays.asList(c1));
		p3.getCategorias().addAll(Arrays.asList(c2));
		p4.getCategorias().addAll(Arrays.asList(c2));
		p5.getCategorias().addAll(Arrays.asList(c3));
		p6.getCategorias().addAll(Arrays.asList(c3));
		p7.getCategorias().addAll(Arrays.asList(c4));
		p8.getCategorias().addAll(Arrays.asList(c4));
		p9.getCategorias().addAll(Arrays.asList(c5));
		p10.getCategorias().addAll(Arrays.asList(c5));
		// ****************************************************************************************************************
		// Repository Categoria

		categoriaRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
		// ****************************************************************************************************************
		// Dominio ClassificacaoProduto
		ClassificacaoProduto cp1 = new ClassificacaoProduto(null, "Masculino");
		ClassificacaoProduto cp2 = new ClassificacaoProduto(null, "Feminino");
		// ****************************************************************************************************************
		// Adicionando o Lista ao Produto
		cp1.getProduto().addAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));
		cp2.getProduto().addAll(Arrays.asList(p10));
		// ****************************************************************************************************************
		// Adicionando Produto a Lista

		p1.getClassificacaoProduto().addAll(Arrays.asList(cp1));
		p2.getClassificacaoProduto().addAll(Arrays.asList(cp1));
		p3.getClassificacaoProduto().addAll(Arrays.asList(cp1));
		p4.getClassificacaoProduto().addAll(Arrays.asList(cp1));
		p5.getClassificacaoProduto().addAll(Arrays.asList(cp1));
		p6.getClassificacaoProduto().addAll(Arrays.asList(cp1));
		p7.getClassificacaoProduto().addAll(Arrays.asList(cp1));
		p8.getClassificacaoProduto().addAll(Arrays.asList(cp1));
		p9.getClassificacaoProduto().addAll(Arrays.asList(cp1));
		p10.getClassificacaoProduto().addAll(Arrays.asList(cp2));
		// ****************************************************************************************************************
		// Repository ClassificacaoProdutoRepository
		classificacaoProdutoRepository.saveAll(Arrays.asList(cp1, cp2));

		// ****************************************************************************************************************
		// Dominio Tipo de Produto

		TipoProduto tp1 = new TipoProduto(null, "Revenda");
		TipoProduto tp2 = new TipoProduto(null, "Varejo");

		tp1.getProduto().addAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
		tp2.getProduto().addAll(Arrays.asList(p10));

		p1.getTipoProduto().addAll(Arrays.asList(tp1));
		p2.getTipoProduto().addAll(Arrays.asList(tp1));
		p3.getTipoProduto().addAll(Arrays.asList(tp1));
		p4.getTipoProduto().addAll(Arrays.asList(tp1));
		p5.getTipoProduto().addAll(Arrays.asList(tp1));
		p6.getTipoProduto().addAll(Arrays.asList(tp1));
		p7.getTipoProduto().addAll(Arrays.asList(tp1));
		p8.getTipoProduto().addAll(Arrays.asList(tp1));
		p9.getTipoProduto().addAll(Arrays.asList(tp1));
		p10.getTipoProduto().addAll(Arrays.asList(tp1, tp2));
		// ****************************************************************************************************************
		// Repository tipo de Produtos

		tipoProdutoRepository.saveAll(Arrays.asList(tp1, tp2));

		// ****************************************************************************************************************
		// *****************************************************************************************************************
		// Repository Produto
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10));
		// ****************************************************************************************************************
		// ****************************************************************************************************************

		// *****************************************************************************************************************

		Estado est0 = new Estado(null, "Goiás");
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidades cc0 = new Cidades(null, "Goiânia", est0);
		Cidades cc1 = new Cidades(null, "Uberlândia", est1);
		Cidades cc2 = new Cidades(null, "São Paulo", est2);
		Cidades cc3 = new Cidades(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(cc1));
		est2.getCidades().addAll(Arrays.asList(cc2, cc3));

		estadoRepository.saveAll(Arrays.asList(est0, est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cc0, cc1, cc2, cc3));

		// ****************************************************************************************************************
		// Dominio do Cliente e Enderecos

		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefone().addAll(Arrays.asList("27363323", "93838393"));
		
		Enderecos end1 = new Enderecos(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, cc1);
		Enderecos end2 = new Enderecos(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, cc2);
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));

		// ****************************************************************************************************************
		// Repository tipo de Produtos

		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecosRepository.saveAll(Arrays.asList(end1, end2));

	}

}
