package com.starkandwayne;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CfEnvSpringApplication {
	
	@GetMapping("/")
	public String home() {
		
        Map<String, String> env = System.getenv();
        
        String string = "<head><title>Cloud Foundry Environment</title><meta name=\\\"viewport\\\" content=\\\"width=device-width\\\"></head>";
        string = string + "<h2>Cloud Foundry Environment</h2>";
        
        string = string + "<div><table>";
        for (String envName : env.keySet()) {
            string = string + "<tr><td><strong>" + envName + "</td></strong>" + "<td>" + env.get(envName) + "</td>" + "</tr>";
        }
		
        string = string + "</table></div>";
        
		return string;
	}
	
	@RequestMapping("/{var}")
	public String envVariable(@PathVariable("var") String var) {
        Map<String, String> env = System.getenv();
		return env.get(var);
	}

	public static void main(String[] args) {
		SpringApplication.run(CfEnvSpringApplication.class, args);
	}

}
