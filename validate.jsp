<body>
   <%
    String loginName=request.getParameter("loginName");
    String loginPass=request.getParameter("loginPass");

    User user=new User();
    user.setUsername(loginName);
    user.setPassword(loginPass);

    LoginDao loginDao=new LoginDaoImpl();
    int flag=loginDao.login(user);
    if(flag==2){
        session.setAttribute("loginName", loginName);
        response.sendRedirect(request.getContextPath()+"/index.html");
    }else {
        if(flag==1){
            request.setAttribute("loginPassError", "loginPass is error");
        }else if(flag==0){
            request.setAttribute("loginNameError", "loginName is error");
        }
        request.getRequestDispatcher("/login.html").forward(request, response);
    }
    %>
  </body>
