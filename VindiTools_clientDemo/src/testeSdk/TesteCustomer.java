package testeSdk;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.vindi.vinditools.ServiceFactory;
import br.com.vindi.vinditools.entity.Customer;
import br.com.vindi.vinditools.exception.VindiToolsException;
import br.com.vindi.vinditools.service.CustomerService;

public class TesteCustomer {
	public static void main(String[] args) {
		
		//testaFindById();
		//testaFindByIdNotFound();
		testaFindAll();
		//testaFindByQuery();
		//testaPaginacao();
		//testaSortBy();	
		//testaPost();
		//testaPut();
		//testaRemove();
			
	}
	
	
	/**
	 * Teste do método  get /v1/customers/{id} da API VINDI. 
	 * A classe Customer criada na SDK que é utilizada nos exemplos abaixo possui um Map denominado Fields que é preenchida com nomes e valores das propriedades encontradas do Cliente. 
	 */
	public static void testaFindById(){
		Customer customer = null;
		try {
				customer = ServiceFactory.getCustomerService().findById("8684");				
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(customer);
	}
	
	/**
	 * Teste do método  get /v1/customers/{id} da API VINDI simulando a busca por um Cliente inexistente. 
	 * Para esta situação o campo fields recebe NULL.
	 */
	public static void testaFindByIdNotFound(){
		Customer customer = null;
		try {			
				customer = ServiceFactory.getCustomerService().findById("22");
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(customer);
	}
	
	/**
	 *  Teste do método get /v1/customers da API VINDI simulando a busca por todos os Clientes. 
	 *  Um java.util.List<Customer> é retornado. 
	 */
	public static void testaFindAll(){
		
		List<Customer> lstcustomer = null;
		try {
				CustomerService cservice = ServiceFactory.getCustomerService();						
				lstcustomer = cservice.findAll();			
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(lstcustomer);
	}
	
	/**
	 *  Teste do método get /v1/customers da API VINDI simulando a busca por todos os Clientes que obedeçam os critérios da query.
	 *  As regras utilizadas para preenchimento do parâmetro do método findByQuery são as mesmas utilizadas na API VINDI. 
	 *  Um java.util.List<Customer> é retornado. 
	 */
	public static void testaFindByQuery(){
		List<Customer> lstcustomer = null;
		try {
				CustomerService cservice = ServiceFactory.getCustomerService();		
				lstcustomer = cservice.findByQuery("status:inactive AND email:hotmail.com");	
				
		} catch (VindiToolsException e) {
			e.printStackTrace();
		}
		
		System.out.println(lstcustomer);
	}
	
	/**
	 * Teste do método setPaginacao(). Os métodos findAll() e findByQuery() quando chamados, sempre retornarão
	 * uma lista de Entidades obedecendo a paginação, caso esta tenha sido configurada como exemplo abaixo.
	 */
	public static void testaPaginacao(){
		List<Customer> lstcustomer = null;
		try {
			CustomerService cservice = ServiceFactory.getCustomerService();	
			cservice.setPagination("1", "3");						
			lstcustomer = cservice.findAll();			
		} catch (VindiToolsException e) {
			e.printStackTrace();
		}
		
		System.out.println(lstcustomer);
	}
	
	/**
	 * Teste do método setSortBy(). Os métodos findAll() e findByQuery() quando chamados, sempre retornarão
	 * uma lista de Entidades obedecendo a ordenação, caso esta tenha sido configurada como exemplo abaixo.
	 */
	public static void testaSortBy(){
		List<Customer> lstcustomer = null;
		try {
			CustomerService cservice = ServiceFactory.getCustomerService();		
			cservice.setSortBy("name", "asc");						
			lstcustomer = cservice.findAll();			
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(lstcustomer);
	}
	
	public static void testaPost(){
		try {
				CustomerService cservice = ServiceFactory.getCustomerService();				
				Map<String, Object> hashFields = new HashMap<String, Object>();
				hashFields.put("name", "teste11");
				hashFields.put("email", "jrpaoliello@gmail.com");
				hashFields.put("code", "2022");
				
				Customer customer = new Customer();
				customer.setFields(hashFields);
				
				Customer customerSaved = cservice.create(customer);
				System.out.println(customerSaved);
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
	}
	
	public static void testaPut(){
		try {
				CustomerService cservice = ServiceFactory.getCustomerService();			
				Map<String, Object> hashFields = new HashMap<String, Object>();					
				hashFields.put("notes", "notes alterado na hora: " + new Date());					
				Customer customer = new Customer();				
				customer.setFields(hashFields);
				
				Customer customerUpdated = cservice.update(customer, "16302");
				System.out.println(customerUpdated);
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
	}
	
	public static void testaRemove(){
		Customer customer = null;
		try {
				customer = ServiceFactory.getCustomerService().remove("15968");				
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(customer);
	}
	
	
}