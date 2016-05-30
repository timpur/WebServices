/**
 * SOAPServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package server.soap.client;

public class SOAPServiceServiceLocator extends org.apache.axis.client.Service implements server.soap.client.SOAPServiceService {

    public SOAPServiceServiceLocator() {
    }


    public SOAPServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SOAPServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SOAPServicePort
    private java.lang.String SOAPServicePort_address = "http://localhost:8080/WebServicesAssignment/soap/service";

    public java.lang.String getSOAPServicePortAddress() {
        return SOAPServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SOAPServicePortWSDDServiceName = "SOAPServicePort";

    public java.lang.String getSOAPServicePortWSDDServiceName() {
        return SOAPServicePortWSDDServiceName;
    }

    public void setSOAPServicePortWSDDServiceName(java.lang.String name) {
        SOAPServicePortWSDDServiceName = name;
    }

    public server.soap.client.SOAPService getSOAPServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SOAPServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSOAPServicePort(endpoint);
    }

    public server.soap.client.SOAPService getSOAPServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            server.soap.client.SOAPServicePortBindingStub _stub = new server.soap.client.SOAPServicePortBindingStub(portAddress, this);
            _stub.setPortName(getSOAPServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSOAPServicePortEndpointAddress(java.lang.String address) {
        SOAPServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (server.soap.client.SOAPService.class.isAssignableFrom(serviceEndpointInterface)) {
                server.soap.client.SOAPServicePortBindingStub _stub = new server.soap.client.SOAPServicePortBindingStub(new java.net.URL(SOAPServicePort_address), this);
                _stub.setPortName(getSOAPServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SOAPServicePort".equals(inputPortName)) {
            return getSOAPServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.server/", "SOAPServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.server/", "SOAPServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SOAPServicePort".equals(portName)) {
            setSOAPServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
