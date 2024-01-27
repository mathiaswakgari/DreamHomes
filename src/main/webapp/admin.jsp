<%@ page import="com.dreamhomes.dreamhomes.models.User" %><%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 1/27/2024
  Time: 12:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  User user = (User) request.getSession().getAttribute("user");

  String fullName = user.getUser_firstname() + " " + user.getUser_lastname();

  int usersCount = (int) request.getAttribute("usersCount");
  int homesCount = (int) request.getAttribute("homesCount");
%>
<html>
<head>
    <title>Dream Homes: Welcome Admin</title>
    <link rel="stylesheet" href="main.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">

</head>
<body class="h-screen overflow-x-hidden max-w-screen bg-white-200" style="font-family: 'Poppins', sans-serif;">
  <nav class="fixed z-30 top-0 bg-white w-full flex justify-between items-center h-16 px-6 border-b-2 border-gray-100">
  <div>
    <img width="150px" src="assets/images/dream-homes-logo-transparent.svg" alt="logo"/>
  </div>
  <div class="flex gap-2">

    <%
      if (!user.getUser_isAdmin()){

    %>
    <a href="admin">
      <button class="text-white h-10 bg-orange-500 rounded-md w-24 hover:bg-orange-600 cursor:pointer duration-300" >
        Admin
      </button>
    </a>
    <%}%>
    <a href="me">
      <div class="flex items-center gap-4 cursor-pointer duration-300 hover:bg-gray-100 p-2 rounded-md">
        <i class="fa-regular fa-user"></i>
        <p><%=fullName%></p>
      </div>
    </a>
    <div class="flex gap-2 text-white">
      <button class="bg-orange-500 rounded-md w-24 hover:bg-orange-600 cursor:pointer duration-300" >
        <a href="logout">Logout <i class="fa-solid fa-arrow-right-from-bracket"></i></a>
      </button>
    </div>
  </div>

</nav>

  <div class="flex mt-16 p-5 gap-5 justify-center">
      <div class="rounded-md p-5 flex flex-col justify-between text-white w-[950px] xl:max-w-[500px] h-[250px] bg-blue-500">
          <p class="text-3xl">Users</p>
          <a class="self-center" href="">
              <button class="text-blue-400 h-10 bg-white rounded-xl hover:scale-105 w-36 hover:bg-gray-100 cursor:pointer duration-300" >
                  Insert house<i class="pl-2 fa fa-add"></i>
              </button>
          </a>
          <a class="self-center" href="users">
              <button class="text-blue-400 h-10 bg-white rounded-xl hover:scale-105 w-36 hover:bg-gray-100 cursor:pointer duration-300" >
                  Users<i class="pl-2 fa fa-list"></i>
              </button>
          </a>
          <div class="flex justify-between items-center">
              <i class="fa fa-user text-2xl"></i>
              <p class="text-4xl font-bold"><%=usersCount%></p>
          </div>
      </div>
      <div class="rounded-md p-5 flex flex-col justify-between text-white w-[950px] xl:max-w-[500px] h-[250px] bg-red-500">
          <p class="text-3xl">Houses</p>
          <a class="self-center" href="addHome.jsp">
              <button class="text-red-400 h-10 bg-white rounded-xl hover:scale-105 w-36 hover:bg-gray-100 cursor:pointer duration-300" >
                    Insert house<i class="pl-2 fa fa-add"></i>
              </button>
          </a>
          <a class="self-center" href="homes">
              <button class="text-red-400 h-10 bg-white rounded-xl hover:scale-105 w-36 hover:bg-gray-100 cursor:pointer duration-300" >
                  Houses<i class="pl-2 fa fa-list"></i>
              </button>
          </a>
          <div class="flex justify-between items-center">
              <i class="fa fa-house text-2xl"></i>
              <p class="text-4xl font-bold"><%=homesCount%></p>
          </div>
      </div>
  </div>
</body>
</html>
