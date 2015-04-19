package testeSdk;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.vindi.vinditools.ServiceFactory;
import br.com.vindi.vinditools.entity.Product;
import br.com.vindi.vinditools.exception.VindiToolsException;
import br.com.vindi.vinditools.service.ProductService;

public class TesteProduct {
	public static void main(String[] args) {
		
		testaFindById();
		//testaFindByIdNotFound();
		//testaFindAll();
		//testaFindByQuery();
		//testaPaginacao();
		//testaSortBy();
		//testaPost();
		//testaPut();					
	}
	
	
	/**
	 * Teste do método  get /v1/products/{id} da API VINDI. 
	 * A classe Product criada na SDK que é utilizada nos exemplos abaixo possui um Map denominado Fields que é preenchida com nomes e valores das propriedades encontradas do Produto. 
	 */
	public static void testaFindById(){
		Product product = null;
		try {						
				product = ServiceFactory.getProductService().findById("1471");
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}				
		
		System.out.println(product);
	}
	
	/**
	 * Teste do método  get /v1/products/{id} da API VINDI simulando a busca por um Produto inexistente. 
	 * Para esta situação o campo fields recebe NULL.
	 */
	public static void testaFindByIdNotFound(){
		Product product = null;
		try {							
				product = ServiceFactory.getProductService().findById("22");
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(product);
	}
	
	/**
	 *  Teste do método get /v1/products da API VINDI simulando a busca por todos os Produtos. 
	 *  Um java.util.List<Product> é retornado. 
	 */
	public static void testaFindAll(){
		
		List<Product> lstproduct = null;
		try {						
				ProductService cservice = ServiceFactory.getProductService();
				lstproduct = cservice.findAll();			
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(lstproduct);
	}
	
	/**
	 *  Teste do método get /v1/products da API VINDI simulando a busca por todos os Produtos que obedeçam os critérios da query.
	 *  As regras utilizadas para preenchimento do parâmetro do método findByQuery são as mesmas utilizadas na API VINDI. 
	 *  Um java.util.List<Product> é retornado. 
	 */
	public static void testaFindByQuery(){
		List<Product> lstproduct = null;
		try {				
				ProductService pservice = ServiceFactory.getProductService();
				lstproduct = pservice.findByQuery("name:mensalidade");	
				
		} catch (VindiToolsException e) {
			e.printStackTrace();
		}
		
		System.out.println(lstproduct);
	}
	
	/**
	 * Teste do método setPaginacao(). Os métodos findAll() e findByQuery() quando chamados, sempre retornarão
	 * uma lista de Entidades obedecendo a paginação, caso esta tenha sido configurada como exemplo abaixo.
	 */
	public static void testaPaginacao(){
		List<Product> lstproduct = null;
		try {			
			ProductService pservice = ServiceFactory.getProductService();			
			pservice.setPagination("1", "2");						
			lstproduct = pservice.findAll();			
		} catch (VindiToolsException e) {
			e.printStackTrace();
		}
		
		System.out.println(lstproduct);
	}
	
	/**
	 * Teste do método setSortBy(). Os métodos findAll() e findByQuery() quando chamados, sempre retornarão
	 * uma lista de Entidades obedecendo a ordenação, caso esta tenha sido configurada como exemplo abaixo.
	 */
	public static void testaSortBy(){
		List<Product> lstproduct = null;
		try {			
			ProductService pservice = ServiceFactory.getProductService();
			pservice.setSortBy("name", "asc");						
			lstproduct = pservice.findAll();			
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(lstproduct);
	}
	
	
	public static void testaPost(){
		try {
			
				ProductService pservice = ServiceFactory.getProductService();
			
				Map<String, Object> pricing_schema = new HashMap<String, Object>();			
				pricing_schema.put("minimum_price", 3);
				pricing_schema.put("price", 2);
				pricing_schema.put("schema_type", "flat");
				
				Map<String, Object> hashFields = new HashMap<String, Object>();
				hashFields.put("name", "Camiseta");				
				hashFields.put("status", "active");
				hashFields.put("pricing_schema", pricing_schema);
				
				Product product = new Product();
				product.setFields(hashFields);
				
				Product productSaved = pservice.create(product);
				System.out.println(productSaved);
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
	}
	
	public static void testaPut(){
		try {
			
				ProductService pservice = ServiceFactory.getProductService();
				
				Map<String, Object> pricing_schema = new HashMap<String, Object>();			
				pricing_schema.put("minimum_price", 2);
				pricing_schema.put("price", 1);			
				
				Map<String, Object> hashFields = new HashMap<String, Object>();					
				hashFields.put("name", "Uniforme");	
				hashFields.put("pricing_schema", pricing_schema);
				
				Product product = new Product();				
				product.setFields(hashFields);
				
				Product productUpdated = pservice.update(product, "1588");
				System.out.println(productUpdated);
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
	}
	

}