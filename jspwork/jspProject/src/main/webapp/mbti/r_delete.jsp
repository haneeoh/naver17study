<%@page import="mbtireple.mbtirepleDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int idx=Integer.parseInt(request.getParameter("idx"));
	mbtirepleDao dao=new mbtirepleDao();
	dao.deleteReple(idx);
%>