<%@page import="shopreple.data.repleDao"%>
<%@page import="shopreple.data.repleDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num=Integer.parseInt(request.getParameter("num"));
	int star=Integer.parseInt(request.getParameter("star"));
	String message=request.getParameter("message");
	
	repleDto dto=new repleDto();
	dto.setNum(num);
	dto.setStar(star);
	dto.setMessage(message);
	
	repleDao dao=new repleDao();
	dao.insertReple(dto);
%>
<data>
	<result>댓글을 DB에 추가했습니다.</result>
</data>