package pagedconsole.pagedconsole;

import java.util.HashMap;
import java.util.Map;

public class LeafPageElement extends Component {

	Map<String, String> attributes;
	
	public LeafPageElement(){
		attributes = new HashMap<>();
	}
	
	public void addAttribute(String attributeName, String attributeValue) {
		attributes.put(attributeName, attributeValue);
	}

	@Override
	public String getText() {
		String result = null;
		String text = elementText;
		String trigger = attributes.get("trigger");
		if(trigger != null){
			result = "<" + trigger + ">" + text; 
		}else{
			result = text;
		}
		return result;
	}
	

}
