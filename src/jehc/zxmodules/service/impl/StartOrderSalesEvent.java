package jehc.zxmodules.service.impl;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class StartOrderSalesEvent implements TaskListener{

	@Override
	public void notify(DelegateTask arg0) {
		// TODO Auto-generated method stub
		System.out.println("1");
	}

}
