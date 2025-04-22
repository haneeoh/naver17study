package reboard.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reboard.data.BoardDao;
import reboard.data.BoardDto;

import java.io.IOException;

/**
 * Servlet implementation class BoardFormServlet
 */
@WebServlet("/board/writeform")
public class BoardFormServlet extends HttpServlet {
	BoardDao dao=new BoardDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//num,regroup,restep,relevel 을 읽는데 새글일경우는 Null 값, 답글일 경우는
		//정수타입의 숫자가 넘어온다.
		
		int num,regroup,restep,relevel;
		String subject="";//새글일경우 아무것도 안찍히고 , 답글일경우 원글의 제목 표시
		
		try {
			//답글인 경우는 원글의 값들을 가져온다
			num=Integer.parseInt(request.getParameter("num"));
			regroup=Integer.parseInt(request.getParameter("regroup"));
			restep=Integer.parseInt(request.getParameter("restep"));
			relevel=Integer.parseInt(request.getParameter("relevel"));
			//원글의 제목을 얻어보자
			subject=dao.getData(num).getSubject();
			
		} catch (NumberFormatException e) {
			// TODO: handle exception
			//새글일 경우는 익셉션이 발생하므로 0으로 초기화
			num=regroup=restep=relevel=0;
		}
		//request 에 저장
		request.setAttribute("num", num);
		request.setAttribute("regroup", regroup);
		request.setAttribute("restep", restep);
		request.setAttribute("relevel", relevel);
		request.setAttribute("subject", subject);
		
		RequestDispatcher rd=request.getRequestDispatcher("./writeform.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}