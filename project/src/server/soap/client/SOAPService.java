/**
 * SOAPService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package server.soap.client;

public interface SOAPService extends java.rmi.Remote {
    public server.soap.client.Poll[] getAllPolls() throws java.rmi.RemoteException;
    public server.soap.client.Poll getPollByID(int arg0) throws java.rmi.RemoteException;
    public server.soap.client.Poll[] getPolls(java.lang.String arg0, boolean arg1, int arg2) throws java.rmi.RemoteException;
    public server.soap.client.Poll[] getPollsBy(java.lang.String arg0, java.lang.String arg1, boolean arg2, int arg3) throws java.rmi.RemoteException;
    public int createPoll(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.util.Calendar[] arg5) throws java.rmi.RemoteException;
    public boolean cloasePoll(java.lang.String arg0, java.lang.String arg1, int arg2) throws java.rmi.RemoteException;
}
