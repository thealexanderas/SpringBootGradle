package com.test.tanos.Must;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	FamilyService familyService;

	@RequestMapping(value ="/hi")
	public String hello(){
		return "Hello all!";
	}
	
	@RequestMapping(value="/family/get", method = RequestMethod.GET)
	public List<Family> getFamily(){
		return familyService.getFamily();
	}
	
	@RequestMapping(value="/family/add", method = RequestMethod.POST)
	public void addFamily(@RequestBody Family family){
		familyService.addFamily(family);
	}
	
	@RequestMapping(value="/family/get/{id}", method = RequestMethod.GET)
	public Optional<Family> getMember(@PathVariable int id){
		return familyService.getMember(id);
	}
	
	@RequestMapping(value = "/family/update/{id}", method = RequestMethod.PUT)
	public Family updateFamily(Family family, @PathVariable int id){
		return familyService.update(family, id);
	}
	
	@RequestMapping(value = "/family/delete/{id}", method = RequestMethod.DELETE)
	public String deleteFamily(@PathVariable int id){
		familyService.deleteMember(id);
		return "Member Deleted";
	}
	
	@RequestMapping(value = "/family/delete/all", method = RequestMethod.DELETE)
	public String deleteAll(){
		familyService.deleteAllMembers();
		return "All data deleted!";
	}
}
