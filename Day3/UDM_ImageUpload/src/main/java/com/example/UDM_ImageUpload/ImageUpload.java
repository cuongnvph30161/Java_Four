package com.example.UDM_ImageUpload;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.IOException;
import java.util.List;

@WebServlet("/ImageUpload")
public class ImageUpload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());

        try {
            List<FileItem> images = upload.parseRequest((RequestContext) req);
            for (FileItem image : images) {
                String name = image.getName();
                name = name.substring(name.lastIndexOf("\\") + 1);
                System.out.println("name" + name);
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }


    }
}
