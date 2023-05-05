package com.marketingapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketingapp.entities.lead;
import com.marketingapp.repository.LeadRepository;
@Service
public class LeadServiceImpl implements LeadService {
	
	@Autowired
private LeadRepository leadRepo;
	@Override
	public void saveReg(lead lead) {
		leadRepo.save(lead);

	}
	@Override
	public List<lead> findAllLeads() {
		List<lead> leads = leadRepo.findAll();
		return leads;
	}
	@Override
	public void deleteLeadById(long id) {
		leadRepo.deleteById(id);
		
	}
	@Override
	public lead findLeadById(long id) {
		Optional<lead> findById = leadRepo.findById(id);
		lead lead = findById.get();
		return lead;
	}

}
