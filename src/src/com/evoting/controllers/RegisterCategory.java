package com.evoting.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.evoting.model.Category;
import com.evoting.model.Election;
import com.evoting.service.CategoryService;

/**
 * Servlet implementation class RegisterPost
 */
@WebServlet("/RegisterCategory")
public class RegisterCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    CategoryService cs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view=request.getRequestDispatcher("WEB-INF/views/RegisterPosts.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String post= request.getParameter("post");
		
		Category c= new Category();
		c.setName(post);
		Integer electionId=(Integer)request.getSession().getAttribute("elections_id");
		//String election=(String)request.getAttribute("elections_id");
		//Integer electionId=Integer.parseInt(election);
		
		cs.addCategory(c, electionId);
		
		
		
		
		
		System.out.println(c);
	}

}
