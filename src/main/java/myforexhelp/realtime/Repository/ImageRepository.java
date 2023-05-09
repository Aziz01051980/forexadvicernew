package myforexhelp.realtime.Repository;

import myforexhelp.realtime.Domain.Images;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class ImageRepository implements JpaRepository<Images, Long> {

    Optional<Images> findByName(String fileName) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Images> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Images> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Images> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Images getOne(Long aLong) {
        return null;
    }

    @Override
    public Images getById(Long aLong) {
        return null;
    }

    @Override
    public Images getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Images> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Images> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Images> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Images> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Images> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Images> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Images, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Images> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Images> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Images> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Images> findAll() {
        return null;
    }

    @Override
    public List<Images> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Images entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Images> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Images> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Images> findAll(Pageable pageable) {
        return null;
    }
}
