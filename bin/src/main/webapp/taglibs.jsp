<%@ page language="java" errorPage="/error.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/struts-tags" prefix="s" %>

<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="datePattern"><fmt:message key="date.format"/></c:set>

<c:set var="yuiversion" value="yui_2.8.1"/>
<c:set var="skins" value="yui/build/assets/skins/plad"/>

<%
Double db = Double.valueOf( Math.random() * 50) ;
pageContext.setAttribute("random", db, PageContext.PAGE_SCOPE);
%>

<c:set var="version" value="${pageScope.random}"/>

<%-- si el valor es true se creara el log --%>
<c:set var="createlog" value="false"/>

<%-- si el valor es true el log no se visualizara por default--%>
<c:set var="hidelog" value="true"/>