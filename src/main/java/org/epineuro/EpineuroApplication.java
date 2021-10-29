package org.epineuro;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.epineuro.model.CivilState;
import org.epineuro.model.Color;
import org.epineuro.model.DiseaseGroup;
import org.epineuro.model.Drugs;
import org.epineuro.model.Exam;
import org.epineuro.model.Group;
import org.epineuro.model.Permission;
import org.epineuro.model.Scholarity;
import org.epineuro.model.Surgery;
import org.epineuro.model.User;
import org.epineuro.repository.CivilStateRepository;
import org.epineuro.repository.ColorRepository;
import org.epineuro.repository.DiseaseGroupRepository;
import org.epineuro.repository.DrugsRepository;
import org.epineuro.repository.ExamRepository;
import org.epineuro.repository.GroupRepository;
import org.epineuro.repository.PermissionRepository;
import org.epineuro.repository.ScholarityRepository;
import org.epineuro.repository.SurgeryRepository;
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

	@Autowired
	private ScholarityRepository sRepository;

	@Autowired
	private CivilStateRepository cVRepository;

	@Autowired
	private ColorRepository cRepository;

	@Autowired
	private DiseaseGroupRepository dGRepository;

	@Autowired
	private ExamRepository examR;

	@Autowired
	private SurgeryRepository surgR;

	@Autowired
	private DrugsRepository drugR;
	
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

		if (cVRepository.findAll().size() == 0) {
		// Scholarities

		Scholarity s1 = Scholarity.builder()
						.id(1L)
						.name("Ensino fundamental incompleto")
		.build();

		Scholarity s2 = Scholarity.builder()
						.id(2L)
						.name("Ensino fundamental completo")
		.build();

		Scholarity s3 = Scholarity.builder()
						.id(3L)
						.name("Ensino médio incompleto")
		.build();

		Scholarity s4 = Scholarity.builder()
						.id(4L)
						.name("Ensino médio completo")
		.build();

		Scholarity s5 = Scholarity.builder()
						.id(5L)
						.name("Ensino técnico incompleto")
		.build();

		Scholarity s6 = Scholarity.builder()
						.id(6L)
						.name("Ensino técnico compelto")
		.build();

		Scholarity s7 = Scholarity.builder()
						.id(7L)
						.name("Ensino superior incompleto")
		.build();

		Scholarity s8 = Scholarity.builder()
						.id(8L)
						.name("Ensino superior completo")
		.build();

		Scholarity s9 = Scholarity.builder()
						.id(9L)
						.name("Ensino ausente")
		.build();

		sRepository.saveAll(Arrays.asList(s1,s2,s3,s4,s5,s6,s7,s8,s9));

		CivilState c1 = CivilState.builder()
						.id(1L)
						.name("Solteiro(a)")
		.build();

		CivilState c2 = CivilState.builder()
						.id(2L)
						.name("Casado(a)")
		.build();

		CivilState c3 = CivilState.builder()
						.id(3L)
						.name("Separado(a)")
		.build();

		CivilState c4 = CivilState.builder()
						.id(4L)
						.name("Divorciado(a)")
		.build();

		CivilState c5 = CivilState.builder()
						.id(5L)
						.name("Viúvo(a)")
		.build();

		cVRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5));

		Color cc1 = Color.builder()
					.id(1L)
					.name("Branco")
		.build();

		Color cc2 = Color.builder()
					.id(2L)
					.name("Preto")
		.build();

		Color cc3 = Color.builder()
					.id(3L)
					.name("Pardo")
		.build();

		Color cc4 = Color.builder()
					.id(4L)
					.name("Amarelo")
		.build();

		Color cc5 = Color.builder()
					.id(5L)
					.name("Indígena")
		.build();

		cRepository.saveAll(Arrays.asList(cc1,cc2,cc3,cc4,cc5));;

		DiseaseGroup d1 = DiseaseGroup.builder()
							.id(1L)
							.name("Cefaleia")
		.build();

		DiseaseGroup d2 = DiseaseGroup.builder()
							.id(2L)
							.name("Distúrbios do movimento")
		.build();

		DiseaseGroup d3 = DiseaseGroup.builder()
							.id(3L)
							.name("Epilepsia")
		.build();

		DiseaseGroup d4 = DiseaseGroup.builder()
							.id(4L)
							.name("Demências")
		.build();

		DiseaseGroup d5 = DiseaseGroup.builder()
							.id(5L)
							.name("Doenças Cerebrovasculares")
		.build();

		DiseaseGroup d6 = DiseaseGroup.builder()
							.id(6L)
							.name("Doenças neuromusculares")
		.build();

		DiseaseGroup d7 = DiseaseGroup.builder()
							.id(7L)
							.name("Doenças neuroinfecciosas")
		.build();

		DiseaseGroup d8 = DiseaseGroup.builder()
							.id(8L)
							.name("Doenças da medula espinal")
		.build();

		DiseaseGroup d9 = DiseaseGroup.builder()
							.id(9L)
							.name("Doenças do sistema nervoso periférico e do neurônio motor")
		.build();

		DiseaseGroup d10 = DiseaseGroup.builder()
							.id(10L)
							.name("Doenças do sono")
		.build();

		DiseaseGroup d11 = DiseaseGroup.builder()
							.id(11L)
							.name("Distúrbios autonômicos")
		.build();

		DiseaseGroup d12 = DiseaseGroup.builder()
							.id(12L)
							.name("Neuro-otologia")
		.build();

		DiseaseGroup d13 = DiseaseGroup.builder()
							.id(13L)
							.name("Esclerose múltipla e outras doenças inflamatórias")
		.build();

		DiseaseGroup d14 = DiseaseGroup.builder()
							.id(14L)
							.name("Neuro-oncologia")
		.build();

		dGRepository.saveAll(Arrays.asList(d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14));

		Exam e1 = Exam.builder()
							.id(1L)
							.name("TC_CRANIO")
		.build();

		Exam e2 = Exam.builder()
							.id(2L)
							.name("TC_CRANIO_CONTRASTE")
		.build();

		Exam e3 = Exam.builder()
							.id(3L)
							.name("TC_COLUNA_CERVICAL")
		.build();

		Exam e4 = Exam.builder()
							.id(4L)
							.name("TC_COLUNA_TORACICA")
		.build();

		Exam e5 = Exam.builder()
							.id(5L)
							.name("TC_COLUNA_LOMBAR")
		.build();

		Exam e6 = Exam.builder()
							.id(6L)
							.name("TC_COLUNA_LOMBOSSACRA")
		.build();

		Exam e7 = Exam.builder()
							.id(7L)
							.name("RM_CRANIO")
		.build();

		Exam e8 = Exam.builder()
							.id(8L)
							.name("RM_SELA_TURCICA")
		.build();

		Exam e9 = Exam.builder()
							.id(9L)
							.name("RM_COLUNA_CERVICAL")
		.build();

		Exam e10 = Exam.builder()
							.id(10L)
							.name("RM_COLUNA_TORACICA")
		.build();

		Exam e11 = Exam.builder()
							.id(11L)
							.name("RM_COLUNA_LOMBAR")
		.build();

		Exam e12 = Exam.builder()
							.id(12L)
							.name("RM_COLUNA_LOMBOSSACRA")
		.build();

		Exam e13 = Exam.builder()
							.id(13L)
							.name("EEG")
		.build();

		Exam e14 = Exam.builder()
							.id(14L)
							.name("ENMG")
		.build();

		Exam e15 = Exam.builder()
							.id(15L)
							.name("POLISSONOGRAFIA")
		.build();

		examR.saveAll(Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15));

		Surgery su1 = Surgery.builder()
								.id(1L)
								.name("TRAUMA")
		.build();

		Surgery su2 = Surgery.builder()
								.id(2L)
								.name("ONCOLOGICA")
		.build();

		Surgery su3 = Surgery.builder()
								.id(3L)
								.name("VASCULAR")
		.build();

		Surgery su4 = Surgery.builder()
								.id(4L)
								.name("ENDOVASCULAR")
		.build();

		Surgery su5 = Surgery.builder()
								.id(5L)
								.name("BASE_DE_CRANIO")
		.build();

		Surgery su6 = Surgery.builder()
								.id(6L)
								.name("COLUNA")
		.build();

		Surgery su7 = Surgery.builder()
								.id(7L)
								.name("NERVOS_PERIFERICOS")
		.build();

		Surgery su8 = Surgery.builder()
								.id(8L)
								.name("DERIVACOES_HIDROCEFALIA")
		.build();

		Surgery su9 = Surgery.builder()
								.id(9L)
								.name("EPILEPSIA")
		.build();

		Surgery su10 = Surgery.builder()
								.id(10L)
								.name("OUTRAS_NEUROCIRURGIAS_FUNCIONAIS")
		.build();

		surgR.saveAll(Arrays.asList(su1,su2,su3,su4,su5,su6,su7,su8,su9,su10));

		Drugs dr1 = Drugs.builder()
								.id(1L)
								.name("Opióides")
		.build();

		Drugs dr2 = Drugs.builder()
								.id(2L)
								.name("Anfetaminas")
		.build();

		Drugs dr3 = Drugs.builder()
								.id(3L)
								.name("Barbitúricos")
		.build();

		Drugs dr4 = Drugs.builder()
								.id(4L)
								.name("Anabolizantes")
		.build();

		Drugs dr5 = Drugs.builder()
								.id(5L)
								.name("Maconha")
		.build();

		Drugs dr6 = Drugs.builder()
								.id(6L)
								.name("Crack")
		.build();

		Drugs dr7 = Drugs.builder()
								.id(7L)
								.name("Cocaína")
		.build();

		Drugs dr8 = Drugs.builder()
								.id(8L)
								.name("Lança-perfume")
		.build();

		Drugs dr9 = Drugs.builder()
								.id(9L)
								.name("Cola")
		.build();

		Drugs dr10 = Drugs.builder()
								.id(10L)
								.name("LSD")
		.build();

		Drugs dr11 = Drugs.builder()
								.id(11L)
								.name("Ecstasy")
		.build();

		Drugs dr12 = Drugs.builder()
								.id(12L)
								.name("Heroína")
		.build();

		Drugs dr13 = Drugs.builder()
								.id(13L)
								.name("Ayahuasca")
		.build();

		drugR.saveAll(Arrays.asList(dr1,dr2,dr3,dr4,dr5,dr6,dr7,dr8,dr9,dr10,dr11,dr12,dr13));

		}
		
	}

}
