package testeSdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.vindi.vinditools.ServiceFactory;
import br.com.vindi.vinditools.entity.Bill;
import br.com.vindi.vinditools.exception.VindiToolsException;
import br.com.vindi.vinditools.service.BillService;


public class TesteBill {
	public static void main(String[] args) {
		
		testaFindById();
		//testaFindByIdNotFound();
		//testaFindAll();
		//testaFindByQuery();
		//testaPaginacao();
		//testaSortBy();	
		//testaPost();		
		//testaRemove();
		//testaApproveBill();
	}
	
	
	/**
	 * Teste do método  get /v1/bills/{id} da API VINDI. 
	 * A classe Bill criada na SDK que é utilizada nos exemplos abaixo possui um Map denominado Fields que é preenchida com nomes e valores das propriedades encontradas do Fatura. 
	 */
	public static void testaFindById(){
		Bill bill = null;
		try {
				bill = ServiceFactory.getBillService().findById("22474");				
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(bill);
	}
	
	/**
	 * Teste do método  get /v1/bills/{id} da API VINDI simulando a busca por um Fatura inexistente. 
	 * Para esta situação o campo fields recebe NULL.
	 */
	public static void testaFindByIdNotFound(){
		Bill bill = null;
		try {			
				bill = ServiceFactory.getBillService().findById("22");
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(bill);
	}
	
	/**
	 *  Teste do método get /v1/bills da API VINDI simulando a busca por todos os Faturas. 
	 *  Um java.util.List<Bill> é retornado. 
	 */
	public static void testaFindAll(){
		
		List<Bill> lstbill = null;
		try {
				BillService cservice = ServiceFactory.getBillService();					
				lstbill = cservice.findAll();			
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(lstbill);
	}
	
	/**
	 *  Teste do método get /v1/bills da API VINDI simulando a busca por todos os Faturas que obedeçam os critérios da query.
	 *  As regras utilizadas para preenchimento do parâmetro do método findByQuery são as mesmas utilizadas na API VINDI. 
	 *  Um java.util.List<Bill> é retornado. 
	 */
	public static void testaFindByQuery(){
		List<Bill> lstbill = null;
		try {
				BillService cservice = ServiceFactory.getBillService();				
				lstbill = cservice.findByQuery("status:paid AND amount:3");	
				
		} catch (VindiToolsException e) {
			e.printStackTrace();
		}
		
		System.out.println(lstbill);
	}
	
	/**
	 * Teste do método setPaginacao(). Os métodos findAll() e findByQuery() quando chamados, sempre retornarão
	 * uma lista de Entidades obedecendo a paginação, caso esta tenha sido configurada como exemplo abaixo.
	 */
	public static void testaPaginacao(){
		List<Bill> lstbill = null;
		try {
			BillService cservice = ServiceFactory.getBillService();		
			cservice.setPagination("1", "3");						
			lstbill = cservice.findAll();			
		} catch (VindiToolsException e) {
			e.printStackTrace();
		}
		
		System.out.println(lstbill);
	}
	
	/**
	 * Teste do método setSortBy(). Os métodos findAll() e findByQuery() quando chamados, sempre retornarão
	 * uma lista de Entidades obedecendo a ordenação, caso esta tenha sido configurada como exemplo abaixo.
	 */
	public static void testaSortBy(){
		List<Bill> lstbill = null;
		try {
			BillService cservice = ServiceFactory.getBillService();			
			cservice.setSortBy("amount", "asc");						
			lstbill = cservice.findAll();			
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(lstbill);
	}
	
	public static void testaPost(){
		try {
			
				List<Map<String, Object>> bill_items = new ArrayList();				
				Map<String, Object> bill_item1 = new HashMap<String, Object>();			
				bill_item1.put("product_id", 1471);
				bill_item1.put("amount", 5);
				bill_items.add(bill_item1);
				
				BillService cservice = ServiceFactory.getBillService();					
				Map<String, Object> hashFields = new HashMap<String, Object>();
				hashFields.put("customer_id", 14514);
				hashFields.put("installments", 1);
				hashFields.put("payment_method_code", "credit_card");
				
				hashFields.put("bill_items", bill_items);
				
				Bill bill = new Bill();
				bill.setFields(hashFields);
				
				Bill billSaved = cservice.create(bill);
				System.out.println(billSaved);
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
	}
	
	
	public static void testaRemove(){
		Bill bill = null;
		try {
				bill = ServiceFactory.getBillService().remove("24116");				
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(bill);
	}
	
	/**
	 *  Teste do método post /v1/bills/{id}/approve da API VINDI simulando a aprovação de uma fatura. 	
	 */
	public static void testaApproveBill(){
		
		Bill bill = null;
		try {
				BillService bservice = ServiceFactory.getBillService();				
				bill = bservice.approveBill("24116");
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(bill); 
	}
	
}