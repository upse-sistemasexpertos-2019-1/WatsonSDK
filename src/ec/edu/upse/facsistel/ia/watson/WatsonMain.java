package ec.edu.upse.facsistel.ia.watson;

import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.MessageInput;
import com.ibm.watson.assistant.v2.model.MessageOptions;
import com.ibm.watson.assistant.v2.model.MessageResponse;
import com.ibm.watson.assistant.v2.model.SessionResponse;

public class WatsonMain {

	public static void main(String[] args) {
		
		IamOptions options = new IamOptions.Builder()
			    .apiKey("Poner Aqui su API KEY")
			    .build();
			Assistant assistant = new Assistant("2019-02-28", options);
			assistant.setEndPoint("https://gateway.watsonplatform.net/assistant/api");
			
		System.out.println(assistant);
		
		String assistantID = "626b29cb-f050-4705-acb1-5fdd00e681b0";
		
		CreateSessionOptions sessionOptions = 
				new CreateSessionOptions.Builder(assistantID).build();
		
		SessionResponse response = assistant.createSession(sessionOptions).execute().getResult();

		String sessionID = response.getSessionId();
		
		System.out.println(response);
		
		MessageInput input = new MessageInput.Builder()
				  .messageType("text")
				  .text("Hey")
				  .build();
		
		MessageOptions messageOptions = new MessageOptions.Builder(assistantID, sessionID)
				  .input(input)
				  .build();
		
		MessageResponse dialogResponse = assistant.message(messageOptions).execute().getResult();

		System.out.println(dialogResponse);
	}

}
