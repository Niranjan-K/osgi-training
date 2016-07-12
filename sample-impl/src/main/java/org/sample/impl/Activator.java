package org.sample.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.sample.api.Hello;

import java.util.Hashtable;


/**
 * Created by aruna on 11/07/2014.
 */
public class Activator implements BundleActivator {
    ServiceRegistration serviceRegistration;

    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Service Impl 1 Hello Activated...");
        HelloWorld helloWorld = new HelloWorld();
        Hashtable props = new Hashtable();
        props.put("name", "impl1");
        serviceRegistration = bundleContext.registerService(Hello.class, helloWorld, props);
    }

    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Service Impl 1 Hello Stopped...");
        serviceRegistration.unregister();
    }
}
