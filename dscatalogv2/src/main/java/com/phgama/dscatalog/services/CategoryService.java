package com.phgama.dscatalog.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.phgama.dscatalog.dto.CategoryDTO;
import com.phgama.dscatalog.entities.Category;
import com.phgama.dscatalog.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll(){
		List<Category> list = repository.findAll(); 
		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
		
		/* metodo nao usual
		List<CategoryDTO> listDto = new ArrayList<>();
		for (Category cat : list) {
			listDto.add(new CategoryDTO(cat));
		}
		*/
	}
	
	
	
}
