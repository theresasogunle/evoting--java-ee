package com.evoting.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.evoting.model.Candidate;
import com.evoting.model.Category;
import com.evoting.model.Election;

import com.evoting.model.Voter;
import com.evoting.service.CandidateService;
import com.evoting.service.CategoryService;
import com.evoting.service.ElectionService;

import com.evoting.service.VoterService;

/**
 * Servlet implementation class RegisterCandidates
 */
@WebServlet("/RegisterCandidates")
public class RegisterCandidates extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	ElectionService es;
	@EJB
	CandidateService cs;
	@EJB
	CategoryService cts;
	@EJB
	VoterService vs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCandidates() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//Elections e=new Elections();
		//String nameOfElection=	e.getNameOfElection();
		//request.setAttribute("elections_name", nameOfElection);
	
        List<Candidate> cList = (List<Candidate>) cs.getCandidates();
		request.setAttribute("candidates_list",cList);
		
		List<Election> eList=(List<Election>) es.getAllElections();
		request.setAttribute("elections_list", eList);
		
		List<Category> catList=(List<Category>) cts.getAllCategory();
		request.setAttribute("category_list", catList);
		
		List<Voter> vList=vs.getAllVoters();
		request.setAttribute("voters_list", vList);
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher view=request.getRequestDispatcher("WEB-INF/views/RegisterCandidates.jsp");
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
		
		
	}

		
	

}
