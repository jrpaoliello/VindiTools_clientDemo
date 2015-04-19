package testeSdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.vindi.vinditools.ServiceFactory;
import br.com.vindi.vinditools.entity.Plan;
import br.com.vindi.vinditools.exception.VindiToolsException;
import br.com.vindi.vinditools.service.PlanService;

public class TestePlan {
	public static void main(String[] args) {
		
		//testaFindById();
		//testaFindByIdNotFound();
		//testaFindAll();
		//testaFindByQuery();
		//testaPaginacao();
		//testaSortBy();		
		//testaPost();
		testaPut();				
	}
	
	
	/**
	 * Teste do método  get /v1/plans/{id} da API VINDI. 
	 * A classe Plan criada na SDK que é utilizada nos exemplos abaixo possui um Map denominado Fields que é preenchida com nomes e valores das propriedades encontradas do Plano. 
	 */
	public static void testaFindById(){
		Plan plan = null;
		try {
				plan = ServiceFactory.getPlanService().findById("872");				
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(plan);
	}
	
	/**
	 * Teste do método  get /v1/plans/{id} da API VINDI simulando a busca por um Plano inexistente. 
	 * Para esta situação o campo fields recebe NULL.
	 */
	public static void testaFindByIdNotFound(){
		Plan plan = null;
		try {			
				plan = ServiceFactory.getPlanService().findById("22");
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(plan);
	}
	
	/**
	 *  Teste do método get /v1/plans da API VINDI simulando a busca por todos os Planos. 
	 *  Um java.util.List<Plan> é retornado. 
	 */
	public static void testaFindAll(){
		
		List<Plan> lstplan = null;
		try {
				PlanService pservice = ServiceFactory.getPlanService();						
				lstplan = pservice.findAll();			
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(lstplan);
	}
	
	/**
	 *  Teste do método get /v1/plans da API VINDI simulando a busca por todos os Planos que obedeçam os critérios da query.
	 *  As regras utilizadas para preenchimento do parâmetro do método findByQuery são as mesmas utilizadas na API VINDI. 
	 *  Um java.util.List<Plan> é retornado. 
	 */
	public static void testaFindByQuery(){
		List<Plan> lstplan = null;
		try {
				PlanService pservice = ServiceFactory.getPlanService();			
				lstplan = pservice.findByQuery("name:plano");	
				
		} catch (VindiToolsException e) {
			e.printStackTrace();
		}
		
		System.out.println(lstplan);
	}
	
	/**
	 * Teste do método setPaginacao(). Os métodos findAll() e findByQuery() quando chamados, sempre retornarão
	 * uma lista de Entidades obedecendo a paginação, caso esta tenha sido configurada como exemplo abaixo.
	 */
	public static void testaPaginacao(){
		List<Plan> lstplan = null;
		try {
			PlanService pservice = ServiceFactory.getPlanService();		
			pservice.setPagination("1", "3");						
			lstplan = pservice.findAll();			
		} catch (VindiToolsException e) {
			e.printStackTrace();
		}
		
		System.out.println(lstplan);
	}
	
	/**
	 * Teste do método setSortBy(). Os métodos findAll() e findByQuery() quando chamados, sempre retornarão
	 * uma lista de Entidades obedecendo a ordenação, caso esta tenha sido configurada como exemplo abaixo.
	 */
	public static void testaSortBy(){
		List<Plan> lstplan = null;
		try {
			PlanService pservice = ServiceFactory.getPlanService();		
			pservice.setSortBy("name", "asc");						
			lstplan = pservice.findAll();			
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(lstplan);
	}
	
	
	public static void testaPost(){
		try {
				PlanService pservice = ServiceFactory.getPlanService();		
				List<Map<String, Object>> plan_items = new ArrayList();
				
				Map<String, Object> plan_item1 = new HashMap<String, Object>();			
				plan_item1.put("product_id", 1471);
				plan_item1.put("cycles", null);
				plan_items.add(plan_item1);
				
				Map<String, Object> plan_item2 = new HashMap<String, Object>();			
				plan_item2.put("product_id", 1472);
				plan_item2.put("cycles", 1);
				plan_items.add(plan_item2);
				
				Map<String, Object> hashFields = new HashMap<String, Object>();
				hashFields.put("name", "Plano For Teens");				
				hashFields.put("status", "active");
				hashFields.put("interval", "months");
				hashFields.put("interval_count", 1);
				hashFields.put("bylling_cycles", null);
				hashFields.put("billing_trigger_type", "beginning_of_period");
				hashFields.put("billing_trigger_day", 5);				
				hashFields.put("installments", 1);
				
				hashFields.put("plan_items", plan_items);
				
				Plan plan = new Plan();
				plan.setFields(hashFields);
				
				Plan planSaved = pservice.create(plan);
				System.out.println(planSaved);
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
	}
	
	public static void testaPut(){
		try {
				PlanService pservice = ServiceFactory.getPlanService();																	
				
				Map<String, Object> hashFields = new HashMap<String, Object>();					
				hashFields.put("name", "Teste Altera nome");
				hashFields.put("billing_trigger_day", 6);	
				
				Plan plan = new Plan();				
				plan.setFields(hashFields);
				
				Plan planUpdated = pservice.update(plan, "872");
				System.out.println(planUpdated);
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
	}
	

}