package testeSdk;

import br.com.vindi.vinditools.ServiceFactory;
import br.com.vindi.vinditools.entity.BillItem;
import br.com.vindi.vinditools.exception.VindiToolsException;

public class TesteBillItem {
	public static void main(String[] args) {
		
		//testaFindById();
		testaFindByIdNotFound();
				
	}
	
	
	/**
	 * Teste do método  get /v1/bill_items/{id} da API VINDI. 
	 * A classe BillItem criada na SDK que é utilizada nos exemplos abaixo possui um Map denominado Fields que é preenchida com nomes e valores das propriedades encontradas do Item da Fatura. 
	 */
	public static void testaFindById(){
		BillItem billItem = null;
		try {
				billItem = ServiceFactory.getBillItemService().findById("32915");				
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(billItem);
	}
	
	/**
	 * Teste do método  get /v1/bill_items/{id} da API VINDI simulando a busca por um Item de Fatura inexistente. 
	 * Para esta situação o campo fields recebe NULL.
	 */
	public static void testaFindByIdNotFound(){
		BillItem billItem = null;
		try {			
				billItem = ServiceFactory.getBillItemService().findById("22");
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(billItem);
	}
	
	
	
}