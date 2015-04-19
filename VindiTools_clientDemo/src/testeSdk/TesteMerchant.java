package testeSdk;

import br.com.vindi.vinditools.ServiceFactory;
import br.com.vindi.vinditools.dao.ChargeDao;
import br.com.vindi.vinditools.dao.rest.RestChargeDao;
import br.com.vindi.vinditools.entity.Merchant;
import br.com.vindi.vinditools.exception.VindiToolsException;
import br.com.vindi.vinditools.service.MerchantService;

public class TesteMerchant {
	public static void main(String[] args) {

		testaFindCurrentMerchant();			
	}
	
	
	/**
	 *  Teste do método get /v1/merchant da API VINDI simulando a busca por todos os Empresas. 
	 *  Um java.util.List<Merchant> é retornado. 
	 */
	public static void testaFindCurrentMerchant(){
		
		Merchant merchant = null;
		try {
				MerchantService mservice = ServiceFactory.getMerchantService();						
				merchant = mservice.findCurrentMerchant();
				
				ChargeDao d = new RestChargeDao();
			
				
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(merchant);
	}
	
	
	
		
	
}