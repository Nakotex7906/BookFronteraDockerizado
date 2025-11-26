package bookfronterab;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookfronterab.model.Room;
import bookfronterab.repo.RoomRepository;

@SpringBootApplication
public class BookFronteraBApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookFronteraBApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(RoomRepository roomRepository) {
        return args -> {
            if (roomRepository.count() == 0) {

                List<Room> salas = List.of(
                        Room.builder()
                                .name("Sala Colaborativa A")
                                .capacity(6)
                                .floor(2)
                                .equipment(List.of("Pizarra", "Proyector", "Enchufes"))
                                .build(),
                        Room.builder()
                                .name("Sala de Estudio B")
                                .capacity(4)
                                .floor(2)
                                .equipment(List.of("Pizarra", "Mesa Redonda"))
                                .build(),
                        Room.builder()
                                .name("Laboratorio Creativo")
                                .capacity(10)
                                .floor(3)
                                .equipment(List.of("TV 50\"", "PC", "Pizarra", "Wifi-6"))
                                .build(),
                        Room.builder()
                                .name("Sala Individual Silenciosa")
                                .capacity(2)
                                .floor(1)
                                .equipment(List.of("Escritorios", "Sillas Ergonómicas"))
                                .build()
                );

                roomRepository.saveAll(salas);
                System.out.println("--- BASE DE DATOS INICIALIZADA CON SALAS DE PRUEBA ---");
            }
        };
    }
}
