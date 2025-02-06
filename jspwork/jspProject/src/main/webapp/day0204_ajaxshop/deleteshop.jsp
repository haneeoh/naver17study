<%@page import="shop.data.shopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1.num 읽기
	int num=Integer.parseInt(request.getParameter("num"));
	//2.dao 선언
	shopDao dao=new shopDao();
	//3.deleteShop(int num) 호출 (dao 에 생성)
	dao.deleteShop(num);
%>