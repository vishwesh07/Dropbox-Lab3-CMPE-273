package com.service;

import com.entity.Document;
import com.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;


    public List<Document> getFiles(String owner, String path){
        return documentRepository.findByOwnerAndPath(owner,path);
    }
}