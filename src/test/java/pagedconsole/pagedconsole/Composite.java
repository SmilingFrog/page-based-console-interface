package pagedconsole.pagedconsole;

import java.util.ArrayList;
import java.util.List;

public abstract class Composite extends Component {
	List<Component> components;
	
	public Composite(){
		components = new ArrayList<>();
	}
	
	public void add(PageElement element) {
		components.add((Component) element);
	}

	@Override
	public String getText() {
		return super.getText();
	}
	
	
}
