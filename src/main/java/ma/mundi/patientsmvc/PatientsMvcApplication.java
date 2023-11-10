package ma.mundi.patientsmvc;

import ma.mundi.patientsmvc.entities.Patient;
import ma.mundi.patientsmvc.repositories.PatientRepository;
import org.hibernate.boot.jaxb.SourceType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

	public static void main(String[] args) {

		SpringApplication.run(PatientsMvcApplication.class, args);
	}
	//@Bean
	CommandLineRunner commandLineRunner(PatientRepository patientRepository){
		return args -> {
			patientRepository.save(
					new Patient(null,"Zoubair", new Date(),false,12));
			patientRepository.save(
					new Patient(null,"Khalid", new Date(),true,45));
			patientRepository.save(
					new Patient(null,"Ali", new Date(),true,90));
			patientRepository.save(
					new Patient(null,"Mouhcine", new Date(),false,82));
			patientRepository.findAll().forEach(p->{
				System.out.println(p.getNom());
			});
		};
	}
}
