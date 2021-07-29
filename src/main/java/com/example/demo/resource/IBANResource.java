package com.example.demo.resource;

import com.example.demo.model.IbanAnswerForm;
import com.example.demo.model.IbanChecker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/iban")
public class IBANResource {

    @GetMapping(value = "/check")
    public List<IbanAnswerForm> checkIbanList(@RequestBody List<String> ibanList){
        List<IbanAnswerForm> ibanAnswerForm = new ArrayList<>();
        IbanChecker ibanChecker = new IbanChecker();

        for (String iban : ibanList) {
            if (ibanChecker.isIbanCorrect(iban)) {
                ibanAnswerForm.add(new IbanAnswerForm(iban, true));
            } else {
                ibanAnswerForm.add(new IbanAnswerForm(iban, false));
            }
        }
        return ibanAnswerForm;
    }

}
