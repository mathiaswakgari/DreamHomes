<%@ page import="com.dreamhomes.dreamhomes.models.User" %><%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 1/19/2024
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%--%>
<%--    User user = (User) request.getSession().getAttribute("user");--%>
<%--    String fullName = user.getUser_firstname() + " " + user.getUser_lastname();--%>
<%--%>--%>
<html>
<head>
    <title>Dream Homes : Error</title>
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
<%--<nav class="fixed z-30 top-0 bg-white w-full flex justify-between items-center h-16 px-6 border-b-2 border-gray-100">--%>
<%--    <div>--%>
<%--        <img width="150px" src="assets/images/dream-homes-logo-transparent.svg" alt="logo"/>--%>
<%--    </div>--%>
<%--    <div class="flex gap-2">--%>
<%--        <a href="me">--%>
<%--            <div class="flex items-center gap-4 cursor-pointer duration-300 hover:bg-gray-100 p-2 rounded-md">--%>
<%--                <i class="fa-regular fa-user"></i>--%>
<%--                <p><%="fullName"%></p>--%>
<%--            </div>--%>
<%--        </a>--%>
<%--        <div class="flex gap-2 text-white">--%>
<%--            <button class="bg-orange-500 rounded-md w-24 hover:bg-orange-600 cursor:pointer duration-300" >--%>
<%--                <a href="logout">Logout <i class="fa-solid fa-arrow-right-from-bracket"></i></a>--%>
<%--            </button>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>
<div class="w-full h-full mt-16 flex flex-col justify-center items-center">
    <p class="text-orange-500 text-4xl">Ooops...</p>
    <p>Some error occurred. Go back to <a href="main"><span class="text-blue-600">Home</span></a> </p>
</div>
</body>
</html>
