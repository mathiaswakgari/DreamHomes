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
    <title>Dream Homes : Add Home</title>
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
            <a href="me">
                <div class="flex items-center gap-4 cursor-pointer duration-300 hover:bg-gray-100 p-2 rounded-md">
                    <i class="fa-regular fa-user"></i>
                    <p><%="fullName"%></p>
                </div>
            </a>
            <div class="flex gap-2 text-white">
                <button class="bg-orange-500 rounded-md w-24 hover:bg-orange-600 cursor:pointer duration-300" >
                    <a href="logout">Logout <i class="fa-solid fa-arrow-right-from-bracket"></i></a>
                </button>
            </div>
        </div>
    </nav>
    <div class="w-full h-full mt-16">
        <p class="text-2xl m-3 p-3 font-normal text-center">REGISTER HOME.</p>
        <form enctype="multipart/form-data" method="post" action="add" class=" flex gap-y-[75px] flex-col mt-1 p-3  h-full w-full rounded-b-lg">

            <div class="grid grid-cols-2 w-full items-center gap-5">
                <div>
                    <div class="">
                        <label for="price" class="block text-sm font-medium leading-6 text-gray-900">Price</label>
                        <div class="mt-2">
                            <div class="rounded-sm flex shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                <input required type="number" step="0.01"  name="price" id="price" autocomplete="email" class="rounded-full h-12 block flex-1 border-0 bg-transparent py-1.5 pl-4 text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm sm:leading-6" placeholder="$340,000.87">
                            </div>
                        </div>
                    </div>
                    <div class=" flex">
                        <div class="w-1/2 pr-1">
                            <label for="bed" class="block text-sm font-medium leading-6 text-gray-900">Bedrooms</label>
                            <div class="mt-2">
                                <div class="rounded-sm flex shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                    <input required type="number"  name="bed" id="bed" class="rounded-full h-12 block flex-1 border-0 bg-transparent py-1.5 pl-4 text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm sm:leading-6" placeholder="2">
                                </div>
                            </div>
                        </div><div class="w-1/2">
                        <label for="bath" class="block text-sm font-medium leading-6 text-gray-900">Bathrooms</label>
                        <div class="mt-2">
                            <div class="rounded-sm flex shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                <input required type="number"  name="bath" id="bath" class="rounded-full h-12 block flex-1 border-0 bg-transparent py-1.5 pl-4 text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm sm:leading-6" placeholder="2">
                            </div>
                        </div>
                    </div>
                    </div>
                    <div class="flex">
                        <div class="w-1/2 pr-1">
                            <label for="area" class="block text-sm font-medium leading-6 text-gray-900">Area</label>
                            <div class="mt-2">
                                <div class="rounded-sm flex shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                    <input required type="number" step="0.01"  name="area" id="area" class="rounded-full h-12 block flex-1 border-0 bg-transparent py-1.5 pl-4 text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm sm:leading-6" placeholder="200">
                                </div>
                            </div>
                        </div><div class="w-1/2">
                        <label for="year" class="block text-sm font-medium leading-6 text-gray-900">Year built</label>
                        <div class="mt-2">
                            <div class="rounded-sm flex shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                <input required type="number"  name="year " id="year" class="rounded-full h-12 block flex-1 border-0 bg-transparent py-1.5 pl-4 text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm sm:leading-6" placeholder="2015">
                            </div>
                        </div>
                    </div>
                    </div>
                    <div class="flex">
                        <div class="w-1/2 pr-1">
                            <label for="type" class="block text-sm font-medium leading-6 text-gray-900">Type</label>
                            <div class="mt-2">
                                <select id="type" name="type" class="bg-gray-200 opacity-90 border border-gray-300 text-gray-900 text-sm w-full  rounded-l-md p-2.5">
                                    <option value="" selected>Select Type</option>
                                    <option value="Single Family">Single Family</option>
                                    <option value="Double Family">Double Family</option>
                                    <option value="Condominium">Condominium</option>
                                </select>
                            </div>
                        </div><div class="w-1/2">
                        <label for="category" class="block text-sm font-medium leading-6 text-gray-900">Category</label>
                        <div class="mt-2">
                            <select name="category" id="category" class="bg-gray-200 opacity-90 border border-gray-300 text-gray-900 text-sm w-full rounded-l-md p-2.5">
                                <option value="" selected>Select Category</option>
                                <option value="sell">For sale</option>
                                <option value="rent">For rent</option>
                            </select>
                        </div>
                    </div>
                    </div>
                </div>
                <div class="w-full flex flex-col">
                    <div class="pr-1 w-full">
                        <label for="utilities" class="block text-sm font-medium leading-6 text-gray-900">Utilities</label>
                        <div class="mt-2 w-full">
                            <div class="w-full flex justify-center shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                <textarea required  name="utilities" id="utilities" class="w-full min-h-15 max-h-28 h-12 block flex-1 border-0 bg-transparent py-1.5 pl-4 text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm sm:leading-6"></textarea>
                            </div>
                        </div>
                    </div><div class="w-full">
                    <label for="about" class="block text-sm font-medium leading-6 text-gray-900">Description</label>
                    <div class="mt-2 w-full">
                        <div class="w-full flex shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                            <textarea required  name="about" id="about" class="min-h-48 max-h-72 w-full h-12 block flex-1 border-0 bg-transparent py-1.5 pl-4 text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm sm:leading-6"></textarea>
                        </div>
                    </div>
                </div>
                </div>
            </div>
<%--            Address--%>
            <div>
                <p class="text-2xl font-normal">Address</p>
                <hr>
                <div class="grid w-full grid-cols-2 mt-5">
                    <div class="grid w-full grid-cols-2">
                        <div class=" pr-1">
                            <label for="address_1" class="block text-sm font-medium leading-6 text-gray-900">Address 1</label>
                            <div class="mt-2">
                                <div class="rounded-sm flex shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                    <input required type="text"  name="address_1" id="address_1" class="rounded-full h-12 block flex-1 border-0 bg-transparent py-1.5 pl-4 text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm sm:leading-6">
                                </div>
                            </div>
                        </div>
                        <div class=" pr-1">
                            <label for="address_2" class="block text-sm font-medium leading-6 text-gray-900">Address 2</label>
                            <div class="mt-2">
                                <div class="rounded-sm flex shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                    <input type="text"  name="address_2" id="address_2" class="rounded-full h-12 block flex-1 border-0 bg-transparent py-1.5 pl-4 text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm sm:leading-6">
                                </div>
                            </div>
                        </div>
                        <div class=" pr-1">
                            <label for="address_3" class="block text-sm font-medium leading-6 text-gray-900">Address 3</label>
                            <div class="mt-2">
                                <div class="rounded-sm flex shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                    <input required type="text"  name="address_3" id="address_3" class="rounded-full h-12 block flex-1 border-0 bg-transparent py-1.5 pl-4 text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm sm:leading-6">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="grid grid-cols-2">
                        <div class=" pr-1">
                            <label for="city" class="block text-sm font-medium leading-6 text-gray-900">City</label>
                            <div class="mt-2">
                                <select id="city" name="city" class="bg-gray-200 opacity-90 border border-gray-300 text-gray-900 text-sm w-full  rounded-l-md p-2.5">
                                    <option value="" selected>Select City</option>
                                    <option value="aa">Addis Ababa</option>
                                    <option value="adama">Adama</option>
                                </select>
                            </div>
                        </div>
                        <div class=" pr-1">
                            <label for="state" class="block text-sm font-medium leading-6 text-gray-900">State</label>
                            <div class="mt-2">
                                <select id="state" name="state" class="bg-gray-200 opacity-90 border border-gray-300 text-gray-900 text-sm w-full  rounded-l-md p-2.5">
                                    <option value="" selected>Select State</option>
                                    <option value="aa">Addis Ababa</option>
                                    <option value="oromia">Oromia</option>
                                </select>
                            </div>
                        </div>
                        <div class=" pr-1">
                                <label for="country" class="block text-sm font-medium leading-6 text-gray-900">Country</label>
                                <div class="mt-2">
                                    <select disabled id="country" name="country" class="bg-gray-200 opacity-90 border border-gray-300 text-gray-900 text-sm w-full  rounded-l-md p-2.5">
                                        <option value="ET" selected>Ethiopia</option>

                                    </select>
                                </div>
                            </div>
                        <div class=" pr-1">
                            <label for="postal" class="block text-sm font-medium leading-6 text-gray-900">Postal Code</label>
                            <div class="mt-2">
                                <div class="rounded-sm flex shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                    <input required type="number"  name="postal" id="postal" class="rounded-full h-12 block flex-1 border-0 bg-transparent py-1.5 pl-4 text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm sm:leading-6">
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
<%--            Pictures--%>
            <div>
                <p class="text-2xl font-normal">Views</p>
                <hr>
                <div class="mt-5 grid grid-cols-3 gap-3">
                    <div class=" pr-1">
                        <label class="block mb-2 text-sm font-medium text-gray-900 " for="main_pic">Main View</label>
                        <input class="block w-full text-sm text-gray-900 border border-gray-300 cursor-pointer bg-gray-50 focus:outline-none" id="main_pic" name="main_pic" type="file">
                    </div>
                    <div class=" pr-1">
                        <label class="block mb-2 text-sm font-medium text-gray-900 " for="pic_1">Additional View</label>
                        <input class="block w-full text-sm text-gray-900 border border-gray-300 cursor-pointer bg-gray-50 focus:outline-none" id="pic_1" name="pic_1" type="file">
                    </div>
                    <div class=" pr-1">
                        <label class="block mb-2 text-sm font-medium text-gray-900 " for="pic_2">Additional View</label>
                        <input class="block w-full text-sm text-gray-900 border border-gray-300 cursor-pointer bg-gray-50 focus:outline-none" id="pic_2" name="pic_2" type="file">
                    </div>
                    <div class=" pr-1">
                        <label class="block mb-2 text-sm font-medium text-gray-900 " for="pic_3">Additional View</label>
                        <input class="block w-full text-sm text-gray-900 border border-gray-300 cursor-pointer bg-gray-50 focus:outline-none" id="pic_3" name="pic_3" type="file">
                    </div>
                    <div class=" pr-1">
                        <label class="block mb-2 text-sm font-medium text-gray-900 " for="pic_4">Additional View</label>
                        <input class="block w-full text-sm text-gray-900 border border-gray-300 cursor-pointer bg-gray-50 focus:outline-none" id="pic_4" name="pic_4" type="file">
                    </div>
                    <div class=" pr-1">
                        <label class="block mb-2 text-sm font-medium text-gray-900 " for="pic_5">Additional View</label>
                        <input class="block w-full text-sm text-gray-900 border border-gray-300 cursor-pointer bg-gray-50 focus:outline-none" id="pic_5" name="pic_5" type="file">
                    </div>
                    <div class=" pr-1">
                        <label class="block mb-2 text-sm font-medium text-gray-900 " for="pic_6">Additional View</label>
                        <input class="block w-full text-sm text-gray-900 border border-gray-300 cursor-pointer bg-gray-50 focus:outline-none" id="pic_6" name="pic_6" type="file">
                    </div>
                </div>
            </div>
<%--            Agent Info--%>
            <div class="w-full">
                <p class="text-2xl font-normal">Listing Agent</p>
                <hr>
                <div class="flex mt-5 w-full">
                    <div class="w-full pr-1">
                        <label for="agent_name" class="block text-sm font-medium leading-6 text-gray-900">Agent Name</label>
                        <div class="mt-2 w-full">
                            <div class="rounded-sm flex shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                <input required type="text"  name="agent_name" id="agent_name" class="rounded-full h-12 block flex-1 border-0 bg-transparent py-1.5 pl-4 text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm sm:leading-6">
                            </div>
                        </div>
                    </div>
                    <div class="w-full pr-1">
                        <label for="agent_number" class="block text-sm font-medium leading-6 text-gray-900">Agent Number</label>
                        <div class="mt-2">
                            <div class="rounded-sm flex shadow-sm ring-1 ring-inset ring-gray-300 focus-within:ring-2 focus-within:ring-inset focus-within:ring-indigo-600 sm:max-w-md">
                                <input required type="text"  name="agent_number" id="agent_number" class="rounded-full h-12 block flex-1 border-0 bg-transparent py-1.5 pl-4 text-gray-900 placeholder:text-gray-400 focus:outline-none sm:text-sm sm:leading-6">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
<%--            Submit--%>
            <div class=" flex items-center pb-10">
                <button type="submit" class="h-10 text-white bg-orange-500 rounded-md w-24 hover:bg-orange-600 cursor:pointer duration-300">Save</button>
            </div>

        </form>
    </div>
</body>
</html>
