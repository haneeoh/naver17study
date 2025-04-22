<%@page import="mbtireple.mbtirepleDao"%>
<%@page import="mbtireple.mbtirepleDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String message=request.getParameter("message");

	
	mbtirepleDto dto=new mbtirepleDto();
	dto.setMessage(message);
	
	mbtirepleDao dao=new mbtirepleDao();
	dao.insertReple(dto);
%>
<data>
	<result>댓글이 등록되었습니다.</result>
</data>