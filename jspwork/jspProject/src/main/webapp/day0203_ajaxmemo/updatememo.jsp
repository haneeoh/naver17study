<?xml version="1.0" encoding="UTF-8"?>
<%@page import="memo.data.MemoDao"%>
<%@page import="memo.data.MemoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 수정 idx 필수! html 만 있으므로 type 확인 필수 -->
<%
	int idx=Integer.parseInt(request.getParameter("idx"));
	String avata=request.getParameter("avata");
	String nickname=request.getParameter("nickname");
	String message=request.getParameter("message");
	
	MemoDto dto=new MemoDto();
	dto.setIdx(idx);
	dto.setAvata(avata);
	dto.setNickName(nickname);
	dto.setMessage(message);
	
	MemoDao dao=new MemoDao();
	dao.updateMemo(dto);
%>