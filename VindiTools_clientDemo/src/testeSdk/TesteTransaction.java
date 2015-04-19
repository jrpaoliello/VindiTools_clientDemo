package testeSdk;

import java.util.List;

import br.com.vindi.vinditools.ServiceFactory;
import br.com.vindi.vinditools.entity.Transaction;
import br.com.vindi.vinditools.exception.VindiToolsException;
import br.com.vindi.vinditools.service.TransactionService;

public class TesteTransaction {
	public static void main(String[] args) {
				
		//testaFindById();
		//testaFindByIdNotFound();
		//testaFindAll();
		//testaFindByQuery();
		//testaPaginacao();
		testaSortBy();		
	}
	
	
	/**
	 * Teste do método  get /v1/transactions/{id} da API VINDI. 
	 * A classe Transaction criada na SDK que é utilizada nos exemplos abaixo possui um Map denominado Fields que é preenchida com nomes e valores das propriedades encontradas do Transação. 
	 */
	public static void testaFindById(){
		Transaction transaction = null;
		try {
				transaction = ServiceFactory.getTransactionService().findById("22507");				
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(transaction);
	}
	
	/**
	 * Teste do método  get /v1/transactions/{id} da API VINDI simulando a busca por um Transação inexistente. 
	 * Para esta situação o campo fields recebe NULL.
	 */
	public static void testaFindByIdNotFound(){
		Transaction transaction = null;
		try {			
				transaction = ServiceFactory.getTransactionService().findById("22");
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(transaction);
	}
	
	/**
	 *  Teste do método get /v1/transactions da API VINDI simulando a busca por todos os Transaçãos. 
	 *  Um java.util.List<Transaction> é retornado. 
	 */
	public static void testaFindAll(){
		
		List<Transaction> lsttransaction = null;
		try {
				TransactionService tservice = ServiceFactory.getTransactionService();					
				lsttransaction = tservice.findAll();			
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(lsttransaction);
	}
	
	/**
	 *  Teste do método get /v1/transactions da API VINDI simulando a busca por todos os Transaçãos que obedeçam os critérios da query.
	 *  As regras utilizadas para preenchimento do parâmetro do método findByQuery são as mesmas utilizadas na API VINDI. 
	 *  Um java.util.List<Transaction> é retornado. 
	 */
	public static void testaFindByQuery(){
		List<Transaction> lsttransaction = null;
		try {
				TransactionService tservice = ServiceFactory.getTransactionService();		
				lsttransaction = tservice.findByQuery("amount=8 AND status:success");	
				
		} catch (VindiToolsException e) {
			e.printStackTrace();
		}
		
		System.out.println(lsttransaction);
	}
	
	/**
	 * Teste do método setPaginacao(). Os métodos findAll() e findByQuery() quando chamados, sempre retornarão
	 * uma lista de Entidades obedecendo a paginação, caso esta tenha sido configurada como exemplo abaixo.
	 */
	public static void testaPaginacao(){
		List<Transaction> lsttransaction = null;
		try {
			TransactionService tservice = ServiceFactory.getTransactionService();
			tservice.setPagination("1", "3");						
			lsttransaction = tservice.findAll();			
		} catch (VindiToolsException e) {
			e.printStackTrace();
		}
		
		System.out.println(lsttransaction);
	}
	
	/**
	 * Teste do método setSortBy(). Os métodos findAll() e findByQuery() quando chamados, sempre retornarão
	 * uma lista de Entidades obedecendo a ordenação, caso esta tenha sido configurada como exemplo abaixo.
	 */
	public static void testaSortBy(){
		List<Transaction> lsttransaction = null;
		try {
			TransactionService tservice = ServiceFactory.getTransactionService();	
			tservice.setSortBy("amount", "asc");						
			lsttransaction = tservice.findAll();			
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(lsttransaction);
	}
	
	
}