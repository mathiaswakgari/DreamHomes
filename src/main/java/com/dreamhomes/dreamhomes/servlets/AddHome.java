package com.dreamhomes.dreamhomes.servlets;

import com.dreamhomes.dreamhomes.models.Address;
import com.dreamhomes.dreamhomes.models.Home;
import com.dreamhomes.dreamhomes.models.User;
import com.dreamhomes.dreamhomes.services.Database;
import com.dreamhomes.dreamhomes.services.DropBox;
import com.dreamhomes.dreamhomes.services.Helpers;
import com.dropbox.core.DbxException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;

@WebServlet("/add")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100
)
public class AddHome extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Database database = new Database();
        DropBox dropBox = new DropBox();

        HttpSession httpSession = req.getSession();

//        User user = (User) httpSession.getAttribute("user");

        double price = Double.parseDouble(req.getParameter("price"));
        int bed = Integer.parseInt(req.getParameter("bed"));
        int bath = Integer.parseInt(req.getParameter("bath"));
        double area = Double.parseDouble(req.getParameter("area"));
        int year = Integer.parseInt(req.getParameter("area"));
        String type = req.getParameter("type");
        String category = req.getParameter("category");
        String utilities = req.getParameter("utilities");
        String description = req.getParameter("about");

        String address1 = req.getParameter("address_1");
        String address2 = req.getParameter("address_2");
        String address3 = req.getParameter("address_3");
        String city = req.getParameter("city");
        String country = req.getParameter("country");
        String state = req.getParameter("state");
        int postalCode = Integer.parseInt(req.getParameter("postal"));

        String agentName = req.getParameter("agent_name");
        String agentNumber = req.getParameter("agent_number");

        Part mainPic = req.getPart("main_pic");
        Part pic1  = req.getPart("pic_1");
        Part pic2  = req.getPart("pic_2");
        Part pic3  = req.getPart("pic_3");
        Part pic4  = req.getPart("pic_4");
        Part pic5  = req.getPart("pic_5");
        Part pic6  = req.getPart("pic_6");

        Address address = new Address(address1,address2,address3,city,state,country,postalCode);
        Home home;

        int addressId = database.insertIntoAddress(address);

        if(addressId == -1){
            System.out.println("Address Adding failed...");
        }else {
            if (mainPic.getSize() == 0){
                // upload as it is
            }else{
                File mainPicFile = new Helpers().convertPartToFile(mainPic);
                File pic1File = new  Helpers().convertPartToFile(pic1);
                File pic2File = new  Helpers().convertPartToFile(pic2);
                File pic3File = new  Helpers().convertPartToFile(pic3);
                File pic4File = new  Helpers().convertPartToFile(pic4);
                File pic5File = new  Helpers().convertPartToFile(pic5);
                File pic6File = new  Helpers().convertPartToFile(pic6);

                try {
                    String mainUrl = dropBox.upload(mainPicFile);
                    String pic1Url = dropBox.upload(pic1File);
                    String pic2Url = dropBox.upload(pic2File);
                    String pic3Url = dropBox.upload(pic3File);
                    String pic4Url = dropBox.upload(pic4File);
                    String pic5Url = dropBox.upload(pic5File);
                    String pic6Url = dropBox.upload(pic6File);

                    mainPicFile.delete();
                    pic1File.delete();
                    pic2File.delete();
                    pic3File.delete();
                    pic4File.delete();
                    pic5File.delete();
                    pic6File.delete();

                    home = new Home(addressId, price, bed,bath,area,description, year,type,utilities, category,agentName,agentNumber,mainUrl,pic1Url,pic2Url,pic3Url,pic4Url,pic5Url,pic6Url,address);

                    database.insertIntoHomes(home);

                    resp.getWriter().println("Success.");
                    //redirect to some page



                } catch (DbxException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}
