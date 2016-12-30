package org.example.sieme002;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.1.7
 * 2016-10-31T14:33:39.762+01:00
 * Generated source version: 3.1.7
 * 
 */
@WebService(targetNamespace = "http://www.example.org/SIEME002/SIEME002", name = "SIEME002")
@XmlSeeAlso({com.endesa.xmlns.commonschemas.ObjectFactory.class, org.example.sieme002_schema.ObjectFactory.class, com.endesa.xmlns.commonschemasneol.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface SIEME002 {

    @WebMethod(operationName = "GetCalle", action = "GetCalle")
    @WebResult(name = "GetCalleResponse", targetNamespace = "http://www.example.org/SIEME002_Schema/", partName = "response")
    public org.example.sieme002_schema.GetCalleResponseType getCalle(
        @WebParam(partName = "request", name = "GetCalleRequest", targetNamespace = "http://www.example.org/SIEME002_Schema/")
        org.example.sieme002_schema.GetCalleRequestType request
    ) throws GetCalleFault;
}
