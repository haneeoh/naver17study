<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="mbtireple.mbtirepleDto"%>
<%@page import="java.util.List"%>
<%@page import="mbtireple.mbtirepleDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	mbtirepleDao dao=new mbtirepleDao();
	List<mbtirepleDto> list=dao.getAllReples();
	
	JSONArray arr=new JSONArray();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	for(mbtirepleDto dto:list)
	{
		JSONObject ob=new JSONObject();
		ob.put("idx",dto.getIdx());
		ob.put("message",dto.getMessage());
		ob.put("writeday",sdf.format(dto.getWriteday()));
		
		arr.add(ob);
	}
%>
<%=arr%>