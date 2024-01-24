<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="com.dreamhomes.dreamhomes.models.Home" %>
<%@ page import="com.dreamhomes.dreamhomes.models.Address" %>
<%@ page import="com.dreamhomes.dreamhomes.models.User" %><%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 12/28/2023
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) request.getSession().getAttribute("user");
    String fullname = user.getUser_firstname() + " " + user.getUser_lastname();
    Home home = (Home) request.getSession().getAttribute("home");
    Address address = home.getAddress();
%>
<html>
<head>
    <title>Dream Homes : <%=address.getAddress1()%></title>
    <script src="https://cdn.tailwindcss.com"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700&display=swap" rel="stylesheet">

</head>
<body class=" max-w-screen min-h-screen flex flex-col justify-center" style="font-family: 'Poppins', sans-serif;">
<%-- NavBar--%>
    <nav class="fixed top-0 bg-white w-full flex justify-between items-center h-16 px-6 border-b-2 border-gray-100">
        <div>
            <img width="150px" src="assets/images/dream-homes-logo-transparent.svg" alt="logo"/>
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
    <div class="w-full h-full p-16 pt-24">
<%--        Photo Grid--%>
        <div class="grid grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 justify-center  gap-2 w-full">
<%--            Main Pic--%>
<%--            Other Pics--%>
                <div class="rounded-sm shadow-md">
                    <img  class="rounded-sm object-fill" src="<%=home.getPic1()%>" alt="Home Pic 1"/>
                </div>
                <div class="rounded-sm shadow-md">
                    <img class="rounded-sm" src="<%=home.getPic2()%>" alt="Home Pic 2"/>
                </div>
                <div class="rounded-sm shadow-md">
                    <img class="rounded-sm" src="<%=home.getPic3()%>" alt="Home Pic 3"/>
                </div>
                <div class="rounded-sm shadow-md">
                    <img class="rounded-sm" src="<%=home.getPic4()%>" alt="Home Pic 4"/>
                </div>

<%--            Other Pics--%>
        </div>
<%--        Photo Grid--%>
        <div class="w-full py-20 flex justify-between px-6">
            <div class="flex flex-col">
                <p class="font-semibold text-lg xl:text-2xl mb-4">ETB <%=NumberFormat.getNumberInstance(Locale.US).format(home.getHomePrice())%></p>
                <div class="font-light xl:text-xl">
                    <p><%=address.getAddress1()%></p>
                    <p><%=address.getCity()%>, <%=address.getState()%> <%=address.getPostalCode()%></p>
                </div>
            </div>
<%--            icons--%>
            <div class="flex mx-6">
                <i class="mx-6 fa-regular fa-heart text-2xl"></i>
            </div>
        </div>
       <hr>
            <div class="grid grid-cols-3 divide-x-2 py-6">
                <div class="my-2 flex justify-center"><span class="font-semibold mr-2"><%=home.getBedNumber()%></span>Beds</div>
                <div class="my-2 flex justify-center"><span class="font-semibold mr-2"><%=home.getBathNumber()%> </span> Baths</div>
                <div class="my-2 flex justify-center"><span class="font-semibold mr-2"><%=home.getHomeArea()%> Sq meter</span></div>
            </div>
        <hr>
<%--        About--%>
        <div class="w-full my-6">
            <p class="font-semibold text-lg mb-2">About This Home</p>
            <p  class="font-light text-[1rem]] text-gray-500 "><%=home.getHomeAbout()%></p>
        </div>
<%--        Home Details--%>
        <div class=" w-full pb-36">
            <p class="font-semibold text-lg mb-4">Home Details</p>
            <div class="grid grid-cols-2 gap-6">
                <div class="flex">
                    <i class="fa-solid fa-house text-2xl"></i>
                    <div class="mx-2">
                        <p>Home Type</p>
                        <p class="text-md font-light text-[14px]"><%=home.getHomeType()%></p>
                    </div>
                </div>
                <div class="flex">
                    <i class="fa-solid fa-hammer text-2xl"></i>
                    <div class="mx-2">
                        <p>Year Built</p>
                        <p class=" font-light text-[14px]"><%=home.getYearBuilt()%></p>
                    </div>
                </div>
                <div class="flex">
                    <i class="fa-solid fa-bed text-2xl"></i>
                    <div class="mx-2">
                        <p>Bedrooms and Bathrooms</p>
                        <p class=" font-light text-[14px]"><%=home.getBedNumber()%> Bedrooms</p>
                        <p class=" font-light text-[14px]"><%=home.getBathNumber()%> Bathrooms</p>
                    </div>
                </div>
                <div class="flex">
                    <i class="fa-solid fa-lightbulb text-2xl"></i>
                    <div class="mx-2">
                        <p>Utilities</p>
                        <%
                            String utilities =(String) home.getHomeUtilities();
                            String[] utilitiesList = Pattern.compile("\n").splitAsStream(utilities).map(s -> s.split(",")).flatMap(Arrays::stream).toArray(String[]::new);
                        %>
                        <%
                            for (String s : utilitiesList) {
                        %><p class="font-light text-[14px]"><%
                            out.println(s);
                        }
                        ;%></p>


                    </div>
                </div>
            </div>
        </div>
<%--        Contact--%>
        <div class="fixed bottom-0 right-0 w-full shadow-lg px-6 flex bg-gray-100 justify-between h-24 items-center">
            <div>
                <p class="font-light">LISTING AGENT</p>
                <p class="font-semibold text-lg font-semibold"><%=home.getAgentName()%></p>
            </div>
            <div class="flex items-center gap-4">
                <p class=""><%=home.getAgentNumber()%></p>
                <button class="bg-orange-500 rounded-lg shadow-sm w-24 h-10 text-slate-50 hover:bg-orange-600">
                    Call
                </button>
            </div>

        </div>



    </div>
</body>
</html>
