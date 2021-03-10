package com.anabneri.messagingsystem.notfication;

import com.anabneri.messagingsystem.notfication.config.ModelMapperConfig;
import com.anabneri.messagingsystem.notfication.dto.RegistrationDTO;
import com.anabneri.messagingsystem.notfication.dto.StatusDTO;
import com.anabneri.messagingsystem.notfication.excpetions.RegistrationWhitoutStatus;
import com.anabneri.messagingsystem.notfication.model.Registration;
import com.anabneri.messagingsystem.notfication.model.Status;
import com.anabneri.messagingsystem.notfication.repository.RegistrationRepository;
import com.anabneri.messagingsystem.notfication.repository.StatusRepository;
import com.anabneri.messagingsystem.notfication.service.RegistrationService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.rules.ErrorCollector;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Matchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

public class RegistrationTest {


    public static final String REGISTRATION_ID = "5793cf6b3fd833521db8c420955e6f01";
    public static final String REGISTRATION_PURCHASED = "REGISTRATION_PURCHASED";
    private RegistrationRepository repository;
    private StatusRepository statusRepository;
    private ModelMapperConfig mapper;
    private RabbitTemplate rabbitTemplate;
    private RegistrationService service;

    @Rule
    public ErrorCollector error = new ErrorCollector();

    @Before
    public void setUp() {
        this.repository = mock(RegistrationRepository.class);
        this.statusRepository = mock(StatusRepository.class);
        this.mapper = mock(ModelMapperConfig.class);
        this.rabbitTemplate = mock(RabbitTemplate.class);
        this.service = new RegistrationService(repository, statusRepository, mapper, rabbitTemplate);
    }

    @Test
    @DisplayName("Registration was saved with success!!")
     void testSaveRegistrationPurchasedWithSuccess() {
        Status status = buildStatusEntity();
        RegistrationDTO registrationDTO = buildRegistrationDTO();
        Registration registration = buildSubscriptionEntity();

        when(statusRepository.findByName(registration.getStatus().getName())).thenReturn(Optional.of(status));
        when(repository.save(registration)).thenReturn(registration);
        when(mapper.map(registrationDTO, Registration.class)).thenReturn(registration);

        registration.onPrePersist();
        service.saveRegistration(registrationDTO);

        error.checkThat(registration.getCreatedAt().toLocalDate().isEqual(LocalDate.now()),
                is(true));
    }

    @Test(expected = RegistrationWhitoutStatus.class)
    public void testDontSaveARegistrationWithoutStatus() {
        RegistrationDTO registrationDTO = RegistrationDTO.builder()
                .id(REGISTRATION_ID)
                .build();
        Registration registration = Registration.builder()
                .id(REGISTRATION_ID)
                .build();

        when(repository.save(Registration)).thenReturn(Registration);
        when(mapper.map(registrationDTO, Registration.class)).thenReturn(registration);

        service.saveRegistration(registrationDTO);
    }

    private RegistrationDTO buildRegistrationDTO() {
        StatusDTO statusDTO = buildStatusDTO();
        return RegistrationDTO.builder()
                .id(REGISTRATION_ID)
                .statusId(statusDTO)
                .build();
    }

    private StatusDTO buildStatusDTO() {
        return StatusDTO.builder()
                .name(REGISTRATION_PURCHASED)
                .build();
    }

    private Registration buildRegistrationEntity() {
        Status status = buildStatusEntity();
        return Registration.builder()
                .id(REGISTRATION_ID)
                .statusId(status)
                .build();
    }

    private Status buildStatusEntity() {
        return Status.builder()
                .name(REGISTRATION_PURCHASED)
                .build();
    }

}
