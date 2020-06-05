/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.whitedwaft.mephi;

import com.google.gson.Gson;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author akors
 */
public class Mephi {
    
   List <Book> books = new ArrayList<>();
   public void addBook(String author,String name,String izd,boolean bellitristika, boolean exist)
    {
       books.add(new Book(author,name,izd,bellitristika,exist));
    }
   public void delBook(String author,String name,String izd,boolean bellitristika, boolean exist)
    {
       books.remove(new Book(author,name,izd,bellitristika,exist));
    }
   public void printInFile(List <Book> books) throws IOException
   {
       Gson gson= new Gson();
       File fl1 = new File("C:\\Users\\akors\\anton.txt");
       FileWriter fw1 = new FileWriter(fl1.getAbsolutePath(),false);
       for (Book b:books)
       {
           fw1.append(gson.toJson(b));
       }
       fw1.close();
   }
   public void getBook(String author,String name,String izd)
   {
       for(Book b: books)
       {
           if(b.name.equals(name) && b.izd.equals(izd) && b.author.equals(author))
               System.out.println(b);
       }
   }
   public void changeBook(String oldname ,String newauthor,String newname,String newizd,boolean bellitristika, boolean exist)
   {
       for(Book b: books)
       {
           if(b.name.equals(oldname))
               b.setAuthor(newauthor);
               b.setName(newname);
               b.setIzd(newizd);              
       }
   }
   public static void main(String[]arg) throws IOException{
       Mephi n = new Mephi();
       n.addBook("qwery", "artur","oreon", true, true);
       n.changeBook("artur","artur", "query", "oreonXP", true, true);
//       n.delBook("qwery", "artur","oreon", true, true);
       n.getBook("artur","artur", "query");
       n.printInFile(n.books);
   }
}
class Book{
    String author;
    String name;
    String izd;
    boolean bellitristika;
    boolean exist;
    
    @Override
    public String toString(){
        return "Find book: \n"+"Name:" + name + " \n Author:" + author + " \n izd:" + izd +" \n bellitristica:" + bellitristika + " \n exist:" + exist;
    }
    

    public boolean isBellitristika() {
        return bellitristika;
    }

    public void setBellitristika(boolean bellitristika) {
        this.bellitristika = bellitristika;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }
    

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIzd() {
        return izd;
    }

    public void setIzd(String izd) {
        this.izd = izd;
    }
    
    public Book(String author,String name,String izd,boolean bellitristika, boolean exist){
        this.author = author;
        this.izd = izd;
        this.name = name;
        this.bellitristika = bellitristika;
        this.exist = exist;
    }
}

