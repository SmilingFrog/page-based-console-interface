package pagedconsole.pagedconsole;

public class BrowserImpl implements Browser {

	@Override
	public String browse(String pageName) {
		System.out.println("HEADER\nBODY\nFOOTER");
		return "HEADER\nBODY\nFOOTER";
	}

}
