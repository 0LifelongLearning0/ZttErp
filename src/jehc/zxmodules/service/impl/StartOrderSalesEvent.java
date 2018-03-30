package jehc.zxmodules.service.impl;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;

public class StartOrderSalesEvent implements ExecutionListener{
	private String language;
	@Override
	public void notify(DelegateExecution arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("1");
		
	}

}
