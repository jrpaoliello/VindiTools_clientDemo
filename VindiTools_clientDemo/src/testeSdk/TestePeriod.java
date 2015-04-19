package testeSdk;

import br.com.vindi.vinditools.ServiceFactory;
import br.com.vindi.vinditools.entity.Period;
import br.com.vindi.vinditools.exception.VindiToolsException;
import br.com.vindi.vinditools.service.PeriodService;

public class TestePeriod {
	public static void main(String[] args) {
				
		//testaFindById();
		//testaFindByIdNotFound();
		testaPostBillByPeriod();		
	}
	
	
	/**
	 * Teste do método  get /v1/periods/{id} da API VINDI. 
	 * A classe Period criada na SDK que é utilizada nos exemplos abaixo possui um Map denominado Fields que é preenchida com nomes e valores das propriedades encontradas do Período. 
	 */
	public static void testaFindById(){
		Period period = null;
		try {
				period = ServiceFactory.getPeriodService().findById("22414");				
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(period);
	}
	
	/**
	 * Teste do método  get /v1/periods/{id} da API VINDI simulando a busca por um Período inexistente. 
	 * Para esta situação o campo fields recebe NULL.
	 */
	public static void testaFindByIdNotFound(){
		Period period = null;
		try {			
				period = ServiceFactory.getPeriodService().findById("22");
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(period);
	}				
	
	/**
	 *  Teste do método post /v1/periods/{id}/bill da API VINDI simulando a emissão de uma fatura de determinado período. 
	 *  O Period em questão é retornado. 
	 */
	public static void testaPostBillByPeriod(){
		
		Period period = null;
		try {
				PeriodService pservice = ServiceFactory.getPeriodService();				
				period = pservice.postBillByPeriod("22414");
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(period); 
	}
}