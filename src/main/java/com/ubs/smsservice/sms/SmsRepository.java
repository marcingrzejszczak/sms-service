package com.ubs.smsservice.sms;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "smsRequests", path = "smsRequests")
@Api(value="smsRequests", description="Operations pertaining to SMS Requests")
public interface SmsRepository extends JpaRepository<Sms, Long>{

    @ApiOperation("find all SMS Requests that are associated with a given phone number")
    List<Sms> findByPhoneNumber(String phoneNumber);

    @ApiOperation("find the latest SMS Request associated with a given phone number by created date")
    Sms findFirstByPhoneNumberOrderByCreatedDateDesc(String phoneNumber);


}
