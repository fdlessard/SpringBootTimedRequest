package io.fdlessard.codebites.timedrequest;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TimedRequestController {

    @GetMapping(value="/timedRequest/{milliseconds}")
    public boolean timedRequest(@PathVariable("milliseconds") int milliseconds) {

        log.info("TimedRequestController.timedRequest() - sleeping for {}", milliseconds);
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e ) {
            log.error("Oups !", e);
        }

        log.info("TimedRequestController.timedRequest() - done sleeping");

        return true;
    }
}
