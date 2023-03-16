package com.example.profile;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OtmprofileApplication {

	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(OtmprofileApplication.class, args);
	}

}

/*

postman input
--------------
{
    "name":"mamatha",
    "mobileNo":"12345",
    "email":"mamatha@gmail.com",
    "address":"kurnool",
    "bio":"mamathashok",
    "skills":{"name":"java"},
    "educations":
                    {"universityName":"jntu",
                    "collageName":"sjcet",
                    "grade":"A",
                    "projectName":"abcd",
                    "projectBio":"123"},
    "workHistories":
                    {
                        "companyName":"hutech",
                        "startDate":"25-01-2023",
                        "endDate":"25-03-2023",
                        "designation":"java developer",
                        "projectName":"abcd",
                        "projectBio":"123"},
    "certificates":
                    {
                        "name":"mamatha",
                        "endDate":"25-03-2023",
                        "url":"www.google.com"
                    }
}
*/