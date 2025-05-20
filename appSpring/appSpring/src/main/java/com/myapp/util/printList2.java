package com.myapp.util;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.myapp.entity.Item;
import com.myapp.service.ItemService;
import com.itextpdf.layout.Document;
//import com.itextpdf.txt.List;

import org.springframework.beans.factory.annotation.Autowired;

public class printList2 {

    @Autowired
    static
   ItemService itemService;       

    //@Autowired
    //ItemRepository itemRepository;
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
		HibernateUtil 	hu = new HibernateUtil();
		
        // path where the pdf is to be created.
        String path = "/home/ub18/addingList.pdf";
        System.out.println("0");
        PdfWriter pdfwriter = new PdfWriter(path);
        System.out.println("01");
        // Creating a PdfDocument object.
        // passing PdfWriter object constructor of
        // pdfDocument.
        PdfDocument pdfdocument
            = new PdfDocument(pdfwriter);
        System.out.println("1");	
        
        java.util.List <Item> itemsList =  itemService.findAll();
        System.out.println("12");
        
        // Creating a Document and passing pdfDocument
        // object
        Document document = new Document(pdfdocument);
        System.out.println("2");
        //List <Item> itemsList = new ArrayList<>();  //
			//itemsList = itemService.findAll(); 

       // com.itextpdf.txt.List a = new com.itextpdf.text.List();
   
       /* com.itextpdf.layout.element.List a = new com.itextpdf.layout.element.List();
        */
        
        for(Item item : itemsList) {
            System.out.println(item.toString());
        }
        
        
        // Adding list to the document
        document.add((AreaBreak) itemsList);
        /*  
        document.add(itemsList);
        */
        System.out.println("end");
        // Closing the document
        document.close();
        System.out.println(
            "List has been successfully added to the file :"
            + path);

        
	
		}
    catch (Exception e) {
        System.out.println(
            "failed to add the list to file due to "
            + e);
    }		
	}

}
