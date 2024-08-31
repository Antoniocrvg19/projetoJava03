package controllers;

import java.util.Scanner;
import java.util.UUID;

import entities.Produto;
import repositories.ProdutoRepository;

public class ProdutoController {

	private Scanner scanner = new Scanner(System.in);

	/*
	 * Método para fazermos a captura dos dados do produto para realação do cadastro
	 */

	public void cadastrarProduto() {

		try {

			System.out.println("\nCADASTRP DE PRODUTOS:\n");
			System.out.print("Nome do produto...:");
			var nome = scanner.nextLine();

			System.out.println("PREÇO..............:");
			var preco = Double.parseDouble(scanner.nextLine());

			System.out.println("QUANTIDADE.........:");
			var quantidade = Integer.parseInt(scanner.nextLine());

			var produto = new Produto(UUID.randomUUID(), nome, preco, quantidade);

			var produtoRepository = new ProdutoRepository();
			produtoRepository.inserir(produto);

		} catch (Exception e) {
			System.out.println("\nFalha ao cadastrar o Produto");
			System.out.println(e.getMessage());

		}
	}

	 public void atualizarProduto() {

	try {

	

		System.out.println("\nATUALIZAÇÃO DE PRODUTOS");
		var id = UUID.fromString(scanner.nextLine());

		var produtoRepository = new ProdutoRepository();
		var produto = produtoRepository.obterPorId(id);

		if (produto != null) {

			System.out.println("\nDADOS DO PRODUTO:");
			System.out.println("ID...........:  " + produto.getId());
			System.out.println("NOME.........:  " + produto.getNome());
			System.out.println("PREÇO.........: " + produto.getPreco());
			System.out.println("QUANTIDADE....: " + produto.getQuantidade());
			System.out.println("");

			System.out.println("ALTERE O NOME......:");
			produto.setNome(scanner.nextLine());

			System.out.println("ALTERE O PREÇO.....:");
			produto.setPreco(Double.parseDouble(scanner.nextLine()));

			System.out.println("ALTERE A QUANTIDADE...");
			produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

			produtoRepository.atualizar(produto);

		}

		else {
			System.out.println("\nProduto nao encontrado. Verifique o ID informado");

		}

	}catch(
	Exception e)
	{
		System.out.println("\nFALHA AO ATUALIZAR PRODUTO");
		System.out.println(e.getMessage());
	}

}

public void excluirProduto() {
	
	try {
		
		System.out.println("\nEXCLUSAO O DE PRODUTOS:\n");
		
		System.out.print("INFORME O ID DO PRODUTO.: ");
		var id = UUID.fromString(scanner.nextLine());
		
		//consultando o produto no banco de dados através do id
		var produtoRepository = new ProdutoRepository();
		var produto = produtoRepository.obterPorId(id);
		
		//verificando se o produto foi encontrado
		if(produto != null) {
			
			System.out.println("\nDADOS DO PRODUTO:");
			System.out.println("ID........: " + produto.getId());
			System.out.println("NOME......: " + produto.getNome());
			System.out.println("PREÇO.....: " + produto.getPreco());
			System.out.println("QUANTIDADE: " + produto.getQuantidade());
			System.out.println("");
							
			//excluindo os dados do produto no banco
			produtoRepository.excluir(produto.getId());				
		}
		else {
			System.out.println("\nProduto não encontrado. Verifique o ID informado.");
		}
	}
	catch(Exception e) {
		System.out.println("\nFalha ao excluir o produto!");
		System.out.println(e.getMessage());
	}


}
                public void consultarPodutos() {
                	try {
                		System.out.println("\nConsulta de Produtos\n");
                		var produtoRepository = new ProdutoRepository();
                		var lista = produtoRepository.consultar();
                		for(Produto produto : lista) {
                			
                			System.out.println("ID..........:" + produto.getId());
                			System.out.println("NOME........:" + produto.getNome());
                			System.out.println("PREÇO.......:" + produto.getPreco());
                			System.out.println("QUANTIDADE..:" + produto.getQuantidade());
                			System.out.println("");
                		}
                		
                		
					} catch (Exception e) {
						System.out.println("\nFalha ao consultar os produtos");
						System.out.println(e.getMessage());
						
						
						
						
					}
                }









}



                         






