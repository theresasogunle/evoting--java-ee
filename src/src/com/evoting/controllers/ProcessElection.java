package com.evoting.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.evoting.model.Election;
import com.evoting.service.ElectionService;

/**
 * Servlet implementation class ProcessElection
 */
@WebServlet("/ProcessElection")
public class ProcessElection extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    ElectionService es;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessElection() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	//	RequestDispatcher view=request.getRequestDispatcher("WEB-INF/views/ProcessElection.jsp");
	//	view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String nameOfElection=request.getParameter("nameOfElection");
		String email=request.getParameter("Email");
		String numberOfCandidates= request.getParameter("numberOfCandidates");
		String raw_duration = request.getParameter("duration");
		
		Election e=new Election();
		
		Integer year = Integer.parseInt(request.getParameter("year"));
		Integer month = Integer.parseInt(request.getParameter("month"));
		Integer day = Integer.parseInt(request.getParameter("day"));
		
	
		
		Calendar cal = Calendar.getInstance();
		
	cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH,month);
	cal.set(Calendar.DAY_OF_MONTH, day);
		
	Date duration = cal.getTime();
		
	e.setNameOfElection(nameOfElection);
	e.setEmail(email);
	e.setDuration(duration);
	e.setNumberOfCandidates(Integer.parseInt(numberOfCandidates));
	
		
		es.addElection(e);
		System.out.println(e);
		
		Integer id=e.getId();
	//System.out.println(id);
	request.setAttribute("elections_id",id);
	
	HttpSession session = request.getSession(true);       
    session.setAttribute("elections_id",id); 
    
	response.sendRedirect("RegisterCategory");
	}

}
