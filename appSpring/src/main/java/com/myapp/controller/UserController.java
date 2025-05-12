package com.myapp.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.entity.Genre;
import com.myapp.entity.User;
import com.myapp.service.CityService;
import com.myapp.service.UserService;
import com.myapp.validator.UserValidator;

@Controller
public class UserController {

    @Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}   
	
    @Autowired
	private CityService cityService;
    @Autowired
    UserValidator userValidator;
    
	@RequestMapping(value="/register", method = RequestMethod.GET)
	//public String registerUser(Map<String, Object> m ) { //@ModelAttribute User user) {
	public ModelAndView registerUser (Map<String, Object> m) {
		System.out.println("********************* RegisterUser*************************");
		 User userForm = new User();    
	     m.put("userForm", userForm);
		
	     
		List<Genre> genderList = new ArrayList<Genre>( Arrays.asList(Genre.values() ));
		 
		 m.put("genderList", genderList);
			     
		List<String> cityList = cityService.getListNomCity();
		 m.put("cityList", cityList);
		 
		 System.out.println("********************* END RegisterUser GET*************************");
		
		return new ModelAndView("register", "map", m);
	}


	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String submitForm (@ModelAttribute("userForm") @Valid User user, BindingResult result)
	{
		System.out.println(" inserData----------------------");
		userValidator.validate(user, result);
		if (user != null)
			userService.insertData(user);
		return "redirect:getList";
	}


        
	@RequestMapping(value = "/getList", method = RequestMethod.GET)
	public ModelAndView getUserList() {
		List<User> userList = userService.getUserList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userlist", userList);
		Integer c = userService.getCount();
		map.put("count",c );
		Integer d = userService.getDistinct();
		map.put("distinct",d );
		Integer e = userService.getNamedQuery();
		map.put("namedquery",e );		
		return new ModelAndView("userList", "map", map);
	}

        
	@RequestMapping(value="/edit", method = RequestMethod.GET)
	public ModelAndView editUser(@RequestParam Integer id,
			@ModelAttribute User user) {

		user = userService.getUser(id);


		Map<String, Object> map = new HashMap<String, Object>();

		map.put("cityList", cityService.getListNomCity());
		map.put("user", user);

		return new ModelAndView("edit", "map", map);

	}

	@RequestMapping(value="/update", method = RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute("user") @Valid User user) {
		System.out.println("******updateUser "+user.toString());
		user.setGender(user.getGender());
		String nom = user.getCity().getNom();
		System.out.println("** UpdateUser: user.city.nom: "+ nom);
	    user.getCity().setId(cityService.getIdByNom(nom));		
		userService.updateData(user);
		System.out.println("** UpdateUser: ok");
		return new ModelAndView("userList");

	}

	@RequestMapping(value="/delete") //, method = RequestMethod.POST)
	public ModelAndView deleteUser(@RequestParam Integer id) {
		System.out.println("id = " + id);
		userService.deleteData(id);
		return new ModelAndView ("userList");
	}    
          
        
        
        
    @RequestMapping(value="/existe")
	public @ResponseBody String existeUser(@RequestParam("firstname") String firstname)
        {
		return userService.getExistFirstname(firstname);       
        }        

}
