package com.example.demo.controller;

import com.example.demo.payload.RewardDto;
import com.example.demo.payload.RewardsDto;
import com.example.demo.payload.RewardsResponseDto;
import com.example.demo.service.RewardService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/rewards")
@Slf4j
@RequiredArgsConstructor
public class RewardController {
    private final RewardService rewardService;

    @GetMapping("/{id}/{months}")
    public ResponseEntity<RewardDto> getRewardByIdAndMonth(@PathVariable(name = "id")Long id, @PathVariable(name = "months") Integer month){
        try{
            log.info("get reward api with id : {}, months: {}\n",id,month);
            return new ResponseEntity<>(rewardService.getRewardById(id,month), HttpStatus.OK);
        }catch(Exception e){
            log.error(e.getMessage());
            return new ResponseEntity<>(new RewardDto(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/customer/{id}/points/available")
    public ResponseEntity<RewardsResponseDto> getAvailablePoints(@PathVariable(name = "id") long id){
        log.info("Get available points of user with id: " + id);
        return new ResponseEntity<>(this.rewardService.
                getRewardingPointsInPastThreeMonths(id), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}/points/encrypted")
    public ResponseEntity<String> getEncryptedPoints(@PathVariable(name = "id") long id){
        log.info("Get available points of user with id: " + id);
        List<RewardDto> res =  this.rewardService.getAllRewardingPointsRecord();
        StringBuilder sb = new StringBuilder();
        res.stream().map(r->{
            sb.append(r.getUserId());
            sb.append(":");
            sb.append("reward:");
            sb.append(r.getRewards());
            sb.append("amount:");
            sb.append(r.getAmount());
            sb.append("\n");
            return r;
        });
        String str = sb.toString();
        byte[] msg = str.getBytes(StandardCharsets.UTF_8);
        return new ResponseEntity<>(Base64.getEncoder().encode(msg).toString(), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}/points/current-month")
    public ResponseEntity<RewardsResponseDto> getCurrentMonthPoints(@PathVariable(name = "id") long id){
        log.info("Get points from current month of user with id: " + id);
        return new ResponseEntity<>(this.rewardService
                .getRewardingPointsInCurrentMonths(id), HttpStatus.OK);
    }

    @GetMapping("/customer/{id}/points")
    public ResponseEntity<Double> getAllPointsByCustomerId(@PathVariable(name = "id") long id){
        log.info("Get all points of user with id: " + id);
        return new ResponseEntity<>(this.rewardService
                .getRewardingPointsByCustomerIdInTotal(id), HttpStatus.OK);
    }

    @GetMapping("/points")
    public ResponseEntity<List<RewardDto>> getAllPoints(){
        log.info("Get all points records.");
        return new ResponseEntity<>(this.rewardService
                .getAllRewardingPointsRecord(), HttpStatus.OK);
    }

    @GetMapping("/points/csv")
    public ResponseEntity<byte[]> getPDF(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            log.info(cookies.toString());
        }

        Cookie cookie = new Cookie("username", "Jovan");
        cookie.setMaxAge(7*24*60*60);
        response.addCookie(cookie);

        // do csv stuff
        List<RewardDto> res = this.rewardService.getAllRewardingPointsRecord();
        CSVFormat csvFormat = CSVFormat.DEFAULT.withHeader("1","2","3");
        File tempFile = File.createTempFile("Points",".csv");
        FileOutputStream fileOutputStream = new FileOutputStream(tempFile);
        CSVPrinter csvPrinter = new CSVPrinter(new OutputStreamWriter(fileOutputStream),csvFormat);
        for(RewardDto r: res){
            csvPrinter.printRecord(r.getUserId());
            csvPrinter.printRecord(r.getRewards());
            csvPrinter.printRecord(r.getAmount());
        }
        csvPrinter.flush();
        csvPrinter.close();
        fileOutputStream.close();
        FileInputStream inputStream = new FileInputStream(tempFile);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] b = new byte[1024];
        int n;
        while((n = inputStream.read(b)) != -1){
            bos.write(b,0,n);
        }
        inputStream.close();
        bos.close();
        HttpHeaders httpHeaders = new HttpHeaders();
        String fileName = new String("Points.csv".getBytes("UTF-8"),"iso-8859-1");
        httpHeaders.setContentDispositionFormData("attachment",fileName);
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        ResponseEntity<byte[]> fileByte = new ResponseEntity<>(bos.toByteArray(),httpHeaders,HttpStatus.CREATED);

        return fileByte;
    }

    @DeleteMapping("/points/{id}")
    public ResponseEntity<String> deleteRewardingPointsRecord(
            @PathVariable(name = "id") long id){
        log.info("Get all point records of user with id: " + id);
        this.rewardService.deleteRewardingPoints(id);
        return new ResponseEntity<>("Deleted rewarding points record by id: " + id, HttpStatus.OK);
    }
}
