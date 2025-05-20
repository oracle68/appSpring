package com.myapp.util;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.myapp.entity.Item;
import com.myapp.service.ItemService;
import com.myapp.service.ItemServiceImpl;
import com.itextpdf.layout.Document;
//import com.itextpdf.txt.List;

import org.springframework.beans.factory.annotation.Autowired;


public class printList {

    @Autowired
    static
   ItemService itemService;       

    //@Autowired
    //ItemRepository itemRepository;
    
	public ItemService getItemService() {
		return itemService;
	}

	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}

	
	public static java.util.List <Item>  getItemsList() {
		
		java.util.List <Item>  itemsList =  new java.util.ArrayList<Item>();
		itemsList = itemService.findAll(); 
        for(Item item : itemsList) {
            System.out.println(item.toString());
        }  		
		return ( itemsList);
	}
	    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		try {
			
	        java.util.List <Item> itemsList =  getItemsList();
	        System.out.println("00");
	        for(Item item : itemsList) {
	            System.out.println(item.toString());
	        }
	        System.out.println("01");
	        
	        
	        
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
        

        
        // Creating a Document and passing pdfDocument
        // object
        Document document = new Document(pdfdocument);
        System.out.println("2");
        //List <Item> itemsList = new ArrayList<>();  //
			//itemsList = itemService.findAll(); 

       // com.itextpdf.txt.List a = new com.itextpdf.text.List();
   
       /* com.itextpdf.layout.element.List a = new com.itextpdf.layout.element.List();
        */
        

        
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

        
 /*       Document document = new Document(PageSize.A4);
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();
        PdfContentByte cb = writer.getDirectContent();

        // Load existing PDF
        PdfReader reader = new PdfReader(templateInputStream);
        PdfImportedPage page = writer.getImportedPage(reader, 1); 

        // Copy first page of existing PDF into output PDF
        document.newPage();
        cb.addTemplate(page, 0, 0);

        // Add your new data / text here
        // for example...
        document.add(new Paragraph("my timestamp")); 

        document.close();		
*/		
		}
    catch (Exception e) {
        System.out.println(
            "failed to add the list to file due to "
            + e);
    }		
	}

}
