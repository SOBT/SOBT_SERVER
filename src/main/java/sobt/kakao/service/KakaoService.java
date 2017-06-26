package sobt.kakao.service;

import sobt.domain.message.MessageVo;

public interface KakaoService {
	public MessageVo getMessageVo(String type);
}
