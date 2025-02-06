<%@page import="shop.data.shopDao"%>
<%@page import="shop.data.shopDto"%>
<%@ page language="java" contentType="html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String sangpum=request.getParameter("sangpum");
	String scolor=request.getParameter("scolor");
	String sphoto=request.getParameter("sphoto");
	String ipgoday=request.getParameter("ipgoday");
	int scnt=Integer.parseInt(request.getParameter("scnt"));
	int sprice=Integer.parseInt(request.getParameter("sprice"));
	
	shopDto dto=new shopDto();
	dto.setSangpum(sangpum);
	dto.setScolor(scolor);
	dto.setSphoto(sphoto);
	dto.setIpgoday(ipgoday);
	dto.setScnt(scnt);
	dto.setSprice(sprice);
	
	shopDao dao=new shopDao();
	dao.insertShop(dto);
%>