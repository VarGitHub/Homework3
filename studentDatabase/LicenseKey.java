package studentDatabase;

public class LicenseKey {
	public String licenseKey;

	private static volatile LicenseKey singleInstance = new LicenseKey();

    //private constructor.
    private LicenseKey(){
    	licenseKey = "XXX-XXXX-XXXX";
    }
    public static LicenseKey getInstance() {
        return singleInstance;
       }

}
