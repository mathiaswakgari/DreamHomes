<%@ page import="java.util.Objects" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
//  if (!((String)(request.getSession().getAttribute("user_id"))).isEmpty()){
//      response.sendRedirect("main");
//  }
%>
<!DOCTYPE html>
<html>
<head>
  <title>Dream Homes : Find your next home</title>
  <script src="https://cdn.tailwindcss.com"></script>
  <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css'></link>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.all.min.js"></script>
</head>
<body class="h-screen w-screen" style="font-family: 'Poppins', sans-serif;">
  <input type="hidden" id="status" value="<%=request.getSession().getAttribute("status")%>"/>
  <div class="h-full w-full flex justify-center items-center" style="
        background-image: url('assets/images/background.png');
        height: 100vh;
        background-position: center;
        background-repeat: no-repeat;
        background-size: cover;">
    <div class="h-[650px] w-[450px] bg-white opacity-90 flex flex-col justify-center items-center rounded-lg shadow-lg z-50">
      <div class="w-full h-72 flex items-center justify-center items-center rounded-t-lg my-4">
        <img class="w-72 h-20" src="assets/images/dream-homes-logo-transparent.svg" alt="logo">
      </div>
      <form method="post" action="login" class="flex flex-col items-center mt-1  h-full w-full rounded-b-lg">
          <div class="w-3/4">
            <label for="email" class="block text-sm font-medium leading-6 text-gray-900">Email</label>
            <div class="mt-2">
              <div class="rounded-full flex shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                <input required type="email"  name="email" id="email" autocomplete="email" class="rounded-full h-12 block flex-1 border-0 bg-transparent py-1.5 pl-4 text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm sm:leading-6" placeholder="dream@homes.com">
              </div>
            </div>
          </div>
        <div class="my-5 mx-5 w-3/4">
          <label for="password" class="block text-sm font-medium leading-6 text-gray-900">Password</label>
          <div class="mt-2">
            <div class="flex rounded-full shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
              <input required type="password" name="password" id="password" autocomplete="password" class="rounded-full h-12 block flex-1 border-0 bg-transparent py-1.5 pl-4 text-gray-900 focus:outline-none sm:text-sm sm:leading-6" >
            </div>
          </div>
        </div>
        <div class="w-3/4 flex items-center justify-center mt-4">
          <button class="w-full bg-orange-500 rounded-full shadow-sm h-10 text-slate-50 hover:bg-orange-600"  type="submit">Login</button>
        </div>
        <div class="mt-3">
          <p class="text-sm">Don't have an account? Register <span class="text-blue-500"><a href="register.jsp">here.</a></span></p>
        </div>
      </form>
    </div>
  </div>
  <script>
    const status = document.getElementById("status");
    if(status.value == 401){
      throw swal.fire({
        title: "Login Failed",
        text: "Try again with correct email and password",
        icon: 'error',
        confirmButton: "OK",
        customClass:{
          fontsize:"1px"
        }
      }).then(()=>{
        <% request.getSession().setAttribute("status", 0);%>
      })
    }
  </script>
</body>
</html>