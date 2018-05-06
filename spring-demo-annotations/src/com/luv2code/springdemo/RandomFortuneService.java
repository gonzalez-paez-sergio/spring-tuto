package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	/**
	 * 1. Modify your file based fortune service to make use of the @PostConstruct
	 * annotation
	 * 
	 * 2. In the @PostConstruct code, read the fortunes from the file system
	 * 
	 * 3. Test your application and verify your @PostConstruct code is being
	 * executed. Hint, add some println statements.
	 */
	// @Value("${fortune}")
	// String[] string;

	static List<String> stringArray = new ArrayList<String>();

	Random random = new Random();

	@Override
	public String getFortune() {
		return "RandomFortuneService: " + stringArray.get(random.nextInt(stringArray.size()));
	}

	@PostConstruct
	public static void doMyPostConstructStuff() {
		// @Value("${fortune}")
		// String[] string;

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
				new File("/home/sergiogp/eclipse-workspace/spring-demo-annotations/src/fortune.properties")));) {
			String stringLine = null;

			while (null != (stringLine = bufferedReader.readLine())) {
				System.out.printf("stringLine:%s", stringLine);

				stringArray.add(stringLine);
			}

			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
