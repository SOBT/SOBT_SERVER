package sobt.chat.template;

import sobt.domain.message.MessageVo;
import sobt.domain.user.User;

public class ChatResult {
	private User user;
	private MessageVo messageVo;
	
	public ChatResult(){
		
	}
	
	public ChatResult(User user , MessageVo messageVo){
		this.user = user;
		this.messageVo =  messageVo;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public MessageVo getMessageVo() {
		return messageVo;
	}
	public void setMessageVo(MessageVo messageVo) {
		this.messageVo = messageVo;
	}
}
