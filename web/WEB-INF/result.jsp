<%-- 
    Document   : result
    Created on : Dec 7, 2016, 11:12:15 AM
    Author     : danand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="java.util.List"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>IBA Version Monitoring</title>
    </head>
    <body>
        <%
        //response.setIntHeader("Refresh", 5);
        
        %>
        <h1 align="center">IBA Version Monitoring</h1>
        
        <table align="center">
                <%-- Række 1 --%>
                <tr> 
                <c:forEach begin="0" end="5" step="1" items="${customerList}" var="customer">
                   
                <td valign="top">
                    <h3 align="center"><c:out value="${customer.cName}"/></h3>
                    <table>
                        <tr>
                            <th valign="top" align="left">Environment</th>
                            <th valign="top" align="left">Version</th>
                        </tr>
                    
                    <c:forEach items="${customer.prodEnv}" var="prodEnv">
                    <tr>
                    <td><a href=<c:out value="${prodEnv.envURL}" />><c:out value="${prodEnv.envName}"/></a></td>
                    <td><c:out value="${prodEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.testEnv}" var="testEnv">
                    <tr>
                    <td><a href=<c:out value="${testEnv.envURL}" />><c:out value="${testEnv.envName}"/></a></td>
                    <td><c:out value="${testEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.devEnv}" var="devEnv">
                    <tr>
                    <td><a href=<c:out value="${devEnv.envURL}" />><c:out value="${devEnv.envName}"/></a></td>
                    <td><c:out value="${devEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.otherEnv}" var="otherEnv">
                    <tr>
                    <td><a href=<c:out value="${otherEnv.envURL}" />><c:out value="${otherEnv.envName}"/></a></td>
                    <td><c:out value="${otherEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    
                    </table>
                      
                </td>
                
                 </c:forEach>
                </tr>
                
                <%-- Række 2 --%>
                <tr> 
                <c:forEach begin="6" end="11" step="1" items="${customerList}" var="customer">  
                <td valign="top">
                    <h3 align="center"><c:out value="${customer.cName}"/></h3>
                    <table>
                        <tr>
                            <th valign="top" align="left">Environment</th>
                            <th valign="top" align="left">Version</th>
                        </tr>
                    
                    <c:forEach items="${customer.prodEnv}" var="prodEnv">
                    <tr>
                    <td><a href=<c:out value="${prodEnv.envURL}" />><c:out value="${prodEnv.envName}"/></a></td>
                    <td><c:out value="${prodEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.testEnv}" var="testEnv">
                    <tr>
                    <td><a href=<c:out value="${testEnv.envURL}" />><c:out value="${testEnv.envName}"/></a></td>
                    <td><c:out value="${testEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.devEnv}" var="devEnv">
                    <tr>
                    <td><a href=<c:out value="${devEnv.envURL}" />><c:out value="${devEnv.envName}"/></a></td>
                    <td><c:out value="${devEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.otherEnv}" var="otherEnv">
                    <tr>
                    <td><a href=<c:out value="${otherEnv.envURL}" />><c:out value="${otherEnv.envName}"/></a></td>
                    <td><c:out value="${otherEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    
                    </table>
                      
                </td>
                 </c:forEach>
                </tr>
                
                <%-- Række 3 --%>
                <tr>
                <c:forEach begin="12" end="17" step="1" items="${customerList}" var="customer">  
                <td valign="top">
                    <h3 align="center"><c:out value="${customer.cName}"/></h3>
                    <table>
                        <tr>
                            <th valign="top" align="left">Environment</th>
                            <th valign="top" align="left">Version</th>
                        </tr>
                    
                    <c:forEach items="${customer.prodEnv}" var="prodEnv">
                    <tr>
                    <td><a href=<c:out value="${prodEnv.envURL}" />><c:out value="${prodEnv.envName}"/></a></td>
                    <td><c:out value="${prodEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.testEnv}" var="testEnv">
                    <tr>
                    <td><a href=<c:out value="${testEnv.envURL}" />><c:out value="${testEnv.envName}"/></a></td>
                    <td><c:out value="${testEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.devEnv}" var="devEnv">
                    <tr>
                    <td><a href=<c:out value="${devEnv.envURL}" />><c:out value="${devEnv.envName}"/></a></td>
                    <td><c:out value="${devEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.otherEnv}" var="otherEnv">
                    <tr>
                    <td><a href=<c:out value="${otherEnv.envURL}" />><c:out value="${otherEnv.envName}"/></a></td>
                    <td><c:out value="${otherEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    
                    </table>
                      
                </td>
                 </c:forEach>
                </tr>
                
                <%-- Række 4 --%>
                <tr>
                <c:forEach begin="18" end="23" step="1" items="${customerList}" var="customer">  
                <td valign="top">
                    <h3 align="center"><c:out value="${customer.cName}"/></h3>
                    <table>
                        <tr>
                            <th valign="top" align="left">Environment</th>
                            <th valign="top" align="left">Version</th>
                        </tr>
                    
                    <c:forEach items="${customer.prodEnv}" var="prodEnv">
                    <tr>
                    <td><a href=<c:out value="${prodEnv.envURL}" />><c:out value="${prodEnv.envName}"/></a></td>
                    <td><c:out value="${prodEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.testEnv}" var="testEnv">
                    <tr>
                    <td><a href=<c:out value="${testEnv.envURL}" />><c:out value="${testEnv.envName}"/></a></td>
                    <td><c:out value="${testEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.devEnv}" var="devEnv">
                    <tr>
                    <td><a href=<c:out value="${devEnv.envURL}" />><c:out value="${devEnv.envName}"/></a></td>
                    <td><c:out value="${devEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.otherEnv}" var="otherEnv">
                    <tr>
                    <td><a href=<c:out value="${otherEnv.envURL}" />><c:out value="${otherEnv.envName}"/></a></td>
                    <td><c:out value="${otherEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    
                    </table>
                      
                 </td>
                 
                 </c:forEach>
                 </tr>
                 
                 <%-- Række 5 --%>
                <tr>
                <c:forEach begin="24" end="29" step="1" items="${customerList}" var="customer">  
                <td valign="top">
                    <h3 align="center"><c:out value="${customer.cName}"/></h3>
                    <table>
                        <tr>
                            <th valign="top" align="left">Environment</th>
                            <th valign="top" align="left">Version</th>
                        </tr>
                    
                    <c:forEach items="${customer.prodEnv}" var="prodEnv">
                    <tr>
                    <td><a href=<c:out value="${prodEnv.envURL}" />><c:out value="${prodEnv.envName}"/></a></td>
                    <td><c:out value="${prodEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.testEnv}" var="testEnv">
                    <tr>
                    <td><a href=<c:out value="${testEnv.envURL}" />><c:out value="${testEnv.envName}"/></a></td>
                    <td><c:out value="${testEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.devEnv}" var="devEnv">
                    <tr>
                    <td><a href=<c:out value="${devEnv.envURL}" />><c:out value="${devEnv.envName}"/></a></td>
                    <td><c:out value="${devEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.otherEnv}" var="otherEnv">
                    <tr>
                    <td><a href=<c:out value="${otherEnv.envURL}" />><c:out value="${otherEnv.envName}"/></a></td>
                    <td><c:out value="${otherEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    
                    </table>
                      
                 </td>
                 
                 </c:forEach>
                 </tr>
                 
                 <%-- Række 6 --%>
                <tr>
                <c:forEach begin="30" end="35" step="1" items="${customerList}" var="customer">  
                <td valign="top">
                    <h3 align="center"><c:out value="${customer.cName}"/></h3>
                    <table>
                        <tr>
                            <th valign="top" align="left">Environment</th>
                            <th valign="top" align="left">Version</th>
                        </tr>
                    
                   <c:forEach items="${customer.prodEnv}" var="prodEnv">
                    <tr>
                    <td><a href=<c:out value="${prodEnv.envURL}" />><c:out value="${prodEnv.envName}"/></a></td>
                    <td><c:out value="${prodEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.testEnv}" var="testEnv">
                    <tr>
                    <td><a href=<c:out value="${testEnv.envURL}" />><c:out value="${testEnv.envName}"/></a></td>
                    <td><c:out value="${testEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.devEnv}" var="devEnv">
                    <tr>
                    <td><a href=<c:out value="${devEnv.envURL}" />><c:out value="${devEnv.envName}"/></a></td>
                    <td><c:out value="${devEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.otherEnv}" var="otherEnv">
                    <tr>
                    <td><a href=<c:out value="${otherEnv.envURL}" />><c:out value="${otherEnv.envName}"/></a></td>
                    <td><c:out value="${otherEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    
                    </table>
                      
                 </td>
                 
                 </c:forEach>
                 </tr>
                 
                 <%-- Række 7 --%>
                <tr>
                <c:forEach begin="36" end="41" step="1" items="${customerList}" var="customer">  
                <td valign="top">
                    <h3 align="center"><c:out value="${customer.cName}"/></h3>
                    <table>
                        <tr>
                            <th valign="top" align="left">Environment</th>
                            <th valign="top" align="left">Version</th>
                        </tr>
                    
                    <c:forEach items="${customer.prodEnv}" var="prodEnv">
                    <tr>
                    <td><a href=<c:out value="${prodEnv.envURL}" />><c:out value="${prodEnv.envName}"/></a></td>
                    <td><c:out value="${prodEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.testEnv}" var="testEnv">
                    <tr>
                    <td><a href=<c:out value="${testEnv.envURL}" />><c:out value="${testEnv.envName}"/></a></td>
                    <td><c:out value="${testEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.devEnv}" var="devEnv">
                    <tr>
                    <td><a href=<c:out value="${devEnv.envURL}" />><c:out value="${devEnv.envName}"/></a></td>
                    <td><c:out value="${devEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    <c:forEach items="${customer.otherEnv}" var="otherEnv">
                    <tr>
                    <td><a href=<c:out value="${otherEnv.envURL}" />><c:out value="${otherEnv.envName}"/></a></td>
                    <td><c:out value="${otherEnv.version}"/></td>
                    </tr>
                    </c:forEach>
                    
                    </table>
                      
                 </td>
                 
                 </c:forEach>
                 </tr>
        </table>
        

                
           

            
            
    </body>
</html>
