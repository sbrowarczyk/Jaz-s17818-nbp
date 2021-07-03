package pl.pjatk.jazs17818nbp.nbpservice;

import org.springframework.stereotype.Service;
import pl.pjatk.jazs17818nbp.model.RequestData;
import pl.pjatk.jazs17818nbp.repository.RequestDataRepository;

@Service
public class RequestDataService {

  private final RequestDataRepository requestDataRepository;

  public RequestDataService(
      RequestDataRepository requestDataRepository) {
    this.requestDataRepository = requestDataRepository;
  }


  public void saveRequestData(RequestData requestData) {
    requestDataRepository.save(requestData);
  }

}
