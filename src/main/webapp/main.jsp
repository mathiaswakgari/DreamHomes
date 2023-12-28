<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.text.NumberFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Locale" %><%--
  Created by IntelliJ IDEA.
  User: mathi
  Date: 12/25/2023
  Time: 3:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList rows = new ArrayList();
    if(request.getSession().getAttribute("homesList") != null){
        rows = (ArrayList) request.getSession().getAttribute("homesList");
    }
    ArrayList rowsSale = new ArrayList();
    if(request.getSession().getAttribute("homesSale") != null){
        rowsSale = (ArrayList) request.getSession().getAttribute("homesSale");
    }
    ArrayList rowsRent = new ArrayList();
    if(request.getSession().getAttribute("homesRent") != null){
        rowsRent = (ArrayList) request.getSession().getAttribute("homesRent");
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
<body class="h-screen w-screen bg-gray-200" style="font-family: 'Poppins', sans-serif;">
    <div class="h-1/2 w-full upper flex flex-col items-center justify-between">
        <nav class=" w-full flex justify-between items-center h-20 px-3" style="background-color: rgba(0,0,0,0.5)">
            <div>
                <img width="150px" src="assets/images/dream-homes-high-resolution-logo-white-transparent%20(2).svg" alt="logo"/>
            </div>
            <div>
                <button class="bg-black  rounded-full w-24 h-10 text-white text-sm">Sign-in</button>
            </div>
        </nav>
        <div class="h-full w-full shadow-xl p-3 " style="background-color: rgba(0,0,0,0.5)">
            <div class="h-full flex items-center justify-center">
                <p class="text-white font-bold text-4xl">Find a home in a neighborhood you love.</p>
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
                <div class="relative flex w-full max-w-[38rem] flex-row rounded-md bg-gray-50 bg-clip-border text-gray-700">
                    <div class="relative m-0 w-2/5 shrink-0 overflow-hidden rounded-md rounded-r-none bg-white bg-clip-border text-gray-700">
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
                <div class="relative flex w-full max-w-[38rem] flex-row rounded-md bg-gray-50 bg-clip-border text-gray-700">
                    <div class="relative m-0 w-2/5 shrink-0 overflow-hidden rounded-md rounded-r-none bg-white bg-clip-border text-gray-700">
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
            <% for (int i = 0; i<rows.size(); i++) {
                ArrayList home = (ArrayList) rows.get(i);
            %>
            <%--House Card--%>
            <div class="mb-5 relative flex w-96 flex-col rounded-sm bg-white bg-clip-border text-gray-700 shadow-md">
                <div class="relative mx-4 mt-4 h-54 overflow-hidden rounded-sm bg-white bg-clip-border text-gray-700">
                    <img
                            src="<%=home.get(3)%>"
                            class="h-full w-full object-cover"
                    />
                </div>
                <div class="p-6">
                    <div class="mb-2 flex items-center justify-between ">
                        <div class="flex w-full">
                            <p class="mr-2 self-start text-base font-medium leading-relaxed text-blue-gray-900 antialiased">
                                ETB <%=NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(home.get(0).toString()))%>
                            </p>
                            <p class="mr-2 block text-base font-medium leading-relaxed text-gray-400 antialiased"><%=home.get(1)%>
                                Beds</p>
                            <p class="block text-base font-medium leading-relaxed text-gray-400 antialiased"><%=home.get(2)%>
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
                        <%=home.get(4)%>
                    </p>
                    <p class=" text-sm font-normal leading-normal text-gray-700 antialiased opacity-75">
                        <%=home.get(7) + ", " + home.get(5) + " " + home.get(6)%>
                    </p>
                </div>
            </div>
            <%}%>
            <%--House Card--%>
        </div>
    </div>
    <%--Open houses--%>
    <%--For Sale--%>
    <div class="w-screen my-8 px-10">
        <div class="mb-5">
            <p class="font-semibold">For Sale</p>
        </div>
        <div class="w-full grid grid-cols-2 lg:grid-cols-3 xl:grid-cols-4">
            <% for (int i = 0; i<rowsSale.size(); i++) {
                ArrayList homeSale = (ArrayList) rowsSale.get(i);
            %>
            <%--House Card--%>
            <div class="mb-5 relative flex w-96 flex-col rounded-sm bg-white bg-clip-border text-gray-700 shadow-md">
                <div class="relative mx-4 mt-4 h-54 overflow-hidden rounded-sm bg-white bg-clip-border text-gray-700">
                    <img
                            src="<%=homeSale.get(3)%>"
                            class="h-full w-full object-cover"
                    />
                </div>
                <div class="p-6">
                    <div class="mb-2 flex items-center justify-between ">
                        <div class="flex w-full">
                            <p class="mr-2 self-start text-base font-medium leading-relaxed text-blue-gray-900 antialiased">
                                ETB <%=NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(homeSale.get(0).toString()))%>
                            </p>
                            <p class="mr-2 block text-base font-medium leading-relaxed text-gray-400 antialiased"><%=homeSale.get(1)%>
                                Beds</p>
                            <p class="block text-base font-medium leading-relaxed text-gray-400 antialiased"><%=homeSale.get(2)%>
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
                        <%=homeSale.get(4)%>
                    </p>
                    <p class=" text-sm font-normal leading-normal text-gray-700 antialiased opacity-75">
                        <%=homeSale.get(7) + ", " + homeSale.get(5) + " " + homeSale.get(6)%>
                    </p>
                </div>
            </div>
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
            <% for (int i = 0; i<rowsRent.size(); i++) {
                ArrayList homeRent = (ArrayList) rowsRent.get(i);
            %>
            <%--House Card--%>
            <div class="mb-5 relative flex w-96 flex-col rounded-sm bg-white bg-clip-border text-gray-700 shadow-md">
                <div class="relative mx-4 mt-4 h-54 overflow-hidden rounded-sm bg-white bg-clip-border text-gray-700">
                    <img
                            src="<%=homeRent.get(3)%>"
                            class="h-full w-full object-cover"
                    />
                </div>
                <div class="p-6">
                    <div class="mb-2 flex items-center justify-between ">
                        <div class="flex w-full">
                            <p class="mr-2 self-start text-base font-medium leading-relaxed text-blue-gray-900 antialiased">
                                ETB <%=NumberFormat.getNumberInstance(Locale.US).format(Integer.parseInt(homeRent.get(0).toString()))%>
                            </p>
                            <p class="mr-2 block text-base font-medium leading-relaxed text-gray-400 antialiased"><%=homeRent.get(1)%>
                                Beds</p>
                            <p class="block text-base font-medium leading-relaxed text-gray-400 antialiased"><%=homeRent.get(2)%>
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
                        <%=homeRent.get(4)%>
                    </p>
                    <p class=" text-sm font-normal leading-normal text-gray-700 antialiased opacity-75">
                        <%=homeRent.get(7) + ", " + homeRent.get(5) + " " + homeRent.get(6)%>
                    </p>
                </div>
            </div>
            <%}%>
            <%--House Card--%>
        </div>
    </div>
    <%--For Rent--%>


</body>
</html>
