package com.bsuir.springapp.facade;

import com.bsuir.springapp.entity.RecordData;

import java.util.List;


public interface RecordFacade {
    void saveRecord(RecordData recordData);

    List<RecordData> getAllRecords();
}
