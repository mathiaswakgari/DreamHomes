<%@ page import="com.dreamhomes.dreamhomes.models.Home" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% ArrayList<Home> homes = (ArrayList<Home>) request.getAttribute("homes");%>
<html>
<head>
    <title>Dream Homes : Homes</title>
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
<input type="hidden" id="status" value="<%=request.getSession().getAttribute("isDeleted")%>"/>
<body class=" max-w-screen min-h-screen flex flex-col justify-center" style="font-family: 'Poppins', sans-serif;">
<%-- NavBar--%>
<nav class=" fixed top-0 bg-white w-full flex justify-between items-center h-16 px-6 border-b-2 border-gray-100">
    <div>
        <img width="150px" src="assets/images/dream-homes-logo-transparent.svg" alt="logo"/>
    </div>
    <div class="flex gap-2">
        <div class="flex items-center gap-4 cursor-pointer duration-300 hover:bg-gray-100 p-2 rounded-md">
            <i class="fa-regular fa-user"></i>
            <p><%="fullname"%></p>
        </div>
        <div class="flex gap-2 text-white">
            <button class="bg-orange-500 rounded-md w-24 hover:bg-orange-600 cursor:pointer duration-300" >
                <a href="logout">Logout <i class="fa-solid fa-arrow-right-from-bracket"></i></a>
            </button>
        </div>
    </div>
</nav>
<div class="p-12 pt-24 flex flex-col items-center h-full w-full">
    <div class="flex flex-wrap -mx-3 mb-5">
        <div class="w-full max-w-full px-3 mb-6  mx-auto">
            <div class="relative flex-[1_auto] flex flex-col break-words min-w-0 bg-clip-border rounded-[.95rem] bg-white m-5">
                <div class="relative flex flex-col min-w-0 break-words border border-dashed bg-clip-border rounded-2xl border-stone-200 bg-light/30">
                    <!-- card header -->
                    <div class="px-9 pt-5 flex justify-between items-stretch flex-wrap min-h-[70px] pb-0 bg-transparent">
                        <h3 class="flex flex-col items-start justify-center m-2 ml-0 font-medium text-xl/tight text-dark">
                            <span class="mr-3 font-semibold text-dark">Admin Panel</span>
                            <span class="mt-1 font-medium text-secondary-dark text-lg/normal">All houses from the database</span>
                        </h3>

                    </div>
                    <!-- end card header -->
                    <!-- card body  -->
                    <div class="flex-auto block py-8 pt-6 px-9">
                        <div class="overflow-x-auto">
                            <table class="w-full my-0 align-middle text-dark border-neutral-200">
                                <thead class="align-bottom">
                                <tr class="font-semibold text-[0.95rem] text-secondary-dark">
                                    <th class="pb-3 text-start min-w-[200px]">PHOTO</th>
                                    <th class="pb-3 text-end min-w-[10px]">ID</th>
                                    <th class="pb-3 text-end min-w-[150px]">ADDRESS 1</th>
                                    <th class="pb-3 pr-12 text-end min-w-[100px]"></th>

                                </tr>
                                </thead>
                                <tbody>
                                <%
                                    for (Home home: homes
                                    ) {

                                %>
                                <tr class="border-b border-dashed last:border-b-0">
                                    <td class="p-3 pl-0">
                                        <div class="flex items-center">
                                            <div class="relative inline-block shrink-0 rounded-2xl me-3">
                                                <img src="<%=home.getMainPic()%>" class="w-[200px] h-[150px] inline-block shrink-0 rounded-sm " alt="">
                                            </div>
                                        </div>
                                    </td>
                                    <td class="p-3 pr-0 text-end">
                                        <span class="font-semibold text-light-inverse text-md/normal"><%=home.getHomeId()%></span>
                                    </td>
                                    <td class="p-3 pr-0 text-end">
                    <span class="text-center align-baseline inline-flex px-2 py-1 mr-auto items-center font-semibold text-base/none text-success text-gray-500 bg-success-light rounded-lg">
                       <%=home.getAddress().getAddress1()%> </span>
                                    </td>
                                    <td class="p-3 pr-0 text-end">
                                        <a href="delete_home?home_id=<%=home.getHomeId()%>">
                                            <button class="focus:outline-none text-white bg-red-700 hover:bg-red-800 focus:ring-4 focus:ring-red-300 font-medium rounded-lg text-xs px-5 py-2.5 me-2 mb-2 dark:bg-red-600 dark:hover:bg-red-700 dark:focus:ring-red-900">
                                                DELETE
                                            </button></a>
                                    </td>
                                </tr>
                                <%}%>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    const isDeleted= document.getElementById("status").value;
    if (isDeleted == "true"){
        alertify.success("User deleted successfully");
    }else if (isDeleted == "false"){
        alertify.error("Some error occurred.")
    }
    <%request.getSession().removeAttribute("isDeleted");%>
</script>
</html>
