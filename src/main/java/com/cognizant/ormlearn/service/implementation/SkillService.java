package com.cognizant.ormlearn.services;

import com.cognizant.ormlearn.model.Skill;

public interface SkillService {

	Skill findSkill(int id);
	
	void saveSkill(Skill skill);
}
