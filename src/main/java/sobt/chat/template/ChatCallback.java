package sobt.chat.template;

import sobt.domain.user.User;

public interface ChatCallback {
	public ChatResult doProcessChat(User user,String text);
}
