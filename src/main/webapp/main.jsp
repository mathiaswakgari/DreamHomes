<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page import="com.dreamhomes.dreamhomes.models.User" %>
<%@ page import="com.dreamhomes.dreamhomes.models.Home" %>
<%@ page import="com.dreamhomes.dreamhomes.models.Address" %><%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 12/25/2023
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user = (User) request.getSession().getAttribute("user");

    String fullName = user.getUser_firstname() + " " + user.getUser_lastname();

    ArrayList<Home> allHomes= new ArrayList<Home>();
    if(request.getSession().getAttribute("allHomes") != null){
        allHomes= (ArrayList<Home>) request.getSession(false).getAttribute("allHomes");
    }

    ArrayList<Home> sellHomes = new ArrayList<Home>();
    if(request.getSession().getAttribute("sellHomes") != null){
        sellHomes = (ArrayList) request.getSession().getAttribute("sellHomes");
    }

    ArrayList<Home> rentHomes = new ArrayList<Home>();
    if(request.getSession().getAttribute("rentHomes") != null){
        rentHomes = (ArrayList) request.getSession().getAttribute("rentHomes");
    }
%>
<html>
<head>
    <title>Dream Homes : Discover your perfect home.</title>
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
                if (user.getUser_isAdmin()){

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
    <div class="h-1/2 w-full upper mt-16 flex flex-col items-center justify-between">

        <div class="h-full w-full shadow-xl p-3 " style="background-color: rgba(0,0,0,0.5)">
            <div class="h-full flex flex-col items-center justify-center">
                <p class="text-white font-bold text-4xl">Find a home in a neighborhood you love.</p>
<%--                Search--%>
                <div class=" mt-2 w-full flex flex-col items-center">
                    <form method="get" action="search" class="flex md:min-w-[500px] xl:min-w-[1000px]">
                        <select name="category" id="category" class="bg-gray-200 opacity-90 border border-gray-300 text-gray-900 text-sm max-w-md rounded-l-md p-2.5">
                            <option value="" selected>Select category</option>
                            <option value="sell">For sale</option>
                            <option value="rent">For rent</option>
                        </select>
                        <div class="w-full">
                            <div class="relative w-full">
                                <div class="flex absolute inset-y-0 left-0 items-center pl-3 pointer-events-none">
                                    <svg class="w-5 h-5 text-gray-100" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path></svg>
                                </div>
                                <input name="place" type="search" id="default-search" class="opacity-90 rounded-r-md block p-4 pl-10 w-full text-sm text-gray-900 bg-gray-200 border border-gray-300 placeholder:text-gray-800" placeholder="Search place" required>
                                <button type="submit" class="text-white absolute right-2.5 bottom-2.5 bg-orange-600 hover:bg-orange-700 focus:ring-4 focus:outline-none font-medium rounded-md text-sm px-4 py-2">Search</button>
                            </div>
                        </div>
                    </form>

                </div>
<%--                Search--%>
            </div>
        </div>
    </div>
    <div class="w-full grid grid-cols-1 lg:grid-cols-2 px-10 items-center ">
        <div class="max-w-[48rem] my-9 items-center">
            <p class="font-bold text-4xl">Trusted by so many</p>
            <p class="text-lg">Only Dream Homes puts you in touch with the individual who knows the most about a property for sale or rent.</p>
        </div>
        <div class="lg:grid grid-cols-2">
            <div class="flex items-center justify-center m-5">
                <div class="relative flex w-full max-w-[38rem] flex-row shadow-md rounded-sm bg-gray-50 bg-clip-border text-gray-700">
                    <div class="relative m-0 w-2/5 shrink-0 overflow-hidden rounded-sm rounded-r-none bg-white bg-clip-border text-gray-700">
                        <img
                                src="https://images.unsplash.com/photo-1522202176988-66273c2fd55f?ixlib=rb-4.0.3&amp;ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&amp;auto=format&amp;fit=crop&amp;w=1471&amp;q=80"
                                alt="image"
                                class="h-full w-full object-cover"
                        />
                    </div>
                    <div class="px-6">
                        <h4 class="mb-2 block font-sans text-2xl font-semibold leading-snug tracking-normal text-blue-gray-900 antialiased">
                            Explore Great Neighborhoods
                        </h4>
                        <p class="mb-8 block font-sans text-base font-normal leading-relaxed text-gray-700 antialiased">
                            Explore video tours, in-depth research, and articles on 20,000 neighborhoods.
                        </p>
                    </div>
                </div>
            </div>
            <div class="flex items-center justify-center m-5">
                <div class="relative flex w-full shadow-md max-w-[38rem] flex-row rounded-sm bg-gray-50 bg-clip-border text-gray-700">
                    <div class="relative m-0 w-2/5 shrink-0 overflow-hidden rounded-sm rounded-r-none bg-white bg-clip-border text-gray-700">
                        <img
                                src="https://images.unsplash.com/photo-1522202176988-66273c2fd55f?ixlib=rb-4.0.3&amp;ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&amp;auto=format&amp;fit=crop&amp;w=1471&amp;q=80"
                                alt="image"

                                class="h-full w-full object-cover"
                        />
                    </div>
                    <div class="px-6">
                        <h4 class="mb-2 block font-sans text-2xl font-semibold leading-snug tracking-normal text-blue-gray-900 antialiased">
                            Find Highly Rated Homes
                        </h4>
                        <p class="mb-8 block font-sans text-base font-normal leading-relaxed text-gray-700 antialiased">
                            Find the very best homes with and ratings from multiple experts</p>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <%--Open houses--%>
    <div class="w-screen my-8 px-10">
        <div class="mb-5">
            <p class="font-semibold">Open Houses</p>
        </div>
        <div class="w-full grid grid-cols-2 lg:grid-cols-3 xl:grid-cols-4">
            <% for (Home home : allHomes) {
                Address address = home.getAddress();
            %>
            <%--House Card--%>
            <a href="home?home_id=<%=home.getHomeId()%>">
            <div class="mb-5 cursor-pointer hover:scale-105 duration-300 relative flex w-96 flex-col rounded-sm bg-white bg-clip-border text-gray-700 shadow-md">
                <div class="relative mx-4 mt-4 h-54 overflow-hidden rounded-sm bg-white bg-clip-border text-gray-700">
                    <img
                            src="<%=home.getMainPic()%>"
                            class="h-full w-full object-cover"
                    />
                </div>
                <div class="p-6">
                    <div class="mb-2 flex items-center justify-between ">
                        <div class="flex w-full">
                            <p class="mr-2 self-start text-base font-medium leading-relaxed text-blue-gray-900 antialiased">
                                ETB <%=NumberFormat.getNumberInstance(Locale.US).format(home.getHomePrice())%>
                            </p>
                            <p class="mr-2 block text-base font-medium leading-relaxed text-gray-400 antialiased"><%=home.getBedNumber()%>
                                Beds</p>
                            <p class="block text-base font-medium leading-relaxed text-gray-400 antialiased"><%=home.getBathNumber()%>
                                Baths</p>
                        </div>
                        <div>
                            <button
                                    class=" select-none rounded-lg bg-blue-gray-900/10 text-center font-sans text-xs font-bold uppercase text-blue-gray-900 transition-all hover:scale-105 focus:scale-105 focus:opacity-[0.85] active:scale-100 active:opacity-[0.85] disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
                                    type="button"
                            >
                                <i class="fa-regular fa-heart text-2xl"></i>
                            </button>
                        </div>
                    </div>
                    <p class=" text-sm font-normal leading-normal text-gray-700 antialiased opacity-75">
                        <%=address.getAddress1()%>
                    </p>
                    <p class=" text-sm font-normal leading-normal text-gray-700 antialiased opacity-75">
                        <%=address.getCity() + ", " + address.getState() + " " + address.getPostalCode()%>
                    </p>
                </div>
            </div>
            </a>
            <%}%>
            <%--House Card--%>
        </div>
    </div>
    <%--Open houses--%>
    <%--For Sell--%>
    <div class="w-screen my-8 px-10">
        <div class="mb-5">
            <p class="font-semibold">For sale</p>
        </div>
        <div class="w-full grid grid-cols-2 lg:grid-cols-3 xl:grid-cols-4">
            <% for (Home home : sellHomes) {
                Address address = home.getAddress();
            %>
            <%--House Card--%>
            <a href="home?home_id=<%=home.getHomeId()%>">
            <div class="mb-5 cursor-pointer hover:scale-105 duration-300 relative flex w-96 flex-col rounded-sm bg-white bg-clip-border text-gray-700 shadow-md">
                <div class="relative mx-4 mt-4 h-54 overflow-hidden rounded-sm bg-white bg-clip-border text-gray-700">
                    <img
                            src="<%=home.getMainPic()%>"
                            class="h-full w-full object-cover"
                    />
                </div>
                <div class="p-6">
                    <div class="mb-2 flex items-center justify-between ">
                        <div class="flex w-full">
                            <p class="mr-2 self-start text-base font-medium leading-relaxed text-blue-gray-900 antialiased">
                                ETB <%=NumberFormat.getNumberInstance(Locale.US).format(home.getHomePrice())%>
                            </p>
                            <p class="mr-2 block text-base font-medium leading-relaxed text-gray-400 antialiased"><%=home.getBedNumber()%>
                                Beds</p>
                            <p class="block text-base font-medium leading-relaxed text-gray-400 antialiased"><%=home.getBathNumber()%>
                                Baths</p>
                        </div>
                        <div>
                            <button
                                    class=" select-none rounded-lg bg-blue-gray-900/10 text-center font-sans text-xs font-bold uppercase text-blue-gray-900 transition-all hover:scale-105 focus:scale-105 focus:opacity-[0.85] active:scale-100 active:opacity-[0.85] disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
                                    type="button"
                            >
                                <i class="fa-regular fa-heart text-2xl"></i>
                            </button>
                        </div>
                    </div>
                    <p class=" text-sm font-normal leading-normal text-gray-700 antialiased opacity-75">
                        <%=address.getAddress1()%>
                    </p>
                    <p class=" text-sm font-normal leading-normal text-gray-700 antialiased opacity-75">
                        <%=address.getCity() + ", " +address.getState() + " " + address.getPostalCode()%>
                    </p>
                </div>
            </div>
            </a>
            <%}%>
            <%--House Card--%>
        </div>
    </div>
    <%--For Sale--%>
    <%--For Rent--%>
    <div class="w-screen my-8 px-10">
        <div class="mb-5">
            <p class="font-semibold">For Rent</p>
        </div>
        <div class="w-full grid grid-cols-2 lg:grid-cols-3 xl:grid-cols-4">
            <% for (Home home: rentHomes) {
                Address address = home.getAddress();
            %>
            <%--House Card--%>
            <a href="home?home_id=<%=home.getHomeId()%>">
            <div class="mb-5 cursor-pointer hover:scale-105 duration-300 relative flex w-96 flex-col rounded-sm bg-white bg-clip-border text-gray-700 shadow-md">
                <div class="relative mx-4 mt-4 h-54 overflow-hidden rounded-sm bg-white bg-clip-border text-gray-700">
                    <img
                            src="<%=home.getMainPic()%>"
                            class="h-full w-full object-cover"
                    />
                </div>
                <div class="p-6">
                    <div class="mb-2 flex items-center justify-between ">
                        <div class="flex w-full">
                            <p class="mr-2 self-start text-base font-medium leading-relaxed text-blue-gray-900 antialiased">
                                ETB <%=NumberFormat.getNumberInstance(Locale.US).format(home.getHomePrice())%>
                            </p>
                            <p class="mr-2 block text-base font-medium leading-relaxed text-gray-400 antialiased"><%=home.getBedNumber()%>
                                Beds</p>
                            <p class="block text-base font-medium leading-relaxed text-gray-400 antialiased"><%=home.getBathNumber()%>
                                Baths</p>
                        </div>
                        <div>
                            <button
                                    class=" select-none rounded-lg bg-blue-gray-900/10 text-center font-sans text-xs font-bold uppercase text-blue-gray-900 transition-all hover:scale-105 focus:scale-105 focus:opacity-[0.85] active:scale-100 active:opacity-[0.85] disabled:pointer-events-none disabled:opacity-50 disabled:shadow-none"
                                    type="button"
                            >
                                <i class="fa-regular fa-heart text-2xl"></i>
                            </button>
                        </div>
                    </div>
                    <p class=" text-sm font-normal leading-normal text-gray-700 antialiased opacity-75">
                        <%=address.getAddress1()%>
                    </p>
                    <p class=" text-sm font-normal leading-normal text-gray-700 antialiased opacity-75">
                        <%=address.getCity() + ", " + address.getState() + " " + address.getPostalCode()%>
                    </p>
                </div>
            </div>
            </a>
            <%}%>
            <%--House Card--%>
        </div>
    </div>
    <%--For Rent--%>

</body>
</html>
