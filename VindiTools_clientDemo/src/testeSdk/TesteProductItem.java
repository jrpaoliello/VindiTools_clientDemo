package testeSdk;

import java.util.HashMap;
import java.util.Map;

import br.com.vindi.vinditools.ServiceFactory;
import br.com.vindi.vinditools.entity.ProductItem;
import br.com.vindi.vinditools.exception.VindiToolsException;
import br.com.vindi.vinditools.service.ProductItemService;

public class TesteProductItem {
	public static void main(String[] args) {
		
		testaFindById();
	    //testaFindByIdNotFound();
		//testaPost();
		//testaPut();		
		
	}
	
	
	/**
	 * Teste do método  get /v1/productItems/{id} da API VINDI. 
	 * A classe ProductItem criada na SDK que é utilizada nos exemplos abaixo possui um Map denominado Fields que é preenchida com nomes e valores das propriedades encontradas do Item de Assinatura (Product_Items). 
	 */
	public static void testaFindById(){
		ProductItem productItem = null;
		try {
				productItem = ServiceFactory.getProductItemService().findById("20264");				
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(productItem);
	}
	
	/**
	 * Teste do método  get /v1/productItems/{id} da API VINDI simulando a busca por um Item de Assinatura (Product_Items) inexistente. 
	 * Para esta situação o campo fields recebe NULL.
	 */
	public static void testaFindByIdNotFound(){
		ProductItem productItem = null;
		try {			
				productItem = ServiceFactory.getProductItemService().findById("22");
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(productItem);
	}

	public static void testaPost(){
		try {
									
				Map<String, Object> pricing_schema = new HashMap<String, Object>();			
				pricing_schema.put("minimum_price", 6);
				pricing_schema.put("price", 5);
				pricing_schema.put("schema_type", "flat");
				
				ProductItemService pservice = ServiceFactory.getProductItemService();			
				Map<String, Object> hashFields = new HashMap<String, Object>();
				hashFields.put("product_id", 1490);
				hashFields.put("subscription_id", 13091);
				hashFields.put("status", "active");
				hashFields.put("cycles", 1);
				hashFields.put("quantity", 1);				
				hashFields.put("pricing_schema", pricing_schema);
				
				ProductItem productItem = new ProductItem();
				productItem.setFields(hashFields);
				
				ProductItem productItemSaved = pservice.create(productItem);
				System.out.println(productItemSaved);
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
	}
	
	public static void testaPut(){
		try {
				ProductItemService pservice = ServiceFactory.getProductItemService();	
				
				Map<String, Object> pricing_schema = new HashMap<String, Object>();			
				pricing_schema.put("minimum_price", 3);
				pricing_schema.put("price", 2);
				pricing_schema.put("schema_type", "flat");
								
				Map<String, Object> hashFields = new HashMap<String, Object>();					
				hashFields.put("pricing_schema", pricing_schema);								
				ProductItem productItem = new ProductItem();				
				productItem.setFields(hashFields);
				
				ProductItem productItemUpdated = pservice.update(productItem, "22197");
				System.out.println(productItemUpdated);
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
	}

	
	
}