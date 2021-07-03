package pl.pjatk.jazs17818nbp.nbpservice;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.jazs17818nbp.model.Rate;
import pl.pjatk.jazs17818nbp.model.RequestData;
import pl.pjatk.jazs17818nbp.model.Root;
import pl.pjatk.jazs17818nbp.repository.RequestDataRepository;

@Service
public class NBPService {

  private final RestTemplate restTemplate;
  private RequestDataRepository requestDataRepository;

  public NBPService(RestTemplate restTemplate,
      RequestDataRepository requestDataRepository) {
    this.restTemplate = restTemplate;
    this.requestDataRepository = requestDataRepository;
  }

  public Double averageCourseOfCurrenciesForDays(String currency, String startDate, String endDate) {

    List<Rate> rates = restTemplate.getForEntity(String
        .format("http://api.nbp.pl/api/exchangerates/rates/a/%s/%s/%s/", currency, startDate,
            endDate), Root.class).getBody().getRates();

    double sum = 0;

    for (Rate rate : rates) {
      sum += Double.parseDouble(rate.getMid());
    }

    double average = sum / (double) rates.size();

    requestDataRepository.save(
        new RequestData(currency, startDate, endDate, average, LocalDateTime.now().toString()));

    return average;
  }

}
