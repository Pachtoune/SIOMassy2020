<%-- 
    Document   : newtag_file
    Created on : 12 mai 2020, 11:51:08
    Author     : sandr
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="test"%>
<c:if test="${test}">
  <div class =error >  
  L'adresse mail doit contenir :
    <ul>
      <li> une chaîne de caractères </li>
      <li>&nbsp;  & &nbsp; un "."&nbsp; </li>
      <li>&nbsp; & &nbsp; un "@" </li>
    </ul>
  </div>
</c:if> 