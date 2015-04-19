package testeSdk;

import java.util.HashMap;
import java.util.Map;

import br.com.vindi.vinditools.ServiceFactory;
import br.com.vindi.vinditools.entity.PaymentProfile;
import br.com.vindi.vinditools.exception.VindiToolsException;
import br.com.vindi.vinditools.service.PaymentProfileService;

public class TestePaymentProfile {
	public static void main(String[] args) {		
		testaPost();		
	}
	

	public static void testaPost(){
		try {
			
				PaymentProfileService pservice = ServiceFactory.getPaymentProfileService();												
				Map<String, Object> hashFields = new HashMap<String, Object>();
				hashFields.put("customer_id", 14514);
				hashFields.put("holder_name", "JOSE DA SILVA");
				hashFields.put("card_expiration", "06/16");
				hashFields.put("card_number", "4444999999999999");
				hashFields.put("card_cvv", "099");				
				
				PaymentProfile paymentProfile = new PaymentProfile();
				paymentProfile.setFields(hashFields);
				
				PaymentProfile paymentProfileSaved = pservice.create(paymentProfile);				
				System.out.println(paymentProfileSaved);
			
				/*PaymentProfileService pservice = new PaymentProfileService();				
				Map<String, Object> hashFields = new HashMap<String, Object>();
				hashFields.put("customer_id", 14514);
				hashFields.put("holder_name", "JOSE DA SILVA");
				hashFields.put("card_expiration", "06/16");
				hashFields.put("card_number", "4444999999999999");
				hashFields.put("card_cvv", "099");				
				
				PaymentProfile paymentProfile = new PaymentProfile();
				paymentProfile.setFields(hashFields);
				
				PaymentProfile paymentProfileSaved = pservice.create(paymentProfile);				
				System.out.println(paymentProfileSaved);*/
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
	}
	

	
	
}