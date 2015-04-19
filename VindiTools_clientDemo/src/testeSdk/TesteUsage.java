package testeSdk;

import java.util.HashMap;
import java.util.Map;

import br.com.vindi.vinditools.ServiceFactory;
import br.com.vindi.vinditools.entity.Usage;
import br.com.vindi.vinditools.exception.VindiToolsException;
import br.com.vindi.vinditools.service.UsageService;

public class TesteUsage {
	public static void main(String[] args) {
		
		testaPost();		
		//testaRemove();			
	}
	
	/**
	 * Exemplo para criar novo Registro de Utilização para um product_item_id.		
	 */
	public static void testaPost(){
		try {
				UsageService uservice = ServiceFactory.getUsageService();			
				Map<String, Object> hashFields = new HashMap<String, Object>();
				hashFields.put("period_id", 22414);
				hashFields.put("product_item_id", 20263);
				hashFields.put("quantity", 1);
				hashFields.put("description", "Testando criação de Registro de utilização.");
				//Usage criado: 34679
				Usage usage = new Usage();
				usage.setFields(hashFields);
				
				Usage usageSaved = uservice.create(usage);
				System.out.println(usageSaved);
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
	}
	
	
	public static void testaRemove(){
		Usage usage = null;
		try {
				usage = ServiceFactory.getUsageService().remove("36322");				
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(usage);
	}
	
	
}