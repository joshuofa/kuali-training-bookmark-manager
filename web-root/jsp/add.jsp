<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html-el.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean-el.tld" prefix="bean" %>
<jsp:include page="header.jsp" />
	<div class="container">
		<h1>New Bookmark</h1>
		<html:form action="/bookmarks">
			<div class="form-group">
				<label for="name">Name</label>
				<html:text property="name" styleId="name" styleClass="form-control" />
			</div>
			<div class="form-group">
				<label for="name">URL</label>
				<html:text property="url" styleId="url" styleClass="form-control" />
			</div>
			<html:hidden property="methodToCall" value="addSave" />
			<html:submit styleClass="btn btn-default">add</html:submit>
		</html:form>
	</div>
<jsp:include page="footer.jsp" />