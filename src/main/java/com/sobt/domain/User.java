package com.sobt.domain;


/*========== 사용자로부터 받는 메시지 예시 ===========
단순 텍스트 입력 :
'{
  "user_key": "encryptedUserKey",
  "type": "text",
  "content": "차량번호등록"
}'

사진 입력 :
'{
  "user_key": "encryptedUserKey",
  "type": "photo",
  "content": "http://photo_url/number.jpg"
}'
===========================================*/

/**유저 객체 ( User object )
 * @author namwoo
 * 손댈 것 없음.
 */
public class User {
	String user_key;// "encryptedUserKey",
	String type;	// "text"    or "photo"
	String content; // "차량번호등록" or "http://photo_url/number.jpg"
	
	public String getUser_key() {
		return user_key;
	}
	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
