package com.bsuir.springapp.facade;

import com.bsuir.springapp.entity.RecordData;
import com.bsuir.springapp.entity.RecordModel;
import com.bsuir.springapp.repository.RecordRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecordFacadeImpl implements RecordFacade {
    @Resource
    RecordRepository recordRepository;
    @Resource
    ModelMapper modelMapper;

    @Override
    public void saveRecord(RecordData recordData) {
        recordRepository.save(modelMapper.map(recordData, RecordModel.class));
    }

    @Override
    public List<RecordData> getAllRecords() {
        return mapAllRecords(recordRepository.findAll());
    }

    private List<RecordData> mapAllRecords(Iterable<RecordModel> records) {
        List<RecordData> recordsData = new ArrayList<>();
        for (RecordModel record : records) {
            recordsData.add(modelMapper.map(record, RecordData.class));
        }
        return recordsData;
    }
}
