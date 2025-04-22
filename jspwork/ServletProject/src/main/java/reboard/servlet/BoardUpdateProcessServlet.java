package reboard.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reboard.data.BoardDao;
import reboard.data.BoardDto;

import java.io.IOException;

/**
 * Servlet implementation class BoardUpdateProcessServlet
 */
@WebServlet("/board/update")
public class BoardUpdateProcessServlet extends HttpServlet {
	
	BoardDao dao=new BoardDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageNum=request.getParameter("pageNum");
		
		BoardDto dto=new BoardDto();
		String subject=request.getParameter("subject");
		String content=request.getParameter("content");
		int num=Integer.parseInt(request.getParameter("num"));
		
		
		request.setAttribute("pageNum", pageNum);

		dto.setSubject(subject);
		dto.setContent(content);
		dto.setNum(num);
		
		dao.updateBoard(dto);
		
		response.sendRedirect("./detail?num="+num+"&pageNum="+pageNum);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
