<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html-el.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean-el.tld" prefix="bean" %>
<jsp:include page="header.jsp" />
	<div class="container">
		<h1>Please Confirm</h1>
		<span>Are you sure you want to delete bookmark "<c:out value="${bookmark.name}" />"?</span>
		<html:link action="/bookmarks.do?methodToCall=deleteSave&id=${bookmark.id}" styleClass="btn btn-danger">yes, remove</html:link> <html:link action="/bookmarks" styleClass="btn btn-default">no, do not remove</html:link>
	</div>
<jsp:include page="footer.jsp" />