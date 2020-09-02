package pl.filipmikolajzeglen.videoapp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.filipmikolajzeglen.videoapp.dao.VideoCassetteRepo;
import pl.filipmikolajzeglen.videoapp.dao.entity.VideoCassette;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VideoCassetteManager {

    private VideoCassetteRepo videoCassetteRepo;

    @Autowired
    public VideoCassetteManager(VideoCassetteRepo videoCassetteRepo) {
        this.videoCassetteRepo = videoCassetteRepo;
    }

    public Optional<VideoCassette> findById(Long id) {
        return videoCassetteRepo.findById(id);
    }

    public Iterable<VideoCassette> findAll() {
        return videoCassetteRepo.findAll();
    }

    public VideoCassette save(VideoCassette videoCassette) {
        return videoCassetteRepo.save(videoCassette);
    }

    public void deleteById(Long id) {
        videoCassetteRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new VideoCassette(1L, "Harry Potter 1", LocalDate.of(2010,1,1)));
        save(new VideoCassette(2L, "Harry Potter 2", LocalDate.of(2011,1,1)));
        save(new VideoCassette(3L, "Harry Potter 3", LocalDate.of(2012,1,1)));
        save(new VideoCassette(4L, "Harry Potter 4", LocalDate.of(2013,1,1)));
        save(new VideoCassette(5L, "Harry Potter 5", LocalDate.of(2014,1,1)));
        save(new VideoCassette(6L, "Harry Potter 6", LocalDate.of(2015,1,1)));
    }
}
