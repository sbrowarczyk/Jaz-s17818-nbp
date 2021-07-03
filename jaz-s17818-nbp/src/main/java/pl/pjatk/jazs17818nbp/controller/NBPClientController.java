package pl.pjatk.jazs17818nbp.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.jazs17818nbp.nbpservice.NBPService;

@RestController
@RequestMapping("/NBP")
public class NBPClientController {

  private final NBPService nbpService;

  public NBPClientController(NBPService nbpService) {
    this.nbpService = nbpService;
  }

  @ApiOperation(value = "Get average course",
      response = Double.class,
      notes = "This method will return average course for given currency from start date to end date")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "OK"),
      @ApiResponse(code = 400, message = "Badly formulated request"),
      @ApiResponse(code = 404, message = "The time parameters are wrong"),
  })
  @GetMapping("/{currency}/{startDate}/{endDate}")
  public ResponseEntity<Double> averageCourseOfCurrenciesForDays(
      @ApiParam(
          name = "currency",
          type = "String",
          value = "parameter that represents the currency",
          required = true)
      @PathVariable String currency,
      @ApiParam(
          name = "startDate",
          type = "String",
          value = "parameter that represents the start date",
          required = true)
      @PathVariable String startDate,
      @ApiParam(
          name = "endDate",
          type = "String",
          value = "parameter that represents the end date",
          required = true)
      @PathVariable String endDate) {

    Double averageCourse = nbpService.averageCourseOfCurrenciesForDays(currency, startDate, endDate);

    return ResponseEntity.ok(averageCourse);
  }

}
