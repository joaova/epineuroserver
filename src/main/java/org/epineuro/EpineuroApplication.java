package org.epineuro;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.epineuro.model.Group;
import org.epineuro.model.Permission;
import org.epineuro.model.User;
import org.epineuro.repository.GroupRepository;
import org.epineuro.repository.PermissionRepository;
import org.epineuro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EpineuroApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EpineuroApplication.class, args);
	}
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PermissionRepository permissionRepository;
	
	@Autowired
	GroupRepository groupRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
		
		if(permissionRepository.findAll().size() < 9) {
			
			Permission p1 = new Permission();
			
			p1.setDescription("Permissão de pessoas");
			p1.setId(1L);
			p1.setName("EP01");
			
			
			permissionRepository.save(p1);
			
			Group g1 = new Group();
			
			g1.setNome("Grupo 1 Pessoa");
			g1.setId(1L);
			
			Set<Permission> set1 = new HashSet<Permission>();
			set1.add(p1);

			g1.setPermissions(set1);
			
			groupRepository.save(g1);
			
			User u1 = User.builder()
					.id(1L)
					.name("João Amaral")
					.email("joaovillanova@hotmail.com.br")
					.password(passwordEncoder.encode("123456"))
					.group(groupRepository.findById(1L).get())
					.type(1L)
					.cod(1L)
			.build();
			
			User u2 = User.builder()
					.id(2L)
					.name("Fernanda Dala Costa")
					.email("nandacdcosta@gmail.com")
					.password(passwordEncoder.encode("123456"))
					.group(groupRepository.findById(1L).get())
					.type(1L)
					.cod(1L)
			.build();
			
			User u3 = User.builder()
					.id(3L)
					.name("Fernando Bellinaso")
					.email("fernandobellinaso@gmail.com")
					.password(passwordEncoder.encode("123456"))
					.group(groupRepository.findById(1L).get())
					.type(1L)
					.cod(1L)
			.build();
			
			User u4 = User.builder()
					.id(4L)
					.name("Luís Guilherme ADCR")
					.email("lgadcr@hotmail.com")
					.password(passwordEncoder.encode("123456"))
					.group(groupRepository.findById(1L).get())
					.type(1L)
					.cod(1L)
			.build();
			
			User u5 = User.builder()
					.id(5L)
					.name("Juliana Silveira")
					.email("julianaofs@yahoo.com.br")
					.password(passwordEncoder.encode("123456"))
					.group(groupRepository.findById(1L).get())
					.type(1L)
					.cod(1L)
			.build();
			
			User u6 = User.builder()
					.id(6L)
					.name("Michele Fighera")
					.email("mrfighera23@gmail.com")
					.password(passwordEncoder.encode("123456"))
					.group(groupRepository.findById(1L).get())
					.type(1L)
					.cod(1L)
			.build();
			
			User u7 = User.builder()
					.id(7L)
					.name("Mônika dos Santos")
					.email("monikadossantos@gmail.com")
					.password(passwordEncoder.encode("123456"))
					.group(groupRepository.findById(1L).get())
					.type(1L)
					.cod(1L)
			.build();
						
			User u8 = User.builder()
					.id(8L)
					.name("Rafaela Rossini")
					.email("rafarossini@hotmail.com")
					.password(passwordEncoder.encode("123456"))
					.group(groupRepository.findById(1L).get())
					.type(1L)
					.cod(1L)
			.build();
			
			User u9 = User.builder()
					.id(8L)
					.name("Larissa Blás")
					.email("lariblas11@gmail.com")
					.password(passwordEncoder.encode("123456"))
					.group(groupRepository.findById(1L).get())
					.type(1L)
					.cod(1L)
			.build();
			
			userRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5,u6,u7,u8,u9));
			
		}
		
	}

}
