package sobt.python.service;

import org.springframework.beans.factory.annotation.Autowired;

import sobt.domain.message.MessageService;
import sobt.domain.message.MessageServiceImpl;
import sobt.domain.message.MessageVo;
import sobt.domain.python.Papago;

public class PapagoServiceImpl implements PapagoService {
	@Autowired
	MessageService msgService;

	public MessageService getMsgService() {
		return msgService;
	}

	public void setMsgService(MessageService msgService) {
		this.msgService = msgService;
	}

	@Override
	public MessageVo getText(String sentence) {
		Papago papago = new Papago();
		// TODO Auto-generated method stub
		MessageVo messageVo = new MessageVo();
		String tds = papago.translate(sentence, "True");
		messageVo.setMessage(msgService.makeMessage(tds));
		return messageVo;
	}
}
