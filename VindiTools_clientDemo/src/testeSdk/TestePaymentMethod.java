package testeSdk;

import java.util.List;

import br.com.vindi.vinditools.ServiceFactory;
import br.com.vindi.vinditools.entity.PaymentMethod;
import br.com.vindi.vinditools.exception.VindiToolsException;
import br.com.vindi.vinditools.service.PaymentMethodService;

public class TestePaymentMethod {
	public static void main(String[] args) {		
		//testaFindByIdPaymentMethod();
		testaFindAllPaymentMethod();		
	}
			
	
	/**
	 * Teste do m�todo  get /v1/payment_methods/{id} da API VINDI. 
	 * A classe PaymentMethod criada na SDK que � utilizada nos exemplos abaixo possui um Map denominado Fields que � preenchida com nomes e valores das propriedades encontradas do PaymentMethod. 
	 */
	public static void testaFindByIdPaymentMethod(){
		PaymentMethod paymentMethod = null;
		try {
			paymentMethod = ServiceFactory.getPaymentMethodService().findById("170");		
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(paymentMethod);
	}


	/**
	 *  Teste do m�todo get /v1/payment_methods da API VINDI simulando a busca por todos os M�todos de Pagamento. 
	 *  Um java.util.List<Payment_Method> � retornado. 
	 */ 
	public static void testaFindAllPaymentMethod(){
		
		List<PaymentMethod> lstPaymentMethod = null;
		try {
				PaymentMethodService pservice = ServiceFactory.getPaymentMethodService();						
				lstPaymentMethod = pservice.findAll();			
		} catch (VindiToolsException e) {			
			e.printStackTrace();
		}
		
		System.out.println(lstPaymentMethod);
	}		

}