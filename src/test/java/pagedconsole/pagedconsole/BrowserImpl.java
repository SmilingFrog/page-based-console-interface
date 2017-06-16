package pagedconsole.pagedconsole;

public class BrowserImpl implements Browser {

	@Override
	public String browse(String pageName) {
		return "HEADER\nBODY\nFOOTER";
	}

}
