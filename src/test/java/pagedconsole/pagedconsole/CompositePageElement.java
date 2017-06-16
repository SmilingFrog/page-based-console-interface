package pagedconsole.pagedconsole;

import java.util.ArrayList;
import java.util.List;

public class CompositePageElement extends Composite{

	@Override
	public String getText() {
		String result = null;
		StringBuilder sb = new StringBuilder();
		sb.append(elementText);
		for(Component component : components){
			sb.append(component.getText());
		}
		result = sb.toString();
		return result; 
	}

}
