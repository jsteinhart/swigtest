package tester;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

//import java.io.IOException;
//
//import cz.adamh.utils.NativeUtils;


public class Main implements BundleActivator {
	
	static {
		System.loadLibrary("tester");
	}
	

	public void start(BundleContext context) throws Exception {

		Tester t = new Tester();
		
		System.out.println("Trying the printer:");
		t.printer();
		
		int num = t.rng();
		context.println("RNG: " +num);
		
		
	}

	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
