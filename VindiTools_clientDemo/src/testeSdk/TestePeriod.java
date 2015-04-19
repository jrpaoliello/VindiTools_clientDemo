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
	 * Teste do m�todo  get /v1/periods/{id} da API VINDI. 
	 * A classe Period criada na SDK que � utilizada nos exemplos abaixo possui um Map denominado Fields que � preenchida com nomes e valores das propriedades encontradas do Per�odo. 
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
	 * Teste do m�todo  get /v1/periods/{id} da API VINDI simulando a busca por um Per�odo inexistente. 
	 * Para esta situa��o o campo fields recebe NULL.
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
	 *  Teste do m�todo post /v1/periods/{id}/bill da API VINDI simulando a emiss�o de uma fatura de determinado per�odo. 
	 *  O Period em quest�o � retornado. 
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