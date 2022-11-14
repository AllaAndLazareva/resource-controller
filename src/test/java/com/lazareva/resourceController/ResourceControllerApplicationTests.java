package com.lazareva.resourceController;

import com.lazareva.resourceController.jpa.entities.VersionEntity;
import com.lazareva.resourceController.jpa.repositories.VersionRepositories;
import com.lazareva.resourceController.models.VersionDataModel;
import com.lazareva.resourceController.provider.VersionDataProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ResourceControllerApplicationTests {


	@Autowired
	private VersionDataProvider repositories;


	@Test
	void contextLoads() {

		VersionDataModel dataModel=new VersionDataModel();
		dataModel.setValueKey("test_test");
		VersionEntity version=repositories.save();
		System.out.println(version);
	}

}
