package testeSdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.vindi.vinditools.ServiceFactory;
import br.com.vindi.vinditools.entity.Period;
import br.com.vindi.vinditools.entity.Subscription;
import br.com.vindi.vinditools.exception.VindiToolsException;
import br.com.vindi.vinditools.service.SubscriptionService;

public class TesteSubscription {
	public static void main(String[] args) {
		
		//testaFindById();
		//testaFindByIdNotFound();
		//testaFindAll();
		//testaFindByQuery();
		//testaPaginacao();
		//testaSortBy();
		//testaPost();		
		//testaRemove();
		testaFindPeriodsBySubscription();
				
	}
	
	
	/**
	 * Teste do método  get /v1/subscriptions/{id} da API VINDI. 
	 * A classe Subscription criada na SDK que é utilizada nos exemplos abaixo possui um Map denominado Fields que é preenchida com nomes e valores das propriedades encontradas da Assinatura. 
	 */
	public static void testaFindById(){
		Subscription subscription = null;
		try {
				subscription = ServiceFactory.getSubscriptionService().findById("13091");			
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(subscription);
	}
	
	/**
	 * Teste do método  get /v1/subscriptions/{id} da API VINDI simulando a busca por uma Assinatura inexistente. 
	 * Para esta situação o campo fields recebe NULL.
	 */
	public static void testaFindByIdNotFound(){
		Subscription subscription = null;
		try {			
				subscription = ServiceFactory.getSubscriptionService().findById("22");
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(subscription);
	}
	
	/**
	 *  Teste do método get /v1/subscriptions da API VINDI simulando a busca por todas as Assinaturas. 
	 *  Um java.util.List<Subscription> é retornado. 
	 */
	public static void testaFindAll(){
		
		List<Subscription> lstsubscription = null;
		try {
				SubscriptionService sservice = ServiceFactory.getSubscriptionService();						
				lstsubscription = sservice.findAll();			
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(lstsubscription);
	}
	
	/**
	 *  Teste do método get /v1/subscriptions da API VINDI simulando a busca por todas as Assinaturas que obedeçam os critérios da query.
	 *  As regras utilizadas para preenchimento do parâmetro do método findByQuery são as mesmas utilizadas na API VINDI. 
	 *  Um java.util.List<Subscription> é retornado. 
	 */
	public static void testaFindByQuery(){
		List<Subscription> lstsubscription = null;
		try {
			SubscriptionService sservice = ServiceFactory.getSubscriptionService();						
				lstsubscription = sservice.findByQuery("status:active AND interval:months");	
				
		} catch (VindiToolsException e) {
			e.printStackTrace();
		}
		
		System.out.println(lstsubscription);
	}
	
	/**
	 * Teste do método setPaginacao(). Os métodos findAll() e findByQuery() quando chamados, sempre retornarão
	 * uma lista de Entidades obedecendo a paginação, caso esta tenha sido configurada como exemplo abaixo.
	 */
	public static void testaPaginacao(){
		List<Subscription> lstsubscription = null;
		try {
			SubscriptionService sservice = ServiceFactory.getSubscriptionService();			
			sservice.setPagination("1", "3");						
			lstsubscription = sservice.findAll();			
		} catch (VindiToolsException e) {
			e.printStackTrace();
		}
		
		System.out.println(lstsubscription);
	}
	
	/**
	 * Teste do método setSortBy(). Os métodos findAll() e findByQuery() quando chamados, sempre retornarão
	 * uma lista de Entidades obedecendo a ordenação, caso esta tenha sido configurada como exemplo abaixo.
	 */
	public static void testaSortBy(){
		List<Subscription> lstsubscription = null;
		try {
			SubscriptionService sservice = ServiceFactory.getSubscriptionService();				
			sservice.setSortBy("interval", "asc");						
			lstsubscription = sservice.findAll();			
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(lstsubscription);
	}
	
	public static void testaPost(){
		try {						
			    List<Map<String, Object>> product_items = new ArrayList();				
				Map<String, Object> product_item1 = new HashMap<String, Object>();			
				product_item1.put("product_id", 1471);
				product_item1.put("cycles", null);
				product_items.add(product_item1);
									
				SubscriptionService sservice = ServiceFactory.getSubscriptionService();					
				Map<String, Object> hashFields = new HashMap<String, Object>();
				hashFields.put("start_at", "2015-04-14T00:00:00.000-03:00");
				hashFields.put("plan_id", 872);
				hashFields.put("customer_id", 14514);
				hashFields.put("payment_method_code", "credit_card");
				hashFields.put("billing_trigger_type", "beginning_of_period");
				hashFields.put("billing_trigger_day", 1);
				
				hashFields.put("product_items", product_items);
				
				Subscription subscription = new Subscription();
				subscription.setFields(hashFields);
				
				Subscription subscriptionSaved = sservice.create(subscription);
				System.out.println(subscriptionSaved);
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
	}
		
	
	public static void testaRemove(){
		Subscription subscription = null;
		try {
				subscription = ServiceFactory.getSubscriptionService().remove("14475");				
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(subscription);
	}
	
	
	/**
	 *  Teste do método get /v1/subscriptions da API VINDI simulando a busca por todas as Assinaturas. 
	 *  Um java.util.List<Subscription> é retornado. 
	 */
	public static void testaFindPeriodsBySubscription(){
		
		List<Period> lstPeriods = null;
		try {
				SubscriptionService sservice = ServiceFactory.getSubscriptionService();								
				lstPeriods = sservice.findPeriodsBySubscription("13091");			
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(lstPeriods);
	}
}