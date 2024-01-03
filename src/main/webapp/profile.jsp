<%@ page import="com.dreamhomes.dreamhomes.models.User" %>
<%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 12/30/2023
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    User user = (User) request.getSession().getAttribute("user");
    String fullname = user.getUser_firstname() + " " + user.getUser_lastname();
    System.out.println(user.getUser_profile_picture());
%>
<html>
<head>
    <title>Dream Homes: <%=fullname%></title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">

    <!-- JavaScript -->
    <script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>

    <!-- CSS -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css"/>
    <!-- Default theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css"/>
    <!-- Semantic UI theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/semantic.min.css"/>
    <!-- Bootstrap theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/bootstrap.min.css"/>
</head>
<input type="hidden" id="status" value="<%=request.getSession().getAttribute("isUpdated")%>"/>
<body class="h-screen overflow-x-hidden max-w-screen bg-white-200" style="font-family: 'Poppins', sans-serif;">
    <nav class="fixed z-30 top-0 bg-white w-full flex justify-between items-center h-16 px-6 border-b-2 border-gray-100">
        <div>
            <img width="150px" src="assets/images/dream-homes-high-resolution-logo-black-transparent.svg" alt="logo"/>
        </div>
        <div class="flex gap-2">
            <div class="flex items-center gap-4 cursor-pointer duration-300 hover:bg-gray-100 p-2 rounded-md">
                <i class="fa-regular fa-user"></i>
                <p><%=fullname%></p>
            </div>
            <div class="flex gap-2 text-white">
                <button class="bg-orange-500 rounded-md w-24 hover:bg-orange-600 cursor:pointer duration-300" >
                    <a href="logout">Logout <i class="fa-solid fa-arrow-right-from-bracket"></i></a>
                </button>
            </div>
        </div>
    </nav>
    <div class="w-full pt-16 h-full grid grid-cols-[350px_auto] xl:grid-cols-[450px_auto]">
        <div class=" flex flex-col items-center gap-6 pt-20 border-r-2">
            <p class="text-3xl font-semibold">Account Settings</p>
            <div>
                <img class="rounded-full h-[100px] w-[100px] object-cover" src="<%=user.getUser_profile_picture()%>"  alt="profile picture"/>
                <label for="file">
                    <i class="relative top-[-20px] left-[72px] fa-solid fa-circle-plus text-2xl"></i>
                </label>
            </div>
            <p class="font-semibold text-xl"><%=fullname%></p>
            <p class="font-light text-xl"><%=user.getUser_email()%></p>
        </div>
        <form method="post" action="update_profile" enctype="multipart/form-data">
            <div class="pt-20 px-4 w-full flex-col justify-center items-center">
                <p class="text-2xl font-semibold"><%=fullname%>'s Profile</p>
                <div class="w-full mt-8 flex items-center">
                    <div class="w-full mr-2">
                        <label for="firstname" class="block text-sm font-semibold leading-6 text-gray-900">First Name</label>
                        <div class="mt-2">
                            <div class="flex rounded-md shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-2xl">
                                <input value=<%=user.getUser_firstname()%> required type="text"  name="firstname" id="firstname" autocomplete="firstname" class="h-12 block flex-1 border-0 bg-transparent py-1.5 pl-1 text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm sm:leading-6">
                            </div>
                        </div>
                    </div>
                    <div class="w-full">
                        <label for="lastname" class="block text-sm font-semibold leading-6 text-gray-900">Last Name</label>
                        <div class="mt-2">
                            <div class="h-12 flex rounded-md shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-2xl">
                                <input value=<%=user.getUser_lastname()%> required type="text"  name="lastname" id="lastname" autocomplete="lastname" class="block flex-1 border-0 bg-transparent py-1.5 pl-1 text-gray-900 focus:outline-none sm:text-sm sm:leading-6">
                            </div>
                        </div>
                    </div>
                </div>
                <input id="file" name="file" class="hidden" type="file">
                <div class="w-full mt-8 flex items-center">
                    <div class="w-full mr-2">
                        <label for="email" class="block text-sm font-semibold leading-6 text-gray-900">Email</label>
                        <div class="mt-2">
                            <div class="flex rounded-md shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-2xl">
                                <input readonly value=<%=user.getUser_email()%> required type="email"  name="email" id="email" autocomplete="email" class="rounded-md text-gray-200 h-12 block flex-1 border-0 bg-transparent py-1.5 pl-1 text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm sm:leading-6">
                            </div>
                        </div>
                    </div>
                    <div class="w-full">
                        <label for="password" class="block text-sm font-semibold leading-6 text-gray-900">Password</label>
                        <div class="mt-2">
                            <div class="h-12 flex rounded-md shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-2xl">
                                <input value=<%=user.getUser_password()%> required type="password"  name="password" id="password" autocomplete="password" class="block flex-1 border-0 bg-transparent py-1.5 pl-1 text-gray-900 focus:outline-none sm:text-sm sm:leading-6">
                            </div>
                        </div>
                    </div>
                </div>
                <button type="submit" class=" mt-8 bg-white h-10 text-orange-500 border-2 border-orange-500 hover:bg-orange-500 hover:text-white rounded-md w-24 cursor:pointer duration-300">Save</button>
            </div>
        </form>
    </div>
</body>
<script>
    const isUpdated = document.getElementById("status").value;
    if (isUpdated == "true"){
        alertify.success("Profile updated successfully");
    }else if (isUpdated == "false"){
        alertify.error("Some error occurred")
    }
    <%request.getSession().removeAttribute("isUpdated");%>
</script>
</html>
