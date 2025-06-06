<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="shopreple.data.repleDto"%>
<%@page import="java.util.List"%>
<%@page import="shopreple.data.repleDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	int num=Integer.parseInt(request.getParameter("num"));

	repleDao dao=new repleDao();
	List<repleDto> list=dao.getAllReples(num);
	
	JSONArray arr=new JSONArray();
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
	                                                                                        
	for(repleDto dto:list)
	{
		JSONObject ob=new JSONObject();
		ob.put("idx",dto.getIdx());
		ob.put("num",dto.getNum());
		ob.put("star",dto.getStar());
		ob.put("message",dto.getMessage());
		ob.put("writeday",sdf.format(dto.getWriteday()));
		
		arr.add(ob);
	}
%>

<%=arr%>