package com.github.s1ckcode.SalesManagement;

import com.github.s1ckcode.SalesManagement.Utils.DataInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalesManagementApplication implements CommandLineRunner {

	@Autowired
	DataInit dataInit;

	public static void main(String[] args) {
		SpringApplication.run(SalesManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dataInit.initData();

	}
}