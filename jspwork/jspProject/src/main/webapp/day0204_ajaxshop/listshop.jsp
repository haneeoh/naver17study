<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="shop.data.shopDto"%>
<%@page import="java.util.List"%>
<%@page import="shop.data.shopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int order=Integer.parseInt(request.getParameter("order"));
	shopDao dao=new shopDao();
	List<shopDto> list=dao.getAllSangpums(order);
	
	JSONArray arr=new JSONArray();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	for(shopDto dto:list)
	{
		JSONObject ob=new JSONObject();
		ob.put("num",dto.getNum());
		ob.put("sangpum",dto.getSangpum());
		ob.put("scolor",dto.getScolor());
		ob.put("sphoto",dto.getSphoto());
		ob.put("ipgoday",dto.getIpgoday());
		ob.put("scnt",dto.getScnt());
		ob.put("sprice",dto.getSprice());
		ob.put("writeday",sdf.format(dto.getWriteday()));
		
		arr.add(ob);
	}
%>
<%=arr%>