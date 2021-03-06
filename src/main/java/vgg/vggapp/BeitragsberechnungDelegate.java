package vgg.vggapp;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class BeitragsberechnungDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		 
		
		Map<String, Object> processVariables = new HashMap();
		processVariables = execution.getVariables();
		long riskobeitrag = 0 ;
	 
		execution.setVariable("Entscheidung", "versicherungsfähig");
		long alter =  (long)processVariables.get("malter") ;
		if(processVariables.get("riskobeitrag") != null)
			riskobeitrag = (long)processVariables.get("riskobeitrag");
		long beitrag = alter > 11  ? (alter *10)+riskobeitrag  :110 + riskobeitrag;  
		 
		execution.setVariable("Beitrag", beitrag);
		 
		
	 
	}

}
