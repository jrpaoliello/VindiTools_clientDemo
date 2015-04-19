package testeSdk;

import java.util.HashMap;
import java.util.Map;

import br.com.vindi.vinditools.ServiceFactory;
import br.com.vindi.vinditools.entity.Discount;
import br.com.vindi.vinditools.exception.VindiToolsException;
import br.com.vindi.vinditools.service.DiscountService;

public class TesteDiscount {
	public static void main(String[] args) {
		
		//testaFindById();
		//testaFindByIdNotFound();
		//testaPost();						
		testaRemove();
	}
	
	
	/**
	 * Teste do método  get /v1/discounts/{id} da API VINDI. 
	 * A classe Discount criada na SDK que é utilizada nos exemplos abaixo possui um Map denominado Fields que é preenchida com nomes e valores das propriedades encontradas do Disconto. 
	 */
	public static void testaFindById(){
		Discount discount = null;
		try {
				discount = ServiceFactory.getDiscountService().findById("4111");				
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(discount);
	}
	
	/**
	 * Teste do método  get /v1/discounts/{id} da API VINDI simulando a busca por um Disconto inexistente. 
	 * Para esta situação o campo fields recebe NULL.
	 */
	public static void testaFindByIdNotFound(){
		Discount discount = null;
		try {			
				discount = ServiceFactory.getDiscountService().findById("22");
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(discount);
	}
				
	
	public static void testaPost(){
		try {								
				DiscountService dservice = ServiceFactory.getDiscountService();				
				Map<String, Object> hashFields = new HashMap<String, Object>();
				hashFields.put("product_item_id", 20264);
				hashFields.put("discount_type", "percentage");
				hashFields.put("percentage", 0.40);
				hashFields.put("cycles", null);
				
				Discount discount = new Discount();
				discount.setFields(hashFields);
				
				Discount discountSaved = dservice.create(discount);
				System.out.println(discountSaved);
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
	}
	
	
	public static void testaRemove(){
		Discount discount = null;
		try {
				discount = ServiceFactory.getDiscountService().remove("4111");				
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(discount);
	}
	
	
}