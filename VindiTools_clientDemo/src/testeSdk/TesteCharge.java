package testeSdk;

import java.util.List;

import br.com.vindi.vinditools.ServiceFactory;
import br.com.vindi.vinditools.entity.Charge;
import br.com.vindi.vinditools.exception.VindiToolsException;
import br.com.vindi.vinditools.service.ChargeService;

public class TesteCharge {
	public static void main(String[] args) {
				
		testaFindById();
		//testaFindByIdNotFound();
		//testaFindAll();
		//testaFindByQuery();
		//testaPaginacao();
		//testaSortBy();		
	}
	
	
	/**
	 * Teste do método  get /v1/charges/{id} da API VINDI. 
	 * A classe Charge criada na SDK que é utilizada nos exemplos abaixo possui um Map denominado Fields que é preenchida com nomes e valores das propriedades encontradas do Cobrança. 
	 */
	public static void testaFindById(){
		Charge charge = null;
		try {
				charge = ServiceFactory.getChargeService().findById("20408");				
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(charge);
	}
	
	/**
	 * Teste do método  get /v1/charges/{id} da API VINDI simulando a busca por um Cobrança inexistente. 
	 * Para esta situação o campo fields recebe NULL.
	 */
	public static void testaFindByIdNotFound(){
		Charge charge = null;
		try {			
				charge = ServiceFactory.getChargeService().findById("22");
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(charge);
	}
	
	/**
	 *  Teste do método get /v1/charges da API VINDI simulando a busca por todos os Cobranças. 
	 *  Um java.util.List<Charge> é retornado. 
	 */
	public static void testaFindAll(){
		
		List<Charge> lstcharge = null;
		try {
				ChargeService cservice = ServiceFactory.getChargeService();				
				lstcharge = cservice.findAll();			
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(lstcharge);
	}
	
	/**
	 *  Teste do método get /v1/charges da API VINDI simulando a busca por todos os Cobranças que obedeçam os critérios da query.
	 *  As regras utilizadas para preenchimento do parâmetro do método findByQuery são as mesmas utilizadas na API VINDI. 
	 *  Um java.util.List<Charge> é retornado. 
	 */
	public static void testaFindByQuery(){
		List<Charge> lstcharge = null;
		try {
				ChargeService cservice = ServiceFactory.getChargeService();				
				lstcharge = cservice.findByQuery("amount=8 AND status:paid");	
				
		} catch (VindiToolsException e) {
			e.printStackTrace();
		}
		
		System.out.println(lstcharge);
	}
	
	/**
	 * Teste do método setPaginacao(). Os métodos findAll() e findByQuery() quando chamados, sempre retornarão
	 * uma lista de Entidades obedecendo a paginação, caso esta tenha sido configurada como exemplo abaixo.
	 */
	public static void testaPaginacao(){
		List<Charge> lstcharge = null;
		try {
				ChargeService cservice = ServiceFactory.getChargeService();		
				cservice.setPagination("1", "3");						
				lstcharge = cservice.findAll();			
		} catch (VindiToolsException e) {
			e.printStackTrace();
		}
		
		System.out.println(lstcharge);
	}
	
	/**
	 * Teste do método setSortBy(). Os métodos findAll() e findByQuery() quando chamados, sempre retornarão
	 * uma lista de Entidades obedecendo a ordenação, caso esta tenha sido configurada como exemplo abaixo.
	 */
	public static void testaSortBy(){
		List<Charge> lstcharge = null;
		try {
				ChargeService cservice = ServiceFactory.getChargeService();				
				cservice.setSortBy("amount", "asc");						
				lstcharge = cservice.findAll();			
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(lstcharge);
	}
	
	
}