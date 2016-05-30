/**
 * SOAPServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package server.soap.client;

public interface SOAPServiceService extends javax.xml.rpc.Service {
    public java.lang.String getSOAPServicePortAddress();

    public server.soap.client.SOAPService getSOAPServicePort() throws javax.xml.rpc.ServiceException;

    public server.soap.client.SOAPService getSOAPServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
