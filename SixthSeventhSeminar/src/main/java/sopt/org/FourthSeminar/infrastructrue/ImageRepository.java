package sopt.org.FourthSeminar.infrastructrue;

import org.springframework.data.repository.Repository;
import sopt.org.FourthSeminar.domain.Image;

public interface ImageRepository extends Repository<Image, Long> {
    // CREATE
    void save(Image image);
}

