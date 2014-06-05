<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html-el.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean-el.tld" prefix="bean" %>
<jsp:include page="header.jsp" />
	<div class="container">
		<h1>edit bookmark</h1>
		<html:form action="/bookmarks">
			<div class="form-group">
				<label for="name">name</label>
				<html:text property="name" value="${bookmark.name}" styleId="name" styleClass="form-control" />
			</div>
			<div class="form-group">
				<label for="url">url</label>
				<html:text property="url" value="${bookmark.url}" styleId="url" styleClass="form-control" />
			</div>
			<html:hidden property="id" value="${bookmark.id}" />
			<html:hidden property="methodToCall" value="editSave" />
			<html:submit styleClass="btn btn-primary">save</html:submit>
			<html:link action="/bookmarks" styleClass="btn btn-default">cancel</html:link>
	</html:form>
	</div>
<jsp:include page="footer.jsp" />