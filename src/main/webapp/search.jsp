<%@ page import="com.dreamhomes.dreamhomes.models.User" %>
<%@ page import="com.dreamhomes.dreamhomes.models.Home" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dreamhomes.dreamhomes.models.Address" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 1/4/2024
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) request.getSession().getAttribute("user");
    String query = (String) request.getSession().getAttribute("query");
    String category = (String) request.getSession().getAttribute("category");
    if (category.isEmpty()) category="All";

    String fullName = user.getUser_firstname() + " " + user.getUser_lastname();

    ArrayList<Home> homes= new ArrayList<>();
    if(request.getSession().getAttribute("homes") != null){
        homes= (ArrayList<Home>) request.getSession(false).getAttribute("homes");
    }


%>
<html>
<head>
    <title>Dream homes: Result - <%=query%></title>
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
            <img width="150px" src="assets/images/dream-homes-high-resolution-logo-black-transparent.svg" alt="logo"/>
        </div>
        <div class="flex gap-2">
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
    <div class="h-full w-full mt-16 px-5 flex flex-col">
        <div class="my-2">
            <p class="text-xl font-light">Search Result: <span class="font-semibold"><%=query%></span> for <%=category%></p>
        </div>
        <div class="w-full  flex flex-col justify-center items-center divide-y ">
            <%if(homes.isEmpty()){%>
            <div class="w-full h-[90vh] flex flex-col justify-center items-center">
                <p>No results found.</p>
                <a href="main">
                    <button class="bg-orange-500 rounded-full text-white w-24 h-10 hover:bg-orange-600 cursor:pointer duration-300">Go back.</button>
                </a>
            </div><%}else{%>
            <% for (Home home : homes) {
                Address address = home.getAddress();
            %>
            <%--House Card--%>
            <a class="py-[3rem] " href="home?home_id=<%=home.getHomeId()%>">
                <div class=" md:max-w-2xl xl:max-w-4xl  cursor-pointer relative flex rounded-l-md text-gray-700 bg-gray-50 border-b-2 ">
                    <div class=" relative h-54 overflow-hidden rounded-l-sm bg-white bg-clip-border text-gray-700">
                        <img
                                src="<%=home.getMainPic()%>"
                                class="h-full w-full object-cover"
                         alt="Home with id:<%=home.getHomeId()%>"/>
                    </div>
                    <div class="p-6 w-full flex flex-col justify-around items-center">
                        <div class="mb-2 w-full">
                            <div class="flex w-full justify-evenly">
<%--                                <p class="mr-2 self-start text-base font-medium leading-relaxed text-blue-gray-900 antialiased">--%>
<%--                                    ETB <%=NumberFormat.getNumberInstance(Locale.US).format(home.getHomePrice())%>--%>
<%--                                </p>--%>
<%--                                <p class="mr-2 block text-base font-medium leading-relaxed text-gray-400 antialiased"><%=home.getBedNumber()%>--%>
<%--                                    Beds</p>--%>
<%--                                <p class="block text-base font-medium leading-relaxed text-gray-400 antialiased"><%=home.getBathNumber()%>--%>
<%--                                    Baths</p>--%>
                                <p class="text-sm line-clamp-4"><%=home.getHomeAbout()%></p>
                            </div>
                        </div>
                        <div class="flex flex-col justify-center items-center">
                            <p class=" text-sm font-normal leading-normal text-gray-700 antialiased opacity-75">
                                <%=address.getAddress1()%>
                            </p>
                            <p class=" text-sm font-normal leading-normal text-gray-700 antialiased opacity-75">
                                <%=address.getCity() + ", " + address.getState() + " " + address.getPostalCode()%>
                            </p>
                        </div>
                    </div>
                </div>
            </a><%}%>
            <%}%>
            <%--House Card--%>
        </div>

    </div>
</body>
</html>
