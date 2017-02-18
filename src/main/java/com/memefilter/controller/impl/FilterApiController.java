package com.memefilter.controller.impl;

import com.memefilter.controller.FilterApi;
import com.memefilter.model.RealMeaning;
import com.memefilter.model.MemeText;
import com.memefilter.realitysource.RealitySource;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.concurrent.CompletableFuture;


@Controller
public class FilterApiController implements FilterApi {

    @Autowired
    private RealitySource realitySource;

    @Override
    public CompletableFuture<ResponseEntity<File>> filterImagePost(@ApiParam(value = "file detail") @RequestPart("file") MultipartFile image) {
        return CompletableFuture.completedFuture(new ResponseEntity<File>(HttpStatus.OK));
    }

    @Override
    public CompletableFuture<ResponseEntity<RealMeaning>> filterTextPost(@ApiParam(value = "The memeText to be filtered.", required = true) @RequestBody MemeText memeText) {

        RealMeaning realMeaning = new RealMeaning();
        realMeaning.setMemeText(memeText.getMemeText());

        realMeaning.setReality(realitySource.getRealMeaning(memeText.getMemeText()));


        return CompletableFuture.completedFuture(new ResponseEntity<>(realMeaning, HttpStatus.OK));
    }
}
