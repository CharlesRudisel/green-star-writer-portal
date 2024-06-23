package com.example.upwork_demo.service;

import com.example.upwork_demo.model.WriterSuccess;
import com.example.upwork_demo.repository.WriterSuccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WriterSuccessService {

    @Autowired
    private WriterSuccessRepository writerSuccessRepository;

    public List<WriterSuccess> getAllWriterSuccesses() {
        return writerSuccessRepository.findAll();
    }

    public Optional<WriterSuccess> getWriterSuccessById(Long id) {
        return writerSuccessRepository.findById(id);
    }

    public WriterSuccess saveWriterSuccess(WriterSuccess writerSuccess) {
        return writerSuccessRepository.save(writerSuccess);
    }

    public List<WriterSuccess> saveAllWriterSuccesses(List<WriterSuccess> writerSuccesses) {
        return writerSuccessRepository.saveAll(writerSuccesses);
    }

    public void deleteWriterSuccess(Long id) {
        writerSuccessRepository.deleteById(id);
    }
}
