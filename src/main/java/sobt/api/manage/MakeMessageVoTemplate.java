package sobt.api.manage;

import org.springframework.beans.factory.annotation.Autowired;

import sobt.domain.message.Message;
import sobt.domain.message.MessageService;
import sobt.domain.message.MessageVo;

public class MakeMessageVoTemplate {

	@Autowired
	MessageService msgService;

	public MessageVo doMakeMessageVo(String sentence) {
		MessageVo msgVo = new MessageVo();
		 Message message = msgService.makeMessage(sentence);
		 msgVo.setMessage(message);
		return msgVo;
	}
}
