package com.marketingapp.service;

import java.util.List;

import com.marketingapp.entities.lead;

public interface LeadService {
public void saveReg(lead lead);

public List<lead> findAllLeads();

public void deleteLeadById(long id);

public lead findLeadById(long id);
}
