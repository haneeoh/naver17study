<?xml version="1.0" encoding="UTF-8"?>
<%@page import="shop.data.shopDao"%>
<%@page import="shop.data.shopDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 수정 num html만 있으므로 type 확인 -->

<%
	int num=Integer.parseInt(request.getParameter("num"));
	String sphoto=request.getParameter("sphoto");
	String sangpum=request.getParameter("sangpum");
	String scolor=request.getParameter("scolor");
	int scnt=Integer.parseInt(request.getParameter("scnt"));
	int sprice=Integer.parseInt(request.getParameter("sprice"));
	String ipgoday=request.getParameter("ipgoday");
	
	shopDto dto=new shopDto();
	dto.setNum(num);
	dto.setSphoto(sphoto);
	dto.setSangpum(sangpum);
	dto.setScolor(scolor);
	dto.setScnt(scnt);
	dto.setSprice(sprice);
	dto.setIpgoday(ipgoday);
	
	shopDao dao=new shopDao();
	dao.updateShop(dto);
%>