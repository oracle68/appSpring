package com.myapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.entity.City;
import com.myapp.entity.Item;
import com.myapp.service.CityService;

@Controller
public class CityController {
	
    @Autowired
	private CityService cityService;

	@RequestMapping(value = "/cityListJson", method = RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody List getAllCities() {
		System.out.println("#########getAll()#########");
		List<City> cityList = cityService.getCityList();
		return cityList;
	}
	
	@RequestMapping(value = "/cityListAngular", method = RequestMethod.GET)
	public String getAllCitiesAngular() {

		return "cityListAngular";
	}	

	@RequestMapping(value = "/cityNomList", method = RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody List getAllNomCities() {
		System.out.println("#########getAll()#########");
		List<String> cityList = cityService.getListNomCity();
		return cityList;
	}
		
	@RequestMapping(value = "/getCity/{Id}", method = RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	public @ResponseBody City getCity (@PathVariable("Id") Integer Id) {
	 
		return  cityService.getCity(Id);
	 }	
	
	
	@RequestMapping(value = "/altacity", method = RequestMethod.GET)
    public ModelAndView altacity(Map<String, Object> m)
    {
		m.put("cityNomList", cityService.getListNomCity());
		m.put("mensaje", "ok");
        return new ModelAndView("altacity","map",m);
    }        


	 @RequestMapping(value="/addcity", method = RequestMethod.POST)
	//public ModelAndView addCity(@ModelAttribute("city") @Valid City city, BindingResult result) {
		public ModelAndView addCity(@RequestParam String nom) {
		 String mensaje="Error camp obligatori";
		 System.out.println("nom: "+nom);
		 Map<String, Object> m = new HashMap<String, Object>() ;

		 if (!nom.equals(""))
         {
			City city = new City();
			city.setNom(nom);
            cityService.insertData(city);
            mensaje="Camp inserit OK";   
         }
		 m.put("cityNomList", cityService.getListNomCity());
		 m.put("mensaje", mensaje);
		 return new ModelAndView("altacity","map",m);
	}
	 
/*	   //, method = RequestMethod.POST) //, produces = MediaType.APPLICATION_JSON_VALUE)
//public ModelAndView addCity(@RequestBody City city,BindingResult result) {
      @RequestMapping(value="/addcity")
      public @ResponseBody String addCity(@RequestParam("nom") String nom) { //(@RequestBody City city) {      
        String mensaje ="OK";
        System.out.println(" nom="+nom);
         try{   
         if (!nom.equals(""))
         {
            City city =new City();    
            city.setNom(nom);
            cityService.insertData(city);
         }
         else mensaje="Nom is null";
         } catch (Exception e) { 
                                 mensaje="Error"; 
                                 System.out.println(e);
                                }   
         //return new ModelAndView("addcity", "mensaje", mensaje);
         System.out.println("mensaje="+mensaje);
         return mensaje;
	}
*/
	

}
