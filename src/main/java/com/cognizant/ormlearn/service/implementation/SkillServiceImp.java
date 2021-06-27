package com.cognizant.ormlearn.services.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.repository.SkillRepository;
import com.cognizant.ormlearn.services.SkillService;

@Service
@Transactional
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillRepository skillRepository;

	@Override
	public Skill findSkill(int id) {

		return skillRepository.findById(id).get();
	}

	@Override
	public void saveSkill(Skill skill) {

		skillRepository.save(skill);
	}

}
