package com.test.tanos.Must;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyService {

	@Autowired
	private Repository repo;

	// Get all data from DB
	public ArrayList<Family> getFamily() {
		ArrayList<Family> familyData = new ArrayList<>();
		repo.findAll().forEach(familyData::add);
		return familyData;
	}

	// Add member to DB
	public void addFamily(Family family) {
		repo.save(family);
	}

	// Get member By ID
	public Optional<Family> getMember(int id) {
		return repo.findById(id);
	}

	// Update Member by ID
	public Family update(Family family, int id) {
		return repo.save(family);
	}

	// Delete member by ID
	public String deleteMember(int id) {
		repo.deleteById(id);
		return "Member Deleted";
	}

	// Delete All Data
	public String deleteAllMembers() {
		repo.deleteAll();
		return "All data deleted";
	}
}
