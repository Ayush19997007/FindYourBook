package com.example.android.findyourbook;

public class four_data {
    private String title;
    private  String pages;
    private String publisher;
    public four_data(String titl, String publshr, String pag)
    {
        title=titl;
        pages=pag;
        publisher=publshr;
    }
    String bookTitle()
    {
        return title;
    }
    String noOfPages()
    {
        return pages;
    }
    String publisherName()
    {
        return publisher;
    }



}
