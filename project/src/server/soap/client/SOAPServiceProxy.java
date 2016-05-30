package server.soap.client;

public class SOAPServiceProxy implements server.soap.client.SOAPService {
  private String _endpoint = null;
  private server.soap.client.SOAPService sOAPService = null;
  
  public SOAPServiceProxy() {
    _initSOAPServiceProxy();
  }
  
  public SOAPServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initSOAPServiceProxy();
  }
  
  private void _initSOAPServiceProxy() {
    try {
      sOAPService = (new server.soap.client.SOAPServiceServiceLocator()).getSOAPServicePort();
      if (sOAPService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)sOAPService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)sOAPService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (sOAPService != null)
      ((javax.xml.rpc.Stub)sOAPService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public server.soap.client.SOAPService getSOAPService() {
    if (sOAPService == null)
      _initSOAPServiceProxy();
    return sOAPService;
  }
  
  public server.soap.client.Poll[] getAllPolls() throws java.rmi.RemoteException{
    if (sOAPService == null)
      _initSOAPServiceProxy();
    return sOAPService.getAllPolls();
  }
  
  public server.soap.client.Poll getPollByID(int arg0) throws java.rmi.RemoteException{
    if (sOAPService == null)
      _initSOAPServiceProxy();
    return sOAPService.getPollByID(arg0);
  }
  
  public server.soap.client.Poll[] getPolls(java.lang.String arg0, boolean arg1, int arg2) throws java.rmi.RemoteException{
    if (sOAPService == null)
      _initSOAPServiceProxy();
    return sOAPService.getPolls(arg0, arg1, arg2);
  }
  
  public server.soap.client.Poll[] getPollsBy(java.lang.String arg0, java.lang.String arg1, boolean arg2, int arg3) throws java.rmi.RemoteException{
    if (sOAPService == null)
      _initSOAPServiceProxy();
    return sOAPService.getPollsBy(arg0, arg1, arg2, arg3);
  }
  
  public int createPoll(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4, java.util.Calendar[] arg5) throws java.rmi.RemoteException{
    if (sOAPService == null)
      _initSOAPServiceProxy();
    return sOAPService.createPoll(arg0, arg1, arg2, arg3, arg4, arg5);
  }
  
  public boolean cloasePoll(java.lang.String arg0, java.lang.String arg1, int arg2) throws java.rmi.RemoteException{
    if (sOAPService == null)
      _initSOAPServiceProxy();
    return sOAPService.cloasePoll(arg0, arg1, arg2);
  }
  
  
}