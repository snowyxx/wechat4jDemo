package com.sample.wechat;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sword.wechat4j.message.CustomerMsg;
import org.sword.wechat4j.user.UserManager;

public class PassMesg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassMesg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String product = request.getParameter("product");
		String message = request.getParameter("message");
//		System.out.println(message);
		UserManager userManager = new UserManager();
		List<Object> userList = userManager.subscriberList();
		if(userList.size() > 0){
			for (int i=0;i<userList.size();i++){
				String toUserOpenId = userList.get(i).toString();
				System.out.println(toUserOpenId);
				String content = product +": " + message;
				CustomerMsg customerMsg = new CustomerMsg(toUserOpenId);
				customerMsg.sendText(content);
			}
			
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
