package com.springboot.mustache.boardexample.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="nation_wide_hospitals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="management_number")
    private String managementNumber;

    @Column(name="business_status")
    private int businessStatus;

    @Column(name="phone")
    private String phone;

    @Column(name="road_name_address")
    private String roadNameAddress;

    @Column(name = "hospital_name")
    private String hospitalName;

    @Column(name = "business_type_name")
    private String businessTypeName;

    @Column(name = "healthcare_provider_count")
    private int healthcareProviderCount;

    @Column(name = "patient_room_count")
    private int patientRoomCount;

    @Column(name = "total_number_of_beds")
    private int totalNumberOfBeds;

    @Column(name = "total_area_size")
    private float totalAreaSize;

    public Hospital(int businessStatus, int healthcareProviderCount, int patientRoomCount, int totalNumberOfBeds) {
        this.businessStatus = businessStatus;
        this.healthcareProviderCount = healthcareProviderCount;
        this.patientRoomCount = patientRoomCount;
        this.totalNumberOfBeds = totalNumberOfBeds;
    }

    public Hospital(int id, int businessStatus, int healthcareProviderCount, int patientRoomCount, int totalNumberOfBeds) {
        this.id = id;
        this.businessStatus = businessStatus;
        this.healthcareProviderCount = healthcareProviderCount;
        this.patientRoomCount = patientRoomCount;
        this.totalNumberOfBeds = totalNumberOfBeds;


    }
}
