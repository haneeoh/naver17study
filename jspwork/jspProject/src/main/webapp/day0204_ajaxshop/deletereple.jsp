<%@page import="shopreple.data.repleDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int idx=Integer.parseInt(request.getParameter("idx"));
	repleDao dao=new repleDao();
	dao.deleteReple(idx);
%>