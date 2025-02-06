<%@page import="org.json.simple.JSONObject"%>
<%@page import="shop.data.shopDto"%>
<%@page import="shop.data.shopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num=Integer.parseInt(request.getParameter("num"));
	shopDao dao=new shopDao();
	shopDto dto=dao.getOneSangpum(num);

		JSONObject ob=new JSONObject();
		ob.put("num",dto.getNum());
		ob.put("sangpum",dto.getSangpum());
		ob.put("scolor",dto.getScolor());
		ob.put("sphoto",dto.getSphoto());
		ob.put("ipgoday",dto.getIpgoday());
		ob.put("scnt",dto.getScnt());
		ob.put("sprice",dto.getSprice());
%>
<%=ob%>