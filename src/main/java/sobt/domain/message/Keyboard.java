package sobt.domain.message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author namwoo
 * 키보드 객체
 * @method addButtons : 버튼으로 입력받도록 입력방식 설정 ( 인자 1개당 1개 버튼 생성 )
 */
public class Keyboard {
	private String type;			// type : "text" or "buttons"
	private List<String> buttons = new ArrayList<String>();;

	// ============== spring 메소드 ================
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }
	public List<String> getButtons() { return buttons; }
	public void setButtons(List<String> buttons) { this.buttons = buttons; }
	// ===========================================

	public void addButton(String button) {
		buttons.add(button);
	}
}
