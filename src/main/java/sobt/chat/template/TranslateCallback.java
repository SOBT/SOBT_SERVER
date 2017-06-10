package sobt.chat.template;

import sobt.domain.message.Keyboard;
import sobt.domain.message.Message;
import sobt.domain.message.MessageService;
import sobt.domain.message.MessageVo;
import sobt.domain.user.SubStatus;
import sobt.domain.user.User;
import sobt.translate.service.Translate;
import sobt.translate.service.TranslateService;

public class TranslateCallback implements ChatCallback {
	private TranslateService translateService;
	
	private MessageService msgService;

	public void setMessageService(MessageService msgService) {
		this.msgService = msgService;
	}
	
	public void setTranslateService(TranslateService translateService){
		this.translateService = translateService;
	}
	@Override
	public ChatResult doProcessChat(User user, String text) {
		// TODO Auto-generated method stub
		if(user.getSubStatus().equals(SubStatus.NORMAL)){
			user.setSubStatus(checkSubStatus(text));
			if(user.getSubStatus().equals(SubStatus.NORMAL)){
				String resultText = "";
				resultText += " 1.한국어 -> 영어로 번역.\n ";
				resultText += "2.한국어 -> 일어로 번역.\n ";
				resultText += "3.한국어 -> 중국어로 번역.\n ";
				resultText += "4.영문  -> 한국어로 번역.\n ";
				resultText += "5.일어  -> 한국어로 번역.\n ";
				resultText += "6.중국어 -> 한국어로 번역.\n\n";
				resultText += "원하시는 번역을 숫자로 입력해주세요.\n ";
				resultText+= "처음단계로 돌아가려면" +"\"처음\"" +"을입력해주세요";
				
				Message message = msgService.makeMessage(resultText);
				MessageVo msgVo = new MessageVo();
				msgVo.setMessage(message);
				return new ChatResult(user, msgVo);
			}else {
				String resultText = "";
				resultText += "번역할 문장을 입력해 주세요.";
				resultText+= "\n\n";
				resultText+= "이전단계로 돌아가려면" +"\"이전\"" +"을 입력해주세요";
				resultText+= "\n";
				resultText+= "처음단계로 돌아가려면" +"\"처음\"" +"을입력해주세요";
				Message message = msgService.makeMessage(resultText);
				
				MessageVo msgVo = new MessageVo();
				msgVo.setMessage(message);
				return new ChatResult(user, msgVo);
			}
		}else
		{
			MessageVo msgVo = null;
			if(text.equals("이전")){
				user.setSubStatus(SubStatus.NORMAL);
				String resultText = "";
				resultText += " 1.한국어 -> 영어로 번역.\n ";
				resultText += "2.한국어 -> 일어로 번역.\n ";
				resultText += "3.한국어 -> 중국어로 번역.\n ";
				resultText += "4.영문  -> 한국어로 번역.\n ";
				resultText += "5.일어  -> 한국어로 번역.\n ";
				resultText += "6.중국어 -> 한국어로 번역.\n\n";
				resultText += "원하시는 번역을 숫자로 입력해주세요.\n ";
				resultText+= "처음단계로 돌아가려면" +"\"처음\"" +"을입력해주세요";
				
				Message message = msgService.makeMessage(resultText);
				msgVo = new MessageVo();
				msgVo.setMessage(message);
				
			}else {
				String resultText = this.translateService.translateSentence(Translate.valueOf(user.getSubStatus().initValue()), text);
				Message message = msgService.makeMessage(resultText);
				msgVo = new MessageVo();
				msgVo.setMessage(message);
			}
			return new ChatResult(user, msgVo);
		}
	}
	
	private SubStatus checkSubStatus(String text){
		if(text.equals("1")){
			return SubStatus.KO_TO_EN;
		}else if(text.equals("2")){
			return SubStatus.KO_TO_JA;
		}else if(text.equals("3")){
			return SubStatus.KO_TO_CN;
		}else if(text.equals("4")){
			return SubStatus.EN_TO_KO;
		}else if(text.equals("5")){
			return SubStatus.JA_TO_KO;
		}else if(text.equals("6")){
			return SubStatus.CN_TO_KO;
		}else {
			return SubStatus.NORMAL;
		}
	}

}