package sobt.chat.template;

import sobt.domain.message.Keyboard;
import sobt.domain.message.Message;
import sobt.domain.message.MessageVo;
import sobt.domain.message.MessageService;
import sobt.domain.user.SubStatus;
import sobt.domain.user.User;
import sobt.user.service.UserService;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import sobt.api.manage.SubwayAPIManager;


public class SubwayCallback implements ChatCallback{
	private MessageService msgService;
	private SubwayAPIManager subwayApiManager;
	private UserService userService;
	
	public void setMessageService(MessageService msgService) {
		this.msgService = msgService;
	}
	
	public void setSubwayAPIManager(SubwayAPIManager subwayApiManager) {
		this.subwayApiManager = subwayApiManager;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public ChatResult doProcessChat(User user, String text) {
		MessageVo msgVo;
        Message message;
        if(user.getSubStatus().equals(SubStatus.NORMAL)) {
        	msgVo = null;
        	user.setSubStatus(SubStatus.SELECT_SUB_SERVICE);
            message = msgService.makeMessage("1. 실시간 지하철 정보\n"+"2. 첫차/막차 정보\n"+"중에서 선택해주세요");
            msgVo = new MessageVo();
            msgVo.setMessage(message);
            return new ChatResult(user, msgVo);
            
        } else if(user.getSubStatus().equals(SubStatus.SELECT_SUB_SERVICE)) {
        	msgVo = null;
            if(text.equals("1")) {
            	user.setSubStatus(SubStatus.RT_RESULT);
            	message = msgService.makeMessage("원하는 지하철역을 입력하세요");
            } else if(text.equals("2")) {
            	user.setSubStatus(SubStatus.FL_SUB_LINE);
            	String messageText = "원하는 호선을 입력하세요\n" + 
            			"1호선 : 1 / 2호선 : 2 / 3호선 : 3 / " + 
            			"4호선 : 4 / 5호선 : 5 / 6호선 : 6 / " + 
            			"7호선 : 7 / 8호선 : 8 / 9호선 : 9\n"+
            			"공항철도 : A\n"+
            			"분당선 : B\n"+
            			"용인경전철 : E\n"+
            			"경춘선 : G\n"+
            			"인천1호선 : I\n"+
            			"인천 2호선 : I2\n"+
            			"경의중앙선 : K\n"+ 
            			"경강선 : KK\n"+
            			"신분당선 : S\n"+
            			"수인선 : SU";

            	message = msgService.makeMessage(messageText);
            } else {
            	user.setSubStatus(SubStatus.NORMAL);
            	message = msgService.makeMessage("1. 실시간 지하철 정보\n"+"2. 첫차/막차 정보\n"+"중에서 선택해주세요");
            }
            msgVo = new MessageVo();
            msgVo.setMessage(message);
            return new ChatResult(user, msgVo);
        }
        else if(user.getSubStatus().equals(SubStatus.RT_RESULT)) {
        	msgVo = null;
        	user.setSubStatus(SubStatus.NORMAL);
            message = msgService.makeMessage("원하는 지하철역을 입력하세요");
            userService.addUserStationNm(user, text);
        	try {
				message = msgService.makeMessage(subwayApiManager.getRealTimeArrival("json", text));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException();
			}
        	msgVo = new MessageVo();
        	msgVo.setMessage(message);
            return new ChatResult(user, msgVo);
        }else if(user.getSubStatus().equals(SubStatus.FL_SUB_NAME)) {
        	msgVo = null;
        	user.setSubStatus(SubStatus.FL_SUB_INOUT);
        	userService.addUserStationNm(user, text);
        	String messageText = "상/하행선을 입력하세요\n" +
        			"상행, 내선 : 1\n" +
        			"하행, 외선 : 2\n";
            message = msgService.makeMessage(messageText);
            msgVo = new MessageVo();
            msgVo.setMessage(message);
            return new ChatResult(user, msgVo);
        } else if(user.getSubStatus().equals(SubStatus.FL_SUB_LINE)) {
        	msgVo = null;
        	user.setSubStatus(SubStatus.FL_SUB_NAME);
        	userService.addUserLineNum(user, text);
            message = msgService.makeMessage("원하는 지하철역을 입력하세요");
            msgVo = new MessageVo();
            msgVo.setMessage(message);
            return new ChatResult(user, msgVo);
        } else if(user.getSubStatus().equals(SubStatus.FL_SUB_INOUT)) {
        	msgVo = null;
        	int week_tag;
        	Date date = new Date();
        	week_tag=changeDayToWeekTag(date.getDate());
        	user.setSubStatus(SubStatus.NORMAL);
        	userService.addUserInOut(user, text);
        	message = msgService.makeMessage(subwayApiManager.getFirstAndLast("json", 
        			userService.getUserLineNum(user.getUserId()), week_tag, text, userService.getUserStationNm(user.getUserId())));
        	msgVo = new MessageVo();
        	msgVo.setMessage(message);
            return new ChatResult(user, msgVo);
        } else {
        	return null;
        } 
	}
	
	private int changeDayToWeekTag(int day) {
		int week_tag;
		if(day == 0) {
			week_tag = 3;
			return week_tag;
		} else if (day == 6) {
			week_tag = 2;
			return week_tag;
		} else {
			week_tag = 1;
			return week_tag;
		}
	}
	
	private SubStatus checkSubStatus(String text) {
		if(text.equals("10")) {
			return SubStatus.SELECT_SUB_SERVICE;
		} else if(text.equals("12")) {
			return SubStatus.RT_RESULT;
		} else if(text.equals("13")) {
			return SubStatus.FL_SUB_LINE;
		} else if(text.equals("14")) {
			return SubStatus.FL_SUB_NAME;
		} else if(text.equals("15")) {
			return SubStatus.FL_SUB_INOUT;
		} else {
			return SubStatus.NORMAL;
		}
	}
}