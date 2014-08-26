package tester

import org.osgi.framework.{BundleActivator,BundleContext}


class Main extends BundleActivator {
  
  System.loadLibrary("tester")
  
  override def start(ctx:BundleContext):Unit = {
    val t = new Tester
    println("testing printer")
    t.printer()
    val rand = t.rng
    println("random: " + rand)
  }
  
  override def stop(ctx:BundleContext):Unit = {
    
  }
    
}