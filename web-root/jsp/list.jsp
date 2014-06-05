<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tlds/struts-html-el.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-bean-el.tld" prefix="bean" %>
<jsp:include page="header.jsp" />
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <html:link action="/bookmarks" styleClass="navbar-brand">Bookmark Manager</html:link>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><html:link action="/bookmarks.do?methodToCall=add">new</html:link></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>
    <div class="container">
      <table class="table table-striped">
		  <thead>
		  	<tr>
		  		<th>Name</th>
		  		<th>URL</th>
		  		<th>Action</th>
		  	</tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${bookmarks}" var="bookmark" varStatus="status">
		  	<tr>
		  		<td><c:out value="${bookmark.name}" /></td>
		  		<td><a href="<c:out value="${bookmark.url}" />"><c:out value="${bookmark.url}" /></a></td>
		  		<td>
		  			<html:link action="/bookmarks.do?methodToCall=edit&id=${bookmark.id}" styleClass="btn btn-primary">edit</html:link>
		  			<html:link action="/bookmarks.do?methodToCall=delete&id=${bookmark.id}" styleClass="btn btn-danger">delete</html:link>
		  		</td>
		  	</tr>
		  	</c:forEach>
		  </tbody>
		</table>
    </div>
<jsp:include page="footer.jsp" />