/*
 * Copyright 2016 WSO2, Inc. http://www.wso2.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sample.sl;


import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

public class SampleServiceListener implements BundleActivator, ServiceListener {

    BundleContext bc;

    public void start(BundleContext bc) throws Exception {
        this.bc = bc;
        bc.addServiceListener(this);
    }

    public void stop(BundleContext bc) throws Exception {
        bc.removeServiceListener(this);
    }

    public void serviceChanged(ServiceEvent event) {
        switch (event.getType()) {

            case ServiceEvent.REGISTERED: {
                System.out.println("Service Registered");
                break;
            }
            case ServiceEvent.UNREGISTERING: {
                System.out.println("Service Unregistered");
                break;
            }
            case ServiceEvent.MODIFIED: {
                System.out.println("Service Modified");
                break;
            }
        }
    }

}
